package ua.crm.DB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Oleg on 02.09.2016.
 */
@Entity
@Table(name = "channeltype" )
public class ChannelType {
    @Id
    private int Id;
    private String ChannelType;

    @OneToMany(mappedBy = "channelType", cascade = CascadeType.REFRESH)
    private List<Orders> orders = new ArrayList<>();

    public ChannelType() {
    }

    public ChannelType(int id, String channelType, List<Orders> orders) {
        ChannelType = channelType;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getChannelType() {
        return ChannelType;
    }

    public void setChannelType(String channelType) {
        ChannelType = channelType;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "ChannelType{" +
                "Id=" + Id +
                ", ChannelType='" + ChannelType + '\'' +
                ", orders=" + orders +
                '}';
    }
}
