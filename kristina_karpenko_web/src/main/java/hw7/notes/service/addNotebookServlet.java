package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/addNotebookServlet")
public class addNotebookServlet extends HttpServlet {

    private static SessionFactory factory;
    Session session = null;
    MemoryDao memoryDao;
    VendorDao vendorDao;
    CPUDao cpuDao;
    Vendor vendor;
    Memory memory;
    CPU cpu;
    Notebook notebook;
    NotebookDao notebookDao;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        notebookDao = new NotebookDaoImpl(factory);
        memoryDao = new MemoryDaoImpl(factory);
        vendorDao = new VendorDaoImpl(factory);
        cpuDao = new CPUDaoImpl(factory);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vend = req.getParameter("vendorName");
        String modelName = req.getParameter("modelName");
        String cpuName = req.getParameter("cpuName");
        String memorySize = req.getParameter("memorySize");
        String memoryVend = req.getParameter("memoryVendor");
        String create = req.getParameter("create");
        String update = req.getParameter("update");
        String idStr = req.getParameter("id");

        vendor = vendorDao.findVendorByName(vend);
        memory = memoryDao.findMemoryByName(memoryVend, memorySize);
        cpu = cpuDao.findCPUByName(cpuName);

        notebook = new Notebook(modelName, vendor, cpu, memory);


        if (update != null && create == null) {
            if (idStr == "") {
                resp.getWriter().print("Input ID, please");
            } else {
                Long id = Long.parseLong(idStr);
                notebook.setId(id);
            }
            boolean is = notebookDao.update(notebook);
            if (is == false) {
                resp.getWriter().print("Not update. Maybe, you input wrong Id");
            }

        } else {
            notebookDao.create(notebook);
        }

    }

}


