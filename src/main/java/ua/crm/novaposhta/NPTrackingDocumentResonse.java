package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 09.09.2016.
 */
public class NPTrackingDocumentResonse {
    @SerializedName("Number")
    private String number;
    @SerializedName("DateCreated")
    private String dateCreated;
    @SerializedName("DocumentWeight")
    private String documentWeight;
    @SerializedName("CheckWeight")
    private String checkWeight;
    @SerializedName("DocumentCost")
    private String documentCost;
    @SerializedName("SumBeforeCheckWeight")
    private String sumBeforeCheckWeight;
    @SerializedName("PayerType")
    private String payerType;
    @SerializedName("RecipientFullName")
    private String recipientFullName;
    @SerializedName("RecipientDateTime")
    private String recipientDateTime;
    @SerializedName("OwnerDocumentType")
    private String ownerDocumentType;
    @SerializedName("ScheduledDeliveryDate")
    private String scheduledDeliveryDate;
    @SerializedName("PaymentMethod")
    private String paymentMethod;
    @SerializedName("CargoDescriptionString")
    private String cargoDescriptionString;
    @SerializedName("CargoType")
    private String cargoType;
    @SerializedName("CitySender")
    private String citySender;
    @SerializedName("CityRecipient")
    private String cityRecipient;
    @SerializedName("WarehouseRecipient")
    private String warehouseRecipient;
    @SerializedName("CounterpartyType")
    private String counterpartyType;
    @SerializedName("Redelivery")
    private String redelivery;
    @SerializedName("RedeliverySum")
    private String redeliverySum;
    @SerializedName("RedeliveryNum")
    private String redeliveryNum;
    @SerializedName("RedeliveryPayer")
    private String redeliveryPayer;
    @SerializedName("AfterpaymentOnGoodsCost")
    private String afterpaymentOnGoodsCost;
    @SerializedName("ServiceType")
    private String serviceType;
    @SerializedName("UndeliveryReasonsSubtypeDescription")
    private String undeliveryReasonsSubtypeDescription;
    @SerializedName("WarehouseRecipientNumber")
    private String warehouseRecipientNumber;
    @SerializedName("LastCreatedOnTheBasisNumber")
    private String lastCreatedOnTheBasisNumber;
    @SerializedName("LastCreatedOnTheBasisDocumentType")
    private String lastCreatedOnTheBasisDocumentType;
    @SerializedName("LastCreatedOnTheBasisPayerType")
    private String lastCreatedOnTheBasisPayerType;
    @SerializedName("LastCreatedOnTheBasisDateTime")
    private String lastCreatedOnTheBasisDateTime;
    @SerializedName("LastTransactionStatusGM")
    private String lastTransactionStatusGM;
    @SerializedName("LastTransactionDateTimeGM")
    private String lastTransactionDateTimeGM;
    @SerializedName("WarehouseRecipientInternetAddressRef")
    private String warehouseRecipientInternetAddressRef;
    @SerializedName("Status")
    private String status;
    @SerializedName("StatusCode")
    private String statusCode;

