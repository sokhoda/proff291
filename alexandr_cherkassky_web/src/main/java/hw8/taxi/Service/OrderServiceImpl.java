package hw8.taxi.Service;

import hw8.taxi.domain.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пк2 on 27.02.2016.
 */
public class OrderServiceImpl implements OrderService{
    private List<Order> orders;



    public OrderServiceImpl(){
        this.orders=new ArrayList<>();
    }
}
