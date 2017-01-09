package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "clienttype")
public class ClientType {
    @Id
    private int id;
    private String clientType;

    @OneToMany(mappedBy = "clientType", cascade = CascadeType.REFRESH)
    private List<Clients> clients = new ArrayList<>();

    public ClientType() {
    }

    public ClientType(String clientType) {
        this.clientType = clientType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public List<Clients> getClients() {
        return clients;
    }

    public void setClients(List<Clients> clients) {
        this.clients = clients;
    }
}
