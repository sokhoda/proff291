package hw8.taxi.action;

import hw8.taxi.domain.Client;
import hw8.taxi.exception.ClientException;
import hw8.taxi.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by v.davidenko on 29.01.2016.
 *
 */

@WebServlet("/clientServlet")
public class ClientServlet extends HttpServlet {

    private ClientServiceImpl clientService = new ClientServiceImpl();
    private int portionStartPos;
    final static String CLIENT_CREATED_MSG = "New client created successfully";
    final static String NO_CLIENTS_FOUND_MSG = "No clients found";
    final static String CLIENT_REGISTRATION_PAGE = "registerClient.jsp";
    final static String CLIENT_LIST_PAGE = "clients.jsp";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        showClientsService(req, resp);
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        registrationClientService(req, resp);
    }

    public void registrationClientService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String name = parameterMap.get("clientName")[0].trim();
        String surname = parameterMap.get("clientSurname")[0].trim();
        String address = parameterMap.get("clientAddress")[0].trim();
        String phone = parameterMap.get("clientPhone")[0].trim();

        boolean isCreated = false;
        try {
            synchronized (ClientServlet.class) {
                isCreated = clientService.createClient(name, surname, phone, address);
            }
            if (isCreated) {
                req.setAttribute("clientServlet_msg", CLIENT_CREATED_MSG);
            }
        } catch (ClientException e) {
            req.setAttribute("clientServlet_err_msg", e.getMessage());
            req.setAttribute("clientName", name);
            req.setAttribute("clientSurname", surname);
            req.setAttribute("clientAddress", address);
            req.setAttribute("clientPhone", phone);
        }
        req.getRequestDispatcher(CLIENT_REGISTRATION_PAGE).forward(req, resp);
    }

    public void showClientsService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String showBy = parameterMap.get("showBy")[0];

        ClientServiceImpl clientService = new ClientServiceImpl();
        List<Client> clients = null;
        String title = "";
        int portionSize = 10;
        int gtSum = 100;

        switch (showBy) {
            case "portion":
                portionSize = Integer.parseInt(parameterMap.get("portionSize")[0]);
                clients = clientService.showClientsByPortion(portionSize);
                int size = (portionSize > clients.size()) ? clients.size() : portionSize;
                title = "Clients " + String.valueOf(portionStartPos + 1) + " - " +
                        String.valueOf(portionStartPos + size);
                portionStartPos += size;
                break;
            case "sum":
                portionStartPos = 0;
                gtSum = Integer.parseInt(parameterMap.get("gtSum")[0]);
                clients = clientService.showClientsGtSum(gtSum);
                title = "Clients ordered on sum greater " + String.valueOf(gtSum);
                req.setAttribute("orderSum", "Sum of orders");
                break;
            case "month":
                portionStartPos = 0;
                clients = clientService.showClientsLastMonth();
                title = "Clients ordered in the last month";
                req.setAttribute("orderDate", "Last order date");
                break;
        }
        req.setAttribute("showBy", showBy);
        req.setAttribute("portionSize", String.valueOf(portionSize));
        req.setAttribute("gtSum", String.valueOf(gtSum));

        if (clients != null && !clients.isEmpty()) {
            req.setAttribute("clientList", clients);
            req.setAttribute("clientListTitle", title);
            req.getRequestDispatcher(CLIENT_LIST_PAGE).forward(req, resp);
        } else {
            req.setAttribute("clientServlet_err_msg", NO_CLIENTS_FOUND_MSG);
            req.getRequestDispatcher(CLIENT_LIST_PAGE).forward(req, resp);
        }
    }
}
