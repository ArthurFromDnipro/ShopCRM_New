package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 08.09.2016.
 */
public class NPCounterpartyResponse {

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
    private NPResponse<NPContactPerson> contactPerson;

    public NPCounterpartyResponse() {
    }

    public NPCounterparty createCounterparty() {
        return new NPCounterparty(contactPerson.getData().get(0).getRef(), contactPerson.getData().get(0).getDescription(), "", contactPerson.getData().get(0).getFirstName(), contactPerson.getData().get(0).getMiddleName(), contactPerson.getData().get(0).getLastName());
    }

    public NPContactPerson createContactPerson() {
        return new NPContactPerson(contactPerson.getData().get(0).getRef(), contactPerson.getData().get(0).getDescription(), contactPerson.getData().get(0).getFirstName(), contactPerson.getData().get(0).getMiddleName(), contactPerson.getData().get(0).getLastName(), contactPerson.getData().get(0).getPhones(), contactPerson.getData().get(0).getEmail());
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

    public NPResponse<NPContactPerson> getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(NPResponse<NPContactPerson> contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Override
    public String toString() {
        return "NPCounterpartyResponse{" +
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
