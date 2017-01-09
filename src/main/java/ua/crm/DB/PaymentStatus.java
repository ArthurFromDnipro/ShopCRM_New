package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "paymentstatus")
public class PaymentStatus {
    @Id
    private int id;
    private String paymentStatus;

    @OneToMany(mappedBy = "paymentStatus",cascade = CascadeType.REFRESH)
    private List<Orders> orders=new ArrayList<>();

    public PaymentStatus() {
    }

    public PaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "PaymentStatus{" +
                "id=" + id +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", orders=" + orders +
                '}';
    }
}
