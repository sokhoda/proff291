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
        orderMap = readMap();
    }

    public boolean addOrder(Order order) {
        if (order == null || isOrderExist(order)) return false;
        orderMap.put(order.getId(), order);
        saveOrder(order);
        return true;
    }

    public boolean replaceOrder(Order order) {
        if (order == null || !isOrderExist(order)) return false;
        orderMap.replace(order.getId(), order);
        saveOrderMap(orderMap);
        return true;
    }

    public boolean isOrderExist(Order order) {
        return (order != null && orderMap.containsKey(order.getId()) &&
            orderMap.get(order.getId()).equals(order));
    }

    public Order getOrderById(Long id) {
        if (id == null || id == 0) return null;
        return orderMap.get(id);
    }

    /////////////////////////////////////////////
    public void saveOrder(Order order) {
        if (order == null){
            return;
        }
        File file = new File(ORDER_BASE_FILE_PATH);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            String[] orderData = {
                    String.valueOf(order.getId()), order.getAmount(),
                    order.getAddressFrom(), order.getAddressTo(),
                    order.getClient().getName(), order.getClient().getSurname(),
                    order.getClient().getPhone(), order.getClient().getAddress()
            };
            StringBuilder sb = new StringBuilder();
            for (String value : orderData) {
                    sb.append(value);
                    sb.append("\t");
                }
            sb.replace(sb.length() - 1, sb.length(), "\n");
            pw.print(sb.toString());
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(pw!= null) {
                pw.close();
            }
        }
    }

    public void saveOrderMap(Map<Long, Order> orders) {
        if (orders.isEmpty()){
            return;
        }
        File file = new File(ORDER_BASE_FILE_PATH);
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            Set<Map.Entry<Long, Order>> entries = orders.entrySet();

            for (Map.Entry<Long, Order> entry : entries) {
                String[] orderData = {
                        String.valueOf(entry.getValue().getId()), entry.getValue().getAmount(),
                        entry.getValue().getAddressFrom(), entry.getValue().getAddressTo(),
                        entry.getValue().getClient().getName(), entry.getValue().getClient().getSurname(),
                        entry.getValue().getClient().getPhone(), entry.getValue().getClient().getAddress()
                };
                StringBuilder sb = new StringBuilder();
                for (String value : orderData) {
                    sb.append(value);
                    sb.append("\t");
                }
                sb.replace(sb.length() - 1, sb.length(), "\n");
                pw.print(sb.toString());
            }
        } catch(IOException e) {
            e.printStackTrace();
        } finally{
            if(pw!= null) {
                pw.close();
            }
        }
    }

    public Map<Long, Order> readMap() {
        Map<Long, Order> orders = new LinkedHashMap<Long, Order>();
        File file = new File(ORDER_BASE_FILE_PATH);
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

    /////////////////////////////////////////////
    public Map<Long, Order> getOrderMap() { return orderMap; }

    public void setOrderMap(Map<Long, Order> orderMap) { this.orderMap = orderMap; }

}
