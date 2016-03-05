package LUs;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Павло on 17.01.2016.
 */


@WebServlet("/LUs.html")
public class LUs extends HttpServlet {
    public LUsM m;
    public boolean b = false;

    public void init() {
        m = new LUsM();
    }

    public void doGet(HttpServletRequest sq, HttpServletResponse sp) throws IOException {
        sp.setContentType("text/html");
        sp.setCharacterEncoding("utf-8");
        PrintWriter out = sp.getWriter();
        out.print("<html>");
        out.print("<form method=\"GET\"" + " \"action=\"/LUs.html\">");
        out.print("<HEAD> <TITLE>");
        out.print("Авторизація");
        out.print("</TITLE></HEAD><BODY>");
        out.print("Введіть логін та пароль" + "<br/>" + "<p></p>");
        out.print("<input type=\"text\" name=\"login\"/>" + "<br/>" + "<p></p>");
        out.print("<input type=\"text\" name=\"password\"/>" + "<br/>" + "<p></p>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Війти\"/>" + "<br/>" + "<p></p>");


        String l = sq.getParameter("login");
        String p = sq.getParameter("password");


        if (m.verify(l, p)) {
            out.print("Ви пройшли авторизацію" + "<br/>" + "<p></p>");
        } else {
            out.print("Не вірний логін чи пароль" + "<br/>" + "<p></p>");
        }

        out.print("<a href=\"http://localhost:8082/LUr.html\">Перейти на сторінку реєстрації</a>" + "<br/>" + "<p></p>");
        out.print("</BODY>");
        out.print("</form>");
        out.print("</html>");
        out.close();


    }
}