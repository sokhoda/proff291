package hw8.taxi.domain;

/**
 * Created by Пк2 on 27.02.2016.
 */
public class Order {
    private long id;
    private Client client;
    private Double orderCost;
    private String adressFrom;
    private String adressTo;

    public Order(long id, Client client, String amount, String adressFrom, String adressTo) {
        this.id = id;
        this.client = client;
        this.orderCost =Double.parseDouble(amount);
        this.adressFrom = adressFrom;
        this.adressTo = adressTo;
    }

    public Client getClient() {
        return client;
    }

    public long getId() {
        return id;
    }

    public String getAmount() {
        return orderCost.toString();
    }

    public String getAdressFrom() {
        return adressFrom;
    }

    public String getAdressTo() {
        return adressTo;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(String amount) {
        this.orderCost = Double.parseDouble(amount);
    }

    public void setAdressFrom(String adressFrom) {
        this.adressFrom = adressFrom;
    }

    public void setAdressTo(String adressTo) {
        this.adressTo = adressTo;
    }

    public boolean equals(Object order) {
        if (order != null) {
            if (this == order) {
                return true;
            }
            Order another = (Order) order;
            if (this.getId() == another.getId()) return true;
            if (this.getClient().equals(another.getClient()) &&
                    this.getAdressFrom().contains(another.getAdressFrom()) &&
                    this.getAdressTo().contains(another.getAdressTo())) return true;
        }
        return false;
    }
}
