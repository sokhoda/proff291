package session6HomeTask;

import jdk.internal.util.xml.impl.Pair;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by i.gonchar on 1/18/2016.
 */

@WebServlet("/registerForm")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println(RegisterBase.showUserMap());

       /* byte[] imageBytes = extractBytes("D:/karl.jpg");
        response.setContentType("image/jpeg");
        response.setContentLength(imageBytes.length);
        response.getOutputStream().write(imageBytes);*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        String login = parameterMap.get("login")[0];
        String password = parameterMap.get("password")[0];
        String rePassword = parameterMap.get("rePassword")[0];

        String pageAddress = "/registerPage.jsp";
        String message = loginFormValidation(login, password, rePassword);

        if (message.equals("You have been registered")) {
            RegisterBase.setUserMap(login, password);
        }


        request.setAttribute("reg_result", message);
        request.getRequestDispatcher(pageAddress).forward(request, response);
    }


    private String loginFormValidation(String login, String password, String rePassword) {
        String message = "";

        if (login.isEmpty() && password.isEmpty() && rePassword.isEmpty()) {
            message = "Please fill all the fields";
        } else if (login.isEmpty() && password.isEmpty()) {
            message = "Login and Password fields are empty";
        } else if (login.isEmpty()) {
            message = "Login field is empty";
        } else if (password.isEmpty()) {
            message = "Password field is empty!";
        } else if (rePassword.isEmpty()) {
            message = "Re-enter the password!";
        } else if (!password.equals(rePassword)) {
            message = "Password does not match!";
        } else {
            boolean temp = passwordValidation(password);
            if(!temp){
                message = "Please view password requirements";
            }
            else {
                message = "You have been registered";
            }

        }

        return message;
    }

    /*protected void imagePost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        byte[] imageBytes = extractBytes("D:\\karl.jpg");

        response.setContentType("image/jpeg");
        response.setContentLength(imageBytes.length);

        response.getOutputStream().write(imageBytes);
    }

    public byte[] extractBytes(String ImageName) throws IOException {
        // open image
        File imgPath = new File(ImageName);
        BufferedImage bufferedImage = ImageIO.read(imgPath);

        // get DataBufferBytes from Raster
        WritableRaster raster = bufferedImage.getRaster();
        DataBufferByte data = (DataBufferByte) raster.getDataBuffer();

        return (data.getData());
    }*/

    private static boolean passwordValidation(String password) {
        Pattern p = Pattern.compile("[A-Z][a-z]+[0-9]");
        Matcher m = p.matcher(password);
        return m.matches();
    }
}
