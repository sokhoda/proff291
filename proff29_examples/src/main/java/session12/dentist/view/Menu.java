package session12.dentist.view;

import session12.dentist.domain.Client;
import session12.dentist.service.ClientService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: al1
 * Date: 4/7/13
 */
public class Menu {
    private static final int SHOW_ALL_USERS_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NEW_USER_ITEM = 2;

    private ClientService userService;
    private Scanner scan;

    public Menu(ClientService userService) {
        this();
        this.userService = userService;
    }

    public Menu() {
        scan = new Scanner(System.in);
        //userService = new ClientServiceImpl(new ClientHibernateDaoImpl());
    }

    public void main() {
        int choise = EXIT_ITEM;

        do {
            showMenu();
            choise = getInput();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_USERS_ITEM:
                    showAllUsers();
                    break;
                case ADD_NEW_USER_ITEM:
                    addNewUser();

            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllUsers() {
        for (Client user : userService.getAllUsers()) {
            System.out.println(user);
        }
    }

    private void addNewUser() {
        System.out.println("Input name");
        String name = scan.nextLine();
        System.out.println("Input surname");
        String surname = scan.nextLine();
        int age = scanIntWithRetry("Input age");
        Date date = scanDateWithRetry("Input date");
        double sum = scanDoubleWithRetry("Input summa");
        Client user = new Client(name, surname, age, date, sum);
        System.out.println("Added users " + user);
        userService.addNewUser(user);
    }

    private double scanDoubleWithRetry(String message) {
        return 0;
    }

    private Date scanDateWithRetry(String message) {
        final String DATE_FORMAT = "mm.dd.yyyy";
        Date date = null;
        String dateStr;
        do {
            System.out.println(message);
            dateStr = scan.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            try {
                date = sdf.parse(dateStr);
            } catch (ParseException pe) {
                System.out.println("Illegal date format, correct format is \'" + DATE_FORMAT + "\', try again");
            }
        } while (date == null);
        return date;
    }

    private int scanIntWithRetry(String ageMsg) {
        Integer age = null;
        String ageStr;
        do {
            System.out.println(ageMsg);
            ageStr = scan.nextLine();
            try {
                age = Integer.valueOf(ageStr);
            } catch (NumberFormatException nfe) {
                System.out.println("Not an int value, input again");
            }
        } while (age == null);

        return age;
    }

    private int getInput() {
        int res = -1;
        String inputStr = scan.nextLine();
        try {
            res = Integer.parseInt(inputStr);
        } catch (NumberFormatException nfe) {
            System.out.println("String " + inputStr + " is not a number");
        }

        return res;
    }

    public void showMenu() {
        System.out.println("-----------------");
        System.out.println("1. Show all users");
        System.out.println("2. Add new users");
        System.out.println("0. Exit");
    }
}
