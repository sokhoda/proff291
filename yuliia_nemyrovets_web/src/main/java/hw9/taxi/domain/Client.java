package hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Юлия on 02.03.2016.
 */
@Entity
@Table(name="CLIENTS")
public class Client {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "SEQ_CLIENTS",
            allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(name = "CLIENT_ID")
    private Long id;

    @Column(name = "CLIENT_NAME")
    private String name;

    @Column(name = "CLIENT_SURNAME")
    private String surname;

    @Column(name = "CLIENT_PHONENUMBER")
    private String phone;

    @Column(name = "CLIENT_ADDRESS")
    private String address;

    @Column(name = "CLIENT_SUMM")
    private int summ;

    @Column(name = "CLIENT_DATEOFLASTORDER")
    private Date dateOfLastOrder;

    @OneToMany(mappedBy = "CLIENTS",cascade = CascadeType.DETACH)
    private Set<Order> orders=new HashSet<>();
    public Client() {
    }

    public Client(String name, String surname, String phone, String address, int summ, Date dateOfLastOrder) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.summ = summ;
        this.dateOfLastOrder = dateOfLastOrder;
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

    public int getSumm() {
        return summ;
    }

    public void setSumm(int summ) {
        this.summ = summ;
    }

    public Date getDateOfLastOrder() {
        return dateOfLastOrder;
    }

    public void setDateOfLastOrder(Date dateOfLastOrder) {
        this.dateOfLastOrder = dateOfLastOrder;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", summ='" + summ + '\'' +
                ", dateOfLastOrder='" + dateOfLastOrder + '\'' +
                '}';
    }
}
