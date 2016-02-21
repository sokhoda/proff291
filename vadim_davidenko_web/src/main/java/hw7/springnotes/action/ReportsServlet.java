package hw7.springnotes.action;

import hw7.springnotes.domain.Notebook;
import hw7.springnotes.domain.Store;
import hw7.springnotes.domain.Vendor;
import hw7.springnotes.service.Menu;
import hw7.springnotes.service.NotebookService;
import hw7.springnotes.util.SpringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by v.davidenko on 16.02.2016.
 */

@WebServlet("/reportsServlet")
public class ReportsServlet  extends HttpServlet {

    private NotebookService noteService;

    @Override
    public void init() throws ServletException {
        noteService = SpringUtils.createNotebookService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        service(req, resp);
    }
    
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("reportMenu")[0];

        switch (option) {
            case "byPortion":
                Integer portion = Integer.parseInt(parameterMap.get("portion")[0]);
                List<Notebook> noteList = noteService.getNotebooksByPortion(0, portion);
                req.setAttribute("noteList", noteList);
                req.setAttribute("page", "0");
                break;

            case "byCPU":
                Long vendorId = Long.valueOf(parameterMap.get("cpuVendor")[0]);
                Vendor vendor = noteService.getVendorById(vendorId);
                noteList = noteService.getNotebooksByCpuVendor(vendor);
                req.setAttribute("noteList", noteList);
                break;

            case "storeAll":
                noteList = noteService.getNotebooksFromStore();
                req.setAttribute("noteList", noteList);
                break;

            case "gtAmount":
                Integer amount = Integer.parseInt(parameterMap.get("gtAmount")[0]);
                noteList = noteService.getNotebooksGtAmount(amount);
                req.setAttribute("noteList", noteList);
                break;

            case "storePresent":
                List<Store> storeList = noteService.getNotebooksStorePresent();
                req.setAttribute("storeList", storeList);
                break;

            case "salesByDays":
                Map<Date, Integer> salesMap = noteService.getSalesByDays();
                req.setAttribute("salesMap", salesMap);
                break;
        }
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        List<Vendor> vendorList = noteService.getAllVendors();
        req.setAttribute("vendorList", vendorList);
        req.getRequestDispatcher(Menu.REPORTS_LIST_PAGE).forward(req, resp);
    }

}
