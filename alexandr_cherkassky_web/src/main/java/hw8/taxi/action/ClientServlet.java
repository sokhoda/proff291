package hw8.taxi.action;

import hw8.taxi.Service.ClientService;
import hw8.taxi.Service.ClientServiceImpl;
import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Пк2 on 26.02.2016.
 */
@WebServlet("/client")
public class ClientServlet extends HttpServlet {
    private Map<String,String> adminLoginPassvord= new HashMap<>();
    private ClientService service;
    @Override
    public void init(){
        service=new ClientServiceImpl();
        adminLoginPassvord.put("admin", "admin");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> paramMap=req.getParameterMap();
        String choice=paramMap.get("Button")[0];
        PrintWriter out=resp.getWriter();

        switch(choice){
            case "LogIn":
                String login= paramMap.get("login")[0];
                String passvord=paramMap.get("passvord")[0];
                if(passvord.equals(adminLoginPassvord.get(login))){
                    System.out.println("Authorisation sucesseful!");
                    RequestDispatcher rd=req.getRequestDispatcher("hw8.taxi/dashboard.jsp");
                    rd.forward(req,resp);

                } else{
                    System.out.println("Wrong login or passvord!");
                    resp.setContentType("text/html");
                    out.print("Wrong login or passvord! Try again");
                    RequestDispatcher rd=req.getRequestDispatcher("index1.jsp");
                    rd.include(req,resp);
                }
                break;

            case "showRegistrForm":
                RequestDispatcher rd=req.getRequestDispatcher("hw8.taxi/registerClient.jsp");
                rd.forward(req,resp);
                break;
            case "create Client":
                String clName=paramMap.get("clName")[0];
                String clSurname=paramMap.get("clSurname")[0];
                String clPhone=paramMap.get("clPhone")[0];
                String clAdress=paramMap.get("clAdress")[0];
                    try {
                    service.createClient(clName,clSurname,clPhone,clAdress);
                } catch (ClientException e) {
                    e.printStackTrace();
                }
                RequestDispatcher rd2=req.getRequestDispatcher("hw8.taxi/dashboard.jsp");
                rd2.forward(req,resp);
                break;

            case "showClientsByTen":
                resp.setContentType("text/html");
                List<Client> clientsList=service.showClientsByPortion(10);
                if(clientsList!=null) {
                    for (Client client:clientsList ){
                        out.println(client.toString());
                    }
                } else{
                    out.println("There is no clients");
                }
                break;
            case "showClientsByOrderCost":
                int wantedCost=Integer.parseInt(paramMap.get("wantedCost")[0]);
                resp.setContentType("text/html");
                List<Client> clientsListByCost=service.showClientsGtSum(wantedCost);
                if(clientsListByCost!=null) {
                    for (Client client : clientsListByCost) {
                        out.println(client.toString());
                    }
                }else{
                    out.println("There is no clients whit such parameter");
                }
                break;

            case "showThisMonthClients":
                List<Client> clientsListByMonth=service.showClientsLastMonth();
                   if(clientsListByMonth!=null){
                    for (Client client : clientsListByMonth) {
                        out.println(client.toString());
                    }
                }else{
                    out.println("There is no clients in this month");
                }
                break;


        }


    }


}
