//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package poker;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.util.Duration;

public class PokerTable extends Application {
    Stage plane = new Stage();
    private Text nextTime = new Text();
    private Countdown level = new Countdown(6);
    private Preflop preflop = new Preflop();
    private Flop flop = new Flop();
    private Turn turn = new Turn();
    private River river = new River();
    private NewHand newHand = new NewHand();
    Cash cash = new Cash();
    Deck deck = new Deck();
    Analysis analysis = new Analysis();
    ImageView myCard1 = new ImageView();
    ImageView myCard2 = new ImageView();
    ImageView compCard1 = new ImageView();
    ImageView compCard2 = new ImageView();
    ImageView button = new ImageView();
    Text blind = new Text("10/20");
    Text nextLevel = new Text("15/30");
    TextField betSize = new TextField();
    int dealerY = 240;
    Text showMyBet = new Text();
    Text showCompBet = new Text();
    Text showMyStackValue = new Text();
    Text showCompStackValue = new Text();
    TextField showBank = new TextField();
    Group gPlane = new Group();
    ImageView flop1 = new ImageView();
    ImageView flop2 = new ImageView();
    ImageView flop3 = new ImageView();
    ImageView showturn = new ImageView();
    ImageView showriver = new ImageView();
    Text dirStatus = new Text();
    String mainPath = new String();
    String altPath = "";
    Stage preStage = new Stage();
    boolean finded = true;
    ArrayList<String> handLog = new ArrayList();
    Text showTempText = new Text();
    String phase = "blin";
    boolean step = true;

