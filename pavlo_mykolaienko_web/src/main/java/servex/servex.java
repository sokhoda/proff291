package servex;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Павло on 17.01.2016.
 */
@WebServlet("/x.html")
public class servex extends HttpServlet {
    public void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {

        rs.getWriter().println("Hello servlet");
    }

}
