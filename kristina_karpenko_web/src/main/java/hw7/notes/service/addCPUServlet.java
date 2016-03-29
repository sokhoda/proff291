package hw7.notes.service;

import hw7.notes.dao.CPUDao;
import hw7.notes.dao.CPUDaoImpl;
import hw7.notes.dao.VendorDao;
import hw7.notes.dao.VendorDaoImpl;
import hw7.notes.domain.CPU;
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
 * Created by Администратор on 17.02.2016.
 */
@WebServlet("/addCPUServlet")
public class addCPUServlet extends HttpServlet {

    private static SessionFactory factory;
    Session session = null;
    VendorDao vendorDao;
    CPUDao cpuDao;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        vendorDao = new VendorDaoImpl(factory);
        cpuDao = new CPUDaoImpl(factory);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String model = req.getParameter("model");
        String frequency = req.getParameter("frequency");
        String vendorName = req.getParameter("vendor");
        String create = req.getParameter("create");
        String update = req.getParameter("update");
        String idStr = req.getParameter("id");

        Vendor vendor = vendorDao.findVendorByName(vendorName);
        CPU cpu = new CPU(vendor, model, frequency);


        if (update != null && create == null) {
            if (idStr == "") {
                resp.getWriter().print("Input ID, please");
            } else {
                Long id = Long.parseLong(idStr);
                cpu.setId(id);
            }
            boolean is = cpuDao.update(cpu);
            if (is == false) {
                resp.getWriter().print("Not update. Maybe, you input wrong Id");
            }

        } else {
            cpuDao.create(cpu);
        }

    }
}
