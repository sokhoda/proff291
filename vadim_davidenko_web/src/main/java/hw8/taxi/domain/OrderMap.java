package hw8.taxi.domain;

import java.io.*;
import java.util.*;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 * Orders base saved in file
 * Primary key is "Order.id"
 */
public class OrderMap {

    private Map<Long, Order> orderMap = new LinkedHashMap<Long, Order>();
    private final static String ORDER_BASE_FILE_PATH = "C:/order_base.txt";

    public OrderMap(Map<Long, Order> orderMap) {
        this.orderMap = orderMap;
    }

    public OrderMap() {
        orderMap = deserialization(ORDER_BASE_FILE_PATH);
    }

    public boolean addOrder(Order order) {
        if (order == null || isOrderExist(order)) {
            return false;
        }
        orderMap.put(order.getId(), order);
        serialization(orderMap, ORDER_BASE_FILE_PATH);
        return true;
    }

    public boolean replaceOrder(Order order) {
        if (order == null || !isOrderExist(order)) {
            return false;
        }
        orderMap.replace(order.getId(), order);
        serialization(orderMap, ORDER_BASE_FILE_PATH);
        return true;
    }

    public boolean isOrderExist(Order order) {
        return (order != null && orderMap.containsKey(order.getId()));
    }

    public Order getOrderById(Long id) {
        if (id == null || id == 0) {
            return null;
        }
        return orderMap.get(id);
    }

    public boolean serialization(Map<Long, Order> orders, String fileName) {
        if (orders.isEmpty()){
            return false;
        }
        File file = new File(fileName);
        PrintWriter pw = null;

        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            Set<Map.Entry<Long, Order>> entries = orders.entrySet();

            for (Map.Entry<Long, Order> entry : entries) {
                String[] orderData = {
                        String.valueOf(entry.getValue().getId()),
                        entry.getValue().getAmount(),
                        entry.getValue().getAddressFrom(),
                        entry.getValue().getAddressTo(),
                        entry.getValue().getClient().getName(),
                        entry.getValue().getClient().getSurname(),
                        entry.getValue().getClient().getPhone(),
                        entry.getValue().getClient().getAddress(),
                        entry.getValue().getClient().getAmount(),
                        entry.getValue().getClient().getLastOrderDate()
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
                    order.setAmount(values[1]);
                    order.setAddressFrom(values[2]);
                    order.setAddressTo(values[3]);
                    order.getClient().setName(values[4]);
                    order.getClient().setSurname(values[5]);
                    order.getClient().setPhone(values[6]);
                    order.getClient().setAddress(values[7]);
                    order.getClient().setAmount(values[8]);
                    order.getClient().setLastOrderDate(values[9]);

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

    public Map<Long, Order> getOrderMap() { return orderMap; }

    public void setOrderMap(Map<Long, Order> orderMap) { this.orderMap = orderMap; }

}
