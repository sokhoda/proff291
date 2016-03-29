package web.hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "ORDER_SEQ", sequenceName = "ORDER_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ORDER_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "DATE_ORDER")
    private Date date;

    @Column(name = "ADDRESS_fROM")
    private String addressFrom;

    @Column(name = "ADDRESS_TO")
    private String addressTo;

    @Column(name = "AMOUNT_ORDER")
    private double amount;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID")
    private Client client;

    public Order() {
    }

    public Order( Client client, double amount, String addressFrom, String addressTo) {
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        date = new Date();
        this.amount = amount;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", date=" + date +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                '}';
    }
}
