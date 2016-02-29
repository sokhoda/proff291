package hw9.taxi.domain;

import hw9.taxi.util.Utils;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Вадим on 28.02.2016.
 */

@Entity
@Table(name = "CLIENTS")
@SequenceGenerator(name = "CLIENTS_SEQ", sequenceName = "CLIENTS_SEQ",
        allocationSize = 1, initialValue = 1)
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLIENTS_SEQ")
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "FIRST_NAME", length = 50)
    private String name;

    @Column(name = "LAST_NAME", length = 50)
    private String surname;

    @Column(name = "PHONE", length = 20)
    private String phone;

    @Column(name = "ADDRESS", length = 100)
    private String address;

    @Column(name = "LAST_ORDER_DATE")
    private Date lastOrderDate;

    @OneToMany(mappedBy = "client", cascade = CascadeType.REFRESH)
    private Set<Order> orders = new HashSet<Order>();

    public Client() {}

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", lastOrderDate=" + lastOrderDate +
                ", orders=" + orders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (address != null ? !address.equals(client.address) : client.address != null) return false;
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
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
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

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Transient
    public String getDateStr() {
        if (lastOrderDate != null) {
            return Utils.DATEFORMAT_COMMON.get().format(lastOrderDate);
        }
        return "";
    }

    public Date getLastOrderDate() {
        return lastOrderDate;
    }

    public void setLastOrderDate(Date lastOrderDate) {
        this.lastOrderDate = lastOrderDate;
    }
}
