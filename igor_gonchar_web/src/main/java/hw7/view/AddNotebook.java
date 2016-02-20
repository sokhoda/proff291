package hw7.view;

import hw7.domain.CPU;
import hw7.domain.Memory;
import hw7.domain.Notebook;
import hw7.domain.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * Created by i.gonchar on 2/17/2016.
 */
@WebServlet("/addNotebook")
public class AddNotebook extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();

        Long vendorId = Long.valueOf(parameterMap.get("vendorId")[0]);
        Vendor vendor = Main.notebookService.getVendorById(vendorId);

        Long cpuId = Long.valueOf(parameterMap.get("cpuId")[0]);
        CPU cpu = Main.notebookService.getCPUById(cpuId);

        Long memoryId = Long.valueOf(parameterMap.get("memoryId")[0]);
        Memory memory = Main.notebookService.getMemoryById(memoryId);

        String model = parameterMap.get("model")[0];

        String dateS = parameterMap.get("manufactureDate")[0];
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = null;
        try {
            date = sdf.parse(dateS);
        } catch (ParseException e) {
            System.out.println("Could not parse the date");
        }

        Notebook notebook = new Notebook(vendor, model, date, cpu, memory);
        Main.notebookService.createNotebok(notebook);

        request.setAttribute("reg_result", "Notebook was added");
        request.getRequestDispatcher("/hw7/addNotebook.jsp").forward(request, resp);

  /*      List<Vendor> vendorList = Main.notebookService.getAllVendors();
        request.setAttribute("vendorList", vendorList);
        request.getRequestDispatcher("/hw7/addNotebook.jsp").forward(request, resp);*/

    }
}