package hw7.view;

import hw7.service.NotebookService;
import hw7.util.StartupListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by i.gonchar on 2/26/2016.
 */
@WebServlet("/addSales")
public class AddSales extends HttpServlet {

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
    }
}