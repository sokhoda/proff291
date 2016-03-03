package hw9.taxi.domain;



import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Solyk on 03.03.2016.
 */
@Entity
@Table(name = "ORDERS")
public class Order {

    @Id
    @SequenceGenerator(name = "seqOfOrders", sequenceName = "ORDERS_SEQ")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqOfOrders")
    @Column(name = "ID")
    private Long id;

    @Column(name = "CLIENT")
    private Client client;

    @Column(name = "AMOUNT")
    private String amount;

    @Column(name = "ADDRESS_FROM")
    private String addressFrom;

    @Column(name = "ADDRESS_TO")
    private String addressTo;

    @Column(name = "DATE_OF_ORDER")
    private Date dateOfOder;

    public Order(){}

    public Order(Client client, String amount, String addressFrom, String addressTo){
        int tempLong = hw8.taxi.service.OrderServiceImpl.orders.size() + 1;
        long tmpFromInt = tempLong;
        this.id = tmpFromInt;
        this.client = client;
        this.amount = amount;
        this.addressFrom = addressFrom;
        this.addressTo = addressTo;
        this.dateOfOder = new Date();
//        this.client.setSumma( this.client.getSumma() + (long)Long.valueOf(amount));
//        this.client.setDateOfLastOrder(this.dateOfOder);
    }

    @Override
    public String toString() {
        return "Order № " + id + " from "+
                new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z").format(dateOfOder) +
                "\n" + client.toString() + " amount " + amount +
                "\n" +"from " + addressFrom + " to " + addressTo;
    }
}
