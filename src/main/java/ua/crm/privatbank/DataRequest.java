package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 23.07.2016.
 */
@XmlRootElement(name = "data")
public class DataRequest {
    @XmlElement(name = "oper")
    private String oper="cmt";
    @XmlElement(name = "wait")
    private int wait=90;
    @XmlElement(name = "test")
    private int test=0;

    private Payment payment;

    public DataRequest(Payment payment) {
        this.payment = payment;
    }

    public DataRequest() {
    }


    public Payment getPayment() {
        return payment;
    }

    @XmlElement(name = "payment")
    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
