package ua.crm.DB;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ua.crm.opencart.Product;

import javax.persistence.*;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "orderdetails")
public class OrderDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Order_id")
    @NotFound(action= NotFoundAction.IGNORE)

    private Orders order;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "productId")
    @NotFound(action=NotFoundAction.IGNORE)
    private Product product;


    private int count = 1;
    private float price;
    private float discount = 0;

    public OrderDetails() {
    }

    public OrderDetails(Product product, int count, float price, float discount) {
        this.product = product;
        this.count = count;
        this.price = price;
        this.discount = discount;
    }

    public OrderDetails(Orders order, Product product, int count, float price, float discount) {
        this.order = order;
        this.product = product;
        this.count = count;
        this.price = price;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", count=" + count +
                ", price=" + price +
                ", discount=" + discount +
                '}';
    }
}