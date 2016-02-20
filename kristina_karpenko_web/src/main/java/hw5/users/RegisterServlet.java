package hw5.users;

import scala.Int;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{
    static {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        java.sql.Date sqlDate = new java.sql.Date(new java.util.Date().getTime());
        try{
        UserJDBCManager manager = new UserJDBCManager();
        manager.create(new User(id,login,password,new Date(116,01,03)));

        resp.getWriter().print("Sucs");}catch (Exception e ){e.printStackTrace();}
    }
}
