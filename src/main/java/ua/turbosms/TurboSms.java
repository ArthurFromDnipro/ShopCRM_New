package ua.turbosms;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name="sribnyk")
public class TurboSms {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Transient
    private Date added;
    @Transient
    private BigDecimal balance;
    @Transient
    private BigDecimal cost;
    @Transient
    @Column(name = "error_code")
    private char errorCode;

    @Column(name = "is_flash")
    private boolean isFlash;

    private String message;
    @Transient
    @Column(name = "msg_id")
    private char msgId;

    private String number;
    @Transient
    private Date received;

    @Column(name = "send_time")
    private Date sendTime;
    @Transient
    private Date sended;

    private String sign;
    @Transient
    @Enumerated
    @Column(columnDefinition = "enum('ACCEPTD','ENROUTE','DELIVRD','REJECTD','UNDELIV','EXPIRED','DELETED','UNKNOWN')")
    private SmsStatus status;

    private String wappush;

    public TurboSms() {
    }

    public TurboSms(Date sendTime, String sign, String number, String message, boolean isFlash, String wappush) {
        this.sendTime = sendTime;
        this.sign = sign;
        this.number = number;
        this.message = message;
        this.isFlash = isFlash;
        this.wappush = wappush;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getCost() {
        return this.cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public char getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(char errorCode) {
        this.errorCode = errorCode;
    }

    public boolean isFlash() {
        return isFlash;
    }

    public void setFlash(boolean flash) {
        isFlash = flash;
    }

    public char getMsgId() {
        return msgId;
    }

    public void setMsgId(char msgId) {
        this.msgId = msgId;
    }

    public SmsStatus getStatus() {
        return status;
    }

    public void setStatus(SmsStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


    public String getSign() {
        return this.sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

//    public String getStatus() {
//        return this.status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public String getWappush() {
        return this.wappush;
    }

    public void setWappush(String wappush) {
        this.wappush = wappush;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public Date getReceived() {
        return received;
    }

    public void setReceived(Date received) {
        this.received = received;
    }

    public Date getSendTime() {
        return sendTime;
    }

    public void setSendTime(Date sendTime) {
        this.sendTime = sendTime;
    }

    public Date getSended() {
        return sended;
    }

    public void setSended(Date sended) {
        this.sended = sended;
    }


}
