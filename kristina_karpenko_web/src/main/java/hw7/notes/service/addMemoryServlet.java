package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.Memory;
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

/**
 * Created by Администратор on 18.02.2016.
 */

@WebServlet("/addMemoryServlet")
public class addMemoryServlet extends HttpServlet {

    private static SessionFactory factory;
    Session session = null;
    MemoryDao memoryDao;
    VendorDao vendorDao;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();

        memoryDao = new MemoryDaoImpl(factory);
        vendorDao = new VendorDaoImpl(factory);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String size = req.getParameter("size");
        String vendorName = req.getParameter("vendor");
        String create = req.getParameter("create");
        String update = req.getParameter("update");
        String idStr = req.getParameter("id");

        Vendor vendor = vendorDao.findVendorByName(vendorName);
        Memory memory = new Memory(vendor, size);

        if (update != null && create == null) {
            if(idStr == ""){
                resp.getWriter().print("Input ID, please");
            }else {
                Long id = Long.parseLong(idStr);
                memory.setId(id);
            }
            boolean is = memoryDao.update(memory);
            if (is == false) {
                resp.getWriter().print("Not update. Maybe, you input wrong Id");
            }

        } else {
            memoryDao.create(memory);
        }

    }


}
