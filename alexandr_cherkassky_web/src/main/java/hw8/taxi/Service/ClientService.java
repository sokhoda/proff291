package hw8.taxi.Service;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Пк2 on 23.01.2016.
 */
public class ClientService {
    private int startIndx=0;



    private List<Client> clients= new ArrayList<Client>();

    boolean createClient(String name, String surname, String phone, String address) throws ClientException{
        if (name == null || surname == null || phone == null || address == null) {
            throw new ClientException("fields must not be null");
        }

        if (name.length() == 0 || surname.length() == 0 || phone.length() == 0 || address.length() == 0) {
            throw new ClientException("fields must not have zero length");
        }

        if(clients.add( new Client(name, surname, phone, address))){
            return true;
        } else return false;
    }

    List showClientsByPortion(int portionSize){
        List<Client> clientsByPortion= new ArrayList<Client>();
        int left=clients.size()-startIndx;
        if(left>0){
            if(left>portionSize){
                for(int i=0;i<portionSize;i++){
                    clientsByPortion.add(clients.get(startIndx+i));
                }
                startIndx=startIndx+portionSize;
            } else {
                for(int i=0;i<left;i++){
                    clientsByPortion.add(clients.get(startIndx+i));
                }
            }
        }
        return clientsByPortion;
    }

    List showClientsGtSum(int sum){
        List<Client> clientsBySum= new ArrayList<Client>();
        int index=0;
        while(index<clients.size()){
            Client tmp=clients.get(index);
            if(tmp.getOrderCost()>=sum){
                clientsBySum.add(tmp);
            }
            index++;
        }
        return clientsBySum;
    }
    List showClientsLastMonth(){
        List<Client> clientsByLastMonth= new ArrayList<Client>();
        return clientsByLastMonth;
    }




}
