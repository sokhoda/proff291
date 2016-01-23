package Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenchi on 22.01.16.
 */
@WebServlet("/registration")
public class FormReg extends HttpServlet {
    public String log;
    public String pass;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("UserLogin");
        String pass = request.getParameter("UserPass");

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
