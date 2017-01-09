package ua.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.crm.DB.Clients;
import ua.crm.DB.CrmService;
import ua.crm.DB.Orders;
import ua.crm.DB.OrderDetails;
import ua.crm.opencart.OpencartService;
import ua.crm.opencart.Order;
import ua.crm.novaposhta.NovaPoshtaService;
import ua.crm.novaposhta.NPCities;
import ua.crm.novaposhta.NPWarehouses;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 12.10.2016.
 */
@Controller
public class ControllerImport {
    @Autowired
    private OpencartService opencartService;


    @Autowired
    private CrmService crmService;

    @Autowired
    private NovaPoshtaService novaPoshtaService;


    List<Orders> ordersToCrm = new ArrayList<>();


    @RequestMapping("/import")
    public String importOrders(@RequestParam(value = "date_Import", required = false) String dateImport, Model model)

    {
        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();

        if (dateImport == null) {
            Calendar ImportDate = Calendar.getInstance();
            date = ImportDate.getTime();
            dateImport = day2.format(date);
        } else {
            try {
                date = day2.parse(dateImport);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("dateImport", dateImport);
        System.out.println(date);
        List<Order> orders = opencartService.findOrdersNotImportedByDate(date);

        ordersToCrm = new ArrayList<>();


        orders.forEach(n -> {
            Clients c = crmService.getOneClientByTel(Clients.prepareTel(n.getTelephone()));
            if (c == null) {
                c = new Clients();
                c.setFirstName(n.getFirstname());
                c.setLastName(n.getLastname());
                c.setTel(n.getTelephone());
                c.setEmail(n.getEmail());
                c.setAddress((n.getOrderSimpleField() == null) ? null : n.getOrderSimpleField().getShippingNewPochtaId());
            }
            System.out.println(c);
            c.setNpCities(novaPoshtaService.findByCitiesByCityName(NPCities.cityPrepare(n.getPaymentCity().toLowerCase())));
            c.setNpWarehouses(novaPoshtaService.findWarehousesByCitiesNum((c.getNpCities() == null) ? null : c.getNpCities().getRef(),
                    (n.getOrderSimpleField() == null) ? null : NPWarehouses.numPrepare(n.getOrderSimpleField().getShippingNewPochtaId())));

            Orders newOrder = n.getNewOrders(c, crmService.getDeliveryStatus(1), crmService.getPaymentStatus(1),
                    crmService.getOrderStatus(2), crmService.getChannelType(1),
                    crmService.getDeliveryType(1), (n.getPaymentCode().equals("bank_transfer")) ? crmService.getPaymentType(2) : crmService.getPaymentType(1));
            List<OrderDetails> orderDetails = new ArrayList<>();
            n.getOrderProduct().forEach(q -> orderDetails.add(q.getOrderDetails(newOrder, n.getCurrencyValue())));
            newOrder.setOrderDetails(orderDetails);

            ordersToCrm.add(newOrder);

        });


        model.addAttribute("orders_opencart", orders);
        model.addAttribute("orders_crm", ordersToCrm);


        return "import";
    }

    @RequestMapping("/import/start")
    public synchronized String importStart(Model model) {
        ordersToCrm.forEach(n -> {
            crmService.saveClient(n.getClient());

            crmService.saveOrder(n);
            crmService.saveOrderDetails(n.getOrderDetails());
        });

        return "redirect:/import";
    }

}