    public NPTrackingDocumentResonse() {
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDocumentWeight() {
        return documentWeight;
    }

    public void setDocumentWeight(String documentWeight) {
        this.documentWeight = documentWeight;
    }

    public String getCheckWeight() {
        return checkWeight;
    }

    public void setCheckWeight(String checkWeight) {
        this.checkWeight = checkWeight;
    }

    public String getDocumentCost() {
        return documentCost;
    }

    public void setDocumentCost(String documentCost) {
        this.documentCost = documentCost;
    }

    public String getSumBeforeCheckWeight() {
        return sumBeforeCheckWeight;
    }

    public void setSumBeforeCheckWeight(String sumBeforeCheckWeight) {
        this.sumBeforeCheckWeight = sumBeforeCheckWeight;
    }

    public String getPayerType() {
        return payerType;
    }

    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    public String getRecipientFullName() {
        return recipientFullName;
    }

    public void setRecipientFullName(String recipientFullName) {
        this.recipientFullName = recipientFullName;
    }

    public String getRecipientDateTime() {
        return recipientDateTime;
    }

    public void setRecipientDateTime(String recipientDateTime) {
        this.recipientDateTime = recipientDateTime;
    }

    public String getOwnerDocumentType() {
        return ownerDocumentType;
    }

    public void setOwnerDocumentType(String ownerDocumentType) {
        this.ownerDocumentType = ownerDocumentType;
    }

    public String getScheduledDeliveryDate() {
        return scheduledDeliveryDate;
    }

    public void setScheduledDeliveryDate(String scheduledDeliveryDate) {
        this.scheduledDeliveryDate = scheduledDeliveryDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCargoDescriptionString() {
        return cargoDescriptionString;
    }

    public void setCargoDescriptionString(String cargoDescriptionString) {
        this.cargoDescriptionString = cargoDescriptionString;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getCitySender() {
        return citySender;
    }

    public void setCitySender(String citySender) {
        this.citySender = citySender;
    }

    public String getCityRecipient() {
        return cityRecipient;
    }

    public void setCityRecipient(String cityRecipient) {
        this.cityRecipient = cityRecipient;
    }

    public String getWarehouseRecipient() {
        return warehouseRecipient;
    }

    public void setWarehouseRecipient(String warehouseRecipient) {
        this.warehouseRecipient = warehouseRecipient;
    }

    public String getCounterpartyType() {
        return counterpartyType;
    }

    public void setCounterpartyType(String counterpartyType) {
        this.counterpartyType = counterpartyType;
    }

    public String getRedelivery() {
        return redelivery;
    }

    public void setRedelivery(String redelivery) {
        this.redelivery = redelivery;
    }

    public String getRedeliverySum() {
        return redeliverySum;
    }

    public void setRedeliverySum(String redeliverySum) {
        this.redeliverySum = redeliverySum;
    }

    public String getRedeliveryNum() {
        return redeliveryNum;
    }

    public void setRedeliveryNum(String redeliveryNum) {
        this.redeliveryNum = redeliveryNum;
    }

    public String getRedeliveryPayer() {
        return redeliveryPayer;
    }

    public void setRedeliveryPayer(String redeliveryPayer) {
        this.redeliveryPayer = redeliveryPayer;
    }

    public String getAfterpaymentOnGoodsCost() {
        return afterpaymentOnGoodsCost;
    }

    public void setAfterpaymentOnGoodsCost(String afterpaymentOnGoodsCost) {
        this.afterpaymentOnGoodsCost = afterpaymentOnGoodsCost;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getUndeliveryReasonsSubtypeDescription() {
        return undeliveryReasonsSubtypeDescription;
    }

    public void setUndeliveryReasonsSubtypeDescription(String undeliveryReasonsSubtypeDescription) {
        this.undeliveryReasonsSubtypeDescription = undeliveryReasonsSubtypeDescription;
    }

    public String getWarehouseRecipientNumber() {
        return warehouseRecipientNumber;
    }

    public void setWarehouseRecipientNumber(String warehouseRecipientNumber) {
        this.warehouseRecipientNumber = warehouseRecipientNumber;
    }

    public String getLastCreatedOnTheBasisNumber() {
        return lastCreatedOnTheBasisNumber;
    }

    public void setLastCreatedOnTheBasisNumber(String lastCreatedOnTheBasisNumber) {
        this.lastCreatedOnTheBasisNumber = lastCreatedOnTheBasisNumber;
    }

    public String getLastCreatedOnTheBasisDocumentType() {
        return lastCreatedOnTheBasisDocumentType;
    }

    public void setLastCreatedOnTheBasisDocumentType(String lastCreatedOnTheBasisDocumentType) {
        this.lastCreatedOnTheBasisDocumentType = lastCreatedOnTheBasisDocumentType;
    }

    public String getLastCreatedOnTheBasisPayerType() {
        return lastCreatedOnTheBasisPayerType;
    }

    public void setLastCreatedOnTheBasisPayerType(String lastCreatedOnTheBasisPayerType) {
        this.lastCreatedOnTheBasisPayerType = lastCreatedOnTheBasisPayerType;
    }

    public String getLastCreatedOnTheBasisDateTime() {
        return lastCreatedOnTheBasisDateTime;
    }

    public void setLastCreatedOnTheBasisDateTime(String lastCreatedOnTheBasisDateTime) {
        this.lastCreatedOnTheBasisDateTime = lastCreatedOnTheBasisDateTime;
    }

    public String getLastTransactionStatusGM() {
        return lastTransactionStatusGM;
    }

    public void setLastTransactionStatusGM(String lastTransactionStatusGM) {
        this.lastTransactionStatusGM = lastTransactionStatusGM;
    }

    public String getLastTransactionDateTimeGM() {
        return lastTransactionDateTimeGM;
    }

    public void setLastTransactionDateTimeGM(String lastTransactionDateTimeGM) {
        this.lastTransactionDateTimeGM = lastTransactionDateTimeGM;
    }

    public String getWarehouseRecipientInternetAddressRef() {
        return warehouseRecipientInternetAddressRef;
    }

    public void setWarehouseRecipientInternetAddressRef(String warehouseRecipientInternetAddressRef) {
        this.warehouseRecipientInternetAddressRef = warehouseRecipientInternetAddressRef;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public String toString() {
        return "NPTrackingDocumentResonse{" +
                "number='" + number + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                ", documentWeight='" + documentWeight + '\'' +
                ", checkWeight='" + checkWeight + '\'' +
                ", documentCost='" + documentCost + '\'' +
                ", sumBeforeCheckWeight='" + sumBeforeCheckWeight + '\'' +
                ", payerType='" + payerType + '\'' +
                ", recipientFullName='" + recipientFullName + '\'' +
                ", recipientDateTime='" + recipientDateTime + '\'' +
                ", ownerDocumentType='" + ownerDocumentType + '\'' +
                ", scheduledDeliveryDate='" + scheduledDeliveryDate + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", cargoDescriptionString='" + cargoDescriptionString + '\'' +
                ", cargoType='" + cargoType + '\'' +
                ", citySender='" + citySender + '\'' +
                ", cityRecipient='" + cityRecipient + '\'' +
                ", warehouseRecipient='" + warehouseRecipient + '\'' +
                ", counterpartyType='" + counterpartyType + '\'' +
                ", redelivery='" + redelivery + '\'' +
                ", redeliverySum='" + redeliverySum + '\'' +
                ", redeliveryNum='" + redeliveryNum + '\'' +
                ", redeliveryPayer='" + redeliveryPayer + '\'' +
                ", afterpaymentOnGoodsCost='" + afterpaymentOnGoodsCost + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", undeliveryReasonsSubtypeDescription='" + undeliveryReasonsSubtypeDescription + '\'' +
                ", warehouseRecipientNumber='" + warehouseRecipientNumber + '\'' +
                ", lastCreatedOnTheBasisNumber='" + lastCreatedOnTheBasisNumber + '\'' +
                ", lastCreatedOnTheBasisDocumentType='" + lastCreatedOnTheBasisDocumentType + '\'' +
                ", lastCreatedOnTheBasisPayerType='" + lastCreatedOnTheBasisPayerType + '\'' +
                ", lastCreatedOnTheBasisDateTime='" + lastCreatedOnTheBasisDateTime + '\'' +
                ", lastTransactionStatusGM='" + lastTransactionStatusGM + '\'' +
                ", lastTransactionDateTimeGM='" + lastTransactionDateTimeGM + '\'' +
                ", warehouseRecipientInternetAddressRef='" + warehouseRecipientInternetAddressRef + '\'' +
                ", status='" + status + '\'' +
                ", statusCode='" + statusCode + '\'' +
                '}';
    }
}
