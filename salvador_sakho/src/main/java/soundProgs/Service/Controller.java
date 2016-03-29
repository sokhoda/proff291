package soundProgs.Service;

import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.io.File;
import java.io.IOException;

import soundProgs.domain.InterfaceInfo;


/**
 * Created by ${BIM} on 19.02.2016.
 */
public class Controller {

    private SoudSelection ss = new SoudSelection();
    private MP3Sound mp3Sound = new MP3Sound();

    public Controller() {
    }

    private ObservableList<InterfaceInfo> interfaceInfoData = ss.getInterfaceInfoData();


    @FXML
    TextArea systemOutput;

    @FXML
    TextArea caseIdArea;

    @FXML
    private ComboBox groupName;

    @FXML
    private DatePicker calendarView;

    @FXML
    private DatePicker calendarViewEnd;

    @FXML
    private Slider sliderSound;

    @FXML
    private TableView<InterfaceInfo> tableInterfaceInfo;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn1;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn2;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn3;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn4;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn5;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn6;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn7;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn8;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn9;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn10;

    @FXML
    private TableColumn<InterfaceInfo, String> colomn11;

    @FXML
    private Button playBtn;

    @FXML
    private Button stopBtn;

    @FXML
    private Button saveBtn;

    @FXML
    private Button selectBTN;

    @FXML
    private Button pauseBtn;

    @FXML
    public void selectALL() {

        if (calendarView.getValue() == null && calendarViewEnd.getValue() == null) {
            if (!interfaceInfoData.isEmpty()) {
                interfaceInfoData.clear();
            }
            ss.sqlProcudureLid(Integer.parseInt(caseIdArea.getText()));
            colomn1.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("LID"));
            colomn2.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("ProjectCaption"));
            colomn3.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("AuthorName"));
            colomn4.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Owner"));
            colomn5.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Result"));
            colomn6.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Phonenumber"));
            colomn7.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallCreated"));
            colomn8.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallLength"));
            colomn9.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Direction"));
            colomn10.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("TaskName"));
            colomn11.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("recordurl"));
            tableInterfaceInfo.setItems(interfaceInfoData);
        }
        if (caseIdArea.getText().isEmpty()) {

            if (!interfaceInfoData.isEmpty()) {
                interfaceInfoData.clear();
            }
            ss.sqlProcudureDate(calendarView.getValue().toString(), calendarViewEnd.getValue().toString());
            colomn1.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("LID"));
            colomn2.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("ProjectCaption"));
            colomn3.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("AuthorName"));
            colomn4.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Owner"));
            colomn5.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Result"));
            colomn6.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Phonenumber"));
            colomn7.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallCreated"));
            colomn8.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallLength"));
            colomn9.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Direction"));
            colomn10.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("TaskName"));
            colomn11.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("recordurl"));
            tableInterfaceInfo.setItems(interfaceInfoData);

        }
        if (!caseIdArea.getText().isEmpty() && calendarView.getValue() != null && calendarViewEnd.getValue() != null) {

            if (!interfaceInfoData.isEmpty()) {
                interfaceInfoData.clear();
            }
            ss.sqlProcudure(Integer.parseInt(caseIdArea.getText()), calendarView.getValue().toString(), calendarViewEnd.getValue().toString());
            colomn1.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("LID"));
            colomn2.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("ProjectCaption"));
            colomn3.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("AuthorName"));
            colomn4.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Owner"));
            colomn5.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Result"));
            colomn6.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Phonenumber"));
            colomn7.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallCreated"));
            colomn8.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("CallLength"));
            colomn9.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("Direction"));
            colomn10.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("TaskName"));
            colomn11.setCellValueFactory(new PropertyValueFactory<InterfaceInfo, String>("recordurl"));
            tableInterfaceInfo.setItems(interfaceInfoData);
        }
    }


    @FXML
    public void onMousClick() {
        try {
            InterfaceInfo interfaceInfo = tableInterfaceInfo.getSelectionModel().getSelectedItem();
            caseIdArea.setText(String.valueOf(interfaceInfo.getLID()));
        } catch (NullPointerException e) {
        }
    }

    @FXML
    public void playSound() {
        InterfaceInfo interfaceInfo = tableInterfaceInfo.getSelectionModel().getSelectedItem();
        systemOutput.setText("Put the record name");
        if (mp3Sound.getState() == 0) {
            systemOutput.setText("listen");
            mp3Sound.playSound(interfaceInfo.getRecordurl());
            mp3Sound.movement(sliderSound);
        } else {
            mp3Sound.stop();
        }
    }

    @FXML
    public void stopMusic() {
        mp3Sound.setState(1);
        if (mp3Sound.getState() == 0) {
            systemOutput.setText("Music is not playing");
        }
        if (mp3Sound.getState() == 1) {
            mp3Sound.stop();
        }
    }

    @FXML
    public void saveFile() {
        Saver saver = new Saver();
        InterfaceInfo interfaceInfo = tableInterfaceInfo.getSelectionModel().getSelectedItem();
        String userName = System.getProperty("user.name");
        File f = new File("C:\\Users\\" + userName + "\\Desktop\\sound");

        try {
            if (!f.exists()) {
                f.mkdir();
            }
            File file1 = new File("C:\\Users\\User\\Desktop\\records\\mix_13518_16e001__2016_02_28__08_00_32_057.mp3").getAbsoluteFile();
            File file2 = new File("C:\\Users\\User\\Desktop\\sound\\" + colomn11.getCellData(interfaceInfo)).getAbsoluteFile();
            saver.copyFileUsingChannel(file1, file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void pauseAction() {
        if (mp3Sound.getState() == 0) {
            mp3Sound.pause();
        }

        if (mp3Sound.getState() == 1) {
            mp3Sound.pause();
        }
    }

    public void positionChange() {
        mp3Sound.movement(sliderSound);
    }

    @FXML
    public void rewindSound() {
        mp3Sound.rewind(sliderSound);
    }

    @FXML
    public void selectGroup() {
        InterfaceInfo interfaceInfo = tableInterfaceInfo.getSelectionModel().getSelectedItem();
        groupName.getItems().addAll(colomn3.getCellData(interfaceInfo));
    }



    /* Lid 4433111*/
}

