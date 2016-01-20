package hw8.taxi.domain;

import java.util.GregorianCalendar;

/**
 * Created by s_okhoda on 20.01.2016.
 */
public class Client {
    private String name;
    private String surname;
    private String phone;
    private String address;
    private int totalOrderAmount;
    private GregorianCalendar lastOrderDate;

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.totalOrderAmount = 0;
        this.lastOrderDate = null;
    }
    public Client(){

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

    public void setTotalOrderAmount(int totalOrderAmount) {
        this.totalOrderAmount = totalOrderAmount;
    }

    public void setLastOrderDate(GregorianCalendar lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public int getTotalOrderAmount() {
        return totalOrderAmount;
    }

    public GregorianCalendar getLastOrderDate() {
        return lastOrderDate;
    }
}
