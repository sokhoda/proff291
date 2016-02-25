package hw6.notes.view;

import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Пк2 on 13.02.2016.
 */
public class Menu {
    private NotebookService service;
    private Scanner scanner;


    public Menu(NotebookService service){
        this.service=service;
        scanner=new Scanner(System.in);
    }


    public void main(){
        boolean run=true;

        while(run){
            printMenu();
            int key=getInput();
            switch(key){
                case 0:
                    run=false;
                    break;
                case 1:
                    addNotebook();
                    break;
                case 2:
                    printNotebookList();
                    break;
                case 3:
                    System.out.println("Enter id");
                    Long id=Long.parseLong(scanner.nextLine());
                    deleteNtb(service.getNoteById(id));
                    break;
                case 4:
                    System.out.println("Enter id");
                    Long id2=Long.parseLong(scanner.nextLine());
                    System.out.println("Enter new price");
                    Double price=Double.parseDouble(scanner.nextLine());
                    Notebook aNote=new Notebook();
                    aNote.setPrice(price);
                    changePrice(aNote);
                    break;
                case 5:
                    System.out.println("Enter id");
                    Long aid2=Long.parseLong(scanner.nextLine());
                    System.out.println("Enter new serial");
                    String serial=scanner.nextLine();
                    System.out.println("Enter new vendor");
                    String vendor=scanner.nextLine();

                    Notebook aNote2=new Notebook();
                    aNote2.setSerial(serial);
                    aNote2.setVendor(vendor);

                    changeSerialVendor(aNote2);
                    break;
                case 6:
                    System.out.println("Enter model to delete notes");
                    String model=scanner.nextLine();
                    deleteByModel(model);
                    break;
                case 7:
                    System.out.println("Enter vendor to show notes");
                    String vendor2=scanner.nextLine();
                    showByVendor(vendor2);
                    break;
                case 8:
                    System.out.println("Enter price to show notes");
                    Double price2=Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter manufDate to show notes");
                    SimpleDateFormat format=new SimpleDateFormat("mm.dd.yyyy");
                    Date date=null;
                    try{
                        date=format.parse(scanner.nextLine());
                    } catch(Exception e){
                        System.out.println("Wrong date");
                    }

                    showByPriceManufDate(price2,date);

                    break;
                case 9:
                    System.out.println("Enter price to show notes from");
                    Double priceFrom=Double.parseDouble(scanner.nextLine());
                    System.out.println("Enter price to show notes To");
                    Double priceTo=Double.parseDouble(scanner.nextLine());
                    SimpleDateFormat formatTo=new SimpleDateFormat("mm.dd.yyyy");
                    Date dateTo=null;
                    try{
                        dateTo=formatTo.parse(scanner.nextLine());
                    } catch(Exception e){
                        System.out.println("Wrong date");
                    }
                    System.out.println("Enter vendor to show notes");
                    String vendorOf=scanner.nextLine();

                    showBetweenPriceLtDateByVendor(priceFrom,priceTo,dateTo,vendorOf);

                    break;



            }
        }
        System.exit(0);


    }

    private void printMenu(){
        System.out.println("-------------------------------");
        System.out.println("1.Add Notebook");
        System.out.println("2.Show All Notebooks");
        System.out.println("3.Delete Notebook by Id");
        System.out.println("4.Change Note price by Id");
        System.out.println("5.Change Note serial and vendor by Id");
        System.out.println("6.Delete Note by model");
        System.out.println("7.Show Note by vendor");
        System.out.println("8.Show Note by price and manufacture date");
        System.out.println("9.Show Note between prices and manufacture date and vendor");


        System.out.println("0.Exit");
    }

    private int getInput(){
        int input=-1;
        String inpStr=scanner.nextLine();
        try{
            input=Integer.parseInt(inpStr);
        } catch(Exception e){
            System.out.println(inpStr+" Wrong input!");
        }
        return input;
    }

    private void addNotebook(){
        System.out.println("Enter Serial number");
        String serial=scanner.nextLine();

        System.out.println("Enter Vendor");
        String vendor=scanner.nextLine();

        System.out.println("Enter Model");
        String model=scanner.nextLine();

        System.out.println("Enter price");
        Double price=Double.parseDouble(scanner.nextLine());

        System.out.println("Enter manufacture date");
        SimpleDateFormat format=new SimpleDateFormat("mm.dd.yyyy");
        Date date=null;
        try{
            date=format.parse(scanner.nextLine());
        } catch(Exception e){
            System.out.println("Wrong date");
        }
        Notebook aNotebook =new Notebook(serial,vendor,model,date,price);
        service.add(aNotebook);
    }

    private void printNotebookList(){
        List<Notebook> noteList=service.findAll();
        for(int i=0;i<noteList.size(); i++){
            String str=noteList.get(i).toString();
            System.out.println("----------------------------------------------");
            System.out.println(str);
            System.out.println("----------------------------------------------");
        }

    }

    void deleteNtb(Notebook note){
        service.delete(note.getId());
    }

    private void changePrice(Notebook note){
        service.changePrice(note.getId(),note.getPrice());
    }

    private void changeSerialVendor(Notebook note){
        service.changeSerialVendor(note.getId(),note.getSerial(),note.getVendor());
    }

    void deleteByModel(String model){
       service.deleteByModel(model);
    }

    void showByVendor(String vendor){
        System.out.println(service.findByVendor(vendor).toString());
    }

    void showByPriceManufDate(double price, Date manufDate){
        System.out.println(service.findByPriceManufDate(price,manufDate).toString());
    }

    void showBetweenPriceLtDateByVendor(double priceFrom, double priceTo, Date date, String vendorId){
        System.out.println(service.findBetweenPriceLtDateByVendor(priceFrom,priceTo,date,vendorId).toString());
    }




}
