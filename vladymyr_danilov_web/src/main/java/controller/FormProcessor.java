package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/formPrev")
public class FormProcessor extends HttpServlet {
    private Map<String, String> users;

    @Override
    public void init() {
        users = new HashMap<>();
        users.put("Vanya", "1");
        users.put("Vasya", "2");
        users.put("Vova", "3");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        Map<String, String>
    }

}
