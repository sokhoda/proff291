package hw8.taxi.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 */
public class Order implements Serializable {

    private Long id;
    private Long clientId;
    private String amount;
    private String addressFrom;
    private String addressTo;
    private String orderDate;   // DD.MM.YYYY

    private static final long serialVersionUID = 1L;

    public Order(Long id, Long clientId, String amount, String addressFrom, String addressTo) {
        this.id = id;
        this.clientId = clientId;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
        orderDate = df.format(new Date());
    }

    public Order() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
        orderDate = df.format(new Date());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Order)) return false;
        Order order = (Order) obj;
        if (!addressFrom.equals(order.addressFrom)) return false;
        if (!addressTo.equals(order.addressTo)) return false;
        if (!amount.equals(order.amount)) return false;
        if (!clientId.equals(order.clientId)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + addressFrom.hashCode();
        result = 31 * result + addressTo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", amount='" + amount + '\'' +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                ", orderDate=" + orderDate +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
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

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
