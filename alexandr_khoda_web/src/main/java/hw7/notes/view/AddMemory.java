package hw7.notes.view;

import hw7.notes.dao.MemoryDao;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Vendor;
import hw7.notes.service.NotebookService;
import hw7.notes.service.NotebookServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static hw7.notes.view.Servlet.checkStringPar;
import static hw7.notes.view.Servlet.setMessageAttr;

/**
 * Created by s_okhoda on 09.02.2016.
 */
@WebServlet("/AddMem")
public class AddMemory extends HttpServlet {
    public static final String NameSurname = " All rights reserved, Alexandr " +
            "Khodakovskyi, Kyiv 2016";
    private NotebookService service;
    private MemoryDao memoryDao;

    @Override
    public void init() {
        service = new NotebookServiceImpl();
        memoryDao = (((NotebookServiceImpl)service).getMemoryDao());
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws
            ServletException, IOException {

        if (req.getParameter("back") != null) {
            req.getRequestDispatcher("/hw7.notes/pages/menu.jsp").forward(req, res);
            return;
        }

        if (req.getParameter("add") != null) {
            try {
                String vendor = req.getParameter("vendor");
                String size = req.getParameter("size");
                if (!checkStringPar(req, vendor) && !checkStringPar(req, size)){
                    if (memoryDao.create(new Memory()) != null) {
                        setMessageAttr(req, "green", "Memory successfully added.");
                    }
                    else {
                        setMessageAttr(req, "red", "Failed to add Memory '" +
                                vendor + "'.");
                    }
                    setVendorAttributes(req);
                }
                req.getRequestDispatcher("/hw7.notes/pages/addMemory.jsp")
                        .forward(req, res);
                return;
            }
            catch (Exception e) {
                throw new ServletException(e.getMessage());
            }
        }

    }
    private void setVendorAttributes(HttpServletRequest req){
        req.setAttribute("nameA", req.getParameter("name"));
    }
}
