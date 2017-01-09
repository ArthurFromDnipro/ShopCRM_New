package ua.crm.opencart;

import ua.crm.DB.Clients;
import ua.crm.DB.ClientsDao;

import java.io.Serializable;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the oc_customer database table.
 */
@Entity
@Table(name = "oc_customer")

public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;


    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "address_id")
    private int addressId;

    private boolean approved;

    private String avatar;

    @Column(name = "cart", columnDefinition = "TEXT")
    private String cart;

    @Column(name = "customer_group_id")
    private int customerGroupId;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_added")
    private Date dateAdded;

    private String email;

    private String fax;

    private String firstname;

    private String ip;

    private String lastname;

    private boolean newsletter;

    private String password;

    private String salt;

    private boolean status;

    @Column(name = "store_id")
    private int storeId;

    private String telephone;

    private String token;

    @Column(name = "wishlist", columnDefinition = "TEXT")
    private String wishlist;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.REFRESH)
    private List<Order> order = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
    private Clients clients;


    public Customer() {
    }

    public Clients getNewClient() {
        Clients c = new Clients();
        c.setFirstName(this.firstname);
        c.setLastName(this.lastname);
        c.setTel(this.telephone);
        c.setEmail(this.email);
        return c;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAddressId() {
        return this.addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCart() {
        return this.cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

    public int getCustomerGroupId() {
        return this.customerGroupId;
    }

    public void setCustomerGroupId(int customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public Date getDateAdded() {
        return this.dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return this.fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getIp() {
        return this.ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getLastname() {
        return this.lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return this.salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getStoreId() {
        return this.storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getWishlist() {
        return this.wishlist;
    }

    public void setWishlist(String wishlist) {
        this.wishlist = wishlist;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public boolean isNewsletter() {
        return newsletter;
    }

    public void setNewsletter(boolean newsletter) {
        this.newsletter = newsletter;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }
}