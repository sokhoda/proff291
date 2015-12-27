package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import example.AbstractProcessor;
import example.Calc;
import example.TestProcessor;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class MG2 extends Application {
    static AbstractProcessor processor = new TestProcessor();
    static Calc calcul;
    char inp;

    public MG2() {
    }

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    public void draw() throws Exception {
        Stage base = new Stage();
        base.setTitle("Calc-ulator  (c) triton");
        Group calc = new Group();
        final TextField tF = new TextField("0");
        tF.setLayoutX(10.0D);
        tF.setLayoutY(10.0D);
        Font myFont1 = new Font(28.0D);
        Font myFont2 = new Font(30.0D);
        tF.setFont(myFont2);
        tF.setMaxWidth(253.0D);
        tF.setAlignment(Pos.BASELINE_RIGHT);
        calc.getChildren().add(tF);
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");
        Button btn9 = new Button("9");
        Button btn0 = new Button("0");
        Button btnPlus = new Button("+");
        Button btnMinus = new Button("-");
        Button btnMult = new Button("x");
        Button btnDiv = new Button("/");
        Button btneq = new Button("=");
        btn1.setFont(myFont2);
        btn1.setLayoutX(10.0D);
        btn1.setLayoutY(75.0D);
        btn2.setFont(myFont2);
        btn2.setLayoutX(75.0D);
        btn2.setLayoutY(75.0D);
        btn3.setFont(myFont2);
        btn3.setLayoutX(140.0D);
        btn3.setLayoutY(75.0D);
        btnPlus.setFont(myFont2);
        btnPlus.setLayoutX(205.0D);
        btnPlus.setLayoutY(75.0D);
        btn4.setFont(myFont2);
        btn4.setLayoutX(10.0D);
        btn4.setLayoutY(140.0D);
        btn5.setFont(myFont2);
        btn5.setLayoutX(75.0D);
        btn5.setLayoutY(140.0D);
        btn6.setFont(myFont2);
        btn6.setLayoutX(140.0D);
        btn6.setLayoutY(140.0D);
        btnMinus.setFont(myFont2);
        btnMinus.setLayoutX(205.0D);
        btnMinus.setLayoutY(140.0D);
        btnMinus.setMinWidth(59.0D);
        btn7.setFont(myFont2);
        btn7.setLayoutX(10.0D);
        btn7.setLayoutY(205.0D);
        btn8.setFont(myFont2);
        btn8.setLayoutX(75.0D);
        btn8.setLayoutY(205.0D);
        btn9.setFont(myFont2);
        btn9.setLayoutX(140.0D);
        btn9.setLayoutY(205.0D);
        btnDiv.setFont(myFont2);
        btnDiv.setLayoutX(205.0D);
        btnDiv.setLayoutY(205.0D);
        btnDiv.setMinWidth(59.0D);
        btn0.setFont(myFont2);
        btn0.setLayoutX(10.0D);
        btn0.setLayoutY(270.0D);
        btn0.setMinWidth(122.0D);
        btneq.setFont(myFont1);
        btneq.setLayoutX(140.0D);
        btneq.setLayoutY(270.0D);
        btneq.setMaxWidth(57.0D);
        btneq.setMinWidth(57.0D);
        btneq.setMinHeight(56.0D);
        btnMult.setFont(myFont2);
        btnMult.setLayoutX(205.0D);
        btnMult.setLayoutY(270.0D);
        btnMult.setMaxWidth(59.0D);
        btnMult.setMinWidth(59.0D);
        calc.getChildren().add(btn1);
        calc.getChildren().add(btn2);
        calc.getChildren().add(btn3);
        calc.getChildren().add(btnPlus);
        calc.getChildren().add(btn4);
        calc.getChildren().add(btn5);
        calc.getChildren().add(btn6);
        calc.getChildren().add(btnMinus);
        calc.getChildren().add(btn7);
        calc.getChildren().add(btn8);
        calc.getChildren().add(btn9);
        calc.getChildren().add(btnDiv);
        calc.getChildren().add(btn0);
        calc.getChildren().add(btneq);
        calc.getChildren().add(btnMult);

        btn1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                tF.setText("1");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('1');
                tF.setText("" + MG2.processor.getResult());

            }

        });
        btn2.setOnAction(new EventHandler() {

            @Override
            public void handle(Event event) {
                tF.setText("2");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('2');
                tF.setText("" + MG2.processor.getResult());

            }

        });
        btn3.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("3");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('3');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn4.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("4");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('4');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn5.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("5");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('5');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn6.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("6");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('6');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn7.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("7");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('7');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn8.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("8");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('8');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn9.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("9");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('9');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btn0.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("0");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('0');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btnPlus.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("+");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('+');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btnMinus.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("-");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('-');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btnDiv.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("/");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('/');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btnMult.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("X");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('*');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        btneq.setOnAction(new EventHandler() {
            public void handle(Event event) {
                tF.setText("=");
                Calc var10000 = MG2.calcul;
                Calc.inSymv('=');
                tF.setText("" + MG2.processor.getResult());
            }
        });
        Scene sc = new Scene(calc, 274.0D, 338.0D);
        base.setScene(sc);
        base.show();
    }

    public void start(Stage arg0) throws Exception {
        MG2 begin = new MG2();
        begin.draw();
    }

    static {
        calcul = new Calc(processor);
    }
}

