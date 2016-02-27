package hw8.taxi.action;

import hw8.taxi.Service.OrderService;
import hw8.taxi.Service.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by Пк2 on 27.02.2016.
 */
public class OrderServlet extends HttpServlet {
    private OrderService orderService;

    @Override
    public void init(){
        this.orderService=new OrderServiceImpl();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException    {
        Map<String,String[]> parMap=req.getParameterMap();
        String choice=parMap.get("Button")[0];
        PrintWriter out =resp.getWriter();

        switch(choice){
            case "":
                break;
            case " ":
                break;
        }
    }

}
