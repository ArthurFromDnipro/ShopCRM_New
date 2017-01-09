package ua.crm.novaposhta;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPContactPersonsRequest {
    private String Ref;
    private String Page;

    public NPContactPersonsRequest() {
    }

    public NPContactPersonsRequest(String ref, String page) {
        Ref = ref;
        Page = page;
    }

    public String getRef() {
        return Ref;
    }

    public void setRef(String ref) {
        Ref = ref;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    @Override
    public String toString() {
        return "NPContactPersonsRequest{" +
                "Ref='" + Ref + '\'' +
                ", Page='" + Page + '\'' +
                '}';
    }
}
