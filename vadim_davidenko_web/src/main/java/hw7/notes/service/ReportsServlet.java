package hw7.notes.service;

import hw7.notes.domain.Notebook;
import hw7.notes.domain.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by v.davidenko on 16.02.2016.
 */

@WebServlet("/reportsServlet")
public class ReportsServlet  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        service(req, resp);
    }

    /*
     * Показать все ноутбуки на складе (пользователь указывает размер порции)
     * Показать все ноутбуки которых больше указанного количества
     * Показать все ноутбуки по указанному имени производителя процессора
     * Показать все ноутбуки на складе
     * Показать типы ноутбуков, оставшиеся на складе по каждому производителю
     *
     * Получить объем продаж ноутбуков в среднем за день (в штуках)
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("reportMenu")[0];
        List<Notebook> reportList = null;

        switch (option) {
            case "byPortion":
                Integer portion = Integer.parseInt(parameterMap.get("portion")[0]);




                break;

            case "gtAmount":
                Integer gtAmount = Integer.parseInt(parameterMap.get("gtAmount")[0]);
                reportList = Menu.noteService.getNotebooksGtAmount(gtAmount);
                req.setAttribute("reportList", reportList);
                break;

            case "byCPU":
                Long vendorId = Long.valueOf(parameterMap.get("cpuVendor")[0]);
                Vendor vendor = Menu.noteService.getVendorById(vendorId);
                reportList = Menu.noteService.getNotebooksByCpuVendor(vendor);
                req.setAttribute("reportList", reportList);
                break;

            case "storeAll":
                reportList = Menu.noteService.getNotebooksFromStore();
                req.setAttribute("reportList", reportList);
                break;

            case "storePresent":
                reportList = Menu.noteService.getNotebooksStorePresent();
                req.setAttribute("reportList", reportList);
                break;

            case "salesByDays":

                break;
        }
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for(Map.Entry<String, String[]> entry : entries) {
            req.setAttribute(entry.getKey(), entry.getValue()[0]);
        }
        List<Vendor> vendorList = Menu.noteService.getAllVendors();
        req.setAttribute("vendorList", vendorList);
        req.getRequestDispatcher(Menu.REPORTS_LIST_PAGE).forward(req, resp);
    }

}
