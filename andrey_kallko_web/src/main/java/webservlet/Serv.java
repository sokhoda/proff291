package webservlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by tri___ton on 17.01.16.
 */

@WebServlet("/x.html")

public class Serv extends HttpServlet {



    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws IOException {

        resp.getWriter().println("Hello from servlet!!!");
    }



}

