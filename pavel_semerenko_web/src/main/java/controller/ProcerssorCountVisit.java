package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Pavel on 17.01.2016.
 */
@WebServlet("/counter")
public class ProcerssorCountVisit extends HttpServlet{
    static int countVisit;

    @Override
    public void init() throws ServletException {
        countVisit = 1;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        countVisit ++;
        req.getRequestDispatcher("counter.jsp").forward(req, resp);
    }

    public static int getCountVisit(){
        return countVisit;
    }
}
