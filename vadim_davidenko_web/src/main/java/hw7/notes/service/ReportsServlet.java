package hw7.notes.service;

import hw7.notes.domain.Notebook;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by v.davidenko on 16.02.2016.
 */

@WebServlet("/reportsServlet")
public class ReportsServlet  extends HttpServlet {

    private static Integer nextPos = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

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
     * Получить объем продаж ноутбуков в среднем за день (в штуках)
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String option = parameterMap.get("reportMenu")[0];

        switch (option) {
            case "byPortion":
                Integer portion = Integer.parseInt(parameterMap.get("portion")[0]);
                List<Notebook> reportList = Menu.noteService.getAllNotebooks();
                req.setAttribute("reportList", reportList);




                break;

            case "gtAmount":
                Integer gtAmount = Integer.parseInt(parameterMap.get("gtAmount")[0]);


                break;

            case "byCPU":
                String cpuVendor = parameterMap.get("cpuVendor")[0];


                break;

            case "storeAll":


                break;

            case "storePresent":


                break;

            case "salesByDays":

                break;
        }
        req.getRequestDispatcher(Menu.REPORTS_LIST_PAGE).forward(req, resp);
    }

}
