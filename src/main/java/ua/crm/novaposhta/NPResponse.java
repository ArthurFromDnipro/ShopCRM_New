package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.08.2016.
 */
public class NPResponse<T> {
    @SerializedName("success")
    private Boolean success;
    @SerializedName("data")
    private List<T> data = new ArrayList<>();
    @SerializedName("errors")
    private List<String> errors = new ArrayList<>();
    @SerializedName("warnings")
    private List<String> warnings = new ArrayList<>();
    @SerializedName("info")
    private List<String> info = new ArrayList<>();
    @SerializedName("messageCodes")
    private List<String> messageCodes = new ArrayList<>();
    @SerializedName("errorCodes")
    private List<String> errorCodes = new ArrayList<>();
    @SerializedName("warningCodes")
    private List<String> warningCodes = new ArrayList<>();
    @SerializedName("infoCodes")
    private List<String> infoCodes = new ArrayList<>();


    public NPResponse() {
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public void setWarnings(List<String> warnings) {
        this.warnings = warnings;
    }

    public List<String> getInfo() {
        return info;
    }

    public void setInfo(List<String> info) {
        this.info = info;
    }

    public List<String> getMessageCodes() {
        return messageCodes;
    }

    public void setMessageCodes(List<String> messageCodes) {
        this.messageCodes = messageCodes;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    public List<String> getWarningCodes() {
        return warningCodes;
    }

    public void setWarningCodes(List<String> warningCodes) {
        this.warningCodes = warningCodes;
    }

    public List<String> getInfoCodes() {
        return infoCodes;
    }

    public void setInfoCodes(List<String> infoCodes) {
        this.infoCodes = infoCodes;
    }


    @Override
    public String toString() {
        return "NPResponse{" +
                "success=" + success +
                ", data=" + data +
                ", errors=" + errors +
                ", warnings=" + warnings +
                ", info=" + info +
                '}';
    }
}
