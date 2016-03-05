 package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
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
    private static final int SHOW_ALL_NOTE_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final int ADD_NEW_NOTE_ITEM = 2;

    private NotebookService noteService;
    private Scanner scan;

    public Menu(NotebookService noteService) {
        this();
        this.noteService  = noteService;;
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
                case SHOW_ALL_NOTE_ITEM:
                    showAllUsers();
                    break;
                case ADD_NEW_NOTE_ITEM:
                    addNewUser();

            }
        } while (choise != EXIT_ITEM);

    }

    private void showAllUsers() {
        for (Notebook ntb : noteService.findAll()) {
            System.out.println(ntb);
        }
    }

    private void addNewUser() {
        int serial = scanIntWithRetry("Input serial");

        System.out.println("Input vendor");
        String vendor = scan.nextLine();

        System.out.println("Input model");
        String model = scan.nextLine();

        Date date = scanDateWithRetry("Input date");
        int price = scanIntWithRetry("Input price");

        Notebook note = new Notebook(serial,vendor,model,date,price);
        System.out.println("Added note " + note);
        noteService.add(note);

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
        System.out.println("1. Show all notebooks");
        System.out.println("2. Add new notebook");
        System.out.println("0. Exit");
    }
}