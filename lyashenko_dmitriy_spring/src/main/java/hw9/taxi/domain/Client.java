package hw9.taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Solyk on 02.03.2016.
 */
@Entity
@Table(name = "CLIENTS")
public class Client {

    @Id
    @SequenceGenerator(name = "seqOfClients", sequenceName = "CLIENTS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOfClients")
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "PHONE_NUMBER")
    private String phone;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "SUM_OF_ORDERS")
    private Double sum;

    @Column(name = "DATE_OF_LAST_ORDER")
    private Date dateOfLastOrder;


    public Client (){}

    public Client(String name, String surname, String phone, String address) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.address = address;
    }


}
