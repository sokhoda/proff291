package web.service;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.spi.http.HttpExchange;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Юра on 21.01.2016.
 */
@WebServlet("/russExpl")
public class ServletRuss extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
//        resp.setContentType("text/html;charset=utf-8");
        resp.setContentType("text/html;charset=windows-1251");
        printWriter.print("Хеллоу Ворлд!!");
        printWriter.print("<H1>Хеллоу Ворлд!!</H1>");

    }
    static public String encode(String src, String defpage ,String codepage)
    {
        String answer="";
        try
        {answer= new String(src.getBytes(defpage), codepage);}
//тут бывают ошибки если указаной кодировки не существует
        catch (Throwable e){answer=src;}
        return answer;
    }
}
