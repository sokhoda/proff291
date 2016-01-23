package taxi.Action;

import taxi.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Юлия on 19.01.2016.
 */
@WebServlet(name = "OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = new Order();

        order.setAddressFrom(request.getParameter("AddressFrom"));
        order.setAddressTo(request.getParameter("AddressTo"));
//        order.setClient(request.getParameter("Client"));
//        order.setId(request.getParameter("Id"));
//        order.setDate(request.getParameter("Date"));
//        order.setAmount(request.getParameter("Amount"));



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
