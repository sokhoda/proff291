package session12;

import session12.dao.UserDAOImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by s_okhoda on 07.02.2016.
 */
public class Task2Main {
    public static void main(String[] args) {
    UserDAOImpl dao = new UserDAOImpl();

//        Scanner scan = new Scanner(System.in);
//        System.out.println("Введите login пользователя:");
//        String login = scan.nextLine();
//        System.out.println("Введите pass пользователя:");
//        String pass = scan.nextLine();

//        List<Object[]> users = web.dao.findUserExceptThis(login, pass);
//
//
//        for (int i = 0; i < users.size(); i++) {
//            System.out.println(Arrays.toString(users.get(i)));
//        }
        System.out.println("count = " + dao.count(27));
    }

}
