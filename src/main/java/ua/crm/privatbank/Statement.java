package ua.crm.privatbank;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;


/**
 * Created by Oleg on 24.07.2016.
 */
@XmlRootElement
@Entity
@Table(name = "statement_tmp")
public class Statement {
    @XmlAttribute
    private String card;
    @Id
    @XmlAttribute
    private String appcode;

    @XmlTransient
    //@MapsId
    @OneToOne(mappedBy = "statementTmp", cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.DETACH})
    //@NotFound(action = NotFoundAction.IGNORE)
    private StatementDB statementDB;

    @XmlAttribute
    private String trandate;
    @XmlAttribute
    private String amount;
    @XmlAttribute
    private String cardamount;
    @XmlAttribute
    private String rest;
    @XmlAttribute
    private String terminal;
    @XmlAttribute
    private String description;

    public Statement() {
    }

    public String getCard() {
        return card;
    }

    public String getAppcode() {
        return appcode;
    }

    public String getTrandate() {
        return trandate;
    }

    public String getAmount() {
        return amount;
    }

    public String getCardamount() {
        return cardamount;
    }

    public String getRest() {
        return rest;
    }

    public String getTerminal() {
        return terminal;
    }

    public String getDescription() {
        return description;
    }

    public StatementDB getNewStatement() {
        DateFormat day2 = new SimpleDateFormat("yyyy-MM-dd");
        StatementDB s = new StatementDB();
        try {
            s.setAmount(Float.parseFloat(cardamount.split(" ")[0]));
            s.setTrandate(day2.parse(trandate));
            s.setAppcode(appcode);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        s.setDescription(description);
        s.setTerminal(terminal);
        s.setOrder(null);
        s.setStatementTmp(this);
        statementDB = s;

        return s;
    }

    public StatementDB getStatementDB() {
        return statementDB;
    }

    public void setStatementDB(StatementDB statementDB) {
        this.statementDB = statementDB;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "card='" + card + '\'' +
                ", appcode='" + appcode + '\'' +
                ", trandate='" + trandate + '\'' +
                ", amount='" + amount + '\'' +
                ", cardamount='" + cardamount + '\'' +
                ", rest='" + rest + '\'' +
                ", terminal='" + terminal + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
