package ua.turbosms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Oleg on 12.09.2016.
 */
@Controller
public class TurboSmsController {
    @Autowired
    private TurboSmsService turboSmsService;

    @RequestMapping("/sms")
    public String update() {
        System.out.println("Send SMS");

       //turboSmsService.sendSMS();

        return "admin";

    }


}
