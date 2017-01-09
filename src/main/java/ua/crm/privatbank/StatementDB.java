package ua.crm.privatbank;

import ua.crm.DB.Orders;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Oleg on 19.10.2016.
 */

@Entity
@Table(name = "statement")
public class StatementDB {
    @Id
    private String appcode;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Statement statementTmp;

    private float amount;
    private String description;
    private String terminal;
    private Date trandate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Orders order;


    public StatementDB() {
    }


    public String getAppcode() {
        return appcode;
    }

    public void setAppcode(String appcode) {
        this.appcode = appcode;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public Date getTrandate() {
        return trandate;
    }

    public void setTrandate(Date trandate) {
        this.trandate = trandate;
    }

    public Statement getStatementTmp() {
        return statementTmp;
    }

    public void setStatementTmp(Statement statementTmp) {
        this.statementTmp = statementTmp;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("StatementDB{" +
                "appcode='" + appcode + '\'' +
                ", statementTmp=");
        if (statementTmp != null) {
            sb.append(statementTmp.getAppcode());
        } else sb.append("null");
        sb.append(", amount=" + amount +
                ", description='" + description + '\'' +
                ", terminal='" + terminal + '\'' +
                ", trandate=" + trandate +
                ", order=");
        if (order != null) {
            sb.append(order.getId());
        } else sb.append("null");
        sb.append("}");
        return sb.toString();
    }
}
