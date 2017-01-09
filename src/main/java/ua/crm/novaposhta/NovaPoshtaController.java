package ua.crm.novaposhta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

/**
 * Created by Oleg on 26.08.2016.
 */

@Controller
public class NovaPoshtaController {
    @Autowired
    NovaPoshtaService novaPoshtaService;

    @RequestMapping("/updatenp")
    public String update() {
        System.out.println("UpdateNP");
        try {
//            novaPoshtaService.updateArea();
            novaPoshtaService.updateCities();
//            novaPoshtaService.updateBackwardDeliveryCargoTypes();
//            novaPoshtaService.updateCargoDescriptionList();
//            novaPoshtaService.updateCargoTypes();
//            novaPoshtaService.updateServiceTypes();
//            novaPoshtaService.updateTypesOfPayersForRedelivery();
//            novaPoshtaService.updateWarehouseTypes();
            novaPoshtaService.updateWarehouses();
//            novaPoshtaService.updateDocumentStatuses();
//            novaPoshtaService.updateCounterparty();
//            novaPoshtaService.updateContactPerson();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "admin";

    }
}


