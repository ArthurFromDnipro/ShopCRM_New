package ua.crm.novaposhta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;

/**
 * Created by Oleg on 30.08.2016.
 */
@Entity
@Table(name = "np_contactperson")
public class NPContactPerson {
    @Id
    @SerializedName("Ref")
    private String ref;

    @SerializedName("Description")
    private String description;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("MiddleName")
    private String middleName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("Phones")
    private String Phones;
    @SerializedName("Email")
    private String email;

    @Expose(serialize = false, deserialize = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterparty_ref")
    private NPCounterparty npCounterparty;


    public NPContactPerson() {
    }

    public NPContactPerson(String ref, String description, String firstName, String middleName, String lastName, String phones, String email) {
        this.ref = ref;
        this.description = description;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.Phones = phones;
        this.email = email;
    }

    public NPCounterparty createCountreparty() {
        return new NPCounterparty(ref, description, "", firstName, middleName, lastName, this);
        //(String ref, String description, String city, String firstName, String middleName, String lastName) {
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

    public String getPhones() {
        return Phones;
    }

    public void setPhones(String phones) {
        Phones = phones;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public NPCounterparty getNpCounterparty() {
        return npCounterparty;
    }

    public void setNpCounterparty(NPCounterparty npCounterparty) {
        this.npCounterparty = npCounterparty;
    }


    @Override
    public String toString() {
        return "NPContactPerson{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Phones='" + Phones + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
