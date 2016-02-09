package controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Юлия on 17.01.2016.
 */
@WebServlet("/form")
public class FormProcessor extends HttpServlet {
//    private Map<String,String[]> hw5.users=new HashMap<String, String[]>();
private Map<String, String> users=new HashMap<>();
    @Override
    public void init() throws ServletException {
//
//        String[] names= new String[1];
//        String[] logins= new String[1];
//        names[0]="Sveta";
//        logins[0]="1234";
//        hw5.users.put( "name",names);
//        hw5.users.put("login", logins);
        users.put("Sveta","1234");
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        Map<String, String[]> parameterMap = req.getParameterMap();
//        String login = parameterMap.get("login")[0];//0-первій элемент массива в виде 0
//        String password = parameterMap.get("password")[0];//0-первій элемент массива в виде 0
//        resp.getWriter().print("Your login is  " + login);

        String login = req.getParameter("login");
        String password  = req.getParameter("password");
        if(users.containsKey(login)&& users.get(login).equals(password)){
            resp.getWriter().print("In"+login);
        }
        else{
            resp.getWriter().print("Out"+login);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }


}
