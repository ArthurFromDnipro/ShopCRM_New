package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 09.09.2016.
 */
public class NPTrackingDocumentRequest {
    @SerializedName("Documents")
    private List<NPDocuments> documents = new ArrayList<>();
    @SerializedName("Language")
    private String language = "UA";

    public NPTrackingDocumentRequest() {
    }

    public NPTrackingDocumentRequest(String npDocument) {
        documents.add(new NPDocuments(npDocument));
    }

}
