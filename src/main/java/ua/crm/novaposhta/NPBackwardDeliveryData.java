package ua.crm.novaposhta;


/**
 * Created by Oleg on 30.08.2016.
 */

public class NPBackwardDeliveryData {
    private String PayerType = "Recipient";
    private String CargoType = "Money";
    private String RedeliveryString;

    public NPBackwardDeliveryData() {
    }

    public NPBackwardDeliveryData(String redeliveryString) {
        RedeliveryString = redeliveryString;
    }

    public NPBackwardDeliveryData(String payerType, String cargoType, String redeliveryString) {
        PayerType = payerType;
        CargoType = cargoType;
        RedeliveryString = redeliveryString;
    }

    public String getPayerType() {
        return PayerType;
    }

    public void setPayerType(String payerType) {
        PayerType = payerType;
    }

    public String getCargoType() {
        return CargoType;
    }

    public void setCargoType(String cargoType) {
        CargoType = cargoType;
    }

    public String getRedeliveryString() {
        return RedeliveryString;
    }

    public void setRedeliveryString(String redeliveryString) {
        RedeliveryString = redeliveryString;
    }

    @Override
    public String toString() {
        return "NPBackwardDeliveryData{" +
                "PayerType='" + PayerType + '\'' +
                ", CargoType='" + CargoType + '\'' +
                ", RedeliveryString='" + RedeliveryString + '\'' +
                '}';
    }
}
