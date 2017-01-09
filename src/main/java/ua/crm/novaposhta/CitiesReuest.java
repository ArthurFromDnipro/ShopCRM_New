package ua.crm.novaposhta;

/**
 * Created by Oleg on 29.08.2016.
 */
public class CitiesReuest {
    private String CityRef;

    public CitiesReuest() {
    }

    public CitiesReuest(String CityRef) {
        this.CityRef = CityRef;
    }

    public String getRef() {
        return CityRef;
    }

    public void setRef(String CityRef) {
        this.CityRef = CityRef;
    }
}
