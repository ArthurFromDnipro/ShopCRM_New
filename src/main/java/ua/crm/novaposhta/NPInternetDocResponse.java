package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPInternetDocResponse {
    @SerializedName("Ref")
    private String ref;
    @SerializedName("CostOnSite")
    private String costOnSite;
    @SerializedName("EstimatedDeliveryDate")
    private String estimatedDeliveryDate;
    @SerializedName("IntDocNumber")
    private String intDocNumber;
    @SerializedName("TypeDocument")
    private String typeDocument;

    public NPInternetDocResponse() {
    }

    public NPInternetDocResponse(String ref, String costOnSite, String estimatedDeliveryDate, String intDocNumber, String typeDocument) {
        this.ref = ref;
        this.costOnSite = costOnSite;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
        this.intDocNumber = intDocNumber;
        this.typeDocument = typeDocument;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCostOnSite() {
        return costOnSite;
    }

    public void setCostOnSite(String costOnSite) {
        this.costOnSite = costOnSite;
    }

    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public String getIntDocNumber() {
        return intDocNumber;
    }

    public void setIntDocNumber(String intDocNumber) {
        this.intDocNumber = intDocNumber;
    }

    public String getTypeDocument() {
        return typeDocument;
    }

    public void setTypeDocument(String typeDocument) {
        this.typeDocument = typeDocument;
    }

    @Override
    public String toString() {
        return "NPInternetDocResponse{" +
                "ref='" + ref + '\'' +
                ", costOnSite='" + costOnSite + '\'' +
                ", estimatedDeliveryDate='" + estimatedDeliveryDate + '\'' +
                ", intDocNumber='" + intDocNumber + '\'' +
                ", typeDocument='" + typeDocument + '\'' +
                '}';
    }
}
