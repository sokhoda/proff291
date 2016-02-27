package hw7.view;

import hw7.domain.CPU;
import hw7.domain.Notebook;
import hw7.domain.Store;
import hw7.service.NotebookService;
import hw7.util.StartupListener;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by i.gonchar on 2/19/2016.
 */
@WebServlet("/addStore")
public class AddStore extends HttpServlet {


    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        notebookService = StartupListener.getBean("notebookService", NotebookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        String quantityS = parameterMap.get("quantity")[0];
        int quantity = Integer.parseInt(quantityS);
        String priceS = parameterMap.get("price")[0];
        int price = Integer.parseInt(priceS);

        Long notebookId = Long.valueOf(parameterMap.get("notebookId")[0]);
        Notebook notebook = notebookService.getNotebookById(notebookId);

        Store store = new Store(notebook, quantity, price);
        notebookService.createStore(store);

        request.setAttribute("reg_result", "Store was added");
        request.getRequestDispatcher("/hw7/addStore.jsp").forward(request, resp);

        String pageAddress = "/hw7/addStore.jsp";
        request.setAttribute("reg_result", "Store was added");
        request.getRequestDispatcher(pageAddress).forward(request, resp);

    }
}
