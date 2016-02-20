package hw7.view;

import hw7.domain.CPU;
import hw7.domain.Memory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by i.gonchar on 2/16/2016.
 */
@WebServlet("/addMemory")
public class AddMemory extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String vendorName = parameterMap.get("vendorName")[0];
        String sizeS = parameterMap.get("size")[0];
        int size = Integer.parseInt(sizeS);

        Memory memory = new Memory (vendorName, size);
        Main.notebookService.createMemory(memory);
    }
}