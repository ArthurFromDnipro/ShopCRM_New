package ua.crm.DB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.crm.novaposhta.NPCounterparty;
import ua.crm.privatbank.StatementDB;
import ua.crm.privatbank.StatementDBDao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 27.09.2016.
 */
@Service
public class CrmService {
    @Autowired
    private OrdersDao ordersDao;

    @Autowired
    private DeliveryStatusDao deliveryStatusDao;

    @Autowired
    private DeliveryTypeDao deliveryTypeDao;

    @Autowired
    private PaymentStatusDao paymentStatusDao;

    @Autowired
    private PaymentTypeDao paymentTypeDao;

    @Autowired
    private OrderStatusDao orderStatusDao;

    @Autowired
    private ChannelTypeDao channelTypeDao;

    @Autowired
    private ClientsDao clientsDao;

    @Autowired
    private OrderDetailsDao orderDetailsDao;

    @Autowired
    private StatementDBDao statementDBDao;


    @Transactional(readOnly = true)
    public List<Orders> getOrders() {
        return ordersDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrdersForSmsSendByDate(Date date) {
        return ordersDao.findForSmsSendByDate(date);
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrdersForReviewRequest() {
        return ordersDao.findForReviewRequest();
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrdersOldDeliveries() {
        Date deadLine = new Date();
        Calendar deadLineDate = Calendar.getInstance();
        deadLineDate.add(Calendar.DAY_OF_MONTH, -4);
        deadLine = deadLineDate.getTime();
        return ordersDao.findOldDeliveries(deadLine);
    }

    @Transactional(readOnly = true)
    public List<Orders> findOrdersForCheck() {
        return ordersDao.findForCheck();
    }

    @Transactional(readOnly = true)
    public List<Orders> getSalesByDate(Date from, Date to) {
        return ordersDao.getSalesByDate(from, to);
    }

    @Transactional(readOnly = true)
    public List<Orders> getOrdersForPayment() {
        return ordersDao.getForPayment();
    }

    @Transactional
    public void setPaymentForOrder(int o, String p) {
        Orders order = ordersDao.getOne(o);
        StatementDB statementDB = statementDBDao.getOne(p);

        order.setPaymentStatus(paymentStatusDao.getOne(2));
        order.setStatemenDB(statementDB);
        statementDB.setOrder(order);

        ordersDao.save(order);
        statementDBDao.save(statementDB);
    }

    @Transactional
    public void saveOrder(Orders order) {
        ordersDao.save(order);
    }

    @Transactional
    public void saveClient(Clients client) {
        clientsDao.save(client);
    }

    @Transactional(readOnly = true)
    public Clients getClient(int i) {
        return clientsDao.getOne(i);
    }

    @Transactional(readOnly = true)
    public List<Clients> getClientsByNameTel(String name, String tel) {
        System.out.println(name);
        System.out.println(tel);
        return clientsDao.findByNameTel(name, tel);
    }

    @Transactional(readOnly = true)
    public Clients getOneClientByTel(String tel) {
        return clientsDao.getOneByTel(tel);
    }

    @Transactional
    public void addCountertpartyToClients(Clients client, NPCounterparty npCounterparty) {
        if (npCounterparty == null) {
            return;
        }
        client.setNpCounterparty(npCounterparty);
        npCounterparty.setClients(client);
        clientsDao.save(client);
    }

    @Transactional
    public void saveOrderDetails(List<OrderDetails> orderDetails) {
        orderDetails.forEach(n -> {
            if (n.getCount() == 0) {
                System.out.println(n.getId());
                n.setOrder(null);
                delOrderDetails(n.getId());

            } else {
                orderDetailsDao.save(n);
            }
        });

    }

    @Transactional(readOnly = true)
    public Integer findForReviewRequestCount() {
        return ordersDao.findForReviewRequestCount();
    }

    @Transactional(readOnly = true)
    public Integer findForSendCount() {
        return ordersDao.findForSendCount();
    }

    @Transactional(readOnly = true)
    public Integer findOldDeliveriesCount() {
        Date deadLine = new Date();
        Calendar deadLineDate = Calendar.getInstance();
        deadLineDate.add(Calendar.DAY_OF_MONTH, -4);
        deadLine = deadLineDate.getTime();
        return ordersDao.findOldDeliveriesCount(deadLine);
    }


    @Transactional(readOnly = true)
    public OrderDetails getOrderDetails(int id) {
        return orderDetailsDao.getOne(id);
    }

    @Transactional
    public void delOrderDetails(int id) {
        orderDetailsDao.delete(id);


        //orderDetailsDao
    }


    @Transactional(readOnly = true)
    public List<Orders> getOrdersByDates(Date from, Date to) {
        return ordersDao.findByDate(from, to);
    }

    @Transactional(readOnly = true)
    public List<Orders> getOrdersForSend() {
        return ordersDao.findForSend();
    }


    @Transactional(readOnly = true)
    public List<Orders> getfindByDateNameTel(Date from, Date to, String name, String tel) {
        return ordersDao.findByDateNameTel(from, to, tel, name);
    }


    @Transactional(readOnly = true)
    public Orders getOrder(int id) {
        return ordersDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public DeliveryType getDeliveryType(int id) {
        return deliveryTypeDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public DeliveryStatus getDeliveryStatus(int id) {
        return deliveryStatusDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public PaymentType getPaymentType(int id) {

        return paymentTypeDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public PaymentStatus getPaymentStatus(int id) {
        return paymentStatusDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public OrderStatus getOrderStatus(int id) {
        return orderStatusDao.getOne(id);
    }

    @Transactional(readOnly = true)
    public ChannelType getChannelType(int id) {
        return channelTypeDao.getOne(id);
    }


    @Transactional(readOnly = true)
    public List<DeliveryStatus> getDeliveryStatus() {
        return deliveryStatusDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<DeliveryType> getDeliveryType() {
        return deliveryTypeDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<PaymentStatus> getPaymentStatus() {
        return paymentStatusDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<PaymentType> getPaymentType() {
        return paymentTypeDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<OrderStatus> getOrderStatus() {
        return orderStatusDao.findAll();
    }

    @Transactional(readOnly = true)
    public List<ChannelType> getChannelType() {
        return channelTypeDao.findAll();
    }


}
