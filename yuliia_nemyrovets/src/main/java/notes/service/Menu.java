package notes.service;

import notes.domain.Notebook;

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

    public  void deleteByModel() {

    }

    public void showByVendor() {

    }

    public void showByPriceManufDate(double price, Date manufDate) {

    }

    public void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, long vendorId) {

    }
}

