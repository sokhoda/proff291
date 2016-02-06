package hw8.taxi.service;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Admin on 20.01.2016.
 */
public class ClientService {

    public static List<Client>  clients = new ArrayList<Client>();

    private int portSize = 0;
    private Date lastMonth;

    public  ClientService() {

    }

    public  boolean createClient(String name, String surname, String phone, String address) throws ClientException {
        if(name == "" || surname == "" || phone == "" || address == ""){
            return false;
        } else {
            clients.add(new Client(name, surname, phone, address));
            return true;
        }
    }



    public List showClientsByPortion(int portionSize) {
        List<Client> clientsByPortion = new ArrayList<Client>();
        if(portSize < clients.size() && (clients.size() - portSize) >= portionSize){

            for (int i = portSize; i < (portSize + portionSize); i++ ){
                clientsByPortion.add(clients.get(i));
            }
            portSize += portionSize;

            return clientsByPortion;
        }
       else if(portSize == clients.size()){
            portSize = 0;
            return null;
        }
       else  if((clients.size() - portSize) < portionSize){

            for (int i = portSize; i < (clients.size() - portSize); i++ ){
                clientsByPortion.add(clients.get(i));
            }
            portSize = clients.size();
            return clientsByPortion;
        }
        else{
           return null;
        }
    }

    public List showClientsGtSum(int sum) {
        List<Client> clientsGtSum = new ArrayList<Client>();
        for (Client clie : clients) {
            if(clie.getSumma() > (long)sum){
                clientsGtSum.add(clie);
            }

        }
        return clientsGtSum;
    }

    public List showClientsLastMonth() {
        Calendar calen = Calendar.getInstance();
        calen.set(2015, Calendar.DECEMBER , 24 );

        lastMonth  = calen.getTime();

        List<Client> clientsLastMonth = new ArrayList<Client>();
        for (Client clie : clients) {
            if(clie.getDateOfLastOrder().after(lastMonth)){
                clientsLastMonth.add(clie);
            }

        }
        return clientsLastMonth;

    }
}


