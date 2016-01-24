package taxi.domain;

import java.util.Date;

/**
 * Created by Юлия on 19.01.2016.
 */
public class Order {
    private Date date;
    private Long id;
    private Client client;
    private String amount;
    private String addressFrom;
    private String addressTo;

    public Order() {

    }

    public Order(Date date, Client client, String amount, String addressFrom, String addressTo) {
        this.date = date;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Order(Long id, Client client, String amount, String addressFrom, String addressTo) {
        this.id=id;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public void setAddressFrom(String addressFrom) {
        this.addressFrom = addressFrom;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getAddressTo() {
        return addressTo;
    }

    public void setAddressTo(String addressTo) {
        this.addressTo = addressTo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}
