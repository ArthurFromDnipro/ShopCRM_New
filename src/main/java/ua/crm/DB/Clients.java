package ua.crm.DB;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ua.crm.novaposhta.NPCities;
import ua.crm.novaposhta.NPCounterparty;
import ua.crm.novaposhta.NPWarehouses;
import ua.crm.opencart.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "clients")
public class Clients {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int client_ID;
    private String firstName;
    private String lastName;
    private String tel;
    private String email;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private NPCities npCities;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_NP_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private NPCounterparty npCounterparty;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wh_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private NPWarehouses npWarehouses;

    private String Address;

    //private String Client_ID_Another;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID_Another")
    private Customer customer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_Type_ID")
    private ClientType clientType;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Orders> orders = new ArrayList<>();

    public Clients() {
    }

    public Clients(String firstName, String lastName, String tel, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tel = tel;
        this.email = email;
    }

    public int getClient_ID() {
        return client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.client_ID = client_ID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = prepareStr(firstName);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = prepareStr(lastName);
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {

        tel = tel.trim().replace("-", "").replace("(", "").replace(")", "").replace(" ", "");
        this.tel = "38".concat((tel.length() > 10) ? tel.substring(tel.length() - 10) : tel);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.equals("empty@localhost") || email.equals("fastorder@sribnyk.com.ua")) {
            email = "";
        }
        this.email = email;
    }


    public NPCounterparty getNpCounterparty() {
        return npCounterparty;
    }

    public void setNpCounterparty(NPCounterparty npCounterparty) {
        this.npCounterparty = npCounterparty;
    }


    public NPCities getNpCities() {
        return npCities;
    }

    public void setNpCities(NPCities npCities) {
        this.npCities = npCities;
    }

    public NPWarehouses getNpWarehouses() {
        return npWarehouses;
    }

    public void setNpWarehouses(NPWarehouses npWarehouses) {
        this.npWarehouses = npWarehouses;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ClientType getClientType() {
        return clientType;
    }

    public void setClientType(ClientType clientType) {
        this.clientType = clientType;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getFirstLastName() {
        return firstName + " " + lastName;
    }


    @Override
    public String toString() {
        return "Clients{" +
                "client_ID=" + client_ID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", tel='" + tel + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static String prepareStr(String s) {
        if (s != null && s.equals("")) {
            s.toLowerCase().replace("a", "а").replace("b", "в").replace("c", "с").replace("e", "е").replace("h", "н").replace("i", "і").replace("k", "к").replace("m", "").replace("o", "о").replace("p", "р").replace("t", "т").replace("x", "Х").replace("'", "`");
            if (s.length() > 1) {
                return s.substring(0, 1).toUpperCase() + s.substring(1);
            } else {
                return s.toUpperCase();
            }
        } else {
            return s;
        }
        //Replace(Replace(Replace(UCase(Left(Trim([firstname]),1))+LCase(Mid(Trim([firstname]),2)), 'c', 'ñ'), 'i', '³'), ""'"", ""`"") AS Âûðàæåíèå9, Replace(Replace(Replace(UCase(Left(Trim([lastname]),1))+LCase(Mid(Trim([lastname]),2)), 'c', 'ñ'), 'i', '³'), ""'"", ""`"") AS Âûðàæåíèå10, " & _
    }

    public static String prepareTel(String t) {
        t = t.trim().replace("-", "").replace("(", "").replace(")", "").replace(" ", "");
        return (t.length() > 10) ? "38" + t.substring(t.length() - 10) : t;

    }

}
