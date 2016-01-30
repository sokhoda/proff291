package controller;

import models.Phones;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pavel on 26.01.2016.
 */
@WebServlet("/phones.html")
public class PhoneAccounts extends HttpServlet {
    List<Phones> accounts;

    @Override
    public void init() throws ServletException {
        accounts = new ArrayList<>();
        accounts.add(new Phones("+380938945694", 9));
        accounts.add(new Phones("+380993409853", 1));
        accounts.add(new Phones("+380662345523", 10));
        accounts.add(new Phones("+380503498923", 54));
        accounts.add(new Phones("+380632938493", 41));
        accounts.add(new Phones("+380969259993", 14));
        accounts.add(new Phones("+380977837382", 123));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123);
        request.setAttribute("accounts", this.accounts);
    }
}
