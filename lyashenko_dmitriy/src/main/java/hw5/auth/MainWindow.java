package hw5.auth;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.List;

/**
 * Created by Solyk on 02.02.2016.
 */
public class MainWindow extends Application {

    private TextField login;
    private PasswordField password;
    private PasswordField passwordConfirmation;

    private Text log = new Text("Login");
    private Text pass = new Text("Password");
    private Text passConf = new Text("PasswordConfirmation");


    private TextArea mainWhindow;

    private Button createUser;
    private Button autintification;

    private UserJDBCManager manager = new UserJDBCManager();

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("JDBCManager");
        primaryStage.setResizable(false);
        primaryStage.setScene(createScene());
        primaryStage.show();
    }

    private Scene createScene() {
        HBox first = new HBox();

        login = new TextField();
        login.setAlignment(Pos.CENTER);

        first.getChildren().add(0, login);
        first.getChildren().add(1,log);

        HBox second = new HBox();


        password = new PasswordField();
        password.setAlignment(Pos.CENTER);

        second.getChildren().add(0,password);
        second.getChildren().add(1,pass);

        HBox third = new HBox();

        passwordConfirmation = new PasswordField();
        passwordConfirmation.setAlignment(Pos.CENTER);

        third.getChildren().add(0, passwordConfirmation);
        third.getChildren().add(1, passConf);

        mainWhindow = new TextArea();

        createUser = new Button("CreatUser");
        createUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(password.getText().equals(passwordConfirmation.getText()) == true && login.getText().equals("") != true && password.getText().equals("") != true) {
                    manager.create(new User(login.getText(), password.getText()));
                   List<String> tmpAppend = manager.findAll();
                    for (String tmpForVisible: tmpAppend) {
                        mainWhindow.appendText(tmpForVisible + "\n");
                    }
                } else{
                    mainWhindow.appendText("Пароль не подтвержден \n");
                    return;
                }
            }
        });

        autintification = new Button("Autintifivation");
        autintification.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if(login.getText().equals("") != true && password.getText().equals("") != true){
                    if(manager.readByNamePass(login.getText(), password.getText()) != null){
                        List<String> tmpAppend2 = manager.findAll();
                        for (String tmpForVisible2: tmpAppend2) {
                            mainWhindow.appendText(tmpForVisible2 + "\n");

                        }
                    } else {
                        mainWhindow.appendText("Не Верный Пороль или Логин \n");
                        return;
                    }
                }
                else{
                    mainWhindow.appendText("Введите Логин И парол \n");
                }
            }
        });



        GridPane gridPane  = new GridPane();
        gridPane.add(first,0,0);
        gridPane.add(createUser,1,0);
        gridPane.add(second, 0, 1);
        gridPane.add(autintification,1,1);
        gridPane.add(third,0,2);
        gridPane.add(mainWhindow,0,3);


        Scene JDBCManager  = new Scene(gridPane);
        return JDBCManager;
    }

    public static void main(String[] args) {
        launch();
    }

}
