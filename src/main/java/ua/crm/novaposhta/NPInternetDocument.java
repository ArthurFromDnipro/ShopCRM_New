package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;
import ua.crm.DB.Orders;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPInternetDocument {
    @SerializedName("InfoRegClientBarcodes")
    private String infoRegClientBarcodes;
    @SerializedName("BackwardDeliveryData")
    private List<NPBackwardDeliveryData> backwardDeliveryData = new ArrayList<>();
    @SerializedName("PayerType")
    private String payerType = "Sender";
    @SerializedName("PaymentMethod")
    private String paymentMethod = "Cash";
    @SerializedName("DateTime")
    private String dateTime;
    @SerializedName("CargoType")
    private String CargoType = "Cargo";
    @SerializedName("OptionsSeat")
    private List<NPOptionsSeat> optionsSeat;
    @SerializedName("VolumeGeneral")
    private String volumeGeneral = "0.0004";
    @SerializedName("Weight")
    private String weight = "0.1";
    @SerializedName("ServiceType")
    private String serviceType = "WarehouseWarehouse";
    @SerializedName("SeatsAmount")
    private String seatsAmount = "1";
    @SerializedName("Description")
    private String Description = "Прикраси";
    @SerializedName("Cost")
    private String cost;
    @SerializedName("CitySender")
    private String citySender = "8d5a980d-391c-11dd-90d9-001a92567626";
    @SerializedName("Sender")
    private String sender = "5d8541f7-27c5-11e5-add9-005056887b8d";
    @SerializedName("SenderAddress")
    private String senderAddress = "01ae2633-e1c2-11e3-8c4a-0050568002cf";
    @SerializedName("ContactSender")
    private String contactSender = "1ff94c23-27a5-11e5-add9-005056887b8d";
    @SerializedName("SendersPhone")
    private String sendersPhone = "380999050857";
    @SerializedName("CityRecipient")
    private String cityRecipient;
    @SerializedName("Recipient")
    private String recipient = "c962cc9f-9126-11e6-a54a-005056801333";
    @SerializedName("RecipientAddress")
    private String recipientAddress;
    @SerializedName("ContactRecipient")
    private String contactRecipient;
    @SerializedName("RecipientsPhone")
    private String recipientsPhone;


    public NPInternetDocument() {
    }

    public NPInternetDocument(Orders order) {
        Calendar c1 = Calendar.getInstance();
        DateFormat day = new SimpleDateFormat("dd.MM.yyyy");
        this.dateTime = day.format(c1.getTime());
        this.infoRegClientBarcodes = String.valueOf(order.getId());
        this.cost = "200";
        if (order.getPaymentType().getId() == 1) {
            this.cost = String.valueOf(Math.round(order.getOrderSum()));
            this.backwardDeliveryData.add(new NPBackwardDeliveryData(this.cost));
        }

        this.cityRecipient = order.getClient().getNpCities().getRef();
        this.recipientAddress = order.getClient().getNpWarehouses().getRef();
        this.contactRecipient = order.getClient().getNpCounterparty().getContactPerson().getRef();
        this.recipientsPhone = order.getClient().getNpCounterparty().getContactPerson().getPhones();

        if (order.getClient().getNpWarehouses().getNpWarehouseTypes().getDescription().split(" ")[0] == "Поштомат") {
            optionsSeat.add(new NPOptionsSeat());
        }


    }


    public String getInfoRegClientBarcodes() {
        return infoRegClientBarcodes;
    }

    public void setInfoRegClientBarcodes(String infoRegClientBarcodes) {
        this.infoRegClientBarcodes = infoRegClientBarcodes;
    }

    public List<NPBackwardDeliveryData> getBackwardDeliveryData() {
        return backwardDeliveryData;
    }

    public void setBackwardDeliveryData(List<NPBackwardDeliveryData> backwardDeliveryData) {
        this.backwardDeliveryData = backwardDeliveryData;
    }

    public String getPayerType() {
        return payerType;
    }

    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }

    public List<NPOptionsSeat> getOptionsSeat() {
        return optionsSeat;
    }

    public void setOptionsSeat(List<NPOptionsSeat> optionsSeat) {
        this.optionsSeat = optionsSeat;
    }

    public String getVolumeGeneral() {
        return volumeGeneral;
    }

    public void setVolumeGeneral(String volumeGeneral) {
        this.volumeGeneral = volumeGeneral;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSeatsAmount() {
        return seatsAmount;
    }

    public void setSeatsAmount(String seatsAmount) {
        this.seatsAmount = seatsAmount;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getCitySender() {
        return citySender;
    }

    public void setCitySender(String citySender) {
        this.citySender = citySender;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSenderAddress() {
        return senderAddress;
    }

    public void setSenderAddress(String senderAddress) {
        this.senderAddress = senderAddress;
    }

    public String getContactSender() {
        return contactSender;
    }

    public void setContactSender(String contactSender) {
        this.contactSender = contactSender;
    }

    public String getSendersPhone() {
        return sendersPhone;
    }

    public void setSendersPhone(String sendersPhone) {
        this.sendersPhone = sendersPhone;
    }

    public String getCityRecipient() {
        return cityRecipient;
    }

    public void setCityRecipient(String cityRecipient) {
        this.cityRecipient = cityRecipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getRecipientAddress() {
        return recipientAddress;
    }

    public void setRecipientAddress(String recipientAddress) {
        this.recipientAddress = recipientAddress;
    }

    public String getContactRecipient() {
        return contactRecipient;
    }

    public void setContactRecipient(String contactRecipient) {
        this.contactRecipient = contactRecipient;
    }

    public String getRecipientsPhone() {
        return recipientsPhone;
    }

    public void setRecipientsPhone(String recipientsPhone) {
        this.recipientsPhone = recipientsPhone;
    }

    @Override
    public String toString() {
        return "NPInternetDocument{" +
                "infoRegClientBarcodes='" + infoRegClientBarcodes + '\'' +
                ", backwardDeliveryData=" + backwardDeliveryData +
                ", payerType='" + payerType + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", CargoType='" + CargoType + '\'' +
                ", optionsSeat=" + optionsSeat +
                ", volumeGeneral='" + volumeGeneral + '\'' +
                ", weight='" + weight + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", seatsAmount='" + seatsAmount + '\'' +
                ", Description='" + Description + '\'' +
                ", cost='" + cost + '\'' +
                ", citySender='" + citySender + '\'' +
                ", sender='" + sender + '\'' +
                ", senderAddress='" + senderAddress + '\'' +
                ", contactSender='" + contactSender + '\'' +
                ", sendersPhone='" + sendersPhone + '\'' +
                ", cityRecipient='" + cityRecipient + '\'' +
                ", recipient='" + recipient + '\'' +
                ", recipientAddress='" + recipientAddress + '\'' +
                ", contactRecipient='" + contactRecipient + '\'' +
                ", recipientsPhone='" + recipientsPhone + '\'' +
                '}';
    }
}
