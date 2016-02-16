package hw7.notes.service;

import hw7.notes.domain.Notebook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by v.davidenko on 15.02.2016.
 */

@WebServlet("/noteServlet")
public class NoteServlet extends HttpServlet {

    final static String NOTEBOOK_PAGE = "hw7/entity/notebook.jsp";
    final static String UPDATE_SUCCESS_MSG = "Data updated successfully";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String id = parameterMap.get("entityId")[0];
        String model = parameterMap.get("model")[0].trim();


        Notebook notebook = new Notebook();
        notebook.setId(Long.valueOf(id));
        notebook.setModel(model);


        if (Menu.noteService.updateNotebook(notebook)) {
            req.setAttribute("server_msg", UPDATE_SUCCESS_MSG);
        }
        req.setAttribute("entityId", id);
        req.setAttribute("model", model);

        req.getRequestDispatcher(NOTEBOOK_PAGE).forward(req, resp);
    }

}
