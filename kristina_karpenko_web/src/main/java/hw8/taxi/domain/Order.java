package hw8.taxi.domain;

import java.time.LocalDate;

//(дата, клиент, сумма, адрес подачи, адрес назначения)
public class Order {
    private long dateOrder;
    private Client client;
    private String amount;
    private String addressFrom;
    private String addressTo;

    public Order(long dateOrder, Client client, String amount, String addressFrom, String addressTo) {
        this.dateOrder = dateOrder;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
    }

    public void setDateOrder(long dateOrder) {
        this.dateOrder = dateOrder;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAmount(String sumOrder) {
        this.amount = sumOrder;
    }

    public void setAddressFrom(String supplyAddress) {
        this.addressFrom = supplyAddress;
    }

    public void setAddressTo(String destinationAddress) {
        this.addressTo = destinationAddress;
    }

    public long getDateOrder() {
        return dateOrder;
    }

    public Client getClient() {
        return client;
    }

    public String getAmount() {
        return amount;
    }

    public String getAddressFrom() {
        return addressFrom;
    }

    public String getAddressTo() {
        return addressTo;
    }

    @Override
    public String toString() {
        return "Дата заказа:" +dateOrder+"Клиент:"+ client+
                "Сумма заказа:"+amount+"Адрес подачи:"+addressFrom+"Адрес назначения:"+addressTo;
    }
}
