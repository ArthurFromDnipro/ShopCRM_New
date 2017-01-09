package ua.crm.novaposhta;

/**
 * Created by Oleg on 30.08.2016.
 */
public class NPCounterpartyRequest {
    private String CounterpartyProperty;
    private String Page;

    public NPCounterpartyRequest() {
    }

    public NPCounterpartyRequest(String counterpartyProperty, String page) {
        CounterpartyProperty = counterpartyProperty;
        Page = page;
    }

    public String getCounterpartyProperty() {
        return CounterpartyProperty;
    }

    public void setCounterpartyProperty(String counterpartyProperty) {
        CounterpartyProperty = counterpartyProperty;
    }

    public String getPage() {
        return Page;
    }

    public void setPage(String page) {
        Page = page;
    }

    @Override
    public String toString() {
        return "NPCounterpartyRequest{" +
                "CounterpartyProperty='" + CounterpartyProperty + '\'' +
                ", Page='" + Page + '\'' +
                '}';
    }
}
