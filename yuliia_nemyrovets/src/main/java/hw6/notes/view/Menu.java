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
 * Created by Юлия on 12.02.2016.
 */
public class Menu {

    private static final int EXIT_ITEM = 0;
    private static final int SHOW_ALL_NOTEBOOK_ITEM = 1;
    private static final int CREATE_NEW_USER = 2;
    Scanner scan;
    private Notebook notebook;
    private NotebookService ntbService;

    public Menu() {
        scan = new Scanner(System.in);

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
                case SHOW_ALL_NOTEBOOK_ITEM:
                    ShowAllNotebookItem();
                    break;
                case CREATE_NEW_USER:
                    addNewUser();

            }
        } while (choise != EXIT_ITEM);

    }

    private void ShowAllNotebookItem() {
//        for (Notebook notebook : ntbService.findAll()) {
//            System.out.println(notebook);
//        }
    }

    private void addNewUser() {

        int id = scanIntWithRetry("Input id");

        System.out.println("Input vendor");
        String vendor = scan.nextLine();

        System.out.println("Input model");
        String model = scan.nextLine();

        Date date = scanDateWithRetry("Input date");

        int price = scanIntWithRetry("Input price");
        System.out.println("Input serial");
        String serial = scan.nextLine();

        Notebook notebook = new Notebook(id, vendor, model, date, price, serial);
        System.out.println("Added notebook " + notebook);
        ntbService.create(notebook);
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

    private int scanIntWithRetry(String id) {
        Integer age = null;
        String ageStr;
        do {
            System.out.println(id);
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

    public Menu(NotebookService ntbService) {
        this();
        this.ntbService = ntbService;
    }

    public void deleteNtb(Notebook notebook) {

    }

    public void changePrice(Notebook notebook) {

    }

    public void changeSerialVendor(Notebook notebook) {

    }

    public void deleteByModel() {

    }

    public void showByVendor() {

    }

    public void showByPriceManufDate(double price, Date manufDate) {

    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {

    }
}

