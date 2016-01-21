package session6HomeTask;

import jdk.internal.util.xml.impl.Pair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by i.gonchar on 1/18/2016.
 */

@WebServlet("/registerForm")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        String rePassword = parameterMap.get("rePassword")[0];

        if (!password.isEmpty() && !rePassword.isEmpty()) {
            if (!password.equals(rePassword)) {
                response.getWriter().println("Password is not the Same!");
            } else {
                RegisterBase.setUserMap(login, password);
                response.getWriter().println("You have been registered");
            }
        }

        String pageAddress = "/registerPage.jsp";
        //Map <String, String> allUSers = RegisterBase.getUserMap();
        //response.getWriter().println(RegisterBase.showUserMap());
        request.setAttribute("test_m", "I am testsing it");
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }
}
