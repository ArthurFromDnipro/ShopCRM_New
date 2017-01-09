package ua.crm.DB;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Created by Oleg on 09.09.2016.
 */
@Entity
@Table(name = "refusedorders")
public class RefusedOrders {
    @Id
    private int id;
    private String documentNumber;
    private Date dateSent;
    private Date dateStatusUpdate;
    private String refuse_Document;
    private String description;

    public RefusedOrders() {
    }

    public RefusedOrders(int id, String documentNumber, Date dateSent, Date dateStatusUpdate, String refuse_Document, String description) {
        this.id = id;
        this.documentNumber = documentNumber;
        this.dateSent = dateSent;
        this.dateStatusUpdate = dateStatusUpdate;
        this.refuse_Document = refuse_Document;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getDateStatusUpdate() {
        return dateStatusUpdate;
    }

    public void setDateStatusUpdate(Date dateStatusUpdate) {
        this.dateStatusUpdate = dateStatusUpdate;
    }

    public String getRefuse_Document() {
        return refuse_Document;
    }

    public void setRefuse_Document(String refuse_Document) {
        this.refuse_Document = refuse_Document;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RefusedOrders{" +
                "id=" + id +
                ", documentNumber='" + documentNumber + '\'' +
                ", dateSent=" + dateSent +
                ", dateStatusUpdate=" + dateStatusUpdate +
                ", refuse_Document='" + refuse_Document + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
