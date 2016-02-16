package hw7.notes.service;

import hw7.notes.domain.Vendor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by v.davidenko on 15.02.2016.
 */

@WebServlet("/vendorServlet")
public class VendorServlet extends HttpServlet {

    final static String VENDOR_PAGE = "hw7/entity/vendor.jsp";
    final static String UPDATE_SUCCESS_MSG = "Data updated successfully";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        service(req, resp);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();
        String id = parameterMap.get("entityId")[0];
        String vendorName = parameterMap.get("vendor")[0].trim();

        Vendor vendor = new Vendor();
        vendor.setId(Long.valueOf(id));
        vendor.setName(vendorName);

        if (Menu.noteService.updateVendor(vendor)) {
            req.setAttribute("server_msg", UPDATE_SUCCESS_MSG);
        }
        req.setAttribute("entityId", id);
        req.setAttribute("vendor", vendorName);
        req.getRequestDispatcher(VENDOR_PAGE).forward(req, resp);
    }
}
