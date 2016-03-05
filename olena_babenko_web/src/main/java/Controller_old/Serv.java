package Controller_old;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenchi on 17.01.16.
 */
@WebServlet("/x.html")
public class Serv extends HttpServlet {
    //у сервлета должна быть привязка к адресу, чтобы метод работал
    //Это делается путем Аннотации и присвоения сервлету символического имени
    //пользователь не должен знать название сервлета Serv class, только символическое его название
    // @WebServlet("/x.html") - вот эта строка записывается до класса

    //строчка будет иметь вид http:/localhost:8083/x.html

    //в будущем: будет Контроллер, в котором будем прописывать методы, которые будут вызывать сервлет.

    //чтобы запустить и посомтреть, как работает этот сервлет: запусти Tomcat, перейди в браузере
    //по адресу http://localhost:8083/x.html

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //берем из респонса поток, закладываем туда инфу
        response.getWriter().println("Hello, servlet!");
    }
}