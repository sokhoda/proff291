package hw8.taxi.domain;

import java.util.Date;

/**
 * Created by Admin on 20.01.2016.
 */
public class Client {

    private String name = "";
    private String surname = "";
    private String phone = "";
    private String address = "";
    private Long summa;
    private Date dateOfLastOrder;

    public Client (String name, String surname, String phone, String address){
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.summa = (long)0;
        this.dateOfLastOrder = null;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (name != null ? !name.equals(client.name) : client.name != null) return false;
        if (surname != null ? !surname.equals(client.surname) : client.surname != null) return false;
        if (phone != null ? !phone.equals(client.phone) : client.phone != null) return false;
        return address != null ? address.equals(client.address) : client.address == null;

    }

    @Override
    public int hashCode() {
        int result = 0;

        if(name != null){
            result = name.hashCode();
        } else {
            result = 0;
        }
        if(surname != null){
            result += surname.hashCode();
        } else {
            result += 0;
        }
        if(phone != null){
            result += phone.hashCode();
        } else {
            result += 0;
        }

        return result;
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + phone + " " + address + "\n";
    }

    public Date getDateOfLastOrder() {
        return dateOfLastOrder;
    }

    public void setDateOfLastOrder(Date dateOfLastOrder) {
        this.dateOfLastOrder = dateOfLastOrder;
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

    public Long getSumma() {
        return summa;
    }

    public void setSumma(Long summa) {
        this.summa = summa;
    }

}
