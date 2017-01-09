package ua.crm.DB;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import ua.crm.opencart.Order;
import ua.crm.privatbank.StatementDB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private Date orderDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Client_ID")
    @NotFound(action = NotFoundAction.IGNORE)
    private Clients client;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_Type_ID")
    private DeliveryType deliveryType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_Type_ID")
    private PaymentType paymentType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_Status_ID")
    private PaymentStatus paymentStatus;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_Status_ID")
    private DeliveryStatus deliveryStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channel_ID")
    private ChannelType channelType;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_Status_ID")
    private OrderStatus orderStatus;

    private String comments = "";


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_ID_Another")
    @NotFound(action = NotFoundAction.IGNORE)
    private Order order;


    private Float deliveryCost;


    private String npDocNumber = "";
    private String npDocRef = "";
    private Boolean smsSent = false;
    private Date dateSent;
    private Date estimatedDeliveryDate;
    private Boolean reviewRequsted = false;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails = new ArrayList<>();

    @OneToOne(mappedBy = "order", cascade = {CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    private StatementDB statemenDB;

    public Orders() {
    }

    public Orders(DeliveryStatus ds, PaymentStatus ps, OrderStatus os, ChannelType ct) {
        this.deliveryStatus = ds;
        this.paymentStatus = ps;
        this.orderStatus = os;
        this.channelType = ct;
    }

    public Orders(Date orderDate, Clients client, DeliveryType deliveryType, PaymentType paymentType, PaymentStatus paymentStatus, DeliveryStatus deliveryStatus, ChannelType channelType, ua.crm.DB.OrderStatus orderStatus, String comments, Order order) {
        this.orderDate = orderDate;
        this.client = client;
        this.deliveryType = deliveryType;
        this.paymentType = paymentType;
        this.paymentStatus = paymentStatus;
        this.deliveryStatus = deliveryStatus;
        this.channelType = channelType;
        this.orderStatus = orderStatus;
        this.comments = comments;
        this.order = order;
    }

    public float getOrderSum() {
        final float[] sum = {0};
        orderDetails.forEach(n -> sum[0] = sum[0] + n.getPrice() * n.getCount() - n.getDiscount());
        return sum[0];
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Clients getClient() {
        return client;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public DeliveryType getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(DeliveryType deliveryType) {
        this.deliveryType = deliveryType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public ChannelType getChannelType() {
        return channelType;
    }

    public void setChannelType(ChannelType channelType) {
        this.channelType = channelType;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

//    public int getOrder_ID_Another() {
//        return order_ID_Another;
//    }
//
//    public void setOrder_ID_Another(int order_ID_Another) {
//        this.order_ID_Another = order_ID_Another;
//    }

    public float getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(float deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getNpDocNumber() {
        return npDocNumber;
    }

    public String getNpDocNumberFormat() {

        return (npDocNumber == null || npDocNumber.equals("")) ? "" : new StringBuilder(npDocNumber.substring(0, 2)).append(" ").append(npDocNumber.substring(2, 6)).append(" ").append(npDocNumber.substring(6, 10)).append(" ").append(npDocNumber.substring(10)).toString();
    }


    public void setNpDocNumber(String npDocNumber) {
        this.npDocNumber = npDocNumber;
    }

    public String getNpDocRef() {
        return npDocRef;
    }

    public void setNpDocRef(String npDocRef) {
        this.npDocRef = npDocRef;
    }

    public Boolean getSmsSent() {
        return smsSent;
    }

    public void setSmsSent(Boolean smsSent) {
        this.smsSent = smsSent;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public Boolean getReviewRequsted() {
        return reviewRequsted;
    }

    public void setReviewRequsted(Boolean reviewRequsted) {
        this.reviewRequsted = reviewRequsted;
    }

    public List<OrderDetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<OrderDetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public StatementDB getStatemenDB() {
        return statemenDB;
    }

    public void setStatemenDB(StatementDB statemenDB) {
        this.statemenDB = statemenDB;
    }

    @Override
    public String toString() {
        return "";

    }
}
