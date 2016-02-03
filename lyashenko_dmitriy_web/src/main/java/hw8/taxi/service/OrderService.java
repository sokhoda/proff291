package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 20.01.2016.
 */
public class OrderService {

    public static List<Order>  orders = new ArrayList<Order>();

    public  OrderService() {

    }

    boolean createOrder(Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if(client == null || amount == "" || addressFrom == "" || addressTo == ""){
            return false;
        } else{
            orders.add(new Order(client,amount,addressFrom,addressTo));
            return true;
        }

    }
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo){
        long tt = id;
        Order redact = new Order(client,amount,addressFrom,addressTo);
        redact.setId(id);
        orders.set((int)tt - 1, redact);
    }

   public List showOrders(Long from, Long to){
        List<Order> amountPrice = new ArrayList<Order>();
       for ( Order ord: amountPrice ) {
           Long tmpLong = Long.valueOf(ord.getAmount());
           if(tmpLong >= from && tmpLong <= to){
               amountPrice.add(ord);
           }

       }

        return amountPrice;
    }

    public List showOrdersByPortion(){

        return orders;
    }
}
