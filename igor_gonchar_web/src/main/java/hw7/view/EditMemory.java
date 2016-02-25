package hw7.view;

import hw7.domain.Memory;
import hw7.domain.Vendor;
import hw7.service.NotebookService;
import hw7.util.StartupListener;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 2/24/2016.
 */
@WebServlet("/editMemory")
public class EditMemory extends HttpServlet {
    private NotebookService notebookService;

    @Override
    public void init() throws ServletException {
        notebookService = StartupListener.getBean("notebookService", NotebookService.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String edit = request.getParameter("editButton");

        Long memoryId = Long.valueOf(parameterMap.get("memoryId")[0]);
        Memory memory = notebookService.getMemoryById(memoryId);

        String message = "";

        if (edit != null) {
            String vendor = parameterMap.get("vendor")[0];
            String sizeS = parameterMap.get("size")[0];
            int size = Integer.parseInt(sizeS);

            memory.setVendor(vendor);
            memory.setSize(size);
            notebookService.updateMemory(memory);

            List<Memory> memoryList = notebookService.getAllMemories();
            request.setAttribute("memoryList", memoryList);
            message = "Memory was edited";
        } else {
            notebookService.removeMemory(memory);

            List<Memory> memoryList = notebookService.getAllMemories();
            request.setAttribute("memoryList", memoryList);

            message = "Memory was deleted";
        }

        String pageAddress = "/hw7/editMemory.jsp";
        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, resp);
    }
}