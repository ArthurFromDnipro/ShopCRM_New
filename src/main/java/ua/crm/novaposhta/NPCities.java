package ua.crm.novaposhta;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import ua.crm.DB.Clients;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 25.08.2016.
 */
@Entity
@Table(name="np_cities")
public class NPCities {
    @Id
    @SerializedName("Ref")
    private String ref;
    @SerializedName("Description")
    private String description;
    @SerializedName("DescriptionRu")
    private String descriptionRu;
    @SerializedName("Delivery1")
    private String delivery1;
    @SerializedName("Delivery2")
    private String delivery2;
    @SerializedName("Delivery3")
    private String delivery3;
    @SerializedName("Delivery4")
    private String delivery4;
    @SerializedName("Delivery5")
    private String delivery5;
    @SerializedName("Delivery6")
    private String delivery6;
    @SerializedName("Delivery7")
    private String delivery7;

    @Transient
    @SerializedName("Area")
    private String area;

    @Expose(serialize = false, deserialize = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private NPArea npArea;





    //    @SerializedName("Conglomerates")
    //    private List<String> conglomerates = new ArrayList<>();

    @SerializedName("CityID")
    private String cityid;

    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy = "npCities", cascade = CascadeType.ALL)
    private List<NPWarehouses> warehouses = new ArrayList<>();

    @Expose(serialize = false, deserialize = false)
    @OneToMany(mappedBy = "npCities", cascade = CascadeType.REFRESH)
    private List<Clients> clients = new ArrayList<>();




    public NPCities() {
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

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getDelivery1() {
        return delivery1;
    }

    public void setDelivery1(String delivery1) {
        this.delivery1 = delivery1;
    }

    public String getDelivery2() {
        return delivery2;
    }

    public void setDelivery2(String delivery2) {
        this.delivery2 = delivery2;
    }

    public String getDelivery3() {
        return delivery3;
    }

    public void setDelivery3(String delivery3) {
        this.delivery3 = delivery3;
    }

    public String getDelivery4() {
        return delivery4;
    }

    public void setDelivery4(String delivery4) {
        this.delivery4 = delivery4;
    }

    public String getDelivery5() {
        return delivery5;
    }

    public void setDelivery5(String delivery5) {
        this.delivery5 = delivery5;
    }

    public String getDelivery6() {
        return delivery6;
    }

    public void setDelivery6(String delivery6) {
        this.delivery6 = delivery6;
    }

    public String getDelivery7() {
        return delivery7;
    }

    public void setDelivery7(String delivery7) {
        this.delivery7 = delivery7;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

//    public String getConglomerates() {
//        return conglomerates;
//    }
//
//    public void setConglomerates(String conglomerates) {
//        this.conglomerates = conglomerates;
//    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public NPArea getNpArea() {
        return npArea;
    }

    public void setNpArea(NPArea npArea) {
        this.npArea = npArea;
    }

    public List<NPWarehouses> getWarehouses() {
        return warehouses;
    }

    public void setWarehouses(List<NPWarehouses> warehouses) {
        this.warehouses = warehouses;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }

    @Override
    public String toString() {
        return "NPCities{" +
                "description='" + description + '\'' +
                ", descriptionRu='" + descriptionRu + '\'' +
                ", ref='" + ref + '\'' +
                ", delivery1='" + delivery1 + '\'' +
                ", delivery2='" + delivery2 + '\'' +
                ", delivery3='" + delivery3 + '\'' +
                ", delivery4='" + delivery4 + '\'' +
                ", delivery5='" + delivery5 + '\'' +
                ", delivery6='" + delivery6 + '\'' +
                ", delivery7='" + delivery7 + '\'' +
                ", area='" + area + '\'' +
//                ", conglomerates='" + conglomerates + '\'' +
                ", cityid='" + cityid + '\'' +
                '}';


    }
    public static String cityPrepare(String s){
        return s.replace("г.","м.").trim();

    }
}
