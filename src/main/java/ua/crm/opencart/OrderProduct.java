package ua.crm.opencart;

import javax.persistence.*;
import java.math.BigDecimal;

import ua.crm.DB.Orders;
import ua.crm.DB.OrderDetails;


/**
 * The persistent class for the oc_order_product database table.
 */
@Entity
@Table(name = "oc_order_product")

public class OrderProduct {


    @Id
    @Column(name = "order_product_id")
    private int orderProductId;

    private String model;

    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    private int quantity;

    private int reward;

    private BigDecimal tax;

    private BigDecimal total;

    public OrderProduct() {
    }

    public OrderDetails getOrderDetails(Orders order, BigDecimal currency) {
        return new OrderDetails(order, product, quantity, price.multiply(currency).setScale(0, BigDecimal.ROUND_HALF_UP).floatValue(), 0);
    }

    public int getOrderProductId() {
        return this.orderProductId;
    }

    public void setOrderProductId(int orderProductId) {
        this.orderProductId = orderProductId;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getReward() {
        return this.reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public BigDecimal getTax() {
        return this.tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getTotal() {
        return this.total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}