package hw8.taxi.domain;

import hw8.taxi.domain.exception.ClientException;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

//зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)

public class Client {


    private String name;
    private String surName;
    private String phone;
    private String address;
    private int sum;
    private LocalDate dateLastOrder;

    public Client() {

    }

    public Client(String name, String serName, String phone, String address, int sum, LocalDate dateLastOrder) {
        this(name,serName,phone,address);
        this.sum = sum;
        this.dateLastOrder = dateLastOrder;
    }

    public Client(String name, String serName, String phone, String address) {
        this.name = name;
        this.surName = serName;
        this.phone = phone;
        this.address = address;
        sum = 0;
        dateLastOrder = LocalDate.now();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surName = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public void setDateLastOrder(LocalDate dateLastOrder) {
        this.dateLastOrder = dateLastOrder;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public int getSum() {
        return sum;
    }

    public LocalDate getDateLastOrder() {
        return dateLastOrder;
    }

    public String toString(){
        return "Name:"+name+"  Surname:"+surName+"  Phone:"+phone+" Address:"+address+" Sum All Order:"+sum+" Last date order:"+dateLastOrder;
    }
}
