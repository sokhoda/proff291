package hw8.taxi.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 * клиент:
 *  имя, фамилия, телефон, адрес, сумма, дата последнего заказа
 */
public class Client implements Serializable {

    private String name;
    private String surname;
    private String phone;
    private String address;
    private String amount;
    private String lastOrderDate;
    private static final long serialVersionUID = 1L;

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        lastOrderDate = df.format(new Date());
        amount = "0.00";
    }

    public Client() {
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
        lastOrderDate = df.format(new Date());
        amount = "0.00";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Client)) return false;

        Client client = (Client) o;

        if (!name.equals(client.name)) return false;
        if (!phone.equals(client.phone)) return false;
        if (!surname.equals(client.surname)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", amount='" + amount + '\'' +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getAmount() { return amount; }

    public void setAmount(String amount) { this.amount = amount; }

    public String getLastOrderDate() { return lastOrderDate; }

    public void setLastOrderDate(String lastOrderDate) { this.lastOrderDate = lastOrderDate; }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
