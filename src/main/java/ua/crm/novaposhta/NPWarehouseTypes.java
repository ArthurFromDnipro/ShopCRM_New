package ua.crm.novaposhta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 30.08.2016.
 */
@Entity
@Table(name="np_warehousetypes")
public class NPWarehouseTypes {
    @Id
    @SerializedName("Ref")
    private String ref;
    @SerializedName("Description")
    private String description;

    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy = "npWarehouseTypes", cascade = CascadeType.REFRESH)
    List<NPWarehouses> npWarehouses = new ArrayList<>();


    public NPWarehouseTypes() {
    }

    public NPWarehouseTypes(String ref, String description) {
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

    public List<NPWarehouses> getNpWarehouses() {
        return npWarehouses;
    }

    public void setNpWarehouses(List<NPWarehouses> npWarehouses) {
        this.npWarehouses = npWarehouses;
    }

    @Override
    public String toString() {
        return "NPWarehouseTypes{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
