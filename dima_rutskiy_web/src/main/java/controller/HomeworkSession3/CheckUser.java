package controller.HomeworkSession3;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Rrr on 22.01.2016.
 */
public class CheckUser extends HttpServlet {
    //public String getServletInfo(){
        //return "Registration servlet";
   // }
    private static String fileName = "C://a.txt";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Map<String, String[]> parameterMap = req.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];

          String usersList=WorkWithFile.read(fileName);
        Map<String, String> m=WorkWithFile.stringToMap(usersList);
        if (m.containsKey(login) && m.get(login).equals(password)) {
            RequestDispatcher dispatcher=req.getRequestDispatcher("\\HomeworkSession3\\successLogin.jsp");
            dispatcher.forward(req,resp);
            //resp.getWriter().println("Hello " + login);
        } else {
            RequestDispatcher dispatcher=req.getRequestDispatcher("\\HomeworkSession3\\successLogin.jsp");
            dispatcher.forward(req,resp);
            //resp.getWriter().println("Buy " + login);
        }



    }




        /* User user = UserList.findUser(request.getParameter("user"));
        if (user == null){
            this.forward("/registration.html", request, response);
        } else {
            if
                    (!user.getPassword().equals(request.getParameter("password"))){
                this.forward("/registration.html", request, response);
            } else {
                this.forward("/successLogin.jsp", request, response);
            }
        }
    }

}*/}
