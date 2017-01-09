package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Oleg on 24.07.2016.
 */
@XmlRootElement
public class Info {

    Statements statements=new Statements();

    public Info() {
    }

    public Statements getStatements() {
        return statements;
    }

    @XmlElement
    public void setStatements(Statements statements) {
        this.statements = statements;
    }
}
