package hw8.taxi.domain;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 */
public class Client implements Serializable {

    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String address;

    private String ordersSum;
    private String lastOrderedDate;

    private static final long serialVersionUID = 1L;

    public Client(Long id, String name, String surname, String phone, String address) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    public Client() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
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
                "id='" + name + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getOrdersSum() {
        return ordersSum;
    }

    public void setOrdersSum(String ordersSum) {
        this.ordersSum = ordersSum;
    }

    public String getLastOrderedDate() {
        return lastOrderedDate;
    }

    public void setLastOrderedDate(String lastOrderedDate) {
        this.lastOrderedDate = lastOrderedDate;
    }
}
