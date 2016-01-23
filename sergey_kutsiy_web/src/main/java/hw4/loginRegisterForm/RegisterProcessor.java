package hw4.loginRegisterForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by skuciy on 21.01.2016.
 */
@WebServlet("/register")
public class  RegisterProcessor extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException{
        String userName = req.getParameter("name");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        String mail = req.getParameter("mail");

    }

}
