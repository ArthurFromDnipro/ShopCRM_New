package ua.crm.novaposhta;

import ua.crm.DB.Clients;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPCounterpartyCreate {
    private String CityRef;
    private String FirstName;
    private String MiddleName = "";
    private String LastName;
    private String Phone;
    private String Email;
    private String CounterpartyType = "PrivatePerson";
    private String CounterpartyProperty = "Recipient";

    public NPCounterpartyCreate() {
    }

    public NPCounterpartyCreate(String cityRef, String firstName, String middleName, String lastName, String phone, String email, String counterpartyType, String counterpartyProperty) {
        CityRef = cityRef;
        FirstName = firstName;
        MiddleName = middleName;
        LastName = lastName;
        Phone = phone;
        Email = email;
        CounterpartyType = counterpartyType;
        CounterpartyProperty = counterpartyProperty;
    }

    public NPCounterpartyCreate(Clients client) {
        CityRef = client.getNpCities().getRef();
        FirstName = client.getFirstName();
        LastName = client.getLastName();
        Phone = client.getTel();
        Email = client.getEmail();
        CounterpartyType = "PrivatePerson";
        CounterpartyProperty = "Recipient";
    }


    public String getCityRef() {
        return CityRef;
    }

    public void setCityRef(String cityRef) {
        CityRef = cityRef;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String middleName) {
        MiddleName = middleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCounterpartyType() {
        return CounterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        CounterpartyType = counterpartyType;
    }

    public String getCounterpartyProperty() {
        return CounterpartyProperty;
    }

    public void setCounterpartyProperty(String counterpartyProperty) {
        CounterpartyProperty = counterpartyProperty;
    }

    @Override
    public String toString() {
        return "NPCounterpartyCreate{" +
                "CityRef='" + CityRef + '\'' +
                ", FirstName='" + FirstName + '\'' +
                ", MiddleName='" + MiddleName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Phone='" + Phone + '\'' +
                ", Email='" + Email + '\'' +
                ", CounterpartyType='" + CounterpartyType + '\'' +
                ", CounterpartyProperty='" + CounterpartyProperty + '\'' +
                '}';
    }
}
