//package hw5.users;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Юлия on 05.02.2016.
// */
//@WebServlet("/list")
//public class MainWindow extends HttpServlet {
//    UserJDBCManager manager = new UserJDBCManager();
//    List<User> list = new ArrayList<>();
//
//    static {
//        try {
//            Class.forName("oracle.jdbc.OracleDriver");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        try {
//            String password = req.getParameter("password").trim();
//            String login = req.getParameter("login").trim();
//            String page = "/index";
//            String message = "";
//            if (login.length() == 0 || password.length() == 0) {
//
//                message = " Your login or password should be not less than 1 letter";
//            } else {
//                req.getRequestDispatcher("/UserList").forward(req, resp);
//                page = "/UserList";
//            }
//
//            manager.create(new User(login, password));
//            req.getRequestDispatcher("/createUser").forward(req, resp);
//            req.setAttribute("message", message);
//
//        } catch (Exception e) {
//
//        }
////        if (req.getParameter("showAllUsers") != null) {
////            try{
////                list = manager.findAll();
////                req.setAttribute("list",  list);
////                req.getRequestDispatcher("/list").forward(req, resp);
////            }catch (Exception e){
////
////            }
////        }
//
//
//    }
//
//}
