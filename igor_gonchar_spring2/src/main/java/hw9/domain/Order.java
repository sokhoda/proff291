package hw9.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by i.gonchar on 2/29/2016.
 * - оформить заказ (дата, клиент, сумма, адрес подачи, адрес назначения)
 * - отредактировать заказ (поменять свойства заказа)
 * - вывести список заказов на сумму в указанном диапазоне
 * - вывести список всех заказов порциями по 5 штук
 */
@Entity
@Table(name = "ORDERS")
public class Order {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "ORDERS_SEQ",
            allocationSize = 1, initialValue = 1)
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "DATE")
    private Date date;

    @ManyToOne
    private Client client;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "ADDRES_FROM")
    private String addressFrom;

    @Column(name = "ADDRES_TO")
    private String addressTo;

    public Order(){

    }

    public Order(Date date, Client client, double amount, String addressFrom, String addressTo) {
        this.date = date;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
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
