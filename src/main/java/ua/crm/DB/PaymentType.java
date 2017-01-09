package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "paymenttype")
public class PaymentType {
    @Id
    private int id;
    private String paymentType;

    @OneToMany(mappedBy = "paymentType",cascade = CascadeType.REFRESH)
    private List<Orders> orders=new ArrayList<>();

    public PaymentType() {
    }

    public PaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "PaymentType{" +
                "id=" + id +
                ", paymentType='" + paymentType + '\'' +
                ", orders=" + orders +
                '}';
    }
}
