package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 24.07.2016.
 */
@XmlRootElement(name = "data")
public class DataResponse {

    String oper;
    Info info=new Info();

    public DataResponse() {
    }

    public String getOper() {
        return oper;
    }

    @XmlElement
    public void setOper(String oper) {
        this.oper = oper;
    }

    public Info getInfo() {
        return info;
    }

    @XmlElement
    public void setInfo(Info info) {
        this.info = info;
    }
}
