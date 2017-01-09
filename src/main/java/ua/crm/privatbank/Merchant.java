package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 23.07.2016.
 */
@XmlRootElement(name = "merchant")
public class Merchant {

    @XmlElement(name = "id")
    private int id = 123237;

    private String signature;

    public Merchant(String signature) {
        this.signature = signature;
    }

    public Merchant() {
    }


    public String getSignature() {
        return signature;
    }

    @XmlElement(name = "signature")
    public void setSignature(String signature) {
        this.signature = signature;
    }
}
