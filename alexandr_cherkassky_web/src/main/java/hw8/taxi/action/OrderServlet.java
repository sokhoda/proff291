package hw8.taxi.action;

import hw8.taxi.domain.Client;
import hw8.taxi.domain.Order;
import hw8.taxi.exception.ClientException;
import hw8.taxi.exception.OrderException;
import hw8.taxi.service.ClientService;
import hw8.taxi.service.ClientServiceImpl;
import hw8.taxi.service.OrderService;
import hw8.taxi.service.OrderServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Пк2 on 27.02.2016.
 */
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    private ClientService clientService;
    private OrderService orderService;

    @Override
    public void init(){
        this.clientService=new ClientServiceImpl();
        this.orderService=new OrderServiceImpl();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parMap = req.getParameterMap();
        String choice = parMap.get("Button")[0];
        PrintWriter out = resp.getWriter();
        Long orderId=Long.valueOf(0);

        switch (choice) {
            case "showOrderCreationForm":
                RequestDispatcher dispatch = req.getRequestDispatcher("hw8.taxi/order.jsp");
                dispatch.forward(req, resp);
                break;
            case "CreateOrder":
                Integer clientId=0;
                try{
                     orderId=Long.parseLong(parMap.get("OrderId")[0]);
                } catch(Exception e){
                    out.println("Wrong order id !");
                }
                try{
                     clientId=Integer.parseInt(parMap.get("ClientId")[0]);
                } catch(Exception e){
                    out.println("Wrong Client id !");
                }

                String orderCost=parMap.get("orderCost")[0];
                String AdressFrom=parMap.get("AdressFrom")[0];
                String AdressTo=parMap.get("AdressTo")[0];

                RequestDispatcher rd3=req.getRequestDispatcher("hw8.taxi.action/ClientServlet");
                rd3.include(req, resp);
                String clexsist= parMap.get("Client")[0];
                if(clexsist=="false"){
                    System.out.println(clexsist);
                } else{
                    System.out.println(clexsist);
                }



















//                ArrayList<Client> clients=clientService.showAllClients();
//                if(!clients.isEmpty()){
//                    for(Client client:clients){
//                        System.out.println(client);
//                    }
//                } else{
//                    System.out.println("there is no clients!");
//                }
//
//                Client newClient=clientExsists(clientId.intValue());
//
//                if(newClient!=null){
//                    try {
//                        orderService.createOrder(orderId,newClient,orderCost,AdressFrom,AdressTo);
//                        System.out.println(orderService.getOrders().toString());
//                    } catch (OrderException e) {
//                        e.printStackTrace();
//                    }
//                }else{
//                    out.println("No such client!");
//                    dispatch=req.getRequestDispatcher("hw8.taxi/order.jsp");
//                    dispatch.include(req,resp);
//                }
//                dispatch = req.getRequestDispatcher("hw8.taxi/dashboard.jsp");
//                dispatch.forward(req, resp);
                break;

            case "EditOrder":
                orderId=Long.parseLong(parMap.get("orderId")[0]);
                Order order=orderService.findOrderById(orderId);
                if(order==null){
                    resp.setContentType("text/html");
                    out.println("Order whit such Id not found");
                } else{
                    req.setAttribute("OrderId",orderId);
                    RequestDispatcher rd=req.getRequestDispatcher("hw8.taxi/order.jsp");
                    rd.forward(req,resp);
                }
                break;

            case "showOrderByPortion":
                List<Order> orderList=orderService.showOrdersByPortion();

                if(!orderList.isEmpty()){
                    resp.setContentType("text/html");
                    for(Order order1:orderList){
                        out.println(order1.toString());
                    }
                } else{
                    resp.setContentType("text/html");
                    out.print("No more orders!");
                }
                break;
            case "showOrdersByCost":

                Long from=Long.parseLong(parMap.get("OrdersByCostFrom")[0]);
                Long to=Long.parseLong(parMap.get("OrdersByCostTo")[0]);
                List<Order> orderListByCost=orderService.showOrders(from,to);
                if(orderListByCost!=null){
                    if(!orderListByCost.isEmpty()) {
                        resp.setContentType("text/html");
                        for (Order order2 : orderListByCost) {
                            out.println(order2.toString());
                        }
                    }else{
                          resp.setContentType("text/html");
                          out.println("No orders whit such parameters");
                         }
                    } else{
                          resp.setContentType("text/html");
                          out.println("Nothing to show");
                    }
                break;
        }
    }

    private Client clientExsists(int clientId){
        Client exsistingClient;
        List<Client> allClients=clientService.showClientsGtSum(0);

        if(allClients!=null){
            if(!allClients.isEmpty()){
                for(Client client:allClients){
                    if(client.getClientId()==clientId){
                        exsistingClient=client;
                        System.out.println(exsistingClient.toString());
                        return exsistingClient;
                    }
                }
            }else{
                System.out.println("no clients");
            }
        } else{
            System.out.println("id error");
        }
        return null;
    }





}