    public PokerTable() {
    }

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        PokerTable current = new PokerTable();
        current.begin();
    }

    public void superBrain() {
        System.out.print("Супер Мозг работает. На входе: ");
        int last = handLog.size() - 1;
        System.out.println((String)handLog.get(last - 1) + " " + (String)handLog.get(last));
        String subLast = ((String)handLog.get(last)).substring(4);
        String subPreLast = ((String)handLog.get(last - 1)).substring(4);
        String stad = ((String)handLog.get(last)).substring(4, 8);
        boolean dec = true;
        if(subLast.equals(subPreLast) && phase.equals(stad) && dec) {
            dec = false;
            System.out.println("Torgi na faze " + stad + " zakonheni. Sdaem kartu.");
            if(stad.equals("pref")) {
                flop.run();
            } else if(stad.equals("flop")) {
                turn.run();
            } else if(stad.equals("turn")) {
                river.run();
            } else if(stad.equals("rive")) {
                System.out.println("Javno ktoto viigral");
                analysis.handEnd();
            } else {
                System.out.println("Что то пошло не так!");
            }
        } else if(((String)handLog.get(last)).startsWith("humapref") && phase.equals("flop") && dec) {
            dec = false;
            System.out.println("Перешли на флоп. Первум чодит человек");
        } else if(((String)handLog.get(last)).startsWith("comppref") && phase.equals("flop") && dec) {
            dec = false;
            System.out.println("Перешли на флоп. Первум xодит komp");
            cash.compChecCall();
        } else if(((String)handLog.get(last)).startsWith("humablin") && dec) {
            dec = false;
            System.out.println("Блины поставлены. Начинаем торги.");
            analysis.preflopStrategyDispetcher();
        } else if(((String)handLog.get(last - 1)).startsWith("compblin") && ((String)handLog.get(last)).startsWith("humapref") && dec) {
            dec = false;
            System.out.println("Comp ne diller. Pora stavit preflop");
            analysis.preflopStrategyDispetcher();
        } else if(((String)handLog.get(last)).startsWith("huma") && dec) {
            dec = false;
            if(phase.equals("flop")) {
                System.out.println("Peredat hod dispecheru flopa");
                cash.compChecCall();
            } else if(phase.equals("turn")) {
                System.out.println("Peredat hod dispecheru turna");
                cash.compChecCall();
            } else if(phase.equals("rive")) {
                System.out.println("Peredat hod dispecheru rivera");
                cash.compChecCall();
            } else {
                System.out.println("Что то пошло не так! 2");
            }
        } else {
            System.out.println();
            System.out.println("SuperMozg Reshenija ne nashel " + (String)handLog.get(last - 1) + " " + (String)handLog.get(last) + " faza " + phase + " PredHod " + stad);
        }
    }

    public void begin() throws Exception {
        preloader();
        plane.setTitle("HeadsUp Trainer.     (c) tri___ton");
        Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0D, 200.0D, true, true);
        Image dealer = new Image("file:/Users/elenabugercuk/Documents/workspace/img/dealer.gif", 50.0D, 50.0D, true, true);
        myCard1.setImage(back);
        myCard1.setLayoutX(5.0D);
        myCard1.setLayoutY(370.0D);
        myCard2.setImage(back);
        myCard2.setLayoutX(110.0D);
        myCard2.setLayoutY(370.0D);
        compCard1.setImage(back);
        compCard1.setLayoutX(5.0D);
        compCard1.setLayoutY(5.0D);
        compCard2.setImage(back);
        compCard2.setLayoutX(110.0D);
        compCard2.setLayoutY(5.0D);
        flop1.setImage(back);
        flop1.setLayoutX(240.0D);
        flop1.setLayoutY(190.0D);
        flop2.setImage(back);
        flop2.setLayoutX(350.0D);
        flop2.setLayoutY(190.0D);
        flop3.setImage(back);
        flop3.setLayoutX(460.0D);
        flop3.setLayoutY(190.0D);
        showturn.setImage(back);
        showturn.setLayoutX(580.0D);
        showturn.setLayoutY(190.0D);
        showriver.setImage(back);
        showriver.setLayoutX(700.0D);
        showriver.setLayoutY(190.0D);
        button.setImage(dealer);
        button.setLayoutX(220.0D);
        button.setLayoutY((double)dealerY);
        showBank.setAlignment(Pos.BASELINE_RIGHT);
        showBank.setLayoutX(130.0D);
        showBank.setLayoutY(250.0D);
        showBank.setMaxWidth(80.0D);
        showBank.setEditable(false);
        showBank.setText("0");
        Text bankText = new Text();
        bankText.setText("Pot");
        bankText.setLayoutX(98.0D);
        bankText.setLayoutY(270.0D);
        showMyBet.setText("0");
        showMyBet.setLayoutX(50.0D);
        showMyBet.setLayoutY(350.0D);
        showCompBet.setText("0");
        showCompBet.setLayoutX(50.0D);
        showCompBet.setLayoutY(180.0D);
        Text myStack = new Text();
        myStack.setText("Stack");
        myStack.setLayoutX(250.0D);
        myStack.setLayoutY(500.0D);
        showMyStackValue.setFont(Font.font(20.0D));
        showMyStackValue.setText("1500");
        showMyStackValue.setLayoutX(290.0D);
        showMyStackValue.setLayoutY(500.0D);
        Text compStack = new Text();
        compStack.setText("Stack");
        compStack.setLayoutX(250.0D);
        compStack.setLayoutY(40.0D);
        showCompStackValue.setFont(Font.font(20.0D));
        showCompStackValue.setText("1500");
        showCompStackValue.setLayoutX(290.0D);
        showCompStackValue.setLayoutY(40.0D);
        final Button toss = new Button();
        toss.minHeight(200.0D);
        toss.minWidth(100.0D);
        toss.maxHeight(200.0D);
        toss.maxWidth(100.0D);
        toss.setFont(Font.font(40.0D));
        toss.setText("Toss");
        toss.setLayoutX(670.0D);
        toss.setLayoutY(450.0D);
        final Button start = new Button(); // клавиша старта игры. Появляется после жеребьевки.
        start.minHeight(200.0D);
        start.minWidth(100.0D);
        start.maxHeight(200.0D);
        start.maxWidth(100.0D);
        start.setFont(Font.font(40.0D));
        start.setText("Start");
        start.setLayoutX(670.0D);
        start.setLayoutY(350.0D);
        Text status = new Text("Small/Big blind");
        status.setLayoutX(650.0D);
        status.setLayoutY(20.0D);
        blind.setText(cash.blind[cash.level] / 2 + "/" + cash.blind[cash.level]);
        blind.setLayoutX(770.0D);
        blind.setLayoutY(20.0D);
        Text next = new Text("Next Level");
        next.setLayoutX(650.0D);
        next.setLayoutY(40.0D);
        nextLevel.setText(cash.blind[cash.level + 1] / 2 + "/" + cash.blind[cash.level + 1]);
        nextLevel.setLayoutX(770.0D);
        nextLevel.setLayoutY(40.0D);
        Text timeAnnot = new Text("Time to next level");
        timeAnnot.setLayoutX(650.0D);
        timeAnnot.setLayoutY(60.0D);
        nextTime.setText("10:00");
        nextTime.setLayoutX(770.0D);
        nextTime.setLayoutY(60.0D);
        final Button act1 = new Button();
        act1.setText("Pass");
        act1.setLayoutX(400.0D);
        act1.setLayoutY(480.0D);
        final Button blindCall = new Button();
        blindCall.setText("Check || Call");
        blindCall.setLayoutX(450.0D);
        blindCall.setLayoutY(480.0D);
        blindCall.setVisible(true);
        betSize.setAlignment(Pos.BASELINE_RIGHT);
        betSize.setLayoutX(545.0D);
        betSize.setLayoutY(480.0D);
        betSize.setMaxWidth(80.0D);
        betSize.setEditable(true);
        betSize.setText("0");
        final Button act3 = new Button();
        act3.setText("Bet | Raise");
        act3.setLayoutX(630.0D);
        act3.setLayoutY(480.0D);
        final Button act4 = new Button();
        act4.setText("All In");
        act4.setLayoutX(715.0D);
        act4.setLayoutY(480.0D);
        showTempText.setLayoutY(150.0D);
        showTempText.setLayoutX(300.0D);
        showTempText.setText("Буду думать...");
        gPlane.getChildren().add(myCard1);
        gPlane.getChildren().add(myCard2);
        gPlane.getChildren().add(compCard1);
        gPlane.getChildren().add(compCard2);
        gPlane.getChildren().add(flop1);
        gPlane.getChildren().add(flop2);
        gPlane.getChildren().add(flop3);
        gPlane.getChildren().add(showturn);
        gPlane.getChildren().add(showriver);
        gPlane.getChildren().add(button);
        gPlane.getChildren().add(showBank);
        gPlane.getChildren().add(bankText);
        gPlane.getChildren().add(showMyBet);
        gPlane.getChildren().add(myStack);
        gPlane.getChildren().add(showCompBet);
        gPlane.getChildren().add(showMyStackValue);
        gPlane.getChildren().add(compStack);
        gPlane.getChildren().add(showCompStackValue);
        gPlane.getChildren().add(toss);
        gPlane.getChildren().add(status);
        gPlane.getChildren().add(blind);
        gPlane.getChildren().add(next);
        gPlane.getChildren().add(nextLevel);
        gPlane.getChildren().add(timeAnnot);
        gPlane.getChildren().add(nextTime);
        gPlane.getChildren().add(showTempText);

        toss.setOnMouseClicked(new EventHandler() {
            public void handle(Event event) {
                gPlane.getChildren().remove(toss);
                gPlane.getChildren().add(start);
                toss();
            }
        });
        start.setOnMouseClicked(new EventHandler() {
            public void handle(Event startevent) {
                gPlane.getChildren().remove(start);
                gPlane.getChildren().add(act1);
                gPlane.getChildren().add(blindCall);
                gPlane.getChildren().add(act3);
                gPlane.getChildren().add(act4);
                gPlane.getChildren().add(betSize);
                level.start();
                myCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0D, 200.0D, true, true));
                compCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0D, 200.0D, true, true));
                cash.makeBlind();
                preflop.start();
            }
        });
        act1.setOnMouseClicked(new EventHandler() {
            public void handle(Event event) {
                preflop.interrupt();
                showTempText.setText("Буду думать...");
                betSize.setText("");
                cash.pot = cash.pot + cash.myBet + cash.compBet;
                cash.compStack += cash.pot;
                cash.pot = 0;
                cash.myBet = 0;
                cash.compBet = 0;
                showCompStackValue.setText("" + cash.compStack);
                showBank.setText("0");
                showMyBet.setText("0");
                showCompBet.setText("0");
                String toLog = "huma" + phase + "0";
                handLog.add(toLog);
                System.out.println("Итоговая история руки ");
                System.out.println(handLog.toString());
                newHand.run();
            }
        });

        blindCall.setOnMouseClicked(new EventHandler() {
            public void handle(Event event) {
                step = true;
                betSize.setText("");
                cash.myStack += cash.myBet;
                cash.myBet = cash.compBet;
                cash.myStack -= cash.myBet;
                showMyStackValue.setText("" + cash.myStack);
                showMyBet.setText("" + cash.myBet);
                String toLog = "huma" + phase + cash.myBet;
                handLog.add(toLog);
                System.out.println(handLog.toString());
                System.out.println("После нажатием кнопки " + phase + " " + step);
                if(phase.equals("pref") && step) {
                    step = false;
                    System.out.println("Этап Flop");
                    superBrain();
                }

                if(phase.equals("flop") && step) {
                    step = false;
                    System.out.println("Нажатие кнопки на флопе");
                    superBrain();
                }

                if(phase.equals("turn") && step) {
                    step = false;
                    System.out.println("Нажатие кнопки на терне");
                    superBrain();
                }

                if(phase.equals("rive") && step) {
                    step = false;
                    System.out.println("Нажатие кнопки на ривере");
                    superBrain();
                }

                event = null;
            }
        });


        act3.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                cash.compAgressor = false;
            }
        });



//        act3.setOnAction(new EventHandler() {
//            public void handle(ActionEvent event) {
//                cash.compAgressor = false;
//            }
//        });




        act4.setOnMouseClicked(new EventHandler() {
            public void handle(Event event) {
                int bet = cash.myStack;
                betSize.setText("" + bet);
                event = null;
            }
        });


        plane.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                preflop.interrupt();
                level.interrupt();
                flop.interrupt();
                newHand.interrupt();
            }
        });


