package ua.crm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ua.crm.DB.*;
import ua.crm.novaposhta.NovaPoshtaService;
import ua.crm.opencart.OpencartService;
import ua.crm.privatbank.PrivatbankService;
import ua.crm.privatbank.StatementDB;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;


@Controller
public class ControllerOrder {
    @Autowired
    private UserService userService;

    @Autowired
    private NovaPoshtaService novaPoshtaService;

    @Autowired
    private CrmService crmService;

    @Autowired
    private ClientsDao clientsDao;

    @Autowired
    private OpencartService opencartService;

    @Autowired
    private PrivatbankService privatbankService;


    //    private Orders currentOrder = null;
    private TreeMap<Integer, Orders> orderPull = new TreeMap<>();
    private TreeMap<Integer, Date> orderDate = new TreeMap<>();
    private TreeMap<Integer, ArrayList<OrderDetails>> detailsForDelete = new TreeMap<>();


    public void setModelforOrder(Model model, Orders currentOrder) {

        model.addAttribute("order", currentOrder);
        model.addAttribute("deliveryType", crmService.getDeliveryType());
        model.addAttribute("deliveryStatus", crmService.getDeliveryStatus());
        model.addAttribute("paymentType", crmService.getPaymentType());
        model.addAttribute("paymentStatus", crmService.getPaymentStatus());
        model.addAttribute("orderStatus", crmService.getOrderStatus());
        model.addAttribute("channelType", crmService.getChannelType());

        model.addAttribute("areas", novaPoshtaService.findAreaAll());
        if (currentOrder.getClient() != null) {
            model.addAttribute("cities", (currentOrder.getClient().getNpCities() == null) ? null : novaPoshtaService.findCitiesByArea(currentOrder.getClient().getNpCities().getNpArea().getRef()));
            model.addAttribute("warehouses", (currentOrder.getClient().getNpCities() == null) ? null : novaPoshtaService.findWarehousesByCities(currentOrder.getClient().getNpCities().getRef()));
        }
        model.addAttribute("product_edit", -1);
        model.addAttribute("comment_edit", false);
        model.addAttribute("client_edit", false);
        model.addAttribute("add_product", false);
        model.addAttribute("client_choose", false);

    }

    public synchronized Orders getCurrentOrder(Integer i) {
        Date d = new Date();

        Iterator it = orderDate.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry item = (Map.Entry) it.next();

            if ((d.getTime() - orderDate.get(item.getKey()).getTime()) / 1000 / 60 / 60 >= 12) {
                it.remove();
                orderPull.remove(item.getKey());
            }
        }


//        orderDate.entrySet().stream().forEach(n -> {
//            if ((d.getTime() - n.getValue().getTime()) / 1000 / 60 / 60 >= 12) {
//                orderPull.remove(n.getKey());
//                orderDate.remove(n.getKey());
//            }
//        });


        if (orderPull.get(i) != null) {
            orderDate.remove(i);
        } else {
            if (i.intValue() == -1) {
                orderPull.put(0, new Orders(new Date(), null, crmService.getDeliveryType(1), crmService.getPaymentType(1), crmService.getPaymentStatus(1), crmService.getDeliveryStatus(1), crmService.getChannelType(1), crmService.getOrderStatus(1), "", null));
                i = Integer.valueOf(0);
            } else {
                orderPull.put(i, crmService.getOrder(i));
            }
        }

