package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * Created by Oleg on 23.07.2016.
 */
@XmlRootElement(name = "request")
@XmlType(propOrder = {"merchant", "data"})
public class Request {
    @XmlAttribute(name="version")
    private String version="1.0";

    private Merchant merchant;

    private DataRequest data;

    public Request(Merchant merchant, DataRequest data) {
        this.merchant = merchant;
        this.data = data;
    }

    public Request() {

    }


    public Merchant getMerchant() {
        return merchant;
    }

    @XmlElement(name = "merchant")
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public DataRequest getData() {
        return data;
    }

    @XmlElement(name = "data")
    public void setData(DataRequest data) {
        this.data = data;
    }
}
