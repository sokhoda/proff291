package hw9.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by i.gonchar on 2/29/2016.
 * - зарегистрировать клиента (имя, фамилия, телефон, адрес, сумма, дата последнего заказа)
 * - вывести всех клиентов порциями по 10 человек
 * - вывести всех клиентов наездивших на сумму больше указанной
 * - вывести всех клиентов, делавших заказы за последний месяц
 */
@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "CLIENTS_SEQ",
            allocationSize = 1, initialValue = 1)
    @Column(name = "CLIENT_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    private long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "TELEPHONE", unique = true)
    private String telephone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "ORDERS_AMOUNT")
    private Double ordersAmount;

    @Column(name = "LAST_ORDER")
    private Date lastOrderDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public Client() {

    }

    public Client(String name, String surname, String telephone, String address) {
        this.ordersAmount = 0.00;
        this.name = name;
        this.surname = surname;
        this.telephone = telephone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public double getOrdersAmount() {
        return ordersAmount;
    }

    public void setOrdersAmount(double ordersAmount) {
        this.ordersAmount = ordersAmount;
    }

    public void updateOrdersAmount(double ordersAmount) {
        this.ordersAmount += ordersAmount;
    }
}