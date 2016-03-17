package hw8.taxi.domain;
import hw8.taxi.exception.ClientException;

import java.util.GregorianCalendar;

/**
 * Created by Пк2 on 23.01.2016.
 */
public class Client  {
    //Поля String name, String surname, String phone, String address
    private String name;
    private String surname;
    private String phone;
    private String address;
    private Double orderCost=0.0;
    private GregorianCalendar lastOrderDate;
    private Integer clientId;
    private static Integer id=1;

    public Client(String name, String surname, String phone, String address){
        this.name=name;
        this.surname=surname;
        this.phone=phone;
        this.address=address;
        this.orderCost=0.0;
        this.lastOrderDate=null;
        this.clientId=Integer.valueOf(id.intValue());
        id=id+1;
    }

    public  void setName(String name){
        this.name=name;
    }

    public  void setSurname(String surname){
        this.surname=surname;
    }

    public  void setPhone(String phone){
        this.phone=phone;
    }

    public  void setAddres(String addres){
        this.address=addres;
    }

    public  void setOrderCost(Double orderCost){
        this.orderCost=orderCost;
    }

    public  void setLastOrderDate(int year, int month, int day){
        this.lastOrderDate=new GregorianCalendar(year,month,day);
    }

    public String getName(){
        return name;
    }

    public String getSurname(){
        return surname;
    }

    public String getPhone(){
        return phone;
    }

    public String getAddress(){
        return address;
    }

    public Double getOrderCost(){
        return orderCost;
    }

    public GregorianCalendar getLastOrderDate(){
        return lastOrderDate;
    }

    public int getClientId(){
        return clientId.intValue();
    }

    @Override
    public String toString() {
        return "Client{" +
                "id"+clientId+
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", orderCost=" + orderCost +
                ", lastOrderDate=" + lastOrderDate +
                '}';
    }
}
