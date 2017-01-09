package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "orderstatus")
public class OrderStatus {
    @Id
    private int id;
    private String orderStatus;

    @OneToMany(mappedBy = "orderStatus",cascade = CascadeType.REFRESH)
    private List<Orders> orders=new ArrayList<>();

    public OrderStatus() {
    }

    public OrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "OrderStatus{" +
                "id=" + id +
                ", orderStatus='" + orderStatus + '\'' +
                ", orders=" + orders +
                '}';
    }
}
