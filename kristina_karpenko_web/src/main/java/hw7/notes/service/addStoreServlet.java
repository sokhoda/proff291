package hw7.notes.service;

import hw7.notes.dao.*;
import hw7.notes.domain.*;
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
@WebServlet("/addStoreServlet")
public class addStoreServlet extends HttpServlet {

    private SessionFactory factory;
    private Session session;
    private MemoryDao memoryDao;
    private VendorDao vendorDao;
    private CPUDao cpuDao;
    private Vendor vendor;
    private Memory memory;
    private CPU cpu;
    private Notebook notebook;
    private NotebookDao notebookDao;
    private Store store;
    private StoreDao storeDao;
    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        notebookDao = new NotebookDaoImpl(factory);
        memoryDao = new MemoryDaoImpl(factory);
        vendorDao = new VendorDaoImpl(factory);
        cpuDao = new CPUDaoImpl(factory);
        storeDao = new StoreDaoImpl(factory);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vend = req.getParameter("vendorName");
        String modelName = req.getParameter("modelName");
        String cpuName = req.getParameter("cpuName");
        String memorySize = req.getParameter("memorySize");
        String memoryVend = req.getParameter("memoryVendor");
        Integer amount = Integer.parseInt(req.getParameter("amount"));
        Double price = Double.parseDouble(req.getParameter("price"));


        Notebook find = notebookDao.findNotebookByParam(vend, modelName, cpuName, memoryVend, memorySize);


        if (find == null) {
            vendor = vendorDao.findVendorByName(vend);
            memory = memoryDao.findMemoryByName(memoryVend, memorySize);
            cpu = cpuDao.findCPUByName(cpuName);
            //добавить если нал верхние
            notebook = new Notebook(modelName, vendor, cpu, memory);
            notebookDao.create(notebook);
            store = new Store(notebook, amount, price);
            storeDao.create(store);
            resp.getWriter().print("Notebook NULL");
        } else {
            store = new Store(find, amount, price);
            storeDao.create(store);
            resp.getWriter().print("Notebook is FIND");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        int amount = Integer.parseInt(req.getParameter("amount"));//списать
        String sale = req.getParameter("sale");

        if (sale != null) {
            req.getRequestDispatcher("/sales").forward(req, resp);
        }

            req.setAttribute("number", amount);
            if (amount < 0) {
                req.getRequestDispatcher("removeFromStore.jsp").forward(req, resp);
            } else {
                store = storeDao.read(id);
                notebookService = new NotebookServiceImpl(storeDao);
                boolean isRemove = notebookService.removeFromStore(store, amount);
                if (!isRemove) {
                    req.getRequestDispatcher("removeFromStore.jsp").forward(req, resp);
                } else {
                    req.getRequestDispatcher("successfull.jsp").forward(req, resp);
                }

        }
    }

 }


