package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.OrderException;

import java.io.*;
import java.util.*;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class OrderServiceImpl implements OrderService {

    private Map<Long, Order> orderMap = new LinkedHashMap<Long, Order>();
    private final static String ORDER_BASE_FILE_PATH = "C:/order_base.txt";
    private final static int SHOW_PORTION_SIZE = 5;
    private static int portionStartPos;

    public OrderServiceImpl(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public OrderServiceImpl() {
        orderMap = deserialization(ORDER_BASE_FILE_PATH);
    }

    public boolean createOrder(Long id, Client client, String amount, String addressFrom, String addressTo)
            throws OrderException {

        if (id == null || amount == null || amount.isEmpty() ||
                addressFrom == null || addressFrom.isEmpty() ||
                addressTo == null || addressTo.isEmpty()) {
            throw new OrderException("Order creation failed, empty Id and/or Client and/or Address");
        }
        ClientServiceImpl clientService = new ClientServiceImpl();
        if (!clientService.getClientMap().containsKey(client.getId())) {
            throw new OrderException("Order creation failed, such client does not exist");
        }
        Order newOrder = new Order(id, client.getId(), amount, addressFrom, addressTo);

        Set<Map.Entry<Long, Order>> entries = orderMap.entrySet();
        for (Map.Entry entry : entries) {
            Order order = (Order) entry.getValue();
            if (newOrder.equals(order)) {
                throw new OrderException("Order creation failed, such order already exists");
            }
        }
        orderMap.put(newOrder.getId(), newOrder);

        if (!serialization(orderMap, ORDER_BASE_FILE_PATH)) {
            orderMap.remove(newOrder.getId());
            throw new OrderException("Order creation failed, database error");
        }
        return true;
    }

    public void editOrder(Long id, Client client, String amount, String addressFrom, String addressTo) {
        orderMap.get(id).setClientId(client.getId());
        orderMap.get(id).setAmount(amount);
        orderMap.get(id).setAddressFrom(addressFrom);
        orderMap.get(id).setAddressTo(addressTo);

        serialization(orderMap, ORDER_BASE_FILE_PATH);
    }

    public List<Order> showOrders(Long from, Long to) {
        portionStartPos = 0;
        Set<Map.Entry<Long, Order>> entries = orderMap.entrySet();
        List<Order> outputList = new LinkedList<>();

        for (Map.Entry entry : entries) {
            Order order = (Order)entry.getValue();
            if (Long.getLong(order.getAmount()) >= from &&
                    Long.valueOf(order.getAmount()) <= to){
                outputList.add(order);
            }
        }
        return outputList;
    }

    public List<Order> showOrdersByPortion() {
        Set<Map.Entry<Long, Order>> entries = orderMap.entrySet();
        List<Order> orderList = new ArrayList<Order>();

        for (Map.Entry entry : entries) {
            orderList.add((Order) entry.getValue());
        }
        int portionSize = SHOW_PORTION_SIZE;
        if (orderList.size() < portionSize) {
            portionSize = orderList.size();
        }
        List<Order> outputList = new ArrayList<Order>();
        if (portionStartPos + portionSize <= orderList.size()) {
            outputList = orderList.subList(portionStartPos, portionStartPos + portionSize);
        }
        portionStartPos += portionSize;
        return outputList;
    }

    public Map<Long, Order> getOrderMap() { return orderMap; }

    public void setOrderMap(Map<Long, Order> orderMap) { this.orderMap = orderMap; }

    /////////////////////////////////////////////////////////////////////////////////
    public boolean serialization(Map<Long, Order> orders, String fileName) {
        if (orders.isEmpty()){
            return false;
        }
        File file = new File(fileName);
        PrintWriter pw = null;

        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            Set<Map.Entry<Long, Order>> entries = orders.entrySet();

            for (Map.Entry<Long, Order> entry : entries) {
                String[] orderData = {
                        entry.getValue().getId().toString(),
                        entry.getValue().getClientId().toString(),
                        entry.getValue().getAmount(),
                        entry.getValue().getAddressFrom(),
                        entry.getValue().getAddressTo(),
                        entry.getValue().getOrderDate()
                };
                StringBuilder sb = new StringBuilder();
                for (String value : orderData) {
                    sb.append(value);
                    sb.append("\t");
                }
                sb.replace(sb.length() - 1, sb.length(), "\n");
                pw.print(sb.toString());
            }
            return true;

        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(pw!= null) {
                pw.close();
            }
        }
        return false;
    }

    public Map<Long, Order> deserialization(String fileName) {
        Map<Long, Order> orders = new LinkedHashMap<Long, Order>();
        File file = new File(fileName);
        BufferedReader br = null;

        if (file.exists()) {
            try{
                br = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\t");
                    Order order = new Order();

                    order.setId(Long.valueOf(values[0]));
                    order.setClientId(Long.valueOf(values[1]));
                    order.setAmount(values[2]);
                    order.setAddressFrom(values[3]);
                    order.setAddressTo(values[4]);
                    order.setOrderDate(values[5]);

                    orders.put(order.getId(), order);
                }
            } catch(IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    if (br != null) {
                        br.close();
                    }
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return orders;
    }
}
