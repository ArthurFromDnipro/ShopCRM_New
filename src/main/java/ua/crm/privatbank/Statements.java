package ua.crm.privatbank;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 24.07.2016.
 */
@XmlRootElement
public class Statements {
    @XmlElement
    private List<Statement> statement = new ArrayList<>();

    public Statements() {
    }

    public List<Statement> getStatement() {
        return statement;
    }
}
