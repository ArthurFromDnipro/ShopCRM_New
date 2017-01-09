package ua.crm.novaposhta; /**
 * Created by Oleg on 25.08.2016.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="np_area")
public class NPArea {
    @Id
    @SerializedName("Ref")
    private String ref;

    @SerializedName("Description")
    private String description;

    @SerializedName("AreasCenter")
    private String areasCenter;

    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy = "npArea", cascade = CascadeType.ALL)
    private List<NPCities> cities = new ArrayList<>();


    public NPArea() {
    }

    public NPArea(String ref, String description, String areasCenter) {
        this.ref = ref;
        this.description = description;
        this.areasCenter = areasCenter;
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

    public String getAreasCenter() {
        return areasCenter;
    }

    public void setAreasCenter(String areasCenter) {
        this.areasCenter = areasCenter;
    }

    public List<NPCities> getCities() {
        return cities;
    }

    public void setCities(List<NPCities> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "NPArea{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                ", areasCenter='" + areasCenter + '\'' +
                '}';
    }
}
