package Controller_old;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Roman on 17.01.2016.
 */
public class Servlet extends HttpServlet{
    public String login;
    public String pass;
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String loginloc =req.getParameter("Login");
        String passloc = req.getParameter("Pass");
        if(login.equals(loginloc)&&pass.equals(passloc)){
            resp.getWriter().print("Your name is " + login);

        }else
            resp.getWriter().print("Your name is unknown " + login);
       // Map<String,String[]> parameterMap = req.getParameterMap();
        //String login1 = parameterMap.get("login")[0];

    }

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().print("Hello servlet");
    }
    public void init(){
        login= "lida";
        pass= "123";
    }
}
