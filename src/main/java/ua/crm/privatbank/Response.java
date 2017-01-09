package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 24.07.2016.
 */
@XmlRootElement
public class Response {

    Merchant merchant=new Merchant();

    DataResponse data=new DataResponse();

    public Response() {
    }


    public Merchant getMerchant() {
        return merchant;
    }

    @XmlElement
    public void setMerchant(Merchant merchant) {
        this.merchant = merchant;
    }

    public DataResponse getData() {
        return data;
    }

    @XmlElement
    public void setData(DataResponse data) {
        this.data = data;
    }
}
