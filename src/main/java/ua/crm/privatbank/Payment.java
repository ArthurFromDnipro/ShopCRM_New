package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

/**
 * Created by Oleg on 23.07.2016.
 */
@XmlRootElement(name = "payment")
public class Payment {


    private String id="";

    @XmlElement(name = "prop")
    private ArrayList<Prop> prop = new ArrayList<>();

    public Payment() {
    }

    public void add(Prop a) {
        prop.add(a);
    }

    public String getId() {
        return id;
    }

    @XmlAttribute(name="id")
    public void setId(String id) {
        this.id = id;
    }


}
