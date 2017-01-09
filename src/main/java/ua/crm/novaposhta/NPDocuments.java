package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Oleg on 09.09.2016.
 */
public class NPDocuments {
    @SerializedName("DocumentNumber")
    private String documentNumber;
    @SerializedName("Phone")
    private String phone = "380999050857";

    public NPDocuments() {
    }

    public NPDocuments(String documentNumber) {
        this.documentNumber = documentNumber;
    }
}
