package hw6.notes.view;

import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.Map;

/**
 * Created by Pavel on 10.02.2016.
 */
@WebServlet("/addNotebook.sepadmi")
public class NotebookController extends HttpServlet {

    private String error_message = "ERROR - incorrect values of fields!";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String server_msg = "";

        Notebook notebook = null;
        NotebookDaoImpl notebookDao = new NotebookDaoImpl(HibernateUtil.getSessionFactory());

        try {
            notebook = new Notebook();
            notebook.setSerial(parameterMap.get("serial")[0]);
            notebook.setVendor(parameterMap.get("vendor")[0]);
            notebook.setModel(parameterMap.get("model")[0]);
            notebook.setManufacture_date(new Date(System.currentTimeMillis()));
            notebook.setPrice(Float.parseFloat(parameterMap.get("price")[0]));
        } catch (Exception e){
            server_msg = error_message;
        }

        if(notebookDao.create(notebook) != null){
            server_msg = "Notebook created";
        }

        req.setAttribute("server_message", server_msg);
        if(server_msg != error_message) {
            req.getRequestDispatcher("/notebooksMain.jsp").forward(req, resp);
        }
    }
}
