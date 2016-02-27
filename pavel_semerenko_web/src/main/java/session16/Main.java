package session16;

import session16.service.EmployeeService;

import java.util.Locale;

/**
 * Created by Pavel on 21.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.ENGLISH);
        System.out.println(new EmployeeService().getSalaryById(1L));
    }
}
