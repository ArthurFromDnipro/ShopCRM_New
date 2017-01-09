package ua.crm.novaposhta;

import com.google.gson.annotations.SerializedName;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Oleg on 29.08.2016.
 */
@Entity
@Table(name="np_cargodescriptionlist")
public class NPCargoDescriptionList {
    @Id
    @SerializedName("Ref")
    private String ref;
    @SerializedName("Description")
    private String description;

    public NPCargoDescriptionList() {
    }

    public NPCargoDescriptionList(String ref, String description) {
        this.ref = ref;
        this.description = description;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "NPCargoDescriptionList{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
