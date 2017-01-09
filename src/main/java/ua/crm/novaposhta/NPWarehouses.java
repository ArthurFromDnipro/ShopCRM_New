package ua.crm.novaposhta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ua.crm.DB.Clients;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 29.08.2016.
 */
@Entity
@Table(name = "np_warehouses")
public class NPWarehouses {
    @Id
    @SerializedName("Ref")
    private String ref;

    @SerializedName("Description")
    private String description;

    @SerializedName("DescriptionRu")
    private String descriptionRu;

    @SerializedName("Phone")
    private String phone;


    @Transient
    @SerializedName("TypeOfWarehouse")
    private String typeOfWarehouse;

    @Expose(serialize = false, deserialize = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typeOfWarehouse")
    private NPWarehouseTypes npWarehouseTypes;


    @SerializedName("Number")
    private int number;

    @Transient
    @SerializedName("CityRef")
    private String cityRef;

    @Expose(serialize = false, deserialize = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Cities")
    private NPCities npCities;


    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy = "npWarehouses", cascade = CascadeType.REFRESH)
    private List<Clients> clients = new ArrayList<>();


    @SerializedName("CityDescription")
    private String cityDescription;

    @SerializedName("CityDescriptionRu")
    private String cityDescriptionRu;

    @SerializedName("Longitude")
    private String longitude;

    @SerializedName("Latitude")
    private String latitude;

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

    public String getDescriptionRu() {
        return descriptionRu;
    }

    public void setDescriptionRu(String descriptionRu) {
        this.descriptionRu = descriptionRu;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTypeOfWarehouse() {
        return typeOfWarehouse;
    }

    public void setTypeOfWarehouse(String typeOfWarehouse) {
        this.typeOfWarehouse = typeOfWarehouse;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCityRef() {
        return cityRef;
    }

    public void setCityRef(String cityRef) {
        this.cityRef = cityRef;
    }

    public String getCityDescription() {
        return cityDescription;
    }

    public void setCityDescription(String cityDescription) {
        this.cityDescription = cityDescription;
    }

    public String getCityDescriptionRu() {
        return cityDescriptionRu;
    }

    public void setCityDescriptionRu(String cityDescriptionRu) {
        this.cityDescriptionRu = cityDescriptionRu;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public NPWarehouseTypes getNpWarehouseTypes() {
        return npWarehouseTypes;
    }

    public void setNpWarehouseTypes(NPWarehouseTypes npWarehouseTypes) {
        this.npWarehouseTypes = npWarehouseTypes;
    }

    public NPCities getNpCities() {
        return npCities;
    }

    public void setNpCities(NPCities npCities) {
        this.npCities = npCities;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "NPWarehouses{" +
                "ref='" + ref + '\'' +
                ", description='" + description + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", phone='" + phone + '\'' +
                ", typeOfWarehouse='" + typeOfWarehouse + '\'' +
                ", number='" + number + '\'' +
                ", cityRef='" + cityRef + '\'' +
                ", cityDescription='" + cityDescription + '\'' +
                ", cityDescriptionRu='" + cityDescriptionRu + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public static Integer numPrepare(String s) {
        Integer i;
        try {
            i = Integer.parseInt(s.replace("Отделение", "").replace("отделение", "").replace("Відділення", "").replace("відділення", "")
                    .replace(" ", "").replace("#", "").replace("№", "").trim());
        } catch (NumberFormatException e) {
            i = null;
        }

        return i;
    }
}