//        plane.setOnCloseRequest(new EventHandler() {
//
//            public void handle(WindowEvent event) {
//                preflop.interrupt();
//                level.interrupt();
//                flop.interrupt();
//                newHand.interrupt();
//            }
//        });

        Scene planeScene = new Scene(gPlane, 840.0D, 540.0D);
        plane.setScene(planeScene);
    }

    public void preloader() throws IOException {
        final Group preGroup = new Group();
        File[] root = File.listRoots();
        final Path startPath = root[0].toPath();
        dirStatus.setText("Нажмите для начала поиска нужной папки.");
        dirStatus.setLayoutX(70.0D);
        dirStatus.setLayoutY(50.0D);
        final Button dirFind = new Button("Serch");
        dirFind.setLayoutX(180.0D);
        dirFind.setLayoutY(150.0D);
        preGroup.getChildren().add(dirStatus);
        preGroup.getChildren().add(dirFind);
        final TextField propPath = new TextField();
        propPath.setLayoutX(30.0D);
        propPath.setLayoutY(30.0D);
        propPath.setMinWidth(250.0D);
        final Button close = new Button("Close");
        close.setLayoutX(90.0D);
        close.setLayoutY(150.0D);
        final Button makeDir = new Button("Создать");
        makeDir.setLayoutX(310.0D);
        makeDir.setLayoutY(30.0D);
        Scene preScene = new Scene(preGroup, 400.0D, 200.0D);
        preStage.setScene(preScene);
        preStage.show();

        dirFind.setOnMouseClicked(new EventHandler() {
            public void handle(Event event) {
                dirStatus.setVisible(true);
                mainPath = "";
                final PrintFiles pf = new PrintFiles();
                dirStatus.setText("                     Поиск начался....");
                final ProgressBar bar = new ProgressBar();
                bar.setVisible(true);
                bar.setLayoutX(50.0D);
                bar.setLayoutY(100.0D);
                bar.setMinWidth(300.0D);
                preGroup.getChildren().add(bar);
                Task task = new Task() {
                    protected Void call() throws Exception {
                        Files.walkFileTree(startPath, pf);
                        return null;
                    }
                };
                bar.progressProperty().bind(task.progressProperty());
                (new Thread(task)).start();

                task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
                    @Override
                    public void handle(WorkerStateEvent event) {
                        bar.setVisible(false);
                        dirStatus.setVisible(false);
                        if(mainPath.equals("")) {
                            Group e = new Group();
                            e.getChildren().add(propPath);
                            propPath.setText(altPath);
                            dirFind.setText("Ресарт.");
                            dirFind.setDisable(true);
                            e.getChildren().add(makeDir);
                            e.getChildren().add(close);
                            e.getChildren().add(dirFind);
                            Scene newScene = new Scene(e, 400.0D, 200.0D);
                            preStage.setScene(newScene);
                            preStage.show();
                        } else {
                            System.out.println("Папка успешно найдена. Переходим к выбору игрока");
                            preStage.close();

                            try {
                                choseUser();
                            } catch (IOException var4) {
                                var4.printStackTrace();
                            }
                        }

                    }
                });



//                task.setOnSucceeded(new EventHandler() {
//                    public void handle(WorkerStateEvent event) {
//                        bar.setVisible(false);
//                        dirStatus.setVisible(false);
//                        if(mainPath.equals("")) {
//                            Group e = new Group();
//                            e.getChildren().add(propPath);
//                            propPath.setText(altPath);
//                            dirFind.setText("Ресарт.");
//                            dirFind.setDisable(true);
//                            e.getChildren().add(makeDir);
//                            e.getChildren().add(close);
//                            e.getChildren().add(dirFind);
//                            Scene newScene = new Scene(e, 400.0D, 200.0D);
//                            preStage.setScene(newScene);
//                            preStage.show();
//                        } else {
//                            System.out.println("Папка успешно найдена. Переходим к выбору игрока");
//                            preStage.close();
//
//                            try {
//                                choseUser();
//                            } catch (IOException var4) {
//                                var4.printStackTrace();
//                            }
//                        }
//
//                    }
//                });

                if(mainPath != "") {
                    dirStatus.setText(dirStatus.getText() + "      Ура!!!! Нашли!!!");
                }

            }
        });


        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                preStage.close();
            }
        });


//        close.setOnMouseClicked(new EventHandler() {
//            public void handle(MouseEvent event) {
//                preStage.close();
//            }
//        });



        makeDir.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dirFind.setDisable(false);
                propPath.setText(propPath.getText() + "/HUpoker");
                (new File(propPath.getText())).mkdirs();
                File check = new File(propPath.getText());
                if(check.isHidden()) {
                    System.out.println("Cant make");
                    propPath.setText("Не удалось создать папку. Выберите другой путь.");
                } else {
                    System.out.println("I did it!");
                }
            }
        });


//        makeDir.setOnMouseClicked(new EventHandler() {
//            public void handle(MouseEvent event) {
//                dirFind.setDisable(false);
//                propPath.setText(propPath.getText() + "/HUpoker");
//                (new File(propPath.getText())).mkdirs();
//                File check = new File(propPath.getText());
//                if(check.isHidden()) {
//                    System.out.println("Cant make");
//                    propPath.setText("Не удалось создать папку. Выберите другой путь.");
//                } else {
//                    System.out.println("I did it!");
//                }
//
//            }
//        });
    }

    public void choseUser() throws IOException {
        System.out.println("Переходим к выбору игрока!");
        final Stage userStage = new Stage();
        Group userGroup = new Group();
        final ArrayList findedUsers = new ArrayList();
        final ObservableList users = FXCollections.observableArrayList(findedUsers);
        Task task = new Task() {
            protected Void call() throws Exception {
                File serchDir = new File(mainPath + "/User");
                File[] temp = serchDir.listFiles();
                int i = 0;

                for(int size = temp.length; i < size; ++i) {
                    if(temp[i].getName().endsWith(".txt")) {
                        System.out.println(temp[i].getName());
                        findedUsers.add(temp[i].getName());
                    }
                }

                return null;
            }
        };


        (new Thread(task)).start();

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                users.setAll(findedUsers);
            }
        });

//        task.setOnSucceeded(new EventHandler() {
//            public void handle(WorkerStateEvent event) {
//                hw5.users.setAll(findedUsers);
//            }
//        });



        Text anonce = new Text("Или создайте нового.");
        anonce.setLayoutX(30.0D);
        anonce.setLayoutY(250.0D);
        final TextField newName = new TextField("Введите имя нового игрока");
        newName.setLayoutX(30.0D);
        newName.setLayoutY(260.0D);
        newName.setMinWidth(260.0D);
        newName.setEditable(true);
        Button create = new Button("Create");
        create.setLayoutX(320.0D);
        create.setLayoutY(260.0D);
        Button chose = new Button("Chose");
        chose.setLayoutX(320.0D);
        chose.setLayoutY(30.0D);
        Text anonce1 = new Text("Выберите существующего игрока.");
        anonce1.setLayoutX(30.0D);
        anonce1.setLayoutY(20.0D);
        ComboBox userList = new ComboBox(users);
        userList.setLayoutX(30.0D);
        userList.setLayoutY(30.0D);
        userList.setMinWidth(260.0D);
        userList.setAccessibleText("Chose existing user.");
        userGroup.getChildren().add(newName);
        userGroup.getChildren().add(create);
        userGroup.getChildren().add(userList);
        userGroup.getChildren().add(chose);
        userGroup.getChildren().add(anonce);
        userGroup.getChildren().add(anonce1);
        Scene userScene = new Scene(userGroup, 400.0D, 300.0D);
        userStage.setScene(userScene);
        userStage.show();