        orderDate.put(i, d);
        return orderPull.get(i);
    }

    @RequestMapping("/order/{oId}/delivery_type/{dId}")
    public String deliveryTypeChange(@PathVariable(value = "oId") int oId,
                                     @PathVariable(value = "dId") int dId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setDeliveryType(crmService.getDeliveryType(dId));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/payment_type/{pId}")
    public String paymentTypeChange(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "pId") int pId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setPaymentType(crmService.getPaymentType(pId));
        currentOrder.setPaymentStatus(crmService.getPaymentStatus(1));

        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/edit_comment")
    public String commentEdit(@PathVariable(value = "oId") int oId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        model.addAttribute("comment_edit", true);
        return "order";
    }

    @RequestMapping(value = "/order/{oId}/save_comment", method = RequestMethod.POST)
    public String commentSave(@PathVariable(value = "oId") int oId,
                              @RequestParam(required = false) String comment, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setComments(comment);
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/client_edit")
    public String clientEdit(@PathVariable(value = "oId") int oId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        model.addAttribute("client_edit", true);
        return "order";
    }

    @RequestMapping("/order/{oId}/client_add")
    public String clientAdd(@PathVariable(value = "oId") int oId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        currentOrder.setClient(new Clients());
        model.addAttribute("client_edit", true);
        return "order";
    }

    @RequestMapping("/order/{oId}/client_choose")
    public String clientChoose(@PathVariable(value = "oId") int oId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        model.addAttribute("client_choose", true);
        return "order";
    }

    @RequestMapping("/order/{oId}/client_filter")
    public String clientFilter(@PathVariable(value = "oId") int oId,
                               @RequestParam(value = "filter_name", required = false) String filter_name,
                               @RequestParam(value = "filter_tel", required = false) String filter_tel, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        if (filter_name == null) {
            filter_name = "";
        }
        if (filter_tel == null) {
            filter_tel = "";
        }
        setModelforOrder(model, currentOrder);
        model.addAttribute("client_choose", true);
        model.addAttribute("filter_name", filter_name);
        model.addAttribute("filter_tel", filter_tel);
        System.out.println(filter_name + " " + filter_tel);
        List<Clients> c = crmService.getClientsByNameTel("%" + filter_name.toLowerCase() + "%", "%" + filter_tel + "%");
        System.out.println(c);
        c.forEach(n -> System.out.println(n));
        //clientsDao.findByNameTel("%" + filter_name.toLowerCase() + "%", "%" + filter_tel + "%").forEach(n-> System.out.println(n));
        model.addAttribute("clients", crmService.getClientsByNameTel("%" + filter_name.toLowerCase() + "%", "%" + filter_tel + "%"));

        return "order";
    }

    @RequestMapping("/order/{oId}/client_change/{cId}")
    public String clientAdd(@PathVariable(value = "oId") int oId, @PathVariable(value = "cId") int cId, Model
            model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setClient(crmService.getClient(cId));
        setModelforOrder(model, currentOrder);
        return "order";
    }


    @RequestMapping(value = "/order/{oId}/client_save", method = RequestMethod.POST)
    public String commentSave(@PathVariable(value = "oId") int oId,
                              @RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName,
                              @RequestParam(required = false) String tel, @RequestParam(required = false) String email, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        System.out.println(firstName + " " + lastName);
        currentOrder.getClient().setFirstName(firstName);
        currentOrder.getClient().setLastName(lastName);
        currentOrder.getClient().setTel(tel);
        currentOrder.getClient().setEmail(email);
        Clients client = null;
        if ((firstName == null || firstName.equals("")) && (lastName == null || lastName.equals(""))) {
            client = crmService.getOneClientByTel(currentOrder.getClient().getTel());
        }
        System.out.println(client);
        if (client != null) {

            currentOrder.setClient(client);
        }
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/add_product")
    public String addProduct(@PathVariable(value = "oId") int oId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        model.addAttribute("add_product", true);
        model.addAttribute("categores", opencartService.findCategoryWithParent());

        return "order";
    }

    @RequestMapping("/order/{oId}/add_product/{pId}")
    public String addProductToOrder(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "pId") int pId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.getOrderDetails().add(
                new OrderDetails(currentOrder, opencartService.getOneProduct(pId), 1, opencartService.getOneProduct(pId).getCurrentPriceUAH(opencartService.getOneCurrence(1).getValue()).floatValue(), 0));
        setModelforOrder(model, currentOrder);
        model.addAttribute("product_edit", 0);
        return "order";
    }

    @RequestMapping("/order/{oId}/product_del/{pId}")
    public String delProductToOrder(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "pId") int pId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.getOrderDetails().forEach(n -> {
            if (n.getId() == pId) {
                n.setCount(0);
            }
        });
        setModelforOrder(model, currentOrder);
        System.out.println(currentOrder.getOrderDetails());

        return "order";
    }


    @RequestMapping("/order/{oId}/product_filter")
    public String filterProduct(@PathVariable(value = "oId") int oId,
                                @RequestParam(value = "filter_name", required = false) String filter_name,
                                @RequestParam(value = "category_input", required = false) Integer category_input, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        if (filter_name == null) {
            filter_name = "";
        }
        if (category_input == null) {
            category_input = Integer.valueOf(0);
        }

        System.out.println(category_input + " " + filter_name);
        setModelforOrder(model, currentOrder);
        model.addAttribute("add_product", true);
        model.addAttribute("categores", opencartService.findCategoryWithParent());
        model.addAttribute("currentCategory", (category_input.intValue() == 0) ? null : opencartService.getOneCategory(category_input));
        model.addAttribute("currentName", filter_name);
        model.addAttribute("currentCurrency", opencartService.getOneCurrence(1).getValue());
        model.addAttribute("products", opencartService.findProductWithFilterCategoryName(category_input, "%" + filter_name.toLowerCase() + "%"));
        model.addAttribute("payments", null);

        return "order";
    }

    @RequestMapping("/order/{oId}/new_product/{pId}")
    public String commentSave(@PathVariable(value = "oId") int oId, @PathVariable(value = "oId") int pId, Model
            model) {
        Orders currentOrder = getCurrentOrder(oId);
//        currentOrder.setComments(comment);
        setModelforOrder(model, currentOrder);
        return "order";
    }


    @RequestMapping("/order/{oId}/product_edit/{pId}")
    public String productEdit(@PathVariable(value = "oId") int oId, @PathVariable(value = "pId") int pId, Model
            model) {
        Orders currentOrder = getCurrentOrder(oId);
        setModelforOrder(model, currentOrder);
        model.addAttribute("product_edit", pId);
        return "order";
    }

    @RequestMapping(value = "/order/{oId}/product_save/{pId}", method = RequestMethod.POST)
    public String productSave(@PathVariable(value = "oId") int oId, @PathVariable(value = "pId") int pId,
                              @RequestParam(required = false) Float price, @RequestParam(required = false) Integer count,
                              @RequestParam(required = false) Float discount, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        if (price == null) {
            price = Float.valueOf(0);
        }
        if (count == null) {
            count = Integer.valueOf(0);
        }
        if (discount == null) {
            price = Float.valueOf(0);
        }
        Float finalPrice = price;
        Integer finalCount = count;
        currentOrder.getOrderDetails().forEach(n -> {
            if (n.getId() == pId) {
                n.setPrice(finalPrice);
                n.setCount(finalCount);
                n.setDiscount(discount);
            }
        });


        setModelforOrder(model, currentOrder);
        //model.addAttribute("product_edit", pId);
        return "order";
    }

    @RequestMapping("/order/{oId}/delivery_status/{dId}")
    public String deliveryStatusChange(@PathVariable(value = "oId") int oId,
                                       @PathVariable(value = "dId") int dId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setDeliveryStatus(crmService.getDeliveryStatus(dId));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/payment_status/{pId}")
    public String paymentStatusChange(@PathVariable(value = "oId") int oId,
                                      @PathVariable(value = "pId") int pId, Model model) {

        Orders currentOrder = getCurrentOrder(oId);
        if (pId == 1) {
            currentOrder.setPaymentStatus(crmService.getPaymentStatus(1));
            if (currentOrder.getStatemenDB() != null) {
                currentOrder.getStatemenDB().setOrder(null);
                currentOrder.setStatemenDB(null);
            }
        }

        setModelforOrder(model, currentOrder);
        if ((currentOrder.getPaymentType().getId() == 2) && (pId == 2)) {
            try {
                privatbankService.updatePrivaBank();
            } catch (IOException | JAXBException e) {
                e.printStackTrace();
            }
            privatbankService.getNewStatement();
            model.addAttribute("payments", privatbankService.getStatementDBbyDate());
        }

        if ((currentOrder.getPaymentType().getId() != 1) && (currentOrder.getPaymentType().getId() != 2) && (pId == 2)) {
            currentOrder.setPaymentStatus(crmService.getPaymentStatus(2));
        }
        return "order";
    }

    @RequestMapping("/order/{oId}/payment/{pId}")
    public String paymentStatusChange(@PathVariable(value = "oId") int oId,
                                      @PathVariable(value = "pId") String appcode, Model model) {

        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setStatemenDB(privatbankService.getOneStatementDB(appcode));
        currentOrder.getStatemenDB().setOrder(currentOrder);
        currentOrder.setPaymentStatus(crmService.getPaymentStatus(2));

        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/channel_type/{cId}")
    public String channelTypeChange(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "cId") int cId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setChannelType(crmService.getChannelType(cId));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/order_status/{cId}")
    public String orderStatusChange(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "cId") int cId, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.setOrderStatus(crmService.getOrderStatus(cId));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/order_area/{area}")
    public String orderAreaChange(@PathVariable(value = "oId") int oId,
                                  @PathVariable(value = "area") String area, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.getClient().setNpWarehouses(null);
        currentOrder.getClient().setNpCities(novaPoshtaService.findCities(novaPoshtaService.findArea(area).getAreasCenter()));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/order_cities/{cities}")
    public String orderCitiesChange(@PathVariable(value = "oId") int oId,
                                    @PathVariable(value = "cities") String cities, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.getClient().setNpWarehouses(null);
        currentOrder.getClient().setNpCities(novaPoshtaService.findCities(cities));
        setModelforOrder(model, currentOrder);
        return "order";
    }

    @RequestMapping("/order/{oId}/order_warehouse/{warehouse}")
    public String orderWarehouseChange(@PathVariable(value = "oId") int oId,
                                       @PathVariable(value = "warehouse") String warehouse, Model model) {
        Orders currentOrder = getCurrentOrder(oId);
        currentOrder.getClient().setNpWarehouses(novaPoshtaService.findWarehouse(warehouse));
        setModelforOrder(model, currentOrder);
        return "order";


    }


    @RequestMapping("/order/{id}")
    public String orderEdit(@PathVariable(value = "id") int id, Model model) {
        orderPull.remove(id);
        orderDate.remove(id);

        Orders currentOrder = getCurrentOrder(id);


        setModelforOrder(model, currentOrder);
        return "order";

    }

    @RequestMapping("/order/{id}/save_order")
    public String orderSave(@PathVariable(value = "id") int id, Model model) {

        Orders currentOrder = getCurrentOrder(id);

        crmService.saveClient(currentOrder.getClient());

        System.out.println(currentOrder.getStatemenDB());
        if (currentOrder.getStatemenDB() != null) {
            if (currentOrder.getPaymentStatus().getId() == 2) {
                crmService.setPaymentForOrder(currentOrder.getId(), currentOrder.getStatemenDB().getAppcode());
                System.out.println("Statement saved");
                currentOrder.setStatemenDB(privatbankService.getOneStatementDB(currentOrder.getStatemenDB().getAppcode()));
            } else {
                StatementDB statementDB = privatbankService.getOneStatementDB(currentOrder.getStatemenDB().getAppcode());
                statementDB.setOrder(null);
                privatbankService.saveStatementDB(statementDB);
                currentOrder.setStatemenDB(null);
            }
        }


        int i = 0;
        for (i = 0; i < currentOrder.getOrderDetails().size(); i++) {
            if (currentOrder.getOrderDetails().get(i).getCount() == 0) {
                currentOrder.getOrderDetails().get(i).setOrder(null);
                break;
            }

        }
        crmService.saveOrder(currentOrder);
        crmService.saveOrderDetails(currentOrder.getOrderDetails());

//        currentOrder.getOrderDetails().remove(i);


        orderPull.remove(id);
        orderDate.remove(id);

        currentOrder = getCurrentOrder(currentOrder.getId());

        setModelforOrder(model, currentOrder);


        return "redirect:/order/" + String.valueOf(currentOrder.getId());

    }

    @RequestMapping("/create_orders")
    public String orderCreate(Model model) {
        Orders currentOrder = getCurrentOrder(-1);

        setModelforOrder(model, currentOrder);

        return "order";
    }


}
