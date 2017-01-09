package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "deliverystatus")
public class DeliveryStatus {
    @Id
    private int id;
    private String deliveryStatus;

    @OneToMany(mappedBy = "deliveryStatus",cascade = CascadeType.REFRESH)
    private List<Orders> orders=new ArrayList<>();

    public DeliveryStatus() {
    }

    public DeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "DeliveryStatus{" +
                "id=" + id +
                ", deliveryStatus='" + deliveryStatus + '\'' +
                ", orders=" + orders +
                '}';
    }
}
