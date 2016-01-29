package hw8.taxi.domain;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 * заказ:
 *  дата, клиент, сумма, адрес подачи, адрес назначения
 * клиент:
 *  имя, фамилия, телефон, адрес
 */
public class Order {

    private Long id;
    private Client client = new Client();
    private String amount;
    private String addressFrom;
    private String addressTo;

    public Order(Long id, Client client, String amount, String addressFrom, String addressTo) {
        this.id = id;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public Order() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;

        Order order = (Order) o;

        if (!addressFrom.equals(order.addressFrom)) return false;
        if (!addressTo.equals(order.addressTo)) return false;
        if (!amount.equals(order.amount)) return false;
        if (!client.equals(order.client)) return false;
        if (!id.equals(order.id)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + client.hashCode();
        result = 31 * result + amount.hashCode();
        result = 31 * result + addressFrom.hashCode();
        result = 31 * result + addressTo.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client=" + client +
                ", amount='" + amount + '\'' +
                ", addressFrom='" + addressFrom + '\'' +
                ", addressTo='" + addressTo + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
