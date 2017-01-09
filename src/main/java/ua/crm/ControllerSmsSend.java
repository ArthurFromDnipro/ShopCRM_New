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
import ua.crm.DB.Orders;
import ua.turbosms.TurboSmsService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Oleg on 16.10.2016.
 */
@Controller
public class ControllerSmsSend {
    @Autowired
    private CrmService crmService;

    @Autowired
    private TurboSmsService turboSmsService;

    @RequestMapping("/review_request")
    public String reviewRequestList(Model model) {
        DateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Calendar ImportDate = Calendar.getInstance();
        date = ImportDate.getTime();
        String date_send = dayTime.format(date);
        date_send = date_send.replace(' ', 'T');

        model.addAttribute("date_send", date_send);
        model.addAttribute("orders", crmService.findOrdersForReviewRequest());
        return "review_request";
    }

    @RequestMapping(value = "/review_request/start", method = RequestMethod.POST)
    public synchronized ResponseEntity<Void> smsReiviewRequest(@RequestParam(value = "toSend[]", required = false) int[] toSend, @RequestParam(value = "date_send", required = false) String date_send, Model model) {


        model.addAttribute("date_send", date_send);


        DateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateSend = new Date();


        if (toSend == null || date_send == null) {

            model.addAttribute("orders", crmService.findOrdersForReviewRequest());
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        if (date_send != null) {
            date_send = date_send.replace('T', ' ');
            try {
                dateSend = dayTime.parse(date_send);
            } catch (ParseException e) {
                e.printStackTrace();
                return new ResponseEntity<Void>(HttpStatus.OK);
            }

        }


        System.out.println(Arrays.toString(toSend));
        System.out.println(dateSend);
        Date finalDateSend = dateSend;
        Arrays.stream(toSend).forEach(n -> {
            Orders o = crmService.getOrder(n);
            if (o.getReviewRequsted() == false) {
                turboSmsService.sendReviewRequest(o, finalDateSend);
            }
        });


        model.addAttribute("orders", crmService.findOrdersForReviewRequest());
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @RequestMapping("/sms_send")
    public String smsSendList(@RequestParam(value = "date_orders", required = false) String dateOrders, Model model) {

        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Calendar ImportDate = Calendar.getInstance();
        date = ImportDate.getTime();

        String date_send = dayTime.format(date);
        date_send = date_send.replace(' ', 'T');
        //System.out.println(date_send);


        if (dateOrders == null) {
            dateOrders = day2.format(date);
        } else {
            try {
                date = day2.parse(dateOrders);
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }

        model.addAttribute("date_orders", dateOrders);
        model.addAttribute("date_send", date_send);
        model.addAttribute("orders", crmService.findOrdersForSmsSendByDate(date));

        return "sms_send";
    }

    @RequestMapping(value = "/sms_send/start", method = RequestMethod.POST)
    public synchronized ResponseEntity<Void> smsSend(@RequestParam(value = "toSend[]", required = false) int[] toSend, @RequestParam(value = "date_send", required = false) String date_send, @RequestParam(value = "date_orders", required = false) String dateOrders, Model model) {

        model.addAttribute("date_orders", dateOrders);
        model.addAttribute("date_send", date_send);

        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date();
        Date dateSend = new Date();

        if (dateOrders != null) {
            try {
                date = day2.parse(dateOrders);
                model.addAttribute("orders", crmService.findOrdersForSmsSendByDate(date));
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        if (toSend == null || dateOrders == null || date_send == null) {

            model.addAttribute("orders", crmService.findOrdersForSmsSendByDate(date));
            return new ResponseEntity<Void>(HttpStatus.OK);
        }

        if (date_send != null) {
            date_send = date_send.replace('T', ' ');
            try {
                dateSend = dayTime.parse(date_send);
            } catch (ParseException e) {
                e.printStackTrace();
                return new ResponseEntity<Void>(HttpStatus.OK);
            }

        }


        System.out.println(Arrays.toString(toSend));
        System.out.println(dateSend);
        Date finalDateSend = dateSend;
        Arrays.stream(toSend).forEach(n -> {
            Orders o = crmService.getOrder(n);
            if (o.getSmsSent() == false) {
                turboSmsService.sendNPDocNumber(o, finalDateSend);
            }
        });


//        model.addAttribute("date_orders", dateOrders);
        model.addAttribute("orders", crmService.findOrdersForSmsSendByDate(date));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


}
