package ua.crm.privatbank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created by Oleg on 05.09.2016.
 */
@Controller
public class PrivatbankController {

    @Autowired
    PrivatbankService privatbankService;

    @RequestMapping("/privat")
    public String update() {
        System.out.println("Update PB");
        try {
            privatbankService.updatePrivaBank();
        } catch (IOException | JAXBException e) {
            e.printStackTrace();
        }

        return "admin";

    }
}
