package session16.view;

import session16.service.HrService;

import java.util.Scanner;

/**
 * Created by s_okhoda on 21.02.2016.
 */
public class Menu {
    private static final int SHOW_ALL_USERS_ITEM = 1;
    private static final int EXIT_ITEM = 0;
    private static final String EXIT_ITEM_S = "0";
    private static final int ADD_NEW_USER_ITEM = 2;

    private HrService service;
    private Scanner scan;

    public void main() {
        int choise = EXIT_ITEM;
        String chs= EXIT_ITEM_S;

        do {
            chs = getInputString();

            switch (choise) {
                case EXIT_ITEM:
                    System.exit(0);
                    break;
                case SHOW_ALL_USERS_ITEM:
//                    showAllUsers();
                    break;
                case ADD_NEW_USER_ITEM:
//                    addNewUser();

            }
        } while (!chs.equals(EXIT_ITEM_S));
    }

    private String getInputString() {
        int res = -1;
        System.out.println("Please, input Employee name:");
        String inputStr = scan.nextLine();
//        try {
//            res = Integer.parseInt(inputStr);
//        } catch (NumberFormatException nfe) {
//            System.out.println("String " + inputStr + " is not a number");
//        }

        return inputStr;
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
}
