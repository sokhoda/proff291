package web.hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "CLIENTS")
public class Client {
    @Id
    @SequenceGenerator(name = "CLIENT_SEQ", sequenceName = "CLIENT_SEQ",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENT_SEQ")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surName;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "SUM")
    private double sum;

    @Column(name = "LAST_ORDER")
    private Date lastOrder;

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Order> orders = new HashSet<>();

    public Client() {
    }

    public Client(String name, String surName, String address, String phone) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.phone = phone;
        this.sum = 0;
        lastOrder = new Date();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getLastOrder() {
        return lastOrder;
    }

    public void setLastOrder(Date lastOrder) {
        this.lastOrder = lastOrder;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public void plusSum(double sum){
        this.sum += sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (surName != null ? !surName.equals(client.surName) : client.surName != null) return false;
        return address != null ? address.equals(client.address) : client.address == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (surName != null ? surName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", address='" + address + '\'' +
                ", sum=" + sum +
                ", lastOrder=" + lastOrder +
                '}';
    }
}