//        newName.setOnMouseClicked(new EventHandler() {
//            public void handle(MouseEvent event) {
//                newName.setText("");
//            }
//        });
//

        newName.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                newName.setText("");
            }
        });


        chose.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                userStage.close();
                plane.show();
            }
        });


//        chose.setOnMouseClicked(new EventHandler() {
//            public void handle(MouseEvent event) {
//                userStage.close();
//                plane.show();
//            }
//        });
    }

    public void toss() {
        deck.shuffleDeck();
        int myToss = deck.getCard(1).intValue();
        String stringMyToss = "file:/Users/elenabugercuk/Documents/workspace/img/" + myToss + ".jpg";
        int compToss = deck.getCard(2).intValue();
        String stringCompToss = "file:/Users/elenabugercuk/Documents/workspace/img/" + compToss + ".jpg";
        Image imageMyToss = new Image(stringMyToss, 100.0D, 200.0D, true, true);
        Image imageCompToss = new Image(stringCompToss, 100.0D, 200.0D, true, true);
        myCard1.setImage(imageMyToss);
        compCard1.setImage(imageCompToss);
        if(myToss - myToss / 100 * 100 == 1) {
            myToss += 14;
        }

        if(compToss - compToss / 100 * 100 == 1) {
            compToss += 14;
        }

        if(myToss - myToss / 100 * 100 > compToss - compToss / 100 * 100) {
            cash.compDealer = false;
            dealerY = 370;
        } else {
            cash.compDealer = true;
            dealerY = 90;
        }

        if(myToss - myToss / 100 * 100 == compToss - compToss / 100 * 100 && myToss > compToss) {
            cash.compDealer = false;
            dealerY = 370;
        }

        button.setLayoutY((double)dealerY);
        RotateTransition proba = new RotateTransition(Duration.millis(1000.0D));
        if(cash.compDealer) {
            proba.setNode(compCard1);
        } else {
            proba.setNode(myCard1);
        }

        proba.setByAngle(180.0D);
        proba.setCycleCount(1);
        proba.setAutoReverse(false);
        PauseTransition pause = new PauseTransition(Duration.seconds(1.0D));
        SequentialTransition sequence = new SequentialTransition(new Animation[]{pause, proba});
        sequence.play();
    }

    public void whoWin(int[] human, int[] comp) {
        System.out.println("Процесс определения победителя");
        byte size = 6;
        int i = 0;

        byte result;
        for(result = 0; i < size; ++i) {
            if(human[i] > comp[i]) {
                result = 1;
                break;
            }

            if(human[i] < comp[i]) {
                result = -1;
                break;
            }
        }

        if(result == 0) {
            System.out.println(" Ничья.");
            showTempText.setText(showTempText.getText() + " SPLIT");
            cash.split();
        }

        if(result == 1) {
            System.out.println(" Человек победил.");
            showTempText.setText(showTempText.getText() + " Human WIN");
            cash.humanWin();
        }

        if(result == -1) {
            System.out.println("Выиграл компьютер.");
            showTempText.setText(showTempText.getText() + " Comp WIN");
            cash.compWin();
        }

    }

    public class Analysis {
        int[] preflopStrategy = new int[8];
        int[] flopStrategy = new int[8];
        int[] turnStrategy = new int[8];
        int[] riverStrategy = new int[8];
        String[] power = new String[]{"323023o", "332024o", "340826o", "342925o", "345827o", "351534o", "359832s", "360836o", "362735o", "366037o", "368328o", "368342s", "374838o", "376762s", "378552s", "380146o", "381645o", "381672s", "385547o", "386443s", "391029o", "394748o", "395363s", "396953s", "399456o", "400239o", "400473s", "402782s", "405157o", "406749o", "408783s", "413364s", "414358o", "414554s", "41692to", "418574s", "423267o", "424292s", "42603to", "426759o", "427084s", "431365s", "432468o", "432693s", "43504to", "436875s", "438694s", "44235to", "44352jo", "444969o", "445585s", "4484t2s", "450578o", "45283jo", "4569t3s", "457295s", "458776s", "46106to", "46194jo", "462486s", "463079o", "4653t4s", "47185jo", "4722t5s", "47302qo", "4738j2s", "474396s", "47846jo", "47917to", "479487s", "481089o", "48223qo", "4823j3s", "4894t6s", "4907j4s", "491297s", "49134qo", "49687jo", "49728to", "4999j5s", "50125qo", "5017q2s", "503322o", "50512ko", "5061j6s", "5064t7s", "508098s", "5102q3s", "51026qo", "51433ko", "51498jo", "51539to", "51777qo", "5186q4s", "52334ko", "5233t8s", "5233j7s", "5277q5s", "5321k2s", "53259jo", "53315ko", "53608qo", "5361q6s", "536933o", "5402j8s", "5403t9s", "5406k3s", "54226ko", "5430q7s", "5489k4s", "54932ao", "55197ko", "5529tjo", "55369qo", "5566j9s", "5579k5s", "55853ao", "5602q8s", "56028ko", "5664k6s", "56734ao", "570244o", "5730tqo", "5738a2s", "5753jts", "5754k7s", "5766q9s", "57686ao", "57705ao", "57819ko", "5814jqo", "5822a3s", "5831k8s", "58847ao", "5903a4s", "5940tko", "5947qts", "59878ao", "5991a6s", "5992a5s", "5999k9s", "6026qjs", "603355o", "6057jko", "60779ao", "6098a7s", "6146qko", "6179kts", "6194a8s", "6257kjs", "6272tao", "6278a9s", "632966o", "6340kqs", "6356jao", "6443qao", "6460ats", "6532kao", "6540ajs", "6621aqs", "662477o", "6705aks", "691688o", "720699o", "7501tto", "7747jjo", "7993qqo", "8240kko", "8520aao"};

        public Analysis() {
        }

        public int[] WinCombination(int card1, int card2) {
            int[] result = new int[6];
            int[] nabor = new int[]{card1, card2, deck.getCard(5).intValue(), deck.getCard(6).intValue(), deck.getCard(7).intValue(), deck.getCard(8).intValue(), deck.getCard(9).intValue()};
            HashMap royal = new HashMap();
            royal.put(Integer.valueOf(nabor[0]), "");
            royal.put(Integer.valueOf(nabor[1]), "");
            royal.put(Integer.valueOf(nabor[2]), "");
            royal.put(Integer.valueOf(nabor[3]), "");
            royal.put(Integer.valueOf(nabor[4]), "");
            royal.put(Integer.valueOf(nabor[5]), "");
            royal.put(Integer.valueOf(nabor[6]), "");
            if(royal.containsKey(Integer.valueOf(101)) && royal.containsKey(Integer.valueOf(110)) && royal.containsKey(Integer.valueOf(111)) && royal.containsKey(Integer.valueOf(112)) && royal.containsKey(Integer.valueOf(113))) {
                System.out.println("Найден флеш!!!");
                showTempText.setText(showTempText.getText() + " Рояль ");
                result[0] = 9;
                return result;
            } else if(royal.containsKey(Integer.valueOf(201)) && royal.containsKey(Integer.valueOf(210)) && royal.containsKey(Integer.valueOf(211)) && royal.containsKey(Integer.valueOf(212)) && royal.containsKey(Integer.valueOf(213))) {
                System.out.println("Найден флеш!!!");
                showTempText.setText(showTempText.getText() + " Рояль ");
                result[0] = 9;
                return result;
            } else if(royal.containsKey(Integer.valueOf(301)) && royal.containsKey(Integer.valueOf(310)) && royal.containsKey(Integer.valueOf(311)) && royal.containsKey(Integer.valueOf(312)) && royal.containsKey(Integer.valueOf(313))) {
                System.out.println("Найден флеш!!!");
                showTempText.setText(showTempText.getText() + " Рояль ");
                result[0] = 9;
                return result;
            } else if(royal.containsKey(Integer.valueOf(401)) && royal.containsKey(Integer.valueOf(410)) && royal.containsKey(Integer.valueOf(411)) && royal.containsKey(Integer.valueOf(412)) && royal.containsKey(Integer.valueOf(413))) {
                System.out.println("Найден флеш!!!");
                showTempText.setText(showTempText.getText() + " Рояль ");
                result[0] = 9;
                return result;
            } else {
                HashMap straitFlash = new HashMap();
                straitFlash.put(Integer.valueOf(nabor[0]), "");
                straitFlash.put(Integer.valueOf(nabor[1]), "");
                straitFlash.put(Integer.valueOf(nabor[2]), "");
                straitFlash.put(Integer.valueOf(nabor[3]), "");
                straitFlash.put(Integer.valueOf(nabor[4]), "");
                straitFlash.put(Integer.valueOf(nabor[5]), "");
                straitFlash.put(Integer.valueOf(nabor[6]), "");

                int i;
                for(i = 0; i < 7; ++i) {
                    Integer care = Integer.valueOf(nabor[i]);
                    Integer checkCare = Integer.valueOf(care.intValue() - 1);
                    Integer full = Integer.valueOf(care.intValue() - 2);
                    Integer checkFull = Integer.valueOf(care.intValue() - 3);
                    Integer flash = Integer.valueOf(care.intValue() - 4);
                    Integer s = Integer.valueOf(care.intValue() + 1);
                    Integer h = Integer.valueOf(care.intValue() + 2);
                    if(straitFlash.containsKey(checkCare) && straitFlash.containsKey(full) && straitFlash.containsKey(checkFull) && straitFlash.containsKey(flash)) {
                        System.out.println("Редкий случай Стрит флэш!!!!");
                        result[0] = 8;
                        if(straitFlash.containsKey(s)) {
                            if(straitFlash.containsKey(h)) {
                                result[1] = h.intValue();
                            } else {
                                result[1] = s.intValue();
                            }
                        } else {
                            result[1] = care.intValue();
                        }

                        showTempText.setText(showTempText.getText() + " Стреет флэш " + result[1]);
                        return result;
                    }
                }

                boolean var28 = false;
                int[] var29 = new int[7];

                for(i = 0; i < 7; ++i) {
                    var29[i] = nabor[i] - nabor[i] / 100 * 100;
                    if(var29[i] == 1) {
                        var29[i] = 14;
                    }
                }

                int[] var30 = new int[15];

                for(i = 0; i < 7; ++i) {
                    ++var30[var29[i]];
                }

                for(i = 0; i > 0; ++i) {
                    if(var30[i] > 3) {
                        System.out.println("Найдена каре!!!!");
                        showTempText.setText(showTempText.getText() + " Каре ");
                        result[0] = 7;
                        result[1] = i;

                        for(int var31 = 14; var31 > 0; --var31) {
                            if(var31 != i && var30[var31] > 0) {
                                result[2] = var31;
                                var31 = 1;
                            }
                        }

                        showTempText.setText(showTempText.getText() + " Каре " + result[1] + " " + result[2]);
                        return result;
                    }
                }

                int[] var33 = new int[7];

                for(i = 0; i < 7; ++i) {
                    var33[i] = nabor[i] - nabor[i] / 100 * 100;
                    if(var33[i] == 1) {
                        var33[i] = 14;
                    }
                }

                int[] var32 = new int[15];

                for(i = 0; i < 7; ++i) {
                    ++var32[var33[i]];
                }

                for(i = 14; i > 0; --i) {
                    if(var32[i] == 3) {
                        for(int var34 = 14; var34 > 0; --var34) {
                            if(var32[var34] >= 2 && i != var34) {
                                System.out.println("Найден фулл-хаус!!!!");
                                result[0] = 6;
                                result[1] = i;
                                result[2] = var34;
                                showTempText.setText(showTempText.getText() + " Фулл-хаус " + result[1] + " " + result[2]);
                                return result;
                            }
                        }
                    }
                }

                int[] var35 = new int[7];

                for(i = 0; i < 7; ++i) {
                    var35[i] = nabor[i] / 100;
                    if(var35[i] == 1) {
                        var35[i] = 14;
                    }
                }

                int var36 = 0;
                int var37 = 0;
                int d = 0;
                int c = 0;

                for(i = 0; i < 7; ++i) {
                    if(var35[i] == 1) {
                        ++c;
                    }

                    if(var35[i] == 2) {
                        ++d;
                    }

                    if(var35[i] == 3) {
                        ++var37;
                    }

                    if(var35[i] == 4) {
                        ++var36;
                    }
                }

                int[] trips;
                if(c <= 4 && d <= 4 && var37 <= 4 && var36 <= 4) {
                    int[] var38 = new int[7];

                    for(i = 0; i < 7; ++i) {
                        var38[i] = nabor[i] - nabor[i] / 100 * 100;
                        if(var38[i] == 1) {
                            var38[i] = 14;
                        }
                    }

                    int[] var39 = new int[15];

                    for(i = 0; i < 7; ++i) {
                        ++var39[var38[i]];
                    }

                    if(var39[14] != 0) {
                        var39[1] = 1;
                    }

                    i = 14;
                    System.out.println("preStraight" + Arrays.toString(var38));
                    System.out.println("Straight" + Arrays.toString(var39));

                    while(i > 4) {
                        if(var39[i] * var39[i - 1] * var39[i - 2] * var39[i - 3] * var39[i - 4] != 0) {
                            System.out.println("Найден Стрит!!!!!");
                            result[0] = 4;
                            result[1] = i;
                            showTempText.setText(showTempText.getText() + " Стрит " + result[1]);
                            return result;
                        }

                        --i;
                    }

                    trips = new int[7];

                    for(i = 0; i < 7; ++i) {
                        trips[i] = nabor[i] - nabor[i] / 100 * 100;
                        if(trips[i] == 1) {
                            trips[i] = 14;
                        }
                    }

                    int[] var40 = new int[15];

                    for(i = 0; i < 7; ++i) {
                        ++var40[trips[i]];
                    }

                    for(i = 14; i > 0; --i) {
                        if(var40[i] > 2) {
                            System.out.println("Найдена тройка!!!!");
                            result[0] = 3;
                            result[1] = i;
                            int twoPair = 14;

                            for(int checkTwoPair = 2; twoPair > 0; --twoPair) {
                                if(i != twoPair && var40[twoPair] > 0) {
                                    result[checkTwoPair] = twoPair;
                                    ++checkTwoPair;
                                }

                                if(checkTwoPair == 4) {
                                    twoPair = 1;
                                }
                            }

                            showTempText.setText(showTempText.getText() + " Тройка " + result[1] + " " + result[2] + " " + result[3]);
                            return result;
                        }
                    }

                    int[] var41 = new int[7];

                    for(i = 0; i < 7; ++i) {
                        var41[i] = nabor[i] - nabor[i] / 100 * 100;
                        if(var41[i] == 1) {
                            var41[i] = 14;
                        }
                    }

                    int[] var42 = new int[15];

                    for(i = 0; i < 7; ++i) {
                        ++var42[var41[i]];
                    }

                    for(i = 14; i > 0; --i) {
                        if(var42[i] == 2) {
                            for(int pair = 14; pair > 0; --pair) {
                                if(var42[pair] == 2 && i != pair) {
                                    System.out.println("Найденo ДВЕ Пары");
                                    result[0] = 2;
                                    result[1] = i;
                                    result[2] = pair;

                                    for(int checkPair = 14; checkPair > 0; --checkPair) {
                                        if(checkPair != i && checkPair != pair && var42[checkPair] > 0) {
                                            result[3] = checkPair;
                                            checkPair = 1;
                                        }
                                    }

                                    showTempText.setText(showTempText.getText() + " ДВЕ Пары " + result[1] + " " + result[2] + " " + result[3]);
                                    return result;
                                }
                            }
                        }
                    }

                    int[] var43 = new int[7];

                    for(i = 0; i < 7; ++i) {
                        var43[i] = nabor[i] - nabor[i] / 100 * 100;
                        if(var43[i] == 1) {
                            var43[i] = 14;
                        }
                    }

                    int[] var44 = new int[15];

                    for(i = 0; i < 7; ++i) {
                        ++var44[var43[i]];
                    }

                    System.out.println("Ранги" + Arrays.toString(var44));

                    for(i = 14; i > 0; --i) {
                        if(var44[i] > 1) {
                            System.out.println("Найдена пара!!!!");
                            result[0] = 1;
                            result[1] = i;
                            int high = 14;

                            for(int checkHigh = 2; high > 0; --high) {
                                if(high != i && var44[high] > 0) {
                                    result[checkHigh] = high;
                                    ++checkHigh;
                                }

                                if(checkHigh == 5) {
                                    high = 1;
                                }
                            }

                            showTempText.setText(showTempText.getText() + " Пара " + result[1] + " " + result[2] + " " + result[3]);
                            return result;
                        }
                    }

                    int[] var45 = new int[7];

                    for(i = 0; i < 7; ++i) {
                        var45[i] = nabor[i] - nabor[i] / 100 * 100;
                        if(var45[i] == 1) {
                            var45[i] = 14;
                        }
                    }

                    int[] var46 = new int[15];

                    for(i = 0; i < 7; ++i) {
                        ++var46[var45[i]];
                    }

                    result[0] = 0;
                    i = 14;

                    for(int k = 1; i > 0 && k < 6; --i) {
                        if(var46[i] > 0) {
                            result[k] = i;
                            ++k;
                        }
                    }

                    System.out.println("Всего лишь старшая карта.");
                    showTempText.setText(showTempText.getText() + " Хай " + result[1] + " " + result[2]);
                    return result;
                } else {
                    System.out.println("Найден флеш!!!");
                    result[0] = 5;
                    short straight = 415;
                    short checkStraight = 100;
                    if(c > 4) {
                        straight = 115;
                    }

                    if(d > 4) {
                        checkStraight = 200;
                        straight = 215;
                    }

                    if(var37 > 4) {
                        checkStraight = 300;
                        straight = 315;
                    }

                    if(var36 > 4) {
                        checkStraight = 400;
                    }

                    trips = new int[15];

                    for(i = 0; i < 7; ++i) {
                        if(nabor[i] > checkStraight && nabor[i] < straight) {
                            ++trips[nabor[i] - checkStraight];
                        }
                    }

                    System.out.println("Flash" + Arrays.toString(trips));
                    i = 14;

                    for(int checkTrips = 1; i > 0; --i) {
                        if(trips[i] > 0) {
                            result[checkTrips] = i;
                            ++checkTrips;
                        }

                        if(checkTrips == 6) {
                            i = 1;
                        }
                    }

                    showTempText.setText(showTempText.getText() + " Флеш " + result[1] + " " + result[2] + " " + result[3]);
                    return result;
                }
            }
        }

        public void preflopStrategyDispetcher() {
            preflopGreenGreen();
        }

        public void flopStrategyDispetcher() {
        }

        public void turnStrategyDispetcher() {
        }

        public void riverStrategyDispetcher() {
        }

        public void preflopGreenGreen() {
            step = false;
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(3) + ".jpg";
            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(4) + ".jpg";
            Image preflop1 = new Image(temp1, 100.0D, 200.0D, true, true);
            Image preflop2 = new Image(temp2, 100.0D, 200.0D, true, true);
            compCard1.setImage(preflop1);
            compCard2.setImage(preflop2);
            System.out.println("Начало анализа.");
            Arrays.fill(preflopStrategy, 0);
            String compHand = stringHand(deck.getCard(3).intValue(), deck.getCard(4).intValue());
            String altHand = "" + compHand.charAt(1) + compHand.charAt(0) + compHand.charAt(2);
            String procent = "";

            for(int i = 0; i < 169; ++i) {
                if(analysis.power[i].endsWith(compHand) || analysis.power[i].endsWith(altHand)) {
                    procent = analysis.power[i].substring(0, 4);
                }
            }

            System.out.println(procent);
            int chance = Integer.parseInt(procent);
            String desition = "";
            if(chance < 4990) {
                desition = "Я бы пассaнул...        ";
                int last = handLog.size() - 1;
                String lastbetSize1 = ((String)handLog.get(last)).substring(8);
                String lastbetSize2 = ((String)handLog.get(last - 1)).substring(8);
                if(lastbetSize1.equals(lastbetSize2)) {
                    cash.compChecCall();
                    System.out.println("Комп играет чек  на блайнде");
                } else {
                    cash.compPass();
                }
            }

            if(chance >= 4990 && chance < 5180) {
                desition = "Играю колл пасс.      ";
                cash.compChecCall();
            }

            if(chance >= 5180 && chance < 5900) {
                desition = "Играю колл колл.       ";
                cash.compChecCall();
            }

            if(chance >= 5900 && chance < 6300) {
                desition = "Играю бет разумный колл.        ";
                cash.compRaise();
            }

            if(chance >= 6300 && chance < 6600) {
                desition = "Играю бет большой колл.         ";
                cash.compRaise();
            }

            if(chance >= 6600) {
                desition = "Играю бет оллин.           ";
                cash.compRaise();
            }

            showTempText.setText(desition);
            superBrain();
        }

        public String stringHand(int card1, int card2) {
            String begin = "";
            String middle = "";
            String end = "";
            int rang1 = card1 - card1 / 100 * 100;
            int rang2 = card2 - card2 / 100 * 100;
            if(rang1 == 1) {
                begin = "a";
            }

            if(rang2 == 1) {
                middle = "a";
            }

            if(rang1 > 1 && rang1 < 10) {
                begin = "" + rang1;
            }

            if(rang2 > 1 && rang2 < 10) {
                middle = "" + rang2;
            }

            if(rang1 == 10) {
                begin = "t";
            }

            if(rang1 == 11) {
                begin = "j";
            }

            if(rang1 == 12) {
                begin = "q";
            }

            if(rang1 == 13) {
                begin = "k";
            }

            if(rang2 == 10) {
                middle = "t";
            }

            if(rang2 == 11) {
                middle = "j";
            }

            if(rang2 == 12) {
                middle = "q";
            }

            if(rang2 == 13) {
                middle = "k";
            }

            if(card1 / 100 == card2 / 100) {
                end = "s";
            } else {
                end = "o";
            }

            String result = begin + middle + end;
            return result;
        }

        public void handEnd() {
            int[] humaComb = new int[6];
            humaComb = analysis.WinCombination(deck.getCard(1).intValue(), deck.getCard(2).intValue());
            int[] compComb = new int[6];
            compComb = analysis.WinCombination(deck.getCard(3).intValue(), deck.getCard(4).intValue());
            System.out.println("Человек " + Arrays.toString(humaComb));
            System.out.println("Компьютер " + Arrays.toString(compComb));
            whoWin(humaComb, compComb);
        }
    }

    public class Cash {
        int myStack = 1500;
        int compStack = 1500;
        int pot = 0;
        int myBet = 0;
        int compBet = 0;
        int level = 0;
        int[] blind = new int[]{20, 30, 40, 50, 60, 80, 100, 120, 150, 200, 250, 300, 400, 500};
        boolean compDealer = true;
        int myM;
        int compM;
        boolean compAgressor;

        public Cash() {
        }

        public void makeBlind() {
            if(compDealer) {
                compAgressor = false;
                if(blind[level] / 2 > compStack) {
                    compBet = compStack;
                } else {
                    compBet = blind[level] / 2;
                }

                if(compBet == compStack) {
                    myBet = compBet;
                }

                if(blind[level] > myStack) {
                    myBet = myStack;
                } else {
                    myBet = blind[level];
                }

                if(myBet < compBet) {
                    compBet = myBet;
                }

                handLog.add("compblin" + compBet);
                handLog.add("humablin" + myBet);
            } else {
                compAgressor = true;
                if(blind[level] / 2 > myStack) {
                    myBet = myStack;
                } else {
                    myBet = blind[level] / 2;
                }

                if(myBet == myStack) {
                    compBet = myBet;
                }

                if(blind[level] > compStack) {
                    compBet = compStack;
                } else {
                    compBet = blind[level];
                }

                if(compBet < myBet) {
                    myBet = compBet;
                }

                handLog.add("humablin" + myBet);
                handLog.add("compblin" + compBet);
            }

            compStack -= compBet;
            myStack -= myBet;
            showMyBet.setText("" + myBet);
            showCompBet.setText("" + compBet);
            showCompStackValue.setText("" + compStack);
            showMyStackValue.setText("" + myStack);
        }

        public void humanCheckCall() {
            System.out.println("Человек играет чек/колл");
            int delta = cash.compBet - cash.myBet;
            cash.myBet += delta;
            cash.myStack -= delta;
            String toLog = "huma" + phase + cash.compBet;
            handLog.add(toLog);
            System.out.println(handLog.toString());
            showMyBet.setText("" + cash.myBet);
            showMyStackValue.setText("" + cash.myStack);
            superBrain();
        }

        public void compChecCall() {
            System.out.println("CompBet=" + cash.compBet);
            System.out.println("Играю Чек/Кол");
            showTempText.setText("Играю Чек/Колл");
            int delta = cash.myBet - cash.compBet;
            cash.compBet += delta;
            cash.compStack -= delta;
            showCompBet.setText("" + cash.compBet);
            showCompStackValue.setText("" + cash.compStack);
            String toLog = "comp" + phase + cash.compBet;
            handLog.add(toLog);
            System.out.println(handLog.toString());
            superBrain();
        }

        public void compPass() {
            System.out.println("Играю пас");
            showTempText.setText("Пас!");
            String toLog = "comp" + phase + "0";
            handLog.add(toLog);
            System.out.println(handLog.toString());
            cash.pot = cash.pot + cash.myBet + cash.compBet;
            cash.myStack += cash.pot;
            cash.myBet = 0;
            cash.compBet = 0;
            cash.pot = 0;
            showMyStackValue.setText("" + cash.myStack);
            showBank.setText("0");
            newHand.run();
        }

        public void compRaise() {
            compAgressor = true;
            boolean delta = false;
            int delta1;
            if(cash.pot == 0) {
                delta1 = 3 * cash.blind[level] - cash.compBet;
            } else {
                delta1 = cash.pot / 2 - cash.compBet;
            }

            cash.compBet += delta1;
            cash.compStack -= delta1;
            showCompStackValue.setText("" + cash.compStack);
            showCompBet.setText("" + cash.compBet);
            String toLog = "comp" + phase + cash.compBet;
            handLog.add(toLog);
            System.out.println(handLog.toString());
            superBrain();
        }

        public void humanWin() {
            cash.pot = cash.pot + cash.myBet + cash.compBet;
            cash.myBet = 0;
            cash.compBet = 0;
            cash.myStack += cash.pot;
            cash.pot = 0;
            showBank.setText("0");
            showMyStackValue.setText("" + cash.myStack);
            showMyBet.setText("0");
            showCompBet.setText("0");
        }

        public void compWin() {
            cash.pot = cash.pot + cash.myBet + cash.compBet;
            cash.myBet = 0;
            cash.compBet = 0;
            cash.compStack += cash.pot;
            cash.pot = 0;
            showBank.setText("0");
            showCompStackValue.setText("" + cash.compStack);
            showMyBet.setText("0");
            showCompBet.setText("0");
        }

        public void split() {
            cash.pot = cash.pot + cash.myBet + cash.compBet;
            cash.myBet = 0;
            cash.compBet = 0;
            if(cash.pot % 2 == 1) {
                if(compDealer) {
                    --cash.pot;
                    ++cash.myStack;
                } else {
                    --cash.pot;
                    ++cash.compStack;
                }
            }

            cash.myStack += cash.pot / 2;
            cash.compStack += cash.pot / 2;
            cash.pot = 0;
            showCompStackValue.setText("" + cash.compStack);
            showCompStackValue.setText("" + cash.myStack);
            showBank.setText("0");
            showMyBet.setText("0");
            showCompBet.setText("0");
        }
    }

    public class Countdown extends Thread {
        private int minute = 0;

        public Countdown() {
        }

        public Countdown(int minute) {
            this.minute = minute;
        }

        public void run() {
            int maxTime = minute * 60;
            boolean i = false;
            boolean repeat = true;

            while(repeat) {
                int minu;
                String secString;
                for(int var9 = 0; var9 < maxTime; nextTime.setText(minu + ":" + secString)) {
                    try {
                        sleep(1000L);
                    } catch (InterruptedException var8) {
                        var8.printStackTrace();
                        this.interrupt();
                        System.out.println("Timer Остановлен в слипе");
                    }

                    ++var9;
                    int temp = maxTime - var9;
                    minu = temp / 60;
                    int sec = temp - minu * 60;
                    if(sec < 10) {
                        secString = "0" + sec;
                    } else {
                        secString = "" + sec;
                    }
                }

                System.out.println(cash.level);
                ++cash.level;
                System.out.println(cash.level);
                blind.setText(cash.blind[cash.level] / 2 + "/" + cash.blind[cash.level]);
                nextLevel.setText(cash.blind[cash.level + 1] / 2 + "/" + cash.blind[cash.level + 1]);
                if(this.isInterrupted()) {
                    System.out.println("Timer Остановлен");
                    break;
                }
            }

        }
    }

    public class Deck {
        private Integer[] deck = new Integer[52];

        public Deck() {
            for(int i = 0; i < 13; ++i) {
                this.deck[i] = Integer.valueOf(101 + i);
                this.deck[i + 13] = Integer.valueOf(201 + i);
                this.deck[i + 26] = Integer.valueOf(301 + i);
                this.deck[i + 39] = Integer.valueOf(401 + i);
            }

        }

        public void shuffleDeck() {
            int i = 0;

            for(Integer transit = Integer.valueOf(0); i < 10000; ++i) {
                int firstCard = (int)(Math.random() * 52.0D);
                int secondCard = (int)(Math.random() * 52.0D);
                transit = getCard(firstCard);
                setCard(firstCard, getCard(secondCard));
                setCard(secondCard, transit);
            }

        }

        public Integer[] getDeck() {
            return this.deck;
        }

        public Integer getCard(int i) {
            return this.deck[i];
        }

        public void setCard(int number, Integer value) {
            this.deck[number] = value;
        }

        public void setDeck(Integer[] deck) {
            this.deck = deck;
        }
    }

    public class Flop extends Thread {
        public Flop() {
        }

        public void run() {
            cash.pot = cash.compBet + cash.myBet;
            cash.myBet = 0;
            cash.compBet = 0;
            showBank.setText("" + cash.pot);
            showMyBet.setText("0");
            showCompBet.setText("0");
            int intFlop1 = deck.getCard(5).intValue();
            int intFlop2 = deck.getCard(6).intValue();
            int intFlop3 = deck.getCard(7).intValue();
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + intFlop1 + ".jpg";
            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + intFlop2 + ".jpg";
            String temp3 = "file:/Users/elenabugercuk/Documents/workspace/img/" + intFlop3 + ".jpg";
            Image iFlop1 = new Image(temp1, 100.0D, 200.0D, true, true);
            Image iFlop2 = new Image(temp2, 100.0D, 200.0D, true, true);
            Image iFlop3 = new Image(temp3, 100.0D, 200.0D, true, true);
            flop1.setImage(iFlop1);
            flop2.setImage(iFlop2);
            flop3.setImage(iFlop3);
            System.out.println("В методе флоп меняем фазу на флоп");
            phase = "flop";
            superBrain();
            Thread.currentThread().interrupt();
        }
    }

    public class NewHand extends Thread {
        public NewHand() {
        }

        public void run() {
            if(cash.compDealer) {
                cash.compDealer = false;
                dealerY = 370;
                button.setLayoutY((double)dealerY);
            } else {
                cash.compDealer = true;
                dealerY = 90;
                button.setLayoutY((double)dealerY);
            }

            handLog.clear();
            Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0D, 200.0D, true, true);
            flop1.setImage(back);
            flop2.setImage(back);
            flop3.setImage(back);
            showturn.setImage(back);
            showriver.setImage(back);
            myCard1.setImage(back);
            myCard2.setImage(back);
            compCard1.setImage(back);
            compCard2.setImage(back);

            try {
                sleep(1000L);
            } catch (InterruptedException var3) {
                var3.printStackTrace();
                this.interrupt();
                System.out.println("NewHand Остановлен в слипе");
            }

            cash.makeBlind();
            preflop.run();
            Thread.currentThread().interrupt();
        }
    }

    public class Opponent implements Serializable {
        String name;
        int oppHands;
        double oppWinnings;
        double oppOverBet;
        double oppVpp;
        double oppPfr;
        double opp3bet;
        double opp4bet;
        double oppFold3bet;
        double oppContbet;
        double oppFoldcontbet;
        double oppCheckraise;
        double oppBetRiver;
        double oppblockBetRiver;
        double oppOverBettRiver;
        double oppWentShowdown;
        double oppWinshodown;
        double oppWinriveraction;
        double oppWinBlockBetRiver;
        double oppWinOverBetRiver;

        public Opponent() {
        }
    }

    public class Preflop extends Thread {
        public Preflop() {
        }

        public void run() {
            deck.shuffleDeck();
            System.out.println("Shuffle");
            int my1 = deck.getCard(1).intValue();
            int my2 = deck.getCard(2).intValue();
            System.out.println(my1 + " " + my2);
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my1 + ".jpg";
            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my2 + ".jpg";
            Image preflop1 = new Image(temp1, 100.0D, 200.0D, true, true);
            Image preflop2 = new Image(temp2, 100.0D, 200.0D, true, true);
            myCard1.setImage(preflop1);
            myCard2.setImage(preflop2);
            System.out.print("В методе preflop.run Меняем стадию " + phase + "на ");
            phase = "pref";
            System.out.println(phase);
            superBrain();
            Thread.currentThread().interrupt();
        }
    }

    public class PrintFiles extends SimpleFileVisitor<Path> {
        public PrintFiles() {
        }

        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
            if((dir.endsWith("Program Files") || dir.endsWith("Applications")) && finded) {
                altPath = "" + dir;
                finded = false;
                System.out.println("Потенциально " + dir + " Размер " + altPath.length() + " " + finded);
            }

            if(dir.endsWith("HUPoker")) {
                System.out.println("Найдена дирректория");
                mainPath = "" + dir;
                System.out.println(mainPath);
                dirStatus.setText(mainPath);
                return FileVisitResult.TERMINATE;
            } else {
                return FileVisitResult.CONTINUE;
            }
        }

        public FileVisitResult visitFileFailed(Path file, IOException exc) {
            System.err.println(exc);
            return FileVisitResult.CONTINUE;
        }
    }

    public class River extends Thread {
        public River() {
        }

        public void run() {
            int intRiver = deck.getCard(9).intValue();
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + intRiver + ".jpg";
            Image iRiver = new Image(temp1, 100.0D, 200.0D, true, true);
            showriver.setImage(iRiver);
            phase = "rive";
            superBrain();
            Thread.currentThread().interrupt();
        }
    }

    public class Turn extends Thread {
        public Turn() {
        }

        public void run() {
            int intTurn = deck.getCard(8).intValue();
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + intTurn + ".jpg";
            Image iTurn = new Image(temp1, 100.0D, 200.0D, true, true);
            showturn.setImage(iTurn);
            phase = "turn";
            superBrain();
            Thread.currentThread().interrupt();
        }
    }
}
