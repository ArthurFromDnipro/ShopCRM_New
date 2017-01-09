
package ua.crm.privatbank;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

//import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

/**
 * Created by Oleg on 26.07.2016.
 */
@Component
@PropertySource("classpath:application.properties")
public class PrivatBank {
    @Value("${PBPassword}")
    private String password;
    @Value("${PBCardNumber}")
    private String cardNumber;
    @Value("${PBMerchantID}")
    private int id;
    private int wait = 90;
    private int test = 0;
    private String oper = "cmt";
    private DataRequest dataRequest = new DataRequest();
    private DataResponse dataResponse = new DataResponse();

    public PrivatBank(String password, String cardNumber, int id, int wait, int test, String oper) {
        this.password = password;
        this.cardNumber = cardNumber;
        this.id = id;
        this.wait = wait;
        this.test = test;
        this.oper = oper;
    }

    public PrivatBank(String password, String cardNumber, int id) {
        this.password = password;
        this.cardNumber = cardNumber;
        this.id = id;
    }

    public PrivatBank() {
    }

    public DataResponse getDataResponse() {
        return dataResponse;
    }

    public void setDataResponse(DataResponse dataResponse) {
        this.dataResponse = dataResponse;
    }

    private void requestData() throws IOException, JAXBException {

        JAXBContext dataContext = JAXBContext.newInstance(DataRequest.class);
        Marshaller dataMarsh = dataContext.createMarshaller();
        dataMarsh.setProperty(Marshaller.JAXB_FRAGMENT, true);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        OutputStream os = new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                baos.write(b);
            }
        };

        dataMarsh.marshal(dataRequest, os);
        String s = baos.toString();
        String signature = Hash.sha1(Hash.md5(s.substring(6, s.length() - 7) + password));
        //System.out.println("Debug password " + password);

        Merchant merchant = new Merchant(signature);
        Request request = new Request(merchant, dataRequest);


        JAXBContext requestContext = JAXBContext.newInstance(Request.class);
        Marshaller requestMarsh = requestContext.createMarshaller();
        // Debug print
//        requestMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
//        requestMarsh.marshal(request, System.out);
//        System.out.println();


        JAXBContext responseContext = JAXBContext.newInstance(Response.class);
        Marshaller responseMarsh = responseContext.createMarshaller();
        Unmarshaller responseUnmarsh = responseContext.createUnmarshaller();
        Response response = new Response();


        //try {
        URL url = new URL("https://api.privatbank.ua/p24api/rest_fiz");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);


        requestMarsh.marshal(request, con.getOutputStream());
        StringBuilder sb2 = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            char[] buf = new char[1000000];
            int r = 0;
            do {
                if ((r = br.read(buf)) > 0)
                    sb2.append(new String(buf, 0, r));
            } while (r > 0);
        }

        signature = Hash.sha1(Hash.md5(sb2.substring(sb2.indexOf("<data>") + 6, sb2.indexOf("</data>")) + password));
//            System.out.println(sb2.toString());
//            System.out.println(sb2.substring(sb2.indexOf("<data>") + 6, sb2.indexOf("</data>")));
//            System.out.println(signature);


        try (ByteArrayInputStream bais = new ByteArrayInputStream(sb2.toString().getBytes())) {

            InputStream is = new InputStream() {
                @Override
                public int read() throws IOException {
                    return bais.read();
                }
            };
            response = (Response) responseUnmarsh.unmarshal(is);
        }

        // Debug print
        responseMarsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        responseMarsh.marshal(response, System.out);


        //}
//        catch (IOException e) {
//            System.out.println(e);
//        }

//        // Debug print
//        System.out.println(signature);
//        System.out.println(response);
//        System.out.println(response.getData());
//        System.out.println(response.merchant.getSignature());

        if (response.merchant.getSignature().equals(signature)) {
            System.out.println("Signature OK");
            dataResponse = response.data;
        } else {
            dataResponse = null;
            System.out.println("Signature NOT OK!!!");
        }


    }


    public void accountDetails(String startDate, String endDate) throws IOException, JAXBException {

//        System.out.println(cardNumber);
//        System.out.println(password);
//        System.out.println(id);
        Payment payment = new Payment();

        payment.add(new Prop("sd", startDate));
        payment.add(new Prop("ed", endDate));
        payment.add(new Prop("card", cardNumber));
        dataRequest.setPayment(payment);
        requestData();
        // System.out.println(Arrays.deepToString(dataResponse.getInfo().getStatements().getStatement().toArray()));


    }


}
