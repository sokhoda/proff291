package hw8.taxi.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Admin on 20.01.2016.
 */
public class Order {

    private Long id;
    private Client client;
    private String amount = "";
    private String addressFrom = "";
    private String addressTo = "";
    private Date dateOfOder;

    public Order(){}

    public Order(Client client, String amount, String addressFrom, String addressTo){
        int tempLong = hw8.taxi.service.OrderServiceImpl.orders.size() + 1;
        long tmpFromInt = tempLong;
        this.id = tmpFromInt;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.dateOfOder = new Date();
        this.client.setSumma( this.client.getSumma() + (long)Long.valueOf(amount));
        this.client.setDateOfLastOrder(this.dateOfOder);
    }

    @Override
    public String toString() {
        return "Order № " + id + " from "+
                new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(dateOfOder) +
                "\n" + client.toString() + " amount " + amount +
                "\n" +"from " + addressFrom + " to " + addressTo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfOder() {
        return dateOfOder;
    }

    public void setDateOfOder(Date dateOfOder) {
        this.dateOfOder = dateOfOder;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }
}
