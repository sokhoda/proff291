package models;

import java.util.Date;

/**
 * Created by Pavel on 21.01.2016.
 */
public class Client {
    String name;
    String surname;
    String phoneNumber;
    String address;
    float summ;
    Date lastOrderDate;

    public Client() {
    }

    public Client(String name, String surname, String phoneNumber, String address, float summ, Date lastOrderDate) {
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.summ = summ;
        this.lastOrderDate = lastOrderDate;
    }
}
