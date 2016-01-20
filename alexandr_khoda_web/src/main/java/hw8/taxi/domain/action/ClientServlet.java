package hw8.taxi.domain.action;

import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InterruptedIOException;

/**
 * Created by s_okhoda on 20.01.2016.
 */
@WebServlet("/ClientServlet")
public class ClientServlet extends HttpServlet {
    ClientService clientService = new ClientService();

    @Override
    public void init(){

    }
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        try {
            clientService.createClient(req.getParameter("name"), req.getParameter
                    ("surname"), req.getParameter("phone"), req.getParameter
                    ("address"));
        }
        catch (ClientException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
//        res.getWriter().print("doGet");
        if (req.getParameter("selAct").equals("createClient")){
            req.getRequestDispatcher("/pages/registerClient.jsp").forward
                    (req,res);
        }
        else if (req.getParameter("selAct").equals("showClientsByPortion")){
            String clientQuantity = req.getParameter("clientQuantity");
            int quantity = 0;
            try {
                quantity = Integer.parseInt(clientQuantity);
            }
            catch (NumberFormatException ex){
                res.getWriter().print("Not valid 'clientQuantity' value:" +
                        clientQuantity);
                return;
            }
            clientService.showClientsByPortion(quantity);
            }
            else if (req.getParameter("selAct").equals("showClientsGtSum")){
                    String clientOrderSum = req.getParameter("clientOrderSum");
                    int orderSum = 0;
                    try {
                        orderSum = Integer.parseInt(clientOrderSum);
                    }
                    catch (NumberFormatException ex){
                        res.getWriter().print("Not valid 'clientOrderSum' value:" + clientOrderSum);
                        return;
                    }
                    clientService.showClientsGtSum(orderSum);
                }
                else if (req.getParameter("selAct").equals("showClientsLastMonth")){
                    clientService.showClientsLastMonth();
                    }
                    else{
                        res.getWriter().println("Not valid option selected.");
                        return;
                    }
    }
}
