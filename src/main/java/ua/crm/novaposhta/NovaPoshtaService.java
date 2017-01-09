package ua.crm.novaposhta;

import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.crm.DB.*;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 26.08.2016.
 */
@Service
@PropertySource("classpath:application.properties")
public class NovaPoshtaService {
    @Value("${NPApiKey}")
    private String npApiKey;

    @Autowired
    private ClientsDao clientsDao;

    @Autowired
    private OrdersDao ordersDao;
    @Autowired
    private NPAreaDao npAreaDao;
    @Autowired
    private NPCitiesDao npCitiesDao;
    @Autowired
    private NPBackwardDeliveryCargoTypesDao npBackwardDeliveryCargoTypesDao;
    @Autowired
    private NPCargoDescriptionListDao npCargoDescriptionListDao;
    @Autowired
    private NPCargoTypesDao npCargoTypesDao;
    @Autowired
    private NPContactPersonDao npContactPersonDao;
    @Autowired
    private NPCounterpartyDao npCounterpartyDao;
    @Autowired
    private NPServiceTypesDao npServiceTypesDao;
    @Autowired
    private NPTypesOfPayersForRedeliveryDao npTypesOfPayersForRedeliveryDao;
    @Autowired
    private NPWarehousesDao npWarehousesDao;
    @Autowired
    private NPWarehouseTypesDao npWarehouseTypesDao;
    @Autowired
    private NPDocumentStatusesDao npDocumentStatusesDao;

    @Autowired
    private OrderStatusDao orderStatusDao;
    @Autowired
    private DeliveryStatusDao deliveryStatusDao;
    @Autowired
    private RefusedOrdersDao refusedOrdersDao;
    @Autowired
    private MoneyBackDao moneyBackDao;

    private List<String> errorList = new ArrayList<>();


    public List<String> getErrorList() {
        return errorList;
    }

    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    public void clearErrorList() {
        errorList.clear();

    }

    @Transactional(readOnly = true)
    public List<NPCities> findCitiesByArea(String area) {
        return npCitiesDao.findByArea(area);
    }

    @Transactional(readOnly = true)
    public NPCities findByCitiesByCityName(String city) {
        return npCitiesDao.findByCityName(city);
    }

    @Transactional(readOnly = true)
    public List<NPWarehouses> findWarehousesByCities(String cities) {
        return npWarehousesDao.findByCities(cities);
    }

    @Transactional(readOnly = true)
    public NPWarehouses findWarehousesByCitiesNum(String cities, Integer number) {
        return npWarehousesDao.findByCitiesNum(cities, number);
    }

    @Transactional(readOnly = true)
    public List<NPArea> findAreaAll() {
        return npAreaDao.findAll();
    }

    @Transactional(readOnly = true)
    public NPArea findArea(String ref) {
        return npAreaDao.getOne(ref);
    }

    @Transactional(readOnly = true)
    public NPCities findCities(String ref) {
        return npCitiesDao.getOne(ref);
    }

    @Transactional(readOnly = true)
    public NPWarehouses findWarehouse(String ref) {
        return npWarehousesDao.getOne(ref);
    }


