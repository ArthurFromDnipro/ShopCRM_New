package ua.crm.DB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Oleg on 09.09.2016.
 */
@Entity
@Table(name = "moneyback")
public class MoneyBack {
    @Id
    private int id;
    private String npDocument;
    private String moneyType;
    private int sum;
    private String redeliveryNPDoc;
    private String redeliveryStatus;
    private Date redeliveryDate;

    public MoneyBack() {
    }

    public MoneyBack(int id, String npDocument, String moneyType, int sum, String redeliveryNPDoc, String redeliveryStatus, Date redeliveryDate) {
        this.id = id;
        this.npDocument = npDocument;
        this.moneyType = moneyType;
        this.sum = sum;
        this.redeliveryNPDoc = redeliveryNPDoc;
        this.redeliveryStatus = redeliveryStatus;
        this.redeliveryDate = redeliveryDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNpDocument() {
        return npDocument;
    }

    public void setNpDocument(String npDocument) {
        this.npDocument = npDocument;
    }

    public String getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(String moneyType) {
        this.moneyType = moneyType;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getRedeliveryNPDoc() {
        return redeliveryNPDoc;
    }

    public void setRedeliveryNPDoc(String redeliveryNPDoc) {
        this.redeliveryNPDoc = redeliveryNPDoc;
    }

    public String getRedeliveryStatus() {
        return redeliveryStatus;
    }

    public void setRedeliveryStatus(String redeliveryStatus) {
        this.redeliveryStatus = redeliveryStatus;
    }

    public Date getRedeliveryDate() {
        return redeliveryDate;
    }

    public void setRedeliveryDate(Date redeliveryDate) {
        this.redeliveryDate = redeliveryDate;
    }

    @Override
    public String toString() {
        return "MoneyBack{" +
                "id=" + id +
                ", npDocument='" + npDocument + '\'' +
                ", moneyType='" + moneyType + '\'' +
                ", sum=" + sum +
                ", redeliveryNPDoc='" + redeliveryNPDoc + '\'' +
                ", redeliveryStatus='" + redeliveryStatus + '\'' +
                ", redeliveryDate=" + redeliveryDate +
                '}';
    }
}
