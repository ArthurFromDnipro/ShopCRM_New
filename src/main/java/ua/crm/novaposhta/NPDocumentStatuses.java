package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name="np_documentstatuses")
public class NPDocumentStatuses {
    @Id
    @SerializedName("StateId")
    private String stateId;
    @SerializedName("StateName")
    private String stateName;
    @SerializedName("GroupId")
    private String groupId;

    public NPDocumentStatuses() {
    }

    public NPDocumentStatuses(String stateName, String stateId, String groupId) {
        this.stateName = stateName;
        this.stateId = stateId;
        this.groupId = groupId;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    @Override
    public String toString() {
        return "NPDocumentStatuses{" +
                "stateId='" + stateId + '\'' +
                ", stateName='" + stateName + '\'' +
                ", groupId='" + groupId + '\'' +
                '}';
    }
}
