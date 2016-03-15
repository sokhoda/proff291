package web.hw9.taxi.service;

import web.hw9.taxi.exception.OrderException;
import web.hw9.taxi.domain.Client;

import java.util.List;

/**
 * Created by Администратор on 14.03.2016.
 */
public interface OrderService {
    boolean createOrder(Client client, Double amount, String addressFrom, String addressTo) throws OrderException;
    void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo);
    List showOrdersSum(double min,double max);
    List showOrdersByPortion(int page, int portionSize);

    }
