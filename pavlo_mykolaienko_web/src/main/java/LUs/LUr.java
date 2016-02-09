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


@WebServlet("/LUr.html")
public class LUr extends HttpServlet {

    public boolean b = false;


    public void doGet(HttpServletRequest sq, HttpServletResponse sp) throws IOException {
        sp.setContentType("text/html");
        sp.setCharacterEncoding("utf-8");
        PrintWriter out = sp.getWriter();
        out.print("<html>");
        out.print("<form method=\"GET\"" + " \"action=\"/LUr.html\">");
        out.print("<HEAD> <TITLE>");
        out.print("Реєстрація користувача");
        out.print("</TITLE></HEAD><BODY>");
        out.print("Введіть логін, пароль, повторно пароль" + "<br/>" + "<p></p>");
        out.print("<input type=\"text\" name=\"login\"/>" + "<br/>" + "<p></p>");
        out.print("<input type=\"text\" name=\"password\"/>" + "<br/>" + "<p></p>");
        out.print("<input type=\"text\" name=\"passwordp\"/>" + "<br/>" + "<p></p>");
        out.print("<input type=\"submit\" name=\"submit\"  value=\"Зареєструватися\"/>" + "<br/>" + "<p></p>");


        String l = sq.getParameter("login");
        String p = sq.getParameter("password");
        String p1 = sq.getParameter("passwordp");
        if (p.equals(p1)) {

            if (LUsM.add(l, p)) {
                out.print("Ви пройшли реєстрацію" + "<br/>" + "<p></p>");

            } else {
                out.print("Користувач з таким логіном вже зареєстрований" + "<br/>" + "<p></p>");
            }
        } else {
            out.print("Паролі не співпадають" + "<br/>" + "<p></p>");

        }
        out.print("<a href=\"http://localhost:8080/LUs.html\">Перейти на сторінку авторизації</a>" + "<br/>" + "<p></p>");
        out.print("</BODY>");
        out.print("</form>");
        out.print("</html>");
        out.close();


    }
}