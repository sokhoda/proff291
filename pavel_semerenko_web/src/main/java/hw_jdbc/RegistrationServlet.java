package hw_jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Pavel on 31.01.2016.
 */
@WebServlet("/regJForm")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Map<String, String[]> parameterMap = req.getParameterMap();

        String fname = parameterMap.get("first_name")[0].trim();
        String lname = parameterMap.get("last_name")[0].trim();
        String pass = parameterMap.get("password")[0].trim();

        JDBC_connection_manager JDBCcm = new JDBC_connection_manager();
        JDBCcm.execSQL("INSERT INTO USERS(id, first_name, last_name, password) " +
                "VALUES(USERS_SEQ.nextval,'"+fname+"','"+lname+"','"+pass+"')");

        ResultSet rs = JDBCcm.execQuery("SELECT * FROM USERS");

        ArrayList<Users_DAO> users = new ArrayList<>();
        try {
            while (rs.next()){
                Users_DAO users_dao = new Users_DAO(rs.getLong("id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("password"));
                users.add(users_dao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JDBCcm.closeConnection();

        req.setAttribute("users", users);
        req.getRequestDispatcher("regJUsers.jsp").forward(req, resp);
    }
}