package hw7.notes.service;

import hw7.notes.dao.SalesDao;
import hw7.notes.dao.SalesDaoImpl;
import hw7.notes.dao.StoreDao;
import hw7.notes.dao.StoreDaoImpl;
import hw7.notes.domain.Sales;
import hw7.notes.domain.Store;
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
 * Created by Администратор on 19.02.2016.
 */
@WebServlet("/sales")
public class SalesServlet extends HttpServlet {
    private SessionFactory factory;
    private Session session = null;
    private StoreDao storeDao;
    private SalesDao salesDao;
    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        factory = HibernateUtil.getSessionFactory();
        session = factory.openSession();
        storeDao = new StoreDaoImpl(factory);
        salesDao = new SalesDaoImpl(factory);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        int amount = Integer.parseInt(req.getParameter("amount"));




        if (amount < 0) {
            req.getRequestDispatcher("sales.jsp").forward(req, resp);
        } else {
            Store store = storeDao.read(id);
            Sales sales = new Sales(store, amount);
            notebookService = new NotebookServiceImpl(storeDao);
            boolean isRemove = notebookService.removeFromStore(store, amount);
            if (!isRemove) {
                req.getRequestDispatcher("sales.jsp").forward(req, resp);
            } else {
                salesDao.create(sales);
                req.getRequestDispatcher("successfull.jsp").forward(req, resp);
            }
        }
    }
}
