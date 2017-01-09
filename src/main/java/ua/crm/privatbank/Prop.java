package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 23.07.2016.
 */
@XmlRootElement(name = "prop")
public class Prop {

    private String name;


    private String value;

    public Prop(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public Prop() {
    }

    public String getName() {
        return name;
    }

    @XmlAttribute(name="name")
    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    @XmlAttribute(name="value")
    public void setValue(String value) {
        this.value = value;
    }

}
