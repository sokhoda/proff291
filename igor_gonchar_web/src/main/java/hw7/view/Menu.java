package hw7.view;

import hw7.dao.*;
import hw7.domain.*;
import hw7.service.NotebookService;
import hw7.service.NotebookServiceImpl;
import hw7.util.HiberSessionFactory;
import hw7.util.StartupListener;
import org.hibernate.SessionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by i.gonchar on 2/15/2016.
 */
@WebServlet("/notebooksAdvancedForm")
public class Menu extends HttpServlet {

    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        notebookService = StartupListener.getBean("notebookService", NotebookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String add = request.getParameter("addButton");
        String show = request.getParameter("showButton");
        String edit = request.getParameter("editButton");

        String option = request.getParameter("addOption");
        String message = "Operation was done successfully";
        String pageAddress = "/hw7/notesAdvanced.jsp";


        if (add != null) {
            switch (option) {
                case "cpu":

                    pageAddress = "/hw7/addCPU.jsp";
                    message = "Add cpu";
                    break;
                case "memory":
                    pageAddress = "/hw7/addMemory.jsp";
                    message = "Add memory";
                    break;
                case "vendor":
                    pageAddress = "/hw7/addVendor.jsp";
                    message = "Add vendor";
                    break;
                case "notebook":
                    pageAddress = "/hw7/addNotebook.jsp";
                    message = "Add notebook";

                    List<Vendor> vendorList = notebookService.getAllVendors();
                    request.setAttribute("vendorList", vendorList);

                    List<CPU> cpuList = notebookService.getAllCPUs();
                    request.setAttribute("cpuList", cpuList);

                    List<Memory> memoryList = notebookService.getAllMemories();
                    request.setAttribute("memoryList", memoryList);

                    request.getRequestDispatcher("/hw7/addNotebook.jsp").forward(request, response);
                    break;
                case "store":
                    List<Notebook> notebookList = notebookService.getAllNotebooks();
                    request.setAttribute("notebookList", notebookList);

                    request.getRequestDispatcher("/hw7/addStore.jsp").forward(request, response);

                    break;
                default:
                    break;
            }
        } else if (show != null) {
            switch (option) {
                case "cpu":
                    List<CPU> list = notebookService.getAllCPUs();
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < list.size(); i++) {
                        sb.append(list.get(i).toString());
                        sb.append("<br/>");
                    }
                    message = sb.toString();
                    break;
                case "memory":
                    List<Memory> list2 = notebookService.getAllMemories();
                    StringBuilder sb2 = new StringBuilder();
                    for (int i = 0; i < list2.size(); i++) {
                        sb2.append(list2.get(i).toString());
                        sb2.append("<br/>");
                    }
                    message = sb2.toString();
                    break;
                case "vendor":
                    List<Vendor> list3 = notebookService.getAllVendors();
                    StringBuilder sb3 = new StringBuilder();
                    for (int i = 0; i < list3.size(); i++) {
                        sb3.append(list3.get(i).toString());
                        sb3.append("<br/>");
                    }
                    message = sb3.toString();
                    break;
                case "notebook":
                    List<Notebook> list4 = notebookService.getAllNotebooks();
                    StringBuilder sb4 = new StringBuilder();
                    for (int i = 0; i < list4.size(); i++) {
                        sb4.append(list4.get(i).toString());
                        sb4.append("<br/>");
                    }
                    message = sb4.toString();
                    break;
                case "store":
                    List<Store> list5 = notebookService.getAllNotebooks();
                    StringBuilder sb5 = new StringBuilder();
                    for (int i = 0; i < list5.size(); i++) {
                        sb5.append(list5.get(i).toString());
                        sb5.append("<br/>");
                    }
                    message = sb5.toString();
                    break;
                default:
                    break;
            }
        } else {
            switch (option) {
                case "cpu":
                    List<CPU> cpuList = notebookService.getAllCPUs();
                    request.setAttribute("cpuList", cpuList);

                    pageAddress = "/hw7/editCPU.jsp";
                    message = "editCPU";
                    break;
                case "memory":
                    List<Memory> memoryList = notebookService.getAllMemories();
                    request.setAttribute("memoryList", memoryList);

                    pageAddress = "/hw7/editMemory.jsp";
                    message = "editMemory";
                    break;
                case "vendor":
                    List<Vendor> vendorList = notebookService.getAllVendors();
                    request.setAttribute("vendorList", vendorList);

                    pageAddress = "/hw7/editVendor.jsp";
                    message = "editVendor";
                    break;
                case "notebook":
                    List<Notebook> notebookList = notebookService.getAllNotebooks();
                    request.setAttribute("notebookList", notebookList);

                    pageAddress = "/hw7/editNotebook.jsp";
                    message = "editNotebook";
                    break;
                case "store":
                    List<Store> storeList = notebookService.getAllStores();
                    request.setAttribute("storeList", storeList);

                    pageAddress = "/hw7/editStore.jsp";
                    message = "editStore";
                    break;
                default:
                    break;
            }
        }
        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, response);

    }
}
