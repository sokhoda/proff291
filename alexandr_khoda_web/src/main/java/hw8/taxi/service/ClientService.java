package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by s_okhoda on 20.01.2016.
 */
public class ClientService {
    private List<Client> clients = new ArrayList<Client>();
    private final int daysNumBeforeToday = 30;
    private int lastPrintedClientInx = -1;
    private int clientQuantity = 7;
    private int clientOrderSum = 100;
    private final String footer = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private final int numOfClients = 20;

    public ClientService() {
    }

    public boolean createClient(String name, String surname, String phone,
                               String address) throws ClientException{
        if (name == null || surname == null || phone == null || address == null){
            throw  new ClientException("Client Data can not be NULL");
        }
        if (name.trim().length() == 0 || surname.trim().length() == 0 ||
                phone.trim().length() == 0){
            throw new ClientException("Client Data can not have ZERO LENGTH");
        }

        clients.add(new Client(name, surname, phone, address));
        return true;
    }

    public List showClientsByPortion(int portionSize){
        List<Client> list = new ArrayList<Client> ();
        if (portionSize == 0) {
            return null;
        }
        int i = lastPrintedClientInx + 1;
        while (i < clients.size() && i < lastPrintedClientInx + 1 +portionSize){
            list.add(clients.get(i++));
        }
        lastPrintedClientInx = i - 1;
        return list;
    }

    public List showClientsGtSum(int sum){
        List<Client> list = new ArrayList<Client> ();
        for (Client client: clients) {
            if(client.getTotalOrderAmount() >= sum){
                list.add(client);
            }
        }
        return list;
    }
    public List showClientsLastMonth(){
        List<Client> list = new ArrayList<Client> ();
//        int curMonth = Calendar.getInstance().get(Calendar.MONTH) + 1;
        GregorianCalendar curGregDate = new GregorianCalendar();

        for (Client client: clients) {
            GregorianCalendar clientLastOrdDate = client.getLastOrderDate();
            if (clientLastOrdDate != null) {
                if (daysBetween2Dates(clientLastOrdDate, curGregDate)
                        >= -daysNumBeforeToday &&
                        client.getLastOrderDate().compareTo(curGregDate) <= 0) {
                    list.add(client);
                }
            }
        }
        return list;
    }
    public int daysBetween2Dates(GregorianCalendar gc1, GregorianCalendar gc2){
        return (int)((gc1.getTimeInMillis() - gc2.getTimeInMillis()) /(
                1000*60*60*24));
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public int getLastPrintedClientInx() {
        return lastPrintedClientInx;
    }

    public void setLastPrintedClientInx(int lastPrintedClientInx) {
        this.lastPrintedClientInx = lastPrintedClientInx;
    }

    public int getClientQuantity() {
        return clientQuantity;
    }

    public void setClientQuantity(int clientQuantity) {
        this.clientQuantity = clientQuantity;
    }

    public int getClientOrderSum() {
        return clientOrderSum;
    }

    public void setClientOrderSum(int clientOrderSum) {
        this.clientOrderSum = clientOrderSum;
    }

    public String getFooter() {
        return footer;
    }

    public int getNumOfClients() {
        return numOfClients;
    }
}
