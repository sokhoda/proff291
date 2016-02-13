package hw6.notes.util;

import hw6.notes.dao.NotebookDao;
import hw6.notes.dao.NotebookDaoImpl;
import hw6.notes.domain.Notebook;
import hw6.notes.service.NotebookService;
import hw6.notes.service.NotebookServiceImpl;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.sql.Date;
import java.util.List;


/**
 * Created by Admin on 11.02.2016.
 */
public class HibernateUtil {


    public  HibernateUtil() {

    }


    public void directoryHarvesting(){

        Text dirHar = new Text("Directory Harvesting");
        Text serial = new Text("Serial");
        Text vendor = new Text("Vendor");
        Text model = new Text("Model");
        Text manufactureDateQ = new Text("ManufactureDate");
        Text price = new Text("Price");
        Text findAlll = new Text("Find All");

        TextField serialFil = new TextField();
        TextField vendorFil = new TextField();
        TextField modelFil = new TextField();
        TextField manufactureDateFil = new TextField();
        TextField priceFil = new TextField();
        Button showListNotebook = new Button("ShowListNotebook");

        TextArea mainText = new TextArea();
        mainText.setEditable(false);

        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox forth = new HBox();
        HBox fifth = new HBox();
        HBox sixts = new HBox();
        HBox seventh = new HBox();
        HBox eigth = new HBox();
        HBox nineth = new HBox();

        Button addNotebook = new Button("ADD");

        addNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookDao notebookDao = new NotebookDaoImpl();
                String tmp = manufactureDateFil.getText();
                String[] tmpArray = tmp.split("[-]");
                Integer year = Integer.valueOf(tmpArray[0]);
                Integer month = Integer.valueOf(tmpArray[1]);
                Integer day = Integer.valueOf(tmpArray[2]);
                Double price = Double.valueOf(priceFil.getText());
                Long id = notebookDao.create(new Notebook(serialFil.getText(),vendorFil.getText(),modelFil.getText(),year,month,day,price));
                if(id == null){
                    mainText.appendText("Error. Check the correctness of the data \n");
                } else {
                    mainText.appendText("Operation Success, Id of this notebook is " + id + "\n");
                }

            }
        });

        showListNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookDao notebookDao = new NotebookDaoImpl();
                List<Notebook>  notes = notebookDao.findAll();
                if(notes == null || notes.isEmpty()){
                    mainText.appendText("Directory is empty");
                }else {

                    for (int i = 0; i < notes.size(); i++) {
                        mainText.appendText(notes.get(i).toString() + "\n");
                    }
                }
            }
        });

        first.getChildren().add(dirHar);
        first.setAlignment(Pos.CENTER);

        second.getChildren().add(0,serialFil);
        second.getChildren().add(1,serial);

        third.getChildren().add(0, vendorFil);
        third.getChildren().add(1, vendor);

        forth.getChildren().add(0, modelFil);
        forth.getChildren().add(1,model);

        fifth.getChildren().add(0, manufactureDateFil);
        fifth.getChildren().add(1, manufactureDateQ);


        sixts.getChildren().add(0, priceFil);
        sixts.getChildren().add(1, price);

        seventh.getChildren().add(addNotebook);
        seventh.setAlignment(Pos.CENTER);

        eigth.getChildren().add(findAlll);
        eigth.setAlignment(Pos.CENTER);

        nineth.getChildren().add(showListNotebook);
        nineth.setAlignment(Pos.CENTER_LEFT);

        GridPane gridPane = new GridPane();

        gridPane.add(first,0,0);
        gridPane.add(second,0,1);
        gridPane.add(third,0,2);
        gridPane.add(forth,0,3);
        gridPane.add(fifth,0,4);
        gridPane.add(sixts,0,5);
        gridPane.add(seventh,0,6);
        gridPane.add(eigth,0,7);
        gridPane.add(nineth,0,8);
        gridPane.add(mainText,0,9);

        Scene scene =  new Scene(gridPane);

        Stage directoryHarve = new Stage();
        directoryHarve.setTitle("DirectoryHarvesting ");
        directoryHarve.setResizable(false);

        directoryHarve.setScene(scene);
        directoryHarve.show();

    }

    public void directoryNotebooks(){

        Text dirNote = new Text("Directory Notebooks");
        Text id = new Text("ID");
        Text serial = new Text("Serial");
        Text vendor = new Text("Vendor");
        Text price = new Text("Price");

        TextField idFil = new TextField();
        TextField serialFil = new TextField();
        TextField vendorFil = new TextField();
        TextField priceFil = new TextField();

        Button deleteNotebook = new Button("Delete");
        Button editNotebookSerialVendor = new Button("EditNotebookSerialVendor");

        TextArea mainText = new TextArea();
        mainText.setEditable(false);

        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox forth = new HBox();
        HBox fifth = new HBox();


        Button editNotebookPrice = new Button("EditNotebookPrice");

        deleteNotebook.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                boolean tmpBool = notebookService.delete(Long.valueOf(idFil.getText()));
                if(tmpBool == false){
                    mainText.appendText("Error. Check the correctness of the data \n");
                } else {
                    mainText.appendText("Operation Success, notebook is delete " + idFil.getText() + "\n");
                }

            }
        });

        editNotebookPrice.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               NotebookService notebookService = new NotebookServiceImpl();
                try {
                    notebookService.changePrice(Long.valueOf(idFil.getText()), Double.valueOf(priceFil.getText()));
                    mainText.appendText("Operation Success. \n");
                } catch (Exception e){
                    mainText.appendText("Error. Check the correctness of the data \n");
                }


            }
        });

        editNotebookSerialVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                try {
                    notebookService.changeSerialVendor(Long.valueOf(idFil.getText()),serialFil.getText(),vendorFil.getText());
                    mainText.appendText("Operation Success. \n");
                } catch (Exception e){
                    mainText.appendText("Error. Check the correctness of the data \n");
                }

            }
        });


        first.getChildren().add(dirNote);
        first.setAlignment(Pos.CENTER);

        second.getChildren().add(0,idFil);
        second.getChildren().add(1,id);
        second.getChildren().add(2,deleteNotebook);

        third.getChildren().add(0, priceFil);
        third.getChildren().add(1, price);
        third.getChildren().add(2, editNotebookPrice);


        forth.getChildren().add(0, serialFil);
        forth.getChildren().add(1,serial);

        fifth.getChildren().add(0, vendorFil);
        fifth.getChildren().add(1, vendor);
        fifth.getChildren().add(2,editNotebookSerialVendor);


        GridPane gridPane = new GridPane();

        gridPane.add(first,0,0);
        gridPane.add(second,0,1);
        gridPane.add(third,0,2);
        gridPane.add(forth,0,3);
        gridPane.add(fifth,0,4);
        gridPane.add(mainText,0,5);

        Scene scene =  new Scene(gridPane);

        Stage directoryNote = new Stage();
        directoryNote.setTitle("DirectoryNotebook");
        directoryNote.setResizable(false);

        directoryNote.setScene(scene);
        directoryNote.show();

    }

    public void directoryExpansion(){

        Text dirExp = new Text("Directory Expansion");

        Text model = new Text("Model");
        Text vendor = new Text("Vendor");
        Text price = new Text("Price");
        Text manufactureDate = new Text("ManufactureDate");
        Text priceFrom = new Text("PriceFrom");
        Text priceTo = new Text("PriceTo");
        Text manufactureDateBefore = new Text("ManufactureDateBefore");
        Text vendorBefore = new Text("VendorBefore");

        TextField modelFil = new TextField();
        TextField vendorFil = new TextField();
        TextField priceFil = new TextField();
        TextField manufactureDateFil = new TextField();
        TextField manufactureDateBeforeFil = new TextField();
        TextField priceFromFil = new TextField();
        TextField priceToFil = new TextField();
        TextField vendorFilBefore = new TextField();

        Button deleteNotebookByModel = new Button("DeleteByModel");
        Button getNotebookVendor = new Button("GetNotebookVendor");
        Button getNotebookPriceFromToDateVendor = new Button("GetNotePriceDateVendor");

        TextArea mainText = new TextArea();
        mainText.setEditable(false);

        HBox first = new HBox();
        HBox second = new HBox();
        HBox third = new HBox();
        HBox forth = new HBox();
        HBox fifth = new HBox();
        HBox sixts  = new HBox();
        HBox seventh = new HBox();
        HBox eighth = new HBox();
        HBox nineth = new HBox();


        Button getNotebookPriceAndDate = new Button("GetNotebookPriceAndDate");

        deleteNotebookByModel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                boolean tmpBool = notebookService.deleteByModel(modelFil.getText());
                if(tmpBool == false){
                    mainText.appendText("Error. Check the correctness of the data \n");
                } else {
                    mainText.appendText("Operation Success, notebook is delete " + modelFil.getText() + "\n");
                }

            }
        });

        getNotebookPriceAndDate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                List<Notebook> tmp = notebookService.findByPriceManufDate(Double.valueOf(priceFil.getText()), Date.valueOf(manufactureDateFil.getText()));
                if(tmp == null || tmp.isEmpty()){
                    mainText.appendText("Error. Check the correctness of the data \n");
                } else {
                    for (int i = 0; i < tmp.size(); i++) {
                        mainText.appendText(tmp.get(i).toString() + "/n");
                    }
                }

            }
        });

        getNotebookVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                List<Notebook> tmp = notebookService.findByVendor(vendorFil.getText());
                if(tmp == null || tmp.isEmpty()){
                    mainText.appendText("Error. Check the correctness of the data \n");
                } else {
                    for (int i = 0; i < tmp.size(); i++){
                        mainText.appendText(tmp.get(i).toString() + "/n");
                    }
                }
            }
        });

        getNotebookPriceFromToDateVendor.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                NotebookService notebookService = new NotebookServiceImpl();
                List<Notebook> tmp = notebookService.findBetweenPriceLtDateByVendor(Double.valueOf(priceFromFil.getText()),Double.valueOf(priceToFil.getText()),
                        Date.valueOf(manufactureDateBeforeFil.getText()), vendorFil.getText());
                if(tmp == null || tmp.isEmpty()){
                    mainText.appendText("Error. Check the correctness of the data  \n");
                } else {
                    for (int i = 0; i < tmp.size(); i++){
                        mainText.appendText(tmp.get(i).toString() + "/n");
                    }
                }
            }
        });

        first.getChildren().add(dirExp);
        first.setAlignment(Pos.CENTER);

        second.getChildren().add(0,modelFil);
        second.getChildren().add(1,model);
        second.getChildren().add(2,deleteNotebookByModel);

        third.getChildren().add(0, vendorFil);
        third.getChildren().add(1, vendor);
        third.getChildren().add(2, getNotebookVendor);


        forth.getChildren().add(0, priceFil);
        forth.getChildren().add(1,price);


        fifth.getChildren().add(0, manufactureDateFil);
        fifth.getChildren().add(1, manufactureDate);
        fifth.getChildren().add(2,getNotebookPriceAndDate);

        sixts.getChildren().add(0, priceFromFil);
        sixts.getChildren().add(1,priceFrom);

        seventh.getChildren().add(0, priceToFil);
        seventh.getChildren().add(1,priceTo);


        eighth.getChildren().add(0, manufactureDateBeforeFil);
        eighth.getChildren().add(1, manufactureDateBefore);

        nineth.getChildren().add(0, vendorFilBefore);
        nineth.getChildren().add(1, vendorBefore);
        nineth.getChildren().add(2, getNotebookPriceFromToDateVendor);





        GridPane gridPane = new GridPane();

        gridPane.add(first,0,0);
        gridPane.add(second,0,1);
        gridPane.add(third,0,2);
        gridPane.add(forth,0,3);
        gridPane.add(fifth,0,4);
        gridPane.add(sixts,0,5);
        gridPane.add(seventh,0,6);
        gridPane.add(eighth,0,7);
        gridPane.add(nineth,0,8);
        gridPane.add(mainText,0,9);

        Scene scene =  new Scene(gridPane);

        Stage directoryExp = new Stage();
        directoryExp.setTitle("DirectoryExpansion");
        directoryExp.setResizable(false);

        directoryExp.setScene(scene);
        directoryExp.show();
    }


}
