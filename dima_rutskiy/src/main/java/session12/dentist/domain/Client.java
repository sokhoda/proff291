package session12.dentist.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
@Entity
@Table(name="CLIENTS")
public class Client {
    @Id
    @GeneratedValue
    @Column(name="CLIENT_ID")
    private Long id;

    private String name;
    private String surname;
    private Integer age;

    @Temporal(TemporalType.DATE)
    @Column(name = "LAST_VISIT_DATE")
    private Date date;
    private Double sum;

    public Client() {
    }

    public Client(String name, String surname, int age, Date date, double sum) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.date = date;
        this.sum = sum;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getSum() {
        return sum;
    }

    public void setSum(Double sum) {
        this.sum = sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", sum=" + sum +
                '}';
    }
}
