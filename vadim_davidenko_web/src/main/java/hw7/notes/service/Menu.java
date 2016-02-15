package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.CPU;
import hw7.notes.domain.Memory;
import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;
import hw7.notes.util.HibernateUtil;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by Вадим on 14.02.2016.
 */

@WebServlet("/menuServlet")
public class Menu extends HttpServlet {
    NotebookService noteService;

    @Override
    public void init() throws ServletException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        NotebookDao notebookDao = new NotebookDaoImpl(sessionFactory);
        VendorDao vendorDao = new VendorDaoImpl(sessionFactory);
        CPUDao cpuDao = new CPUDaoImpl(sessionFactory);
        MemoryDao memoryDao = new MemoryDaoImpl(sessionFactory);
        StoreDao storeDao = new StoreDaoImpl(sessionFactory);
        SalesDao salesDao = new SalesDaoImpl(sessionFactory);

        noteService = new NotebookServiceImpl(notebookDao, vendorDao, cpuDao, memoryDao, storeDao, salesDao);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        main(req, resp);
    }

    public void main(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String menuOption = parameterMap.get("menuOption")[0];
        switch (menuOption) {
            case "entity":
                entityService(req, resp);
                break;
            case "receive":
                receiveService(req, resp);
                break;
            case "remove":
                removeService(req, resp);
                break;
            case "sale":
                salesService(req, resp);
                break;
            case "report":
                reportService(req, resp);
                break;
        }
    }

    public void entityService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("entityMenu")[0];
        Long id = (parameterMap.get("id")[0].isEmpty()) ? 0L : Long.valueOf(parameterMap.get("id")[0]);
        String targetPage = "";

        switch (option) {
            case "notebook":
                Notebook notebook = noteService.getNotebookById(id);
                req.setAttribute("model", (notebook != null) ? notebook.getModel() : "");
                req.setAttribute("date", (notebook != null) ? notebook.getManufactureDateStr() : "");

                req.setAttribute("vendorId", (notebook != null) ? String.valueOf(notebook.getVendor().getId()) : "");
                List<Vendor> vendorList = noteService.getAllVendors();
                req.setAttribute("vendorList", vendorList);

                req.setAttribute("cpuId", (notebook != null) ? String.valueOf(notebook.getCpu().getId()) : "");
                List<CPU> cpuList = noteService.getAllCPUs();
                req.setAttribute("cpuList", cpuList);

                req.setAttribute("memoryId", (notebook != null) ? String.valueOf(notebook.getMemory().getId()) : "");
                List<Memory> memoryList = noteService.getAllMemories();
                req.setAttribute("memoryList", memoryList);

                targetPage = "hw7/notebook.jsp";
                break;

            case "vendor":
                Vendor vendor = noteService.getVendorById(id);
                req.setAttribute("vendor", (vendor != null) ? vendor.getName() : "");
                targetPage = "hw7/vendor.jsp";
                break;

            case "cpu":
                CPU cpu = noteService.getCPUById(id);
                req.setAttribute("model", (cpu != null) ? cpu.getModel() : "");
                req.setAttribute("vendor", (cpu != null) ? cpu.getVendor() : "");
                req.setAttribute("frequency", (cpu != null) ? cpu.getFrequency() : "");
                targetPage = "hw7/cpu.jsp";
                break;

            case "memory":
                Memory memory = noteService.getMemoryById(id);
                req.setAttribute("vendor", (memory != null) ? memory.getVendor() : "");
                req.setAttribute("size", (memory != null) ? memory.getSize() : "");
                targetPage = "hw7/memory.jsp";
                break;
        }
        if (!targetPage.isEmpty()) {
            req.getRequestDispatcher(targetPage).forward(req, resp);
        }
    }

    public void receiveService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        // to add code here
    }

    public void removeService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        // to add code here
    }

    public void salesService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        // to add code here
    }

    public void reportService(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("reportMenu")[0];
        // to add code here
    }
}
