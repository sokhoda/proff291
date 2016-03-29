package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.util.*;

/**
 * Created by Пк2 on 27.02.2016.
 */
public class OrderServiceImpl implements OrderService{
    private static List<Order> orders;
    private int startInd=0;
    private int portionSize=10;



    public OrderServiceImpl(){
        this.orders=new ArrayList<>();
    }

    @Override
    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo) throws OrderException {
        if(id==null || client==null || amount==null || addressFrom==null || addressTo==null){
            throw new OrderException("fields must not be null");
        }
        if( amount.isEmpty() || addressFrom.isEmpty() || addressTo.isEmpty()){
            throw new OrderException("fields must not be null");
        }

        Order order=new Order(id,client,amount,addressFrom,addressTo);

        if(orderExsists(order)){
            throw new OrderException("fields must not be null");
        }
        orders.add(order);
        return true;
    }

    @Override
    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        Order curOrder=findOrderById(id);
        if (curOrder!=null) {
            curOrder.setClient(client);
            curOrder.setAmount(amount);
            curOrder.setAdressFrom(addressFrom);
            curOrder.setAdressTo(addressTo);
        }
    }

    @Override
    public List showOrders(Long from, Long to) {
        if(orders.isEmpty()){
            return null;
        }
        List<Order> showByCost =new ArrayList<>();
        Double doubleFrom=(double) from;
        Double doubleTo=(double) to;
        for(Order order:orders){
            Double orderCost=Double.parseDouble(order.getAmount());
            if(orderCost>=from && orderCost<=to){
                showByCost.add(order);
            }
        }
        return showByCost;
    }

    @Override
    public List showOrdersByPortion() {
        List<Order> orders = new ArrayList<>();
        int left=this.orders.size()-startInd;
        if(left>0){
            if(left>=portionSize) {
                for (int i = startInd; i < portionSize; i++) {
                    orders.add(this.orders.get(i));
                }
                startInd=startInd+portionSize;
            }else{
                for (int i = startInd; i<left; i++) {
                    orders.add(this.orders.get(i));

                }
                startInd=startInd+left;
            }
        } else{
            startInd=0;
        }
        return orders;
    }


    private boolean orderExsists(Order newOrder){
        for(Order order:orders){
            if(order.equals(newOrder)) return true;
        }
        return false;
    }

    public Order findOrderById(Long id){
        for(int i=0; i<orders.size();i++){
            Order order=orders.get(i);
            if(order.getId().longValue()==id.longValue()){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }
}
