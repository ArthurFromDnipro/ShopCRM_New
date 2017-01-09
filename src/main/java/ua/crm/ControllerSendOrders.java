package ua.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.crm.DB.CrmService;
import ua.crm.novaposhta.NovaPoshtaService;
import ua.crm.DB.Orders;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Oleg on 15.10.2016.
 */
@Controller
public class ControllerSendOrders {


    @Autowired
    private CrmService crmService;

    @Autowired
    private NovaPoshtaService novaPoshtaService;

    @RequestMapping("/send_orders")
    public String OrderSend(Model model) {


        model.addAttribute("orders", crmService.getOrdersForSend());
        model.addAttribute("errors", (novaPoshtaService.getErrorList().size() > 0) ? novaPoshtaService.getErrorList() : null);

        return "send_orders";
    }


    @RequestMapping(value = "/send_orders/create", method = RequestMethod.POST)
    public synchronized ResponseEntity<Void> toSend(@RequestParam(value = "toSend[]", required = false) int[] toSend, Model model) {

        if (toSend != null) {
            novaPoshtaService.clearErrorList();

            Arrays.stream(toSend).forEach(n -> {
                Orders o = crmService.getOrder(n);
                try {
                    if (o.getClient().getNpCounterparty() == null) {
                        crmService.addCountertpartyToClients(o.getClient(), novaPoshtaService.createCounterparty(o.getClient()));
                    }

                    System.out.println("НП клиент: " + o.getClient().getNpCounterparty());
                    if (o.getClient().getNpCounterparty() != null) {
                        if ((o.getDeliveryStatus().getId() == 1) && (o.getOrderStatus().getId() == 4)) {
                            novaPoshtaService.createNPDelivery(o);
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    System.out.println(e);
                }
            });
        }
        novaPoshtaService.getErrorList().forEach(n -> System.out.println(n));
        model.addAttribute("orders", crmService.getOrdersForSend());
        model.addAttribute("errors", (novaPoshtaService.getErrorList().size() > 0) ? novaPoshtaService.getErrorList() : null);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
