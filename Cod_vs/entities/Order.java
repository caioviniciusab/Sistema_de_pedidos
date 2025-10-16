package Cod_vs.entities;

import Cod_vs.entitie.enuns.orderStatus;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

    private Date moment;
    private orderStatus status;

    private Client client;
    private List<OrderItem> items = new ArrayList<>();

    public Order(Client client){

    }

    public Order(Date moment, orderStatus status, Client client) {
        this.client = client;
        this.moment = moment;
        this.status = status;
    }

    public Date getMoment() {
        return moment;
    }

    public void setMoment(Date moment) {
        this.moment = moment;
    }

    public orderStatus getStatus() {
        return status;
    }

    public void setStatus(orderStatus status) {
        this.status = status;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    public Double total(){
        double sum = 0;
        for (OrderItem i : items){
            sum += i.subTotal();
        }
        return sum;
    }
}

