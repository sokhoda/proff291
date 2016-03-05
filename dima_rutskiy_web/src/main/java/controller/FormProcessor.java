package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Rrr on 17.01.2016.
 */
@WebServlet("/sform.html")
public class FormProcessor extends HttpServlet {
    @Override
    public void init() throws ServletException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        //String login= req.getParameter("login");

        Map<String,String[]> parametrMap=req.getParameterMap();
        String login =parametrMap.get("login")[0];
        //response.getWriter().print()
    }
}
