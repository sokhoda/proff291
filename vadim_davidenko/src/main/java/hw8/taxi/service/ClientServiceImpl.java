package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.ClientException;

import java.io.*;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class ClientServiceImpl implements ClientService {

    private Map<Long, Client> clientMap = new LinkedHashMap<Long, Client>();
    private final static String CLIENT_BASE_FILE_PATH = "C:/client_base.txt";
    private static int portionStartPos;

    public ClientServiceImpl(Map<Long, Client> clientMap) {
        this.clientMap = clientMap;
    }

    public ClientServiceImpl() {
        clientMap = deserialization(CLIENT_BASE_FILE_PATH);
    }

    public boolean createClient(String name, String surname, String phone, String address)
            throws ClientException {

        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() ||
                phone == null || phone.isEmpty()) {
            throw new ClientException("Client creation failed, empty Name and/or Surname and/or Phone number");
        }
        Long id = sequenceNumber(clientMap.keySet());
        if (id.equals(1L)) id += 100;
        Client newClient = new Client(id, name, surname, phone, address);

        Set<Map.Entry<Long, Client>> entries = clientMap.entrySet();
        for (Map.Entry entry : entries) {
            Client client = (Client) entry.getValue();
            if (newClient.equals(client)) {
                throw new ClientException("Client creation failed, such client already exists");
            }
        }
        clientMap.put(newClient.getId(), newClient);

        if (!serialization(clientMap, CLIENT_BASE_FILE_PATH)) {
            clientMap.remove(newClient.getId());
            throw new ClientException("Client creation failed, database error");
        }
        return true;
    }

    public List<Client> showClientsByPortion(int portionSize) {
        Set<Map.Entry<Long, Client>> entries = clientMap.entrySet();
        List<Client> clientList = new ArrayList<Client>();

        for (Map.Entry<Long, Client> entry : entries) {
            clientList.add(entry.getValue());
        }
        if (clientList.size() < portionSize) {
            portionSize = clientList.size();
        }
        List<Client> outputList = new ArrayList<Client>();
        if (portionStartPos + portionSize <= clientList.size()) {
            outputList = clientList.subList(portionStartPos, portionStartPos + portionSize);
        }
        portionStartPos += portionSize;
        return outputList;
    }

    public List<Client> showClientsGtSum(int sum) {
        portionStartPos = 0;

        OrderServiceImpl orderService = new OrderServiceImpl();
        Map<Long, Order> orderMap = orderService.getOrderMap();
        Set<Map.Entry<Long, Client>> clientEntries = clientMap.entrySet();
        List<Client> outputList = new LinkedList<Client>();

        for (Map.Entry clientEntry : clientEntries) {
            Client client = (Client) clientEntry.getValue();
            Set<Map.Entry<Long, Order>> orderEntries = orderMap.entrySet();

            int clientSum = 0;
            for (Map.Entry orderEntry : orderEntries) {
                Order order = (Order)orderEntry.getValue();
                if (order.getClientId().equals(client.getId())) {
                    clientSum += Integer.parseInt(order.getAmount());
                }
            }
            if (clientSum > sum) {
                client.setOrdersSum(String.valueOf(clientSum));
                outputList.add(client);
            }
        }
        return outputList;
    }

    public List<Client> showClientsLastMonth() {
        portionStartPos = 0;

        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);  // DD.MM.YYYY
        String currentMonth = df.format(new Date()).substring(3, 5);

        OrderServiceImpl orderService = new OrderServiceImpl();
        Map<Long, Order> orderMap = orderService.getOrderMap();
        Set<Map.Entry<Long, Client>> clientEntries = clientMap.entrySet();
        List<Client> outputList = new LinkedList<Client>();

        for (Map.Entry clientEntry : clientEntries) {
            Client client = (Client) clientEntry.getValue();
            Set<Map.Entry<Long, Order>> orderEntries = orderMap.entrySet();

            for (Map.Entry orderEntry : orderEntries) {
                Order order = (Order)orderEntry.getValue();
                String orderMonth = order.getOrderDate().substring(3, 5);

                if (order.getClientId().equals(client.getId()) && orderMonth.equals(currentMonth)) {
                    client.setLastOrderedDate(order.getOrderDate());
                    outputList.add(client);
                    break;
                }
            }
        }
        return outputList;
    }

    public Long sequenceNumber(Set<Long> numbers) {
        Long max = 0L;
        for (Long number : numbers) {
            if (max.compareTo(number) < 0) max = number;
        }
        return ++max;
    }

    public Map<Long, Client> getClientMap() { return clientMap; }

    public void setClientMap(Map<Long, Client> clientMap) { this.clientMap = clientMap; }

    ///////////////////////////////////////////////////////////////////////////

    public boolean serialization(Map<Long, Client> clients, String fileName) {
        if (clients.isEmpty()){
            return false;
        }
        File file = new File(fileName);
        PrintWriter pw = null;

        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, false)));
            Set<Map.Entry<Long, Client>> entries = clients.entrySet();

            for (Map.Entry<Long, Client> entry : entries) {
                String[] clientData = {
                        entry.getValue().getId().toString(),
                        entry.getValue().getName(),
                        entry.getValue().getSurname(),
                        entry.getValue().getPhone(),
                        entry.getValue().getAddress()
                };
                StringBuilder sb = new StringBuilder();
                for (String value : clientData) {
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

    public Map<Long, Client> deserialization(String fileName) {
        Map<Long, Client> orders = new LinkedHashMap<Long, Client>();
        File file = new File(fileName);
        BufferedReader br = null;

        if (file.exists()) {
            try{
                br = new BufferedReader(new FileReader(file));
                String line = "";
                while ((line = br.readLine()) != null) {
                    String[] values = line.split("\t");
                    Client client = new Client();

                    client.setId(Long.valueOf(values[0]));
                    client.setName(values[1]);
                    client.setSurname(values[2]);
                    client.setPhone(values[3]);
                    client.setAddress(values[4]);

                    orders.put(client.getId(), client);
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