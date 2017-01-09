package ua.crm.DB;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Oleg on 07.09.2016.
 */
public interface OrdersDao extends JpaRepository<Orders, Integer> {
    @Query("SELECT o FROM Orders o where o.orderDate >= :fromDate and o.orderDate <= :toDate ORDER BY o.id ASC")
    List<Orders> findByDate(@Param("fromDate") Date from, @Param("toDate") Date to);


    //@Query("SELECT o FROM Orders o where (o.orderDate >= :fromDate and o.orderDate <= :toDate) and ((concat(o.client.firstName,' ',o.client.lastName) LIKE :name) or (o.client.tel LIKE :tel))  ORDER BY o.id ASC")
    @Query("SELECT o FROM Orders o where o.orderDate >= :fromDate and o.orderDate <= :toDate and o.client.tel LIKE :tel and lower(concat(o.client.firstName,' ',o.client.lastName)) LIKE :name  ORDER BY o.id DESC")
    List<Orders> findByDateNameTel(@Param("fromDate") Date from, @Param("toDate") Date to, @Param("tel") String tel, @Param("name") String name);


    ///
    @Query("SELECT o FROM Orders o where (o.client.npWarehouses is not null) and (o.client.npCities is not null) and (o.deliveryType.id=1) and (o.deliveryStatus.id=1) and (o.orderStatus.id=4) and ((o.paymentType.id=1 and o.paymentStatus.id=1) or(o.paymentType.id<>1 and o.paymentStatus.id=2)) ORDER BY o.id ASC")
    List<Orders> findForSend();

    @Query("SELECT count(o.id) FROM Orders o where (o.client.npWarehouses is not null) and (o.client.npCities is not null) and (o.deliveryType.id=1) and (o.deliveryStatus.id=1) and (o.orderStatus.id=4) and ((o.paymentType.id=1 and o.paymentStatus.id=1) or(o.paymentType.id<>1 and o.paymentStatus.id=2)) ORDER BY o.id ASC")
    Integer findForSendCount();


    @Query("SELECT o FROM Orders o where o.dateSent = :sendDate and o.smsSent=false and o.orderStatus.id=5 and o.npDocNumber<>'' and o.npDocNumber is not null ORDER BY o.id ASC")
    List<Orders> findForSmsSendByDate(@Param("sendDate") Date sendDate);


    @Query("SELECT o FROM Orders o where o.reviewRequsted=false and o.deliveryStatus.id=3 ORDER BY o.id ASC")
    List<Orders> findForReviewRequest();

    @Query("SELECT count(o.id) FROM Orders o where o.reviewRequsted=false and o.deliveryStatus.id=3 ORDER BY o.id ASC")
    Integer findForReviewRequestCount();


    //
    @Query("SELECT o FROM Orders o where o.estimatedDeliveryDate<= :deadLine and o.npDocNumber<>'' and o.npDocNumber is not null and o.orderStatus.id=5 and (o.deliveryStatus.id<>3 or o.deliveryStatus.id is null) ORDER BY o.id ASC")
    List<Orders> findOldDeliveries(@Param("deadLine") Date deadLine);

    @Query("SELECT count(o.id) FROM Orders o where o.estimatedDeliveryDate<= :deadLine and o.npDocNumber<>'' and o.npDocNumber is not null and o.orderStatus.id=5 and (o.deliveryStatus.id<>3 or o.deliveryStatus.id is null) ORDER BY o.id ASC")
    Integer findOldDeliveriesCount(@Param("deadLine") Date deadLine);



    @Query("SELECT o FROM Orders o where o.npDocNumber<>'' and o.npDocNumber is not null and o.orderStatus.id=5 and o.deliveryStatus.id=2 and o.deliveryType.id=1 and o.dateSent<CURRENT_DATE  ORDER BY o.id ASC")
    List<Orders> findForCheck();

    @Query("SELECT o FROM Orders o where (o.dateSent >= :fromDate) and (o.dateSent <= :toDate) and ((o.orderStatus.id=5) or (o.orderStatus.id=7))  ORDER BY o.dateSent ASC")
    List<Orders> getSalesByDate(@Param("fromDate") Date from, @Param("toDate") Date to);

    @Query("SELECT o FROM Orders o where o.deliveryStatus.id=1 and o.paymentType.id=2 and o.paymentStatus.id=1 and o.orderStatus=1 ORDER BY o.id DESC")
    List<Orders> getForPayment();


}

