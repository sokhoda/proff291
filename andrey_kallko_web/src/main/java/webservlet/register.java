package webservlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by tri___ton on 21.01.16.
 */

@WebServlet("/register")
public class register extends HttpServlet {
    Client[] clients= new Client[200];
    String tempname;
    String tempsurName;
    String tempphone;
    String tempadress;
    String tempprice;
    String templastCall;

    public class Client {
        String name;
        String surName;
        String phone;
        String adress;
        int price;
        String lastCall;

        public Client(){

        }

        public Client(String name, String surName, String phone, String adress, int price, String lastCall) {
            this.name = name;
            this.surName = surName;
            this.phone = phone;
            this.adress = adress;
            this.price = price;
            this.lastCall = lastCall;
        }

        @Override
        public String toString() {
            return "Client{" +
                    "name='" + name + '\'' +
                    ", surName='" + surName + '\'' +
                    ", phone='" + phone + '\'' +
                    ", adress='" + adress + '\'' +
                    ", price='" + price + '\'' +
                    ", lastCall='" + lastCall + '\'' +
                    '}';
        }
    }


    @Override
    public void init() {


        clients[0]=new Client("Andy","Bandy","223344","Kyev",200,"November");
        clients[1]=new Client("Alex","Smalex","112233","Dnepr",300,"September");
        clients[2]=new Client("Max","Shmax","664477","Kharkov",100,"January");
        clients[3]=new Client("Dimon","Mamon","558833","Doneck",250,"June");
        clients[4]=new Client("Misha","Shish","448822","Poltava",110,"December");

        System.out.println("Зарегестрировано 5  клиентов");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // простой вариант получения параметра
        //login =  request.getParameter("login");


        // надежный вариант получения параметра
        Map<String, String[]> parameterMap = request.getParameterMap();
        tempname = parameterMap.get("name")[0];
        tempsurName = parameterMap.get("surName")[0];
        tempphone = parameterMap.get("phone")[0];
        tempadress = parameterMap.get("adress")[0];
        tempprice = parameterMap.get("price")[0];
        int intTempPrice = Integer.parseInt(tempprice);
        templastCall = parameterMap.get("lastCall")[0];

        int i=0;
        while (i<200){
            if (clients[i]==null) {
                clients[i] = new Client(tempname,tempsurName,tempphone,tempadress,intTempPrice,templastCall);
                break;
            }

            i++;
        }


        i=0;
        while (clients[i]!=null) {
            System.out.println(clients[i].toString());
            i++;
        }
        System.out.println();
        request.getRequestDispatcher("register.jsp").forward(request,response);
    }
}