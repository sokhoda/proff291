package hw7.notes.service;

import hw7.notes.domain.Store;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by Вадим on 17.02.2016.
 */
public class StoreServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("storeMenu")[0];

        switch (option) {
            case "receive":
                receiveService(req, resp);
                break;
            case "remove":
                removeService(req, resp);
                break;
            case "sale":
                salesService(req, resp);
        }
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        req.getRequestDispatcher(Menu.STORE_PAGE).forward(req, resp);
    }

    /*
     * Принять на склад партию ноутбуков (id ноутбука, количество, цена)
     */
    public void receiveService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long noteId = Long.valueOf(parameterMap.get("noteIdReceive")[0]);
        Integer amountReceive = Integer.valueOf(parameterMap.get("amountReceive")[0]);
        Double priceReceive = Double.valueOf(parameterMap.get("priceReceive")[0]);



    }

    /*
     * Списать со склада ноутбуки (ключ, количество)
     */
    public void removeService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long noteId = Long.valueOf(parameterMap.get("noteIdRemove")[0]);
        Integer amountRemove = Integer.valueOf(parameterMap.get("amountRemove")[0]);


    }

    /*
     * Продать указанное количество ноутбуков со склада(id склада, количество)
     */
    public void salesService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        Long storeId = Long.valueOf(parameterMap.get("storeIdSale")[0]);
        Integer amountSale = Integer.valueOf(parameterMap.get("amountSale")[0]);



    }
}
