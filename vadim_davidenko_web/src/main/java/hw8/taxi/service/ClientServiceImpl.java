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

    private List<Client> clientList = new LinkedList<Client>();
    private final static String CLIENT_BASE_FILE_PATH = "C:/client_base.txt";
    private int portionStartPos;

    public ClientServiceImpl(List<Client> clientList) {
        this.clientList = clientList;
    }

    public ClientServiceImpl() {
        clientList = deserialization(CLIENT_BASE_FILE_PATH);
    }

    public boolean createClient(String name, String surname, String phone, String address)
            throws ClientException {

        if (name == null || name.isEmpty() || surname == null || surname.isEmpty() ||
                phone == null || phone.isEmpty()) {
            throw new ClientException("Client creation failed, empty Name and/or Surname and/or Phone number");
        }
        Long id = (long)(clientList.size() + 1);
        Client newClient = new Client(id, name, surname, phone, address);
        if (clientList.contains(newClient)) {
            throw new ClientException("Client creation failed, such client already exists");
        }
        clientList.add(newClient);

        if (!serialization(clientList, CLIENT_BASE_FILE_PATH)) {
            clientList.remove(newClient);
            throw new ClientException("Client creation failed, database error");
        }
        return true;
    }

    public List<Client> showClientsByPortion(int portionSize) {
        if (clientList.size() < portionSize) {
            portionSize = clientList.size();
        }
        List<Client> outputList = new ArrayList<Client>();
        if (portionStartPos + portionSize <= clientList.size()) {
            ArrayList<Client> clientArrayList = new ArrayList<Client>(clientList);
            outputList = clientArrayList.subList(portionStartPos, portionStartPos + portionSize);
        }
        portionStartPos += portionSize;
        return outputList;
    }

    public List<Client> showClientsGtSum(int sum) {
        portionStartPos = 0;
        List<Client> outputList = new LinkedList<Client>();

        OrderServiceImpl orderService = new OrderServiceImpl();
        Map<Long, Order> orderMap = orderService.getOrderMap();
        Set<Map.Entry<Long, Order>> entries = orderMap.entrySet();

        for (Client client : clientList) {
            int clientSum = 0;
            for (Map.Entry entry : entries) {
                Order order = (Order)entry.getValue();
                if (order.getClientId().equals(client.getId())) {
                    clientSum += Integer.parseInt(order.getAmount());
                }
            }
            if (clientSum > sum) {
                outputList.add(client);
            }
        }
        return outputList;
    }

    public List<Client> showClientsLastMonth() {
        portionStartPos = 0;
        List<Client> outputList = new LinkedList<Client>();

        OrderServiceImpl orderService = new OrderServiceImpl();
        Map<Long, Order> orderMap = orderService.getOrderMap();
        Set<Map.Entry<Long, Order>> entries = orderMap.entrySet();

        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);  // DD.MM.YYYY
        String currentMonth = df.format(new Date()).substring(3, 5);

        for (Client client : clientList) {
            for (Map.Entry entry : entries) {
                Order order = (Order)entry.getValue();
                String orderMonth = order.getOrderDate().substring(3, 5);
                if (order.getClientId().equals(client.getId()) && orderMonth.equals(currentMonth)) {
                    outputList.add(client);
                    break;
                }
            }
        }
        return outputList;
    }

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    ///////////////////////////////////////////////////////////////////////////
    public boolean serialization(List<Client> clients, String fileName) {
        if (clients.isEmpty()) {
            return false;
        }
        File file = new File(fileName);
        PrintWriter pw = null;

        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            for (Client client : clients) {
                String record = client.getId().toString() + "\t" +
                        client.getName() + "\t" +
                        client.getSurname() + "\t" +
                        client.getPhone() + "\t" +
                        client.getAddress() + "\n";
                pw.print(record);
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

    public List<Client> deserialization(String fileName) {
        List<Client> clients = new LinkedList<Client>();
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

                    clients.add(client);
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
        return clients;
    }
}

