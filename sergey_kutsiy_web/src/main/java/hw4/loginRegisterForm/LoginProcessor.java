package hw4.loginRegisterForm;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by skuciy on 21.01.2016.
 */
@WebServlet ("/logon")
public class LoginProcessor extends HttpServlet {
    public ArrayList<User> users = new ArrayList<>();
    @Override

    public void init () {
        users.add(new User("Ivanov", "password"));
        users.add(new User("Petrov", "password"));
    }

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String login = req.getParameter("login");
        String password = req.getParameter("password");

        boolean isAuthenticated=false;
        boolean isUserExist=false;
        boolean wrongPassword=false;

        for (User usr : users) {
            if (login.equals(usr.getLogin()) && password.equals(usr.getPassword())) {
                isAuthenticated=true;
            } else if (login.equals(usr.getLogin()) && !password.equals(usr.getPassword())) {
                wrongPassword=true;
            }

            if (login.equals(usr.getLogin())) {
                isUserExist=true;
            }
        }

        if (isAuthenticated) {
            resp.getWriter().print("Your name " + login );
            //передаем управление
        }

        if (!isUserExist) {
            resp.getWriter().print("User not register");
        }

        if (wrongPassword) {
            resp.getWriter().print("Incorrect password");
        }
    }


    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.getWriter().print("doGetForm");
    }


}
