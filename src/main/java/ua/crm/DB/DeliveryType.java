package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "deliverytype")
public class DeliveryType {
    @Id
    private int id;
    private String deliveryType;

    @OneToMany(mappedBy = "deliveryType",cascade = CascadeType.REFRESH)
    private List<Orders> orders=new ArrayList<>();

    public DeliveryType() {
    }

    public DeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "DeliveryType{" +
                "id=" + id +
                ", deliveryType='" + deliveryType + '\'' +
                ", orders=" + orders +
                '}';
    }
}