    @Transactional
    public void updateArea() throws IOException, ClassNotFoundException {
        npAreaDao.deleteAll();
        npAreaDao.flush();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Address", "getAreas", null);
        NPResponse<NPArea> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPArea());
        npResponse.getData().stream().forEach(n -> npAreaDao.save(n));
    }

    @Transactional
    public void updateCities() throws IOException, ClassNotFoundException {
        npCitiesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Address", "getCities", null);
        NPResponse<NPCities> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPCities());
        npResponse.getData().stream().forEach(n -> {
            n.setNpArea(npAreaDao.findOne(n.getArea()));
            npCitiesDao.save(n);
        });

    }

    @Transactional
    public void updateBackwardDeliveryCargoTypes() throws IOException, ClassNotFoundException {
        npBackwardDeliveryCargoTypesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getBackwardDeliveryCargoTypes", null);
        NPResponse<NPBackwardDeliveryCargoTypes> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPBackwardDeliveryCargoTypes());
        npResponse.getData().stream().forEach(n -> npBackwardDeliveryCargoTypesDao.save(n));
    }

    @Transactional
    public void updateCargoDescriptionList() throws IOException, ClassNotFoundException {
        npCargoDescriptionListDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getCargoDescriptionList", null);
        NPResponse<NPCargoDescriptionList> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPCargoDescriptionList());
        npResponse.getData().stream().forEach(n -> npCargoDescriptionListDao.save(n));
    }


    @Transactional
    public void updateCargoTypes() throws IOException, ClassNotFoundException {
        npCargoTypesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getCargoTypes", null);
        NPResponse<NPCargoTypes> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPCargoTypes());
        npResponse.getData().stream().forEach(n -> npCargoTypesDao.save(n));
    }

    @Transactional
    public void updateContactPerson() throws IOException, ClassNotFoundException {
        npContactPersonDao.deleteAll();
        npCounterpartyDao.deleteAll();

//        npCounterpartyDao.findAll().forEach(n -> {
        NPCounterparty n = new NPCounterparty("528d5d18-37c3-11e6-a54a-005056801333"); // Ref - Частное лицо
        int i = 1;
        NPResponse<NPContactPerson> npResponse = new NPResponse<>();
        do {
            NPRequest<NPContactPersonsRequest> npRequest = new NPRequest<>(npApiKey, "Counterparty", "getCounterpartyContactPersons", new NPContactPersonsRequest(n.getRef(), String.valueOf(i++)));
            try {
                npResponse = requestToNP(npRequest, new NPContactPerson());
            } catch (IOException e) {
                e.printStackTrace();
            }
            npResponse.getData().stream().forEach(q -> {
                NPCounterparty m = q.createCountreparty();
                npCounterpartyDao.save(m);
                q.setNpCounterparty(m);
                npContactPersonDao.save(q);
            });
        } while (npResponse.getData().size() > 0);
//        });

    }

    @Transactional
    public void updateCounterparty() throws IOException, ClassNotFoundException {
//        npCounterpartyDao.deleteAll();
//        int i = 1;
//        NPResponse<NPCounterparty> npResponse = new NPResponse<>();
//        do {
//            NPRequest<NPCounterpartyRequest> npRequest = new NPRequest<>(npApiKey, "Counterparty", "getCounterparties", new NPCounterpartyRequest("Recipient", String.valueOf(i++)));
//            npResponse = requestToNP(npRequest, new NPCounterparty());
//            npResponse.getData().stream().forEach(n -> npCounterpartyDao.save(n));
//        } while (npResponse.getData().size() > 0);
    }

    @Transactional
    public void updateServiceTypes() throws IOException, ClassNotFoundException {
        npServiceTypesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getServiceTypes", null);
        NPResponse<NPServiceTypes> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPServiceTypes());
        npResponse.getData().stream().forEach(n -> npServiceTypesDao.save(n));
    }

    @Transactional
    public void updateTypesOfPayersForRedelivery() throws IOException, ClassNotFoundException {
        npTypesOfPayersForRedeliveryDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getTypesOfPayersForRedelivery", null);
        NPResponse<NPTypesOfPayersForRedelivery> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPTypesOfPayersForRedelivery());
        npResponse.getData().stream().forEach(n -> npTypesOfPayersForRedeliveryDao.save(n));
    }

    @Transactional
    public void updateWarehouses() throws IOException, ClassNotFoundException {
        npWarehousesDao.deleteAll();
        npCitiesDao.findAll().forEach(n -> {
            n.getRef();
            NPRequest<CitiesReuest> npRequest = new NPRequest<>(npApiKey, "AddressGeneral", "getWarehouses", new CitiesReuest(n.getRef()));
            NPResponse<NPWarehouses> npResponse = new NPResponse<>();
            try {
                npResponse = requestToNP(npRequest, new NPWarehouses());
            } catch (IOException e) {
                e.printStackTrace();
            }

            npResponse.getData().stream().forEach(q -> {
                q.setNpCities(npCitiesDao.findOne(q.getCityRef()));
                q.setNpWarehouseTypes(npWarehouseTypesDao.findOne(q.getTypeOfWarehouse()));
                npWarehousesDao.save(q);
            });
        });

    }

    @Transactional
    public void updateWarehouseTypes() throws IOException, ClassNotFoundException {
        npWarehouseTypesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "AddressGeneral", "getWarehouseTypes", null);
        NPResponse<NPWarehouseTypes> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPWarehouseTypes());
        npResponse.getData().stream().forEach(n -> npWarehouseTypesDao.save(n));

    }

    @Transactional
    public void updateDocumentStatuses() throws IOException, ClassNotFoundException {
        npDocumentStatusesDao.deleteAll();
        NPRequest<String> npRequest = new NPRequest<>(npApiKey, "Common", "getDocumentStatuses", null);
        NPResponse<NPDocumentStatuses> npResponse = new NPResponse<>();
        npResponse = requestToNP(npRequest, new NPDocumentStatuses());
        npResponse.getData().stream().forEach(n -> npDocumentStatusesDao.save(n));
    }

    @Transactional
    public NPCounterparty createCounterparty(Clients client) throws IOException, ClassNotFoundException {
        if ((client.getNpWarehouses() == null) || (client.getNpCities() == null)) {
            return null;
        }
        System.out.println("Start createCounterparty");
        NPRequest<NPCounterpartyCreate> npRequest = new NPRequest<>(npApiKey, "Counterparty", "save",
                new NPCounterpartyCreate(client));
        NPResponse<NPCounterpartyResponse> npResponse = new NPResponse<>();
        System.out.println("Parse createCounterparty");
        npResponse = requestToNP(npRequest, new NPCounterpartyResponse());
        if (npResponse.getSuccess() == false && npResponse.getErrors().size() > 0) {
            npResponse.getErrors().forEach(n -> errorList.add("Клиент " + client.getClient_ID() + " " + client.getFirstLastName() + " " + n));
        }
        System.out.println("End Parse createCounterparty");

        if (npResponse.getData().size() > 0) {
            NPCounterparty n = npResponse.getData().get(0).createCounterparty();

            NPContactPerson p = npResponse.getData().get(0).createContactPerson();
            p.setPhones(client.getTel());

            npCounterpartyDao.save(n);
            System.out.println("Save CounterParty");

            p.setNpCounterparty(n);
            n.setContactPerson(p);

            npContactPersonDao.save(p);

            System.out.println("Done NP Client ALL");
            return n;
        } else {
            return null;
        }


    }

    @Transactional
    public void createNPDelivery(Orders order) throws IOException, ClassNotFoundException {

        NPRequest<NPInternetDocument> npRequest = new NPRequest<>(npApiKey, "InternetDocument", "save",
                new NPInternetDocument(order));
        NPResponse<NPInternetDocResponse> npResponse = new NPResponse<>();
        try {
            npResponse = requestToNP(npRequest, new NPInternetDocResponse());
            if (npResponse.getSuccess() == false && npResponse.getErrors().size() > 0) {
                npResponse.getErrors().forEach(n -> errorList.add("Заказ " + order.getId() + " " + n));
            }
            if (npResponse.getData() != null && npResponse.getData().size() > 0) {
                order.setNpDocNumber(npResponse.getData().get(0).getIntDocNumber());
                order.setNpDocRef(npResponse.getData().get(0).getRef());
                order.setDeliveryCost(Float.parseFloat(npResponse.getData().get(0).getCostOnSite()));

                DateFormat format = new SimpleDateFormat("dd.MM.yyyy");
                order.setDateSent(format.parse(npRequest.getMethodProperties().getDateTime()));
                order.setEstimatedDeliveryDate(format.parse(npResponse.getData().get(0).getEstimatedDeliveryDate()));
                order.setOrderStatus(orderStatusDao.findOne(5));
                order.setDeliveryStatus(deliveryStatusDao.findOne(2));
                ordersDao.save(order);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }


//    @Transactional
//    public void createNPDelivery(ArrayList<Orders> orders) throws IOException, ClassNotFoundException {
//        orders.forEach(n -> createNPDelivery(n));
//    }

    @Transactional
    public void checkNPDelivery(List<Orders> orders) throws IOException, ClassNotFoundException {
        orders.forEach(n -> {
            NPRequest<NPTrackingDocumentRequest> npRequest = new NPRequest<>(npApiKey, "TrackingDocument", "getStatusDocuments",
                    new NPTrackingDocumentRequest(n.getNpDocNumber()));
            NPResponse<NPTrackingDocumentResonse> npResponse = new NPResponse<>();
            try {
                npResponse = requestToNP(npRequest, new NPTrackingDocumentResonse());
                DateFormat formatD = new SimpleDateFormat("dd-MM-yyyy");
                DateFormat formatDT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                n.setEstimatedDeliveryDate(formatD.parse(npResponse.getData().get(0).getScheduledDeliveryDate()));
// получено
                if ((npResponse.getData().get(0).getStatusCode().equals("9")) || (npResponse.getData().get(0).getStatusCode().equals("10")) || (npResponse.getData().get(0).getStatusCode().equals("106"))) {
                    n.setDeliveryStatus(deliveryStatusDao.findOne(3));
                    if (n.getPaymentStatus().getId() == 2) {
                        n.setOrderStatus(orderStatusDao.findOne(7));
                    } else {
                        moneyBackDao.save(
                                new MoneyBack(n.getId(), n.getNpDocNumber(), npResponse.getData().get(0).getLastCreatedOnTheBasisDocumentType(),
                                        Integer.parseInt(npResponse.getData().get(0).getRedeliverySum()), npResponse.getData().get(0).getLastCreatedOnTheBasisNumber(), npResponse.getData().get(0).getLastTransactionStatusGM(),
                                        formatDT.parse(npResponse.getData().get(0).getLastCreatedOnTheBasisDateTime())));
                    }

                    //TO-DO:

                }
//возврат
                if ((npResponse.getData().get(0).getStatusCode().equals("102")) || (npResponse.getData().get(0).getStatusCode().equals("103")) || (npResponse.getData().get(0).getStatusCode().equals("11"))) {
                    n.setDeliveryStatus(deliveryStatusDao.findOne(4));
                    n.setOrderStatus(orderStatusDao.findOne(9));
                    refusedOrdersDao.save(new RefusedOrders(n.getId(), n.getNpDocNumber(), n.getDateSent(), new Date(), npResponse.getData().get(0).getLastCreatedOnTheBasisNumber(), npResponse.getData().get(0).getUndeliveryReasonsSubtypeDescription()));
                }
                ordersDao.save(n);

            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }

        });

    }


    private <T> NPResponse<T> requestToNP(NPRequest npRequest, T t) throws IOException {

        Gson gson = new GsonBuilder().create();
        String request = gson.toJson(npRequest);
        System.out.println(request);

        StringBuilder sb = new StringBuilder();
        URL url = new URL("https://api.novaposhta.ua/v2.0/json/");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();
        http.setDoOutput(true);
        http.setRequestMethod("POST");
        http.setRequestProperty("Content-Type", "application/json");


        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(http.getOutputStream()))) {
            bw.write(request);
            bw.flush();
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(http.getInputStream()))) {


            char[] buf = new char[1000000];
            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb.append(new String(buf, 0, r));
            } while (r > 0);

        }
        http.disconnect();


        JsonParser parser = new JsonParser();
        JsonElement jsonElement = parser.parse(sb.toString());
        JsonObject rootObject = jsonElement.getAsJsonObject();
        System.out.println(rootObject.toString());

        JsonArray data = jsonElement.getAsJsonObject().getAsJsonArray("data");
        System.out.println(rootObject.get("data").toString());
        Boolean status = rootObject.get("success").getAsBoolean();
        System.out.println(status);
//        System.out.println(data.toString());


        NPResponse<T> b = new NPResponse<>();

        b.setSuccess(status);
//        b.setErrors(rootObject.get("errors").toString());
//        b.setWarnings(rootObject.get("warnings").toString());
//        b.setInfo(rootObject.get("info").toString());
//        b.setMessageCodes(rootObject.get("messageCodes").toString());
//        b.setErrorCodes(rootObject.get("errorCodes").toString());
//        b.setWarningCodes(rootObject.get("warningCodes").toString());
//        b.setInfoCodes(rootObject.get("infoCodes").toString());

        if (!status) {
            b.getErrors().add(rootObject.get("errors").toString());
            return b;

        }


//        System.out.println(data.toString());

        for (JsonElement element : data) {

            System.out.println(element.toString());

            try {
                T k = (T) t.getClass().getDeclaredConstructor(null).newInstance(null);
                System.out.println(k.getClass());
                k = gson.fromJson(element.toString(), (Class<T>) k.getClass());
                //System.out.println(k);
                b.getData().add(k);
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }

        }

        System.out.println("Done!");


        return b;
    }

}
