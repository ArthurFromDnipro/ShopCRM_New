package ua.turbosms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.crm.DB.Orders;
import ua.crm.DB.OrdersDao;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by Oleg on 12.09.2016.
 */
@Service
public class TurboSmsService {

    @Autowired
    private TurboSmsDao turboSmsDao;

    @Autowired
    private OrdersDao ordersDao;


    @Transactional
    public void sendNPDocNumber(Orders order, Date sendTime) {

        StringBuilder sb = new StringBuilder(order.getClient().getFirstName());
        sb.append(", замовлення відправлено. Накладна НП: ").append(order.getNpDocNumberFormat()).append(". Дякуємо за замовлення. 099-905-08-57 sribnyk.com.ua");
        sendSMS(sendTime, "SRIBNYK", order.getClient().getTel(), sb.toString(), false, "");
        order.setSmsSent(true);
        ordersDao.save(order);
    }

    @Transactional
    public void sendReviewRequest(Orders order, Date sendTime) {

        sendSMS(sendTime, "SRIBNYK", order.getClient().getTel(), "Дякуємо за замовлення в Інтернет магазині «Срібник», будемо вдячні за гарний відгук на сайті: sribnyk.com.ua або у спільноті Facebook: fb.com/sribnyk. Ваша думка дуже важлива. Гарного дня! :)", false, "");
        order.setReviewRequsted(true);
        ordersDao.save(order);
    }


    @Transactional
    public void sendSMS(Date sendTime, String sign, String number, String message, boolean isFlash, String wappush) {


        turboSmsDao.save(new TurboSms(sendTime, sign, number, message, isFlash, wappush));


    }
}
