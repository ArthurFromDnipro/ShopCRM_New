package ua.crm.novaposhta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ua.crm.DB.Clients;

import javax.persistence.*;

/**
 * Created by Oleg on 30.08.2016.
 */
@Entity
@Table(name = "np_counterparty")
public class NPCounterparty {
    @Id
    @SerializedName("Ref")
    private String ref;
    @SerializedName("Description")
    private String description;
    @SerializedName("City")
    private String city;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("MiddleName")
    private String middleName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Counterparty")
    private String counterparty;
    @SerializedName("OwnershipForm")
    private String ownershipForm;
    @SerializedName("OwnershipFormDescription")
    private String ownershipFormDescription;
    @SerializedName("EDRPOU")
    private String EDRPOU;
    @SerializedName("CounterpartyType")
    private String counterpartyType;

    @SerializedName("ContactPerson")
    @OneToOne(mappedBy = "npCounterparty",cascade = CascadeType.ALL)
    private NPContactPerson contactPerson;

    @Expose(serialize = false, deserialize = false)
    @OneToOne(mappedBy = "npCounterparty", cascade = CascadeType.REFRESH)
    private Clients clients;


    public NPCounterparty() {
    }

    public NPCounterparty(String ref) {
        this.ref = ref;
    }

    public NPCounterparty(String ref, String description, String city, String firstName, String middleName, String lastName) {
        this.ref = ref;
        this.description = description;
        this.city = city;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
    public NPCounterparty(String ref, String description, String city, String firstName, String middleName, String lastName,NPContactPerson npContactPerson) {
        this.ref = ref;
        this.description = description;
        this.city = city;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.contactPerson=npContactPerson;
    }

    public NPCounterparty(String ref, String description, String city, String firstName, String middleName, String lastName, String counterparty, String ownershipForm, String ownershipFormDescription, String EDRPOU, String counterpartyType, NPContactPerson contactPerson) {
        this.ref = ref;
        this.description = description;
        this.city = city;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.counterparty = counterparty;
        this.ownershipForm = ownershipForm;
        this.ownershipFormDescription = ownershipFormDescription;
        this.EDRPOU = EDRPOU;
        this.counterpartyType = counterpartyType;
        this.contactPerson = contactPerson;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCounterparty() {
        return counterparty;
    }

    public void setCounterparty(String counterparty) {
        this.counterparty = counterparty;
    }

    public String getOwnershipForm() {
        return ownershipForm;
    }

    public void setOwnershipForm(String ownershipForm) {
        this.ownershipForm = ownershipForm;
    }

    public String getOwnershipFormDescription() {
        return ownershipFormDescription;
    }

    public void setOwnershipFormDescription(String ownershipFormDescription) {
        this.ownershipFormDescription = ownershipFormDescription;
    }

    public String getEDRPOU() {
        return EDRPOU;
    }

    public void setEDRPOU(String EDRPOU) {
        this.EDRPOU = EDRPOU;
    }

    public String getCounterpartyType() {
        return counterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        this.counterpartyType = counterpartyType;
    }

    public NPContactPerson getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(NPContactPerson contactPerson) {
        this.contactPerson = contactPerson;
    }

    public Clients getClients() {
        return clients;
    }

    public void setClients(Clients clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "NPCounterparty{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                ", city='" + city + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", counterparty='" + counterparty + '\'' +
                ", ownershipForm='" + ownershipForm + '\'' +
                ", ownershipFormDescription='" + ownershipFormDescription + '\'' +
                ", EDRPOU='" + EDRPOU + '\'' +
                ", counterpartyType='" + counterpartyType + '\'' +
                ", contactPerson=" + contactPerson +
                '}';
    }
}
