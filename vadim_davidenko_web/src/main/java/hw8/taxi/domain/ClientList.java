package hw8.taxi.domain;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by v.davidenko on 29.01.2016.
 */
public class ClientList {

    private List<Client> clientList = new LinkedList<Client>();
    private final static String CLIENT_BASE_FILE_PATH = "C:/client_base.txt";

    public ClientList(List<Client> clientList) {
        this.clientList = clientList;
    }

    public ClientList() {
        clientList = deserialization(CLIENT_BASE_FILE_PATH);
    }

    public boolean addClient(Client client) {
        if (client == null || clientList.contains(client)) {
            return false;
        }
        clientList.add(client);
        serialization(clientList, CLIENT_BASE_FILE_PATH);
        return true;
    }

    public boolean serialization(List<Client> clients, String fileName) {
        if (clients.isEmpty()) {
            return false;
        }
        File file = new File(fileName);
        PrintWriter pw = null;

        try{
            pw = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            for (Client client : clients) {
                String record = client.getName() + "\t" +
                                client.getSurname() + "\t" +
                                client.getPhone() + "\t" +
                                client.getAddress() + "\t" +
                                client.getAmount() + "\t" +
                                client.getLastOrderDate() + "\n";
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

                    client.setName(values[0]);
                    client.setSurname(values[1]);
                    client.setPhone(values[2]);
                    client.setAddress(values[3]);
                    client.setAmount(values[4]);
                    client.setLastOrderDate(values[5]);

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

    public List<Client> getClientList() {
        return clientList;
    }

    public void setClientList(List<Client> clientList) {
        this.clientList = clientList;
    }
}
