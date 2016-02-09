package Count;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Павло on 21.01.2016.
 */
@WebServlet("/c.html")
public class Count extends HttpServlet {
    int i = 0;

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        res.getWriter().println("count " + ++i);

    }

}
