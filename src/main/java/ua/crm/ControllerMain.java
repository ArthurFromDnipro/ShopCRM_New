package ua.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.crm.DB.CrmService;
import ua.crm.novaposhta.NovaPoshtaService;
import ua.crm.privatbank.PrivatbankService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Oleg on 12.10.2016.
 */
@Controller
public class ControllerMain {
    @Autowired
    private CrmService crmService;

    @Autowired
    private NovaPoshtaService novaPoshtaService;

    @Autowired
    private PrivatbankService privatbankService;

    private void modelSet(String name, String tel, String dateFrom, String dateTo, Model model) {
        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        if (name == null) {
            name = "";
        }
        if (tel == null) {
            tel = "";
        }

        if (dateFrom == null) {
            Calendar fromDate = Calendar.getInstance();
            fromDate.add(Calendar.DAY_OF_MONTH, -7);
            dateStart = fromDate.getTime();
            dateFrom = day2.format(dateStart);
        } else {
            try {
                dateStart = day2.parse(dateFrom);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (dateTo == null) {
            Calendar toDate = Calendar.getInstance();
            dateEnd = toDate.getTime();
            dateTo = day2.format(dateEnd);
        } else {
            try {
                dateEnd = day2.parse(dateTo);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("name", name);
        model.addAttribute("tel", tel);
        model.addAttribute("dateStart", dateFrom);
        model.addAttribute("dateEnd", dateTo);
        model.addAttribute("quickview", null);
        model.addAttribute("oldDevCount",crmService.findOldDeliveriesCount());
        model.addAttribute("toSendCount",crmService.findForSendCount());
        model.addAttribute("reviewCount",crmService.findForReviewRequestCount());
        model.addAttribute("orders", crmService.getfindByDateNameTel(dateStart, dateEnd, "%" + name.toLowerCase() + "%", "%" + tel + "%"));
    }


    @RequestMapping("/")
    public String index(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "tel", required = false) String tel, @RequestParam(value = "dateFrom", required = false) String dateFrom, @RequestParam(value = "dateTo", required = false) String dateTo, Model model) {

        modelSet(name, tel, dateFrom, dateTo, model);


        return "index";
    }

    @RequestMapping("/old_deliveries")
    public String oldDeliveries(Model model) {

        model.addAttribute("orders", crmService.findOrdersOldDeliveries());
        return "old_deliveries";

    }

    @RequestMapping("/update_status")
    public String updateStatus(Model model) {

        try {
            novaPoshtaService.checkNPDelivery(crmService.findOrdersForCheck());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/";

    }

    @RequestMapping("/quickview/{oId}")
    public String quickView(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "tel", required = false) String tel, @RequestParam(value = "dateFrom", required = false) String dateFrom, @RequestParam(value = "dateTo", required = false) String dateTo, @PathVariable(value = "oId") int oId, Model model) {

        modelSet(name, tel, dateFrom, dateTo, model);
        model.addAttribute("quickview", crmService.getOrder(oId));

        return "index";

    }


    @RequestMapping("/payment")
    public String payment(Model model) {

        try {
            privatbankService.updatePrivaBank();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }
        System.out.println("Get new Statement");
        privatbankService.getNewStatement();
        model.addAttribute("payments", privatbankService.getStatementDBbyDate());
        model.addAttribute("orders", null);

        return "payment";

    }

    @RequestMapping("/payment/{pId}")
    public String paymentToOrder(@PathVariable(value = "pId") String appcode, Model model) {


        model.addAttribute("payments", null);
        model.addAttribute("payment_c", privatbankService.getOneStatementDB(appcode));

        model.addAttribute("orders", crmService.getOrdersForPayment());


        return "payment";

    }

    @RequestMapping("/payment/{pId}/order/{oId}")
    public String paymentSetForOrder(@PathVariable(value = "pId") String appcode, @PathVariable(value = "oId") int oId, Model model) {


        crmService.setPaymentForOrder(oId, appcode);

        //privatbankService.getStatementDBbyDate().forEach(n-> System.out.println(n));


        return "redirect:/payment";

    }


//    @RequestMapping(value = "/update", method = RequestMethod.POST)
//    public String update(@RequestParam(required = false) String email, @RequestParam(required = false) String phone) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String login = user.getUsername();
//
//        CustomUser dbUser = userService.getUserByLogin(login);
//        dbUser.setEmail(email);
//        dbUser.setPhone(phone);
//
//        userService.updateUser(dbUser);
//
//        return "redirect:/";
//    }
//
//    @RequestMapping("/admin")
//    public String admin() {
//        return "admin";
//    }

//    @RequestMapping("/updatenp1")
//    public String update(){
//        try {
//            novaPoshtaService.updateArea();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return "admin";
//    }

    @RequestMapping("/unauthorized")
    public String unauthorized(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute("login", user.getUsername());
        return "unauthorized";
    }

    @RequestMapping("/sales")
    public String sales(@RequestParam(value = "dateFrom", required = false) String dateFrom, @RequestParam(value = "dateTo", required = false) String dateTo, Model model) {
        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        Date dateStart = new Date();
        Date dateEnd = new Date();

        if (dateFrom == null) {
            Calendar fromDate = Calendar.getInstance();
//            fromDate.add(Calendar.DAY_OF_MONTH, -7);
            dateStart = fromDate.getTime();
            dateFrom = day2.format(dateStart);
        } else {
            try {
                dateStart = day2.parse(dateFrom);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        if (dateTo == null) {
            Calendar toDate = Calendar.getInstance();
            dateEnd = toDate.getTime();
            dateTo = day2.format(dateEnd);
        } else {
            try {
                dateEnd = day2.parse(dateTo);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("dateStart", dateFrom);
        model.addAttribute("dateEnd", dateTo);
        model.addAttribute("orders", crmService.getSalesByDate(dateStart, dateEnd));

        return "sales";
    }

}
