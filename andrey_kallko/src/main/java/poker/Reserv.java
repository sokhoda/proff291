//package poker;/**
// * Created by tri___ton on 04.01.16.
// */
//
//
//
//import javafx.animation.*;
//import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.concurrent.Task;
//import javafx.concurrent.WorkerStateEvent;
//import javafx.event.ActionEvent;
//import javafx.event.Event;
//import javafx.event.EventHandler;
//import javafx.geometry.Pos;
//import javafx.scene.Group;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.MouseEvent;
//import javafx.scene.paint.Color;
//import javafx.scene.text.Font;
//import javafx.stage.Stage;
//import javafx.scene.text.Text;
//import javafx.stage.WindowEvent;
//import javafx.util.Duration;
//import scala.Int;
//
//
//import java.io.File;
//import java.io.IOException;
//import java.io.Serializable;
//import java.nio.file.*;
//import java.nio.file.attribute.BasicFileAttributes;
//import java.util.*;
//
//
//public class Table extends Application {
//    Stage plane = new Stage();
//    private Text nextTime = new Text();  //счетчик до следующего уровня
//    private Countdown level = new Countdown(6); // класс поток обратный таймер в минутах
//    private Preflop preflop = new Preflop(); // класс поток раздача префлоп
//    private Flop flop = new Flop(); // класс поток раздача флоп
//    private Turn turn = new Turn();
//    private River river = new River();
//    private NewHand newHand = new NewHand(); // класс поток начало новой руки. Сброс графики к началу.
//    Cash cash = new Cash(); // класс работы с фишками
//    Deck deck = new Deck(); // класс работы c колодой
//    Analysis analysis=new Analysis(); // класс работы для анализа и принятия решения компьютером
//    ImageView myCard1 = new ImageView(); // картинка моя карта1
//    ImageView myCard2 = new ImageView(); // картинка моя карта2
//    ImageView compCard1 = new ImageView(); // картинка комп карта1
//    ImageView compCard2 = new ImageView(); // картинка комп карта2
//    ImageView button = new ImageView(); // картинка кнопка диллера
//    Text blind = new Text("10/20"); // текст текущий уровень блайндов
//    Text nextLevel = new Text("15/30"); // текст следующий уровень блайндов
//    TextField betSize = new TextField(); // текстовое поле для определения уровня бета
//    int dealerY=240; // y-координата кнопки диллера
//    Text showMyBet = new Text(); // текст размер моей ставки в этом раунде
//    Text showCompBet = new Text(); // текст размер ставки компьютера в этом раунде;
//    Text showMyStackValue = new Text(); // текст размер моего стека
//    Text showCompStackValue = new Text(); //текст размер стека компьютера
//    TextField showBank = new TextField();
//    Group gPlane = new Group(); // группа картинок для графики стола
//    ImageView flop1 = new ImageView(); // картинка первоя карты флопа
//    ImageView flop2 = new ImageView(); // картинка второй карты флопа
//    ImageView flop3 = new ImageView(); // картинка третьей карты флопа
//    ImageView showturn = new ImageView(); // картинка карты терна
//    ImageView showriver = new ImageView(); // картинка карты ривера
//
//
//    // Переменные для окна предзапуска игры.
//    Text dirStatus = new Text();
//    String mainPath = new String(); // путь к основной папке, в которой хранятся профайлы игроков и архивы игры
//    String altPath = "";  // если основной папки нет комп предложит создать ее по этому адресу
//    Stage preStage = new Stage();
//    boolean finded=true; //техническая для поиска возможной дирректории
//
//
//    ArrayList <String> handLog = new ArrayList<>();// запись истории руки.
//
//
//
//
//    Text showTempText = new Text(); //временное поле текст стратегия игры компа и другие тестовые данные
//    String phase = "blin";// возможные значения blin, pref, flop, turn, rive;
//    boolean step=true;
//
//
//
//    // основной блок графики стола
//    public Table(){
//
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//
//
//    public void start(Stage primaryStage) throws Exception {
//        Table current = new Table();
//        current.begin();
//
//    }
//
//    public void superBrain(){
//        // задача superbrain определить стадию раздачи и запустить один из вариантов:
//        // * анализ и разработку стратегии компа на данной стадии
//        // * передать ход компьютеру
//        // * передать ход человеку
//        // * отрисовать флоп/терн/ривер
//        // * передать ход определителю победителя
//
//        System.out.print("Супер Мозг работает. На входе: ");
//
//        int last=handLog.size()-1;
//        System.out.println(handLog.get(last-1) + " " + handLog.get(last));
//        String subLast = handLog.get(last).substring(4);
//        String subPreLast= handLog.get(last-1).substring(4);
//
//        String stad=handLog.get(last).substring(4,8);
//
//        boolean dec=true;
//
//        // торги на этом етапе закончены.  Dве последние ставки равны и сделаны на текузей стадии. Переход к следуюзей стадии
//
//        if(((subLast.equals(subPreLast))&&(phase.equals(stad)))&&(dec)) {
//
//            dec=false;
//            System.out.println("Torgi na faze " + stad +" zakonheni. Sdaem kartu.");
//            if (stad.equals("pref")) {
//                flop.run();
//                return;
//            }
//
//
//            if (stad.equals("flop")) {
//                turn.run();
//                return;
//            }
//
//            if (stad.equals("turn")) {
//                river.run();
//                return;
//            }
//
//            if (stad.equals("rive")) {
//
//                System.out.println("Javno ktoto viigral");
//                analysis.handEnd();
//                return;
//            }
//
//            System.out.println("Что то пошло не так!");
//            return;
//
//        }
//
//
//        if ((handLog.get(last).startsWith("humapref")&&(phase.equals("flop")))&&(dec)) {
//            dec=false;
//            System.out.println("Перешли на флоп. Первум чодит человек");
//            return;
//        }
//
//
//        if ((handLog.get(last).startsWith("comppref")&&(phase.equals("flop")))&&(dec)) {
//            dec=false;
//            System.out.println("Перешли на флоп. Первум xодит komp");
//            //flopdispether а пока временно чек кол
//            cash.compChecCall();
//            return;
//        }
//
//        if ((handLog.get(last).startsWith("humablin"))&&(dec)) {
//            dec=false;
//            System.out.println("Блины поставлены. Начинаем торги.");
//            analysis.preflopStrategyDispetcher();
//            return;
//        }
//
//
//        if (((handLog.get(last-1).startsWith("compblin"))&&(handLog.get(last).startsWith("humapref")))&& (dec)){
//            dec=false;
//            System.out.println("Comp ne diller. Pora stavit preflop");
//            analysis.preflopStrategyDispetcher();
//            return;
//        }
//
//
//        if ((handLog.get(last).startsWith("huma"))&&(dec)){
//            dec=false;
//            if (phase.equals("flop")) {
//                System.out.println("Peredat hod dispecheru flopa");
//                cash.compChecCall();
//                return;
//            }
//
//            if (phase.equals("turn")) {
//                System.out.println("Peredat hod dispecheru turna");
//                cash.compChecCall();
//                return;
//            }
//
//            if (phase.equals("rive")) {
//                System.out.println("Peredat hod dispecheru rivera");
//                cash.compChecCall();
//                return;
//            }
//            System.out.println("Что то пошло не так! 2");
//
//            return;
//        }
//
//        // Устранение лисчнего цчек на флопе
//
//
//
//
//        System.out.println();
//        System.out.println("SuperMozg Reshenija ne nashel " + handLog.get(last-1) + " " + handLog.get(last) + " faza " + phase + " PredHod " + stad);
//
//
//
//
//    }
//
//    public void begin () throws Exception {
//
//
//
//        //preload.run();
//        preloader();
//
//        plane.setTitle("HeadsUp Trainer.     (c) tri___ton");
//
//
//        Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true);
//        Image dealer = new Image("file:/Users/elenabugercuk/Documents/workspace/img/dealer.gif", 50.0, 50.0, true, true);
//
//
//
//        myCard1.setImage(back);
//        myCard1.setLayoutX(5);
//        myCard1.setLayoutY(370);
//
//
//
//        myCard2.setImage(back);
//        myCard2.setLayoutX(110);
//        myCard2.setLayoutY(370);
//
//
//        compCard1.setImage(back);
//        compCard1.setLayoutX(5);
//        compCard1.setLayoutY(5);
//
//
//        compCard2.setImage(back);
//        compCard2.setLayoutX(110);
//        compCard2.setLayoutY(5);
//
//
//        flop1.setImage(back);
//        flop1.setLayoutX(240);
//        flop1.setLayoutY(190);
//
//
//        flop2.setImage(back);
//        flop2.setLayoutX(350);
//        flop2.setLayoutY(190);
//
//
//        flop3.setImage(back);
//        flop3.setLayoutX(460);
//        flop3.setLayoutY(190);
//
//
//        showturn.setImage(back);
//        showturn.setLayoutX(580);
//        showturn.setLayoutY(190);
//
//
//        showriver.setImage(back);
//        showriver.setLayoutX(700);
//        showriver.setLayoutY(190);
//
//
//        button.setImage(dealer);
//        button.setLayoutX(220);
//        button.setLayoutY(dealerY);
//
//
//
//        showBank.setAlignment(Pos.BASELINE_RIGHT);
//        showBank.setLayoutX(130);
//        showBank.setLayoutY(250);
//        showBank.setMaxWidth(80);
//        showBank.setEditable(false);
//        showBank.setText("0");
//
//
//        Text bankText = new Text();
//        bankText.setText("Pot");
//        bankText.setLayoutX(98);
//        bankText.setLayoutY(270);
//
//
//        showMyBet.setText("0");
//        showMyBet.setLayoutX(50);
//        showMyBet.setLayoutY(350);
//
//
//        showCompBet.setText("0");
//        showCompBet.setLayoutX(50);
//        showCompBet.setLayoutY(180);
//
//        Text myStack = new Text();
//        myStack.setText("Stack");
//        myStack.setLayoutX(250);
//        myStack.setLayoutY(500);
//
//
//        showMyStackValue.setFont(Font.font(20.0));
//        showMyStackValue.setText("1500");
//        showMyStackValue.setLayoutX(290);
//        showMyStackValue.setLayoutY(500);
//
//
//        Text compStack = new Text();
//        compStack.setText("Stack");
//        compStack.setLayoutX(250);
//        compStack.setLayoutY(40);
//
//
//        showCompStackValue.setFont(Font.font(20.0));
//        showCompStackValue.setText("1500");
//        showCompStackValue.setLayoutX(290);
//        showCompStackValue.setLayoutY(40);
//
//        Button toss = new Button();// клавиша жеребьевки первого хода. Исчезает после первого использования
//        toss.minHeight(200);
//        toss.minWidth(100);
//        toss.maxHeight(200);
//        toss.maxWidth(100);
//        toss.setFont(Font.font(40.0));
//        toss.setText("Toss");
//        toss.setLayoutX(670);
//        toss.setLayoutY(450);
//
//
//        Button start = new Button(); // клавиша старта игры. Появляется после жеребьевки.
//        start.minHeight(200);
//        start.minWidth(100);
//        start.maxHeight(200);
//        start.maxWidth(100);
//        start.setFont(Font.font(40.0));
//        start.setText("Start");
//        start.setLayoutX(670);
//        start.setLayoutY(350);
//
//
//        Text status = new Text("Small/Big blind");
//        status.setLayoutX(650);
//        status.setLayoutY(20);
//
//
//        blind.setText((cash.blind[cash.level]) / 2 + "/" + cash.blind[cash.level]);
//        blind.setLayoutX(770);
//        blind.setLayoutY(20);
//
//
//        Text next = new Text("Next Level");
//        next.setLayoutX(650);
//        next.setLayoutY(40);
//
//
//        nextLevel.setText((cash.blind[cash.level + 1]) / 2 + "/" + cash.blind[cash.level + 1]);
//        nextLevel.setLayoutX(770);
//        nextLevel.setLayoutY(40);
//
//
//        Text timeAnnot = new Text("Time to next level");
//        timeAnnot.setLayoutX(650);
//        timeAnnot.setLayoutY(60);
//
//
//        nextTime.setText("10:00");
//        nextTime.setLayoutX(770);
//        nextTime.setLayoutY(60);
//
//
//        Button act1 = new Button();//кнопка пасс
//        act1.setText("Pass");
//        act1.setLayoutX(400);
//        act1.setLayoutY(480);
//
//
//        Button blindCall = new Button(); // кнопка чек/колл
//        blindCall.setText("Check || Call");
//        blindCall.setLayoutX(450);
//        blindCall.setLayoutY(480);
//        blindCall.setVisible(true);
//
//
//
//
//        betSize.setAlignment(Pos.BASELINE_RIGHT);
//        betSize.setLayoutX(545);
//        betSize.setLayoutY(480);
//        betSize.setMaxWidth(80);
//        betSize.setEditable(true);
//        betSize.setText("0");
//
//
//        Button act3 = new Button();// кнопка бет/рейз
//        act3.setText("Bet | Raise");
//        act3.setLayoutX(630);
//        act3.setLayoutY(480);
//
//        Button act4 = new Button();// кнопка оллин
//        act4.setText("All In");
//        act4.setLayoutX(715);
//        act4.setLayoutY(480);
//
//
//        showTempText.setLayoutY(150);
//        showTempText.setLayoutX(300);
//        showTempText.setText("Буду думать...");
//
//
//        gPlane.getChildren().add(myCard1);
//        gPlane.getChildren().add(myCard2);
//        gPlane.getChildren().add(compCard1);
//        gPlane.getChildren().add(compCard2);
//        gPlane.getChildren().add(flop1);
//        gPlane.getChildren().add(flop2);
//        gPlane.getChildren().add(flop3);
//        gPlane.getChildren().add(showturn);
//        gPlane.getChildren().add(showriver);
//        gPlane.getChildren().add(button);  //dealer img
//        gPlane.getChildren().add(showBank);
//        gPlane.getChildren().add(bankText);
//        gPlane.getChildren().add(showMyBet);
//        gPlane.getChildren().add(myStack);
//        gPlane.getChildren().add(showCompBet);
//        gPlane.getChildren().add(showMyStackValue);
//        gPlane.getChildren().add(compStack);
//        gPlane.getChildren().add(showCompStackValue);
//        gPlane.getChildren().add(toss);
//        gPlane.getChildren().add(status);
//        gPlane.getChildren().add(blind);
//        gPlane.getChildren().add(next);
//        gPlane.getChildren().add(nextLevel);
//        gPlane.getChildren().add(timeAnnot);
//        gPlane.getChildren().add(nextTime);
//        gPlane.getChildren().add(showTempText);
//
//
//
//        // жеребьевка и добавление клавиш для основной игры
//        toss.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//                gPlane.getChildren().remove(toss);
//                gPlane.getChildren().add(start);
//
//                toss();
//
//
//            }
//        });
//
//
//        // запуск игры
//        start.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event startevent) {
//                gPlane.getChildren().remove(start);
//                gPlane.getChildren().add(act1);
//                gPlane.getChildren().add(blindCall);
//                gPlane.getChildren().add(act3);
//                gPlane.getChildren().add(act4);
//                gPlane.getChildren().add(betSize);
//                level.start();
//                myCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true));
//                compCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true));
//                cash.makeBlind();
//                preflop.start();
//            }
//        });
//
//
//        // действие по кнопке пасс
//        act1.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//                preflop.interrupt();
//                showTempText.setText("Буду думать...");
//                betSize.setText("");// сброс текстового поля размера рейза
//                cash.pot = cash.pot + cash.myBet+cash.compBet;
//                cash.compStack=cash.compStack+cash.pot;
//                cash.pot=0;
//                cash.myBet=0;
//                cash.compBet=0;
//                showCompStackValue.setText(""+cash.compStack);
//                showBank.setText("0");
//                showMyBet.setText("0");
//                showCompBet.setText("0");
//                String toLog = "huma" + phase+"0";
//                handLog.add(toLog);
//                System.out.println("Итоговая история руки ");
//                System.out.println(handLog.toString());
//
//                newHand.run();
//
//
//
//
//            }
//        });
//
//
//
//        // действие по кнопке Чек/Колл
//
//
//
//        blindCall.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//                //System.out.println("Do moego chek " + cash.compStack + " " + cash.compBet + " " + cash.pot+ " " + cash.myBet + " " + cash.myStack);
//                step=true;
//                betSize.setText("");
//                cash.myStack=cash.myStack+cash.myBet;
//                cash.myBet=cash.compBet;
//                cash.myStack=cash.myStack-cash.myBet;
//                showMyStackValue.setText(""+cash.myStack);
//                showMyBet.setText(""+cash.myBet);
//                String toLog="huma"+phase+cash.myBet;
//                // System.out.println("Posle moego chek " + cash.compStack + " " + cash.compBet + " " + cash.pot+ " " + cash.myBet + " " + cash.myStack);
//                handLog.add(toLog);
//
//                System.out.println(handLog.toString());
//
//                System.out.println("После нажатием кнопки " + phase +" " + step);
//
//                // изменение функции кнопки по мере перехода фазы.
//
//                if ((phase.equals("pref"))&&(step)) {
//                    step=false;
//                    System.out.println("Этап Flop");
////                    flop.run();
////                    event=null;
////                    System.out.println("В нажатии кнопки чек меяем стадию префлоп на флоп");
////                    phase="flop";
//                    superBrain();
//                }
//
//                if ((phase.equals("flop"))&&(step)) {
//                    step=false;
//                    System.out.println("Нажатие кнопки на флопе");
//                    superBrain();
//                }
//
//                if ((phase.equals("turn"))&&(step)) {
//                    step=false;
//
//                    System.out.println("Нажатие кнопки на терне");
//                    superBrain();
//                }
//
//
//                if ((phase.equals("rive"))&&(step)) {
//                    step=false;
//                    System.out.println("Нажатие кнопки на ривере");
//                    superBrain();
//                }
//
//
//                event=null;
//            }
//        });
//
//
//        //Действие по клавише бет/рэйз
//
//        act3.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                cash.compAgressor=false;
//            }
//        });
//
//        // действие по кнопке оллин
//
//        act4.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//
//                int bet = cash.myStack;
//                betSize.setText(""+bet);
//                event=null;
//
//            }
//        });
//
//
//
//        // закрытие потоков после закрытия основного окна
//
//        plane.setOnCloseRequest(new EventHandler<WindowEvent>() {
//            @Override
//            public void handle(WindowEvent event) {
//                preflop.interrupt();
//                level.interrupt();
//                flop.interrupt();
//                newHand.interrupt();
//
//            }
//        });
//
//        Scene planeScene = new Scene(gPlane, 840, 540);
//        plane.setScene(planeScene);
//
//
//
//
//
//    }
//
//
//
//    // проверка и настройка системы перед запуском
//
//    public void preloader() throws IOException {
//
//
//        Group preGroup = new Group();
//
//
//        File [] root = File.listRoots();
//        Path startPath = root[0].toPath(); // определение корневого каталога
//
//
//        dirStatus.setText("Нажмите для начала поиска нужной папки.");
//        dirStatus.setLayoutX(70);
//        dirStatus.setLayoutY(50);
//
//        Button dirFind = new Button("Serch");
//        dirFind.setLayoutX(180);
//        dirFind.setLayoutY(150);
//
//        preGroup.getChildren().add(dirStatus);
//        preGroup.getChildren().add(dirFind);
//
//
//        TextField propPath = new TextField();
//        propPath.setLayoutX(30);
//        propPath.setLayoutY(30);
//        propPath.setMinWidth(250);
//
//        Button close = new Button("Close");
//        close.setLayoutX(90);
//        close.setLayoutY(150);
//
//        Button makeDir = new Button("Создать");
//        makeDir.setLayoutX(310);
//        makeDir.setLayoutY(30);
//
//
//
//        Scene preScene = new Scene(preGroup, 400, 200);
//        preStage.setScene(preScene);
//        preStage.show();
//
//
//        dirFind.setOnAction(new EventHandler() {
//            @Override
//            public void handle(Event event) {
//
//
//                dirStatus.setVisible(true);
//
//                mainPath="";
//                PrintFiles pf = new PrintFiles();
//                dirStatus.setText("                     Поиск начался....");
//
//                ProgressBar bar = new ProgressBar();
//                bar.setVisible(true);
//                bar.setLayoutX(50);
//                bar.setLayoutY(100);
//                bar.setMinWidth(300);
//                preGroup.getChildren().add(bar);
//
//
//                // создание бекграундового процесса по поиску нужной папки.
//                Task<Void> task = new Task<Void>() {
//                    @Override
//                    protected Void call() throws Exception {
//                        Files.walkFileTree(startPath, pf);
//                        return null;
//                    }
//                };
//
//
//                bar.progressProperty().bind(task.progressProperty());// статус бар во время поиска папки
//                new Thread(task).start();
//
//
//                // процессы выполняемые после окончания поиска папки
//
//                task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//                    @Override
//                    public void handle(WorkerStateEvent event) {
//                        bar.setVisible(false);
//                        dirStatus.setVisible(false);
//
//
//                        if (mainPath.equals("")) {
//                            Group newGroup = new Group();
//
//                            newGroup.getChildren().add(propPath);
//                            propPath.setText(altPath);
//                            dirFind.setText("Ресарт.");
//                            dirFind.setDisable(true);
//                            newGroup.getChildren().add(makeDir);
//                            newGroup.getChildren().add(close);
//                            newGroup.getChildren().add(dirFind);
//                            Scene newScene = new Scene(newGroup, 400, 200);
//                            preStage.setScene(newScene);
//                            preStage.show();
//
//                        } else {
//                            System.out.println("Папка успешно найдена. Переходим к выбору игрока");
//                            preStage.close();
//                            try {
//                                choseUser();
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//
//
//                        }
//
//
//
//                    }
//                });
//
//                if (mainPath!=""){
//                    dirStatus.setText(dirStatus.getText() + "      Ура!!!! Нашли!!!");
//
//                }
//
//            }
//        });
//
//
//        close.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                preStage.close();
//
//            }
//        });
//
//
//
//        // !!!!!!!!!!!!!Дошлифовать создание папки с учетом возможности ручного ввода пути!!!!!!!!
//
//        makeDir.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                dirFind.setDisable(false);
//                propPath.setText(propPath.getText()+"/HUpoker");
//                new File(propPath.getText()).mkdirs();
//
//                File check = new File(propPath.getText());
//                if (check.isHidden()==true) {
//                    System.out.println("Cant make");
//                    propPath.setText("Не удалось создать папку. Выберите другой путь.");
//                } else {
//                    System.out.println("I did it!");
//                }
//            }
//        });
//
//    }
//
//
//
//
//    public void choseUser() throws IOException {
//
//        System.out.println("Переходим к выбору игрока!");
//
//
//        Stage userStage = new Stage();
//        Group userGroup = new Group();
//
//        ArrayList<String> findedUsers = new ArrayList<>();
//        ObservableList users = FXCollections.observableArrayList(findedUsers);
//
//        Task<Void> task = new Task<Void>() {
//            @Override
//            protected Void call() throws Exception {
//                File serchDir = new File(mainPath+"/User");
//                File [] temp = serchDir.listFiles();
//                int i=0;
//                int size = temp.length;
//                while (i<size){
//                    if (temp[i].getName().endsWith(".txt")) {
//                        System.out.println(""+temp[i].getName());
//                        findedUsers.add(""+temp[i].getName());
//                    }
//                    i++;
//                }
//                return null;
//            }
//        };
//        new Thread(task).start();
//
//        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
//            @Override
//            public void handle(WorkerStateEvent event) {
//                users.setAll(findedUsers);
//            }
//        });
//
//
//        Text anonce = new Text("Или создайте нового.");
//        anonce.setLayoutX(30);
//        anonce.setLayoutY(250);
//
//        TextField newName = new TextField("Введите имя нового игрока");
//        newName.setLayoutX(30);
//        newName.setLayoutY(260);
//        newName.setMinWidth(260);
//        newName.setEditable(true);
//
//        Button create = new Button("Create");
//        create.setLayoutX(320);
//        create.setLayoutY(260);
//
//
//        Button chose = new Button("Chose");
//        chose.setLayoutX(320);
//        chose.setLayoutY(30);
//
//        Text anonce1 = new Text("Выберите существующего игрока.");
//        anonce1.setLayoutX(30);
//        anonce1.setLayoutY(20);
//
//
//        ComboBox userList = new ComboBox(users);
//        userList.setLayoutX(30);
//        userList.setLayoutY(30);
//        userList.setMinWidth(260);
//        userList.setAccessibleText("Chose existing user.");
//
//
//        userGroup.getChildren().add(newName);
//        userGroup.getChildren().add(create);
//        userGroup.getChildren().add(userList);
//        userGroup.getChildren().add(chose);
//        userGroup.getChildren().add(anonce);
//        userGroup.getChildren().add(anonce1);
//
//        Scene userScene = new Scene(userGroup, 400, 300);
//        userStage.setScene(userScene);
//        userStage.show();
//
//        newName.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                newName.setText("");
//            }
//        });
//
//        chose.setOnMouseClicked(new EventHandler<MouseEvent>() {
//            @Override
//            public void handle(MouseEvent event) {
//                userStage.close();
//                plane.show();
//            }
//        });
//
//    }
//
//
//
//
//
//
//
//
//
//
//// процесс жеребьевки
//
//    public void toss()  {
//
//
//        deck.shuffleDeck();
//        int myToss = deck.getCard(1);
//        String stringMyToss = "file:/Users/elenabugercuk/Documents/workspace/img/"+myToss+".jpg";
//        int compToss = deck.getCard(2);
//        String stringCompToss = "file:/Users/elenabugercuk/Documents/workspace/img/"+compToss+".jpg";
//        Image imageMyToss = new Image(stringMyToss, 100.0, 200.0, true, true);
//        Image imageCompToss = new Image(stringCompToss, 100.0, 200.0, true, true);
//        myCard1.setImage(imageMyToss);
//        compCard1.setImage(imageCompToss);
//
//
//        if (myToss-(myToss/100)*100==1) {myToss=myToss+14;} // первод туза в самую старшую карту
//        if (compToss-(compToss/100)*100==1) {compToss=compToss+14;}
//
//
//        if (myToss-(myToss/100)*100>compToss-(compToss/100)*100) {
//            cash.compDealer=false;
//            dealerY=370;
//
//        } else {
//            cash.compDealer=true;
//            dealerY=90;
//
//        }
//
//        if ((myToss-(myToss/100)*100==compToss-(compToss/100)*100)&&(myToss>compToss)) {
//            cash.compDealer=false;
//            dealerY=370;
//        }
//
//        button.setLayoutY(dealerY);
//
//
//// выделение анимацией победившей карты
//
//
//        RotateTransition proba = new RotateTransition(Duration.millis(1000));
//        if (cash.compDealer) {proba.setNode(compCard1);} else {proba.setNode(myCard1);}
//        proba.setByAngle(180f);
//        proba.setCycleCount(1);
//        proba.setAutoReverse(false);
//
//        PauseTransition pause = new PauseTransition(Duration.seconds(1));
//
//        SequentialTransition sequence = new SequentialTransition(pause, proba);
//        sequence.play();
//
//
//    }
//
//
//    // отрисовка ривера
//
//    public class River extends Thread {
//        public River (){
//
//        }
//
//        public void run() {
//
//            int intRiver = deck.getCard(9);
//            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intRiver+".jpg";
//            Image iRiver = new Image(temp1, 100.0, 200.0, true, true);
//            showriver.setImage(iRiver);
//            phase="rive";
//            superBrain();
//            Thread.currentThread().interrupt();
//
//        }
//    }
//
//
//
//
//// отрисовка терна
//
//    public class Turn extends Thread {
//        public Turn(){
//
//        }
//
//        public void run() {
//
//            int intTurn = deck.getCard(8);
//            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intTurn+".jpg";
//            Image iTurn = new Image(temp1, 100.0, 200.0, true, true);
//            showturn.setImage(iTurn);
//            phase="turn";
//            superBrain();
//            Thread.currentThread().interrupt();
//
//        }
//    }
//
//
//    // отрисовка флопа
//
//    public class Flop extends Thread {
//        public Flop (){
//        }
//
//        public void run (){
//            cash.pot=cash.compBet+cash.myBet;
//            cash.myBet=0;
//            cash.compBet=0;
//            showBank.setText(""+cash.pot);
//            showMyBet.setText("0");
//            showCompBet.setText("0");
//
//            //System.out.println("Posle flopa bank=" + cash.pot+ " mojstek="+cash.myStack + "compst=" + cash.compStack +" " + cash.myBet + " " + cash.compBet);
//
//            int intFlop1 = deck.getCard(5);
//            int intFlop2 = deck.getCard(6);
//            int intFlop3 = deck.getCard(7);
//
//            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop1+".jpg";
//            String temp2= "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop2+".jpg";
//            String temp3= "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop3+".jpg";
//            Image iFlop1 = new Image(temp1, 100.0, 200.0, true, true);
//            Image iFlop2 = new Image(temp2, 100.0, 200.0, true, true);
//            Image iFlop3 = new Image(temp3, 100.0, 200.0, true, true);
//            flop1.setImage(iFlop1);
//            flop2.setImage(iFlop2);
//            flop3.setImage(iFlop3);
//            System.out.println("В методе флоп меняем фазу на флоп");
//            phase="flop";
//            superBrain();
//
//            Thread.currentThread().interrupt();
//
//        }
//
//    }
//
//
//    // сброс графики перед началом новой раздачи
//
//    public class NewHand extends Thread {
//        public NewHand(){
//
//        }
//
//        public void run(){
//            if (cash.compDealer) {
//                cash.compDealer=false;
//                dealerY=370;
//                button.setLayoutY(dealerY);
//            } else {
//                cash.compDealer=true;
//                dealerY=90;
//                button.setLayoutY(dealerY);
//
//            }
//            handLog.clear();// очистка истории
//            Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100, 200, true, true);
//            flop1.setImage(back);
//            flop2.setImage(back);
//            flop3.setImage(back);
//            showturn.setImage(back);
//            showriver.setImage(back);
//            myCard1.setImage(back);
//            myCard2.setImage(back);
//            compCard1.setImage(back);
//            compCard2.setImage(back);
//
//
//
//            try {
//                sleep(1000l);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                this.interrupt();
//                System.out.println("NewHand Остановлен в слипе");
//            }
//            cash.makeBlind();
//            preflop.run();
//
//            Thread.currentThread().interrupt();
//
//        }
//    }
//
//
//    // отрисовка префлопа
//
//    public class Preflop extends Thread {
//        public Preflop (){
//
//        }
//
//        public void run(){
//
//            deck.shuffleDeck();
//            System.out.println("Shuffle");
//            int my1 = deck.getCard(1);
//            int my2 = deck.getCard(2);
//
//            System.out.println(my1 + " " + my2);
//            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my1 + ".jpg";
//            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my2 + ".jpg";
//            Image preflop1 = new Image(temp1, 100.0, 200.0, true, true);
//            Image preflop2 = new Image(temp2, 100.0, 200.0, true, true);
//            myCard1.setImage(preflop1);
//            myCard2.setImage(preflop2);
//            System.out.print("В методе preflop.run Меняем стадию " + phase + "на ");
//            phase="pref";
//            System.out.println(phase);
//            superBrain();
//
//            Thread.currentThread().interrupt();
//
//
//        }
//    }
//
//    // определение победителя на шоудауне.
//
//    public void  whoWin(int[] human, int[]comp){
//
//        System.out.println("Процесс определения победителя");
//        int size=6;
//        int i=0;
//        int result=0;
//
//        while(i<size){
//            if (human[i]>comp[i]){
//                result=1;
//                break;
//            }
//
//            if (human[i]<comp[i]) {
//                result=-1;
//                break;
//            }
//
//            i++;
//        }
//
//        if (result==0) {
//            System.out.println(" Ничья.");
//            showTempText.setText(showTempText.getText() + " SPLIT");
//            cash.split();
//
//        }
//
//        if (result==1) {
//            System.out.println(" Человек победил.");
//            showTempText.setText(showTempText.getText() + " Human WIN");
//            cash.humanWin();
//
//        }
//
//        if (result==-1) {
//            System.out.println("Выиграл компьютер.");
//            showTempText.setText(showTempText.getText() + " Comp WIN");
//            cash.compWin();
//
//        }
//
//
//    }
//
//
//    // Класс поток обратного отсчета до следующего уровня блиндов
//
//    public class Countdown extends Thread {
//        private int minute=0;
//
//
//        public Countdown(){
//
//        }
//
//        public Countdown (int minute){
//            this.minute=minute;
//        }
//
//        public void run(){
//            int maxTime=this.minute*60;
//            int i=0;
//
//            boolean repeat = true;
//            while (repeat) {
//                i=0;
//                while (i < maxTime) {
//                    try {
//                        sleep(1000l);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                        this.interrupt();
//                        System.out.println("Timer Остановлен в слипе");
//                    }
//                    i++;
//                    int temp = maxTime - i;
//
//                    // перевод секунд в мм:сс
//
//                    int minu = temp / 60;
//                    int sec = temp - (minu * 60);
//                    String secString;
//                    if (sec < 10) {
//                        secString = "0" + sec;
//                    } else {
//                        secString = "" + sec;
//                    }
//
//                    nextTime.setText(minu + ":" + secString);
//
//
//                }
//                System.out.println(cash.level);
//                cash.level=cash.level+1;
//                System.out.println(cash.level);
//
//                blind.setText(("" + (cash.blind[cash.level]) / 2) + "/" + cash.blind[cash.level]);
//                nextLevel.setText(""+ ((cash.blind[cash.level+1])/2)+"/"+ cash.blind[cash.level+1]);
//
//                if (this.isInterrupted()) {
//                    System.out.println("Timer Остановлен");
//                    break;
//                }
//
//
//            }
//
//
//        }
//
//
//    }
//
//
//
//
//
//
//
//    /**
//     * Создание и перемешивание колоды карт.
//     * пика 401 - 413
//     * чирва 301 - 313
//     * бубна 201 - 212
//     * трефа 101 - 113
//     */
//    public class Deck {
//        private  Integer[] deck = new Integer[52];
//
//        public Deck(){
//            int i=0;
//            while (i<13){
//                deck[i]=101+i;
//                deck[i+13] = 201+i;
//                deck[i+26] = 301+i;
//                deck[i+39] = 401+i;
//                i=i+1;
//            }
//        }
//
//
//
//        public void shuffleDeck(){
//            int i=0;
//            Integer transit=0;
//            while (i<10000){
//                int firstCard= (int) (Math.random()*52);
//                int secondCard = (int) (Math.random()*52);
//                transit = this.getCard(firstCard);
//                this.setCard(firstCard, this.getCard(secondCard));
//                this.setCard(secondCard, transit);
//                i++;
//            }
//        }
//
//
//
//
//        public Integer[] getDeck() {
//            return deck;
//        }
//
//        public Integer getCard(int i){
//            return deck[i];
//        }
//
//        public void setCard(int number, Integer value){
//            this.deck[number]=value;
//        }
//
//        public void setDeck(Integer[] deck) {
//            this.deck = deck;
//        }
//    }
//
//
//
//
//
//
//
//
//    public class Cash {
//        int myStack;
//        int compStack;
//        int pot;
//        int myBet;
//        int compBet;
//        int level;
//        int[] blind;
//        boolean compDealer;
//        int myM;
//        int compM;
//        boolean compAgressor;
//
//
//
//        public Cash(){
//            this.level=0;
//            this.myStack=1500;
//            this.myBet=0;
//            this.compStack=1500;
//            this.compBet=0;
//            this.blind=new int [] {20, 30, 40, 50, 60, 80, 100, 120, 150, 200, 250, 300, 400, 500};
//            this.compDealer=true;
//            this.pot=0;
//
//        }
//
//
//        public void makeBlind (){
//
//
//            if (compDealer) {
//                compAgressor=false;
//                if (blind[level]/2>compStack) {compBet=compStack;} else {compBet = blind[level]/2;}
//                if (compBet==compStack) {myBet=compBet;}
//                if (blind[level]>myStack) {myBet=myStack;} else {myBet=blind[level];}
//                if (myBet<compBet) {compBet=myBet;}
//                handLog.add("compblin"+compBet);
//                handLog.add("humablin" + myBet);
//
//            } else {
//                compAgressor=true;
//                if (blind[level]/2>myStack) {myBet=myStack;} else {myBet = blind[level]/2;}
//                if (myBet==myStack) {compBet=myBet;}
//                if (blind[level]>compStack) {compBet=compStack;} else {compBet=blind[level];}
//                if (compBet<myBet) {myBet=compBet;}
//                handLog.add("humablin"+myBet);
//                handLog.add("compblin"+compBet);
//
//            }
//            compStack= compStack-compBet;
//            myStack=myStack-myBet;
//            showMyBet.setText(""+myBet);
//            showCompBet.setText(""+compBet);
//            showCompStackValue.setText(""+compStack);
//            showMyStackValue.setText(""+myStack);
//
//
//        }
//
//
//
//        public void humanCheckCall(){
//            System.out.println( "Человек играет чек/колл");
//            int delta=cash.compBet-cash.myBet;
//            cash.myBet=cash.myBet+delta;
//            cash.myStack=cash.myStack-delta;
//            String toLog="huma"+phase+(""+cash.compBet);
//            handLog.add(toLog);
//            System.out.println(handLog.toString());
//            showMyBet.setText(""+cash.myBet);
//            showMyStackValue.setText(""+cash.myStack);
//            superBrain();
//
//        }
//
//        public void compChecCall (){
//
//
//            System.out.println("CompBet=" + cash.compBet);
//            System.out.println("Играю Чек/Кол");
//            showTempText.setText("Играю Чек/Колл");
//            int delta=cash.myBet-cash.compBet;
//            cash.compBet=cash.compBet+delta;
//            cash.compStack=cash.compStack-delta;
//            showCompBet.setText(""+cash.compBet);
//            showCompStackValue.setText(""+cash.compStack);
//            String toLog="comp"+phase+cash.compBet;
//            handLog.add(toLog);
//            System.out.println(handLog.toString());
//            superBrain();
//
//        }
//
//        public void compPass(){
//            // System.out.println("Do pasa pot "+cash.pot+"MB="+cash.myBet+"CB="+cash.compBet+"MS="+cash.myStack+"CS="+cash.compStack);
//            System.out.println("Играю пас");
//            showTempText.setText("Пас!");
//            String toLog = "comp" + phase +"0";
//            handLog.add(toLog);
//            System.out.println(handLog.toString());
//
//            cash.pot=cash.pot+cash.myBet+cash.compBet;
//            cash.myStack=cash.myStack+cash.pot;
//            cash.myBet=0;
//            cash.compBet=0;
//            cash.pot=0;
//            showMyStackValue.setText(""+cash.myStack);
//            showBank.setText("0");
//            //System.out.println("После pasa pot "+cash.pot+"MB="+cash.myBet+"CB="+cash.compBet+"MS="+cash.myStack+"CS="+cash.compStack);
//
//            newHand.run();
//        }
//
//
//        public void compRaise(){
//            compAgressor=true;
//            int delta=0;
//            if (cash.pot==0){
//                // Этап префлоп
//                delta=3*cash.blind[level]-cash.compBet;
//
//            } else {
//                // После флопа
//                delta=cash.pot/2-cash.compBet;
//            }
//            cash.compBet=cash.compBet+delta;
//            cash.compStack=cash.compStack-delta;
//            showCompStackValue.setText(""+cash.compStack);
//            showCompBet.setText(""+cash.compBet);
//            String toLog = "comp" + phase + cash.compBet;
//            handLog.add(toLog);
//            System.out.println(handLog.toString());
//            superBrain();
//
//        }
//
//        public void humanWin (){
//
//            cash.pot=cash.pot+cash.myBet+cash.compBet;
//            cash.myBet=0;
//            cash.compBet=0;
//            cash.myStack=cash.myStack+cash.pot;
//            cash.pot=0;
//
//            showBank.setText("0");
//            showMyStackValue.setText(""+cash.myStack);
//            showMyBet.setText("0");
//            showCompBet.setText("0");
//
//        }
//
//        public void compWin(){
//            cash.pot=cash.pot+cash.myBet+cash.compBet;
//            cash.myBet=0;
//            cash.compBet=0;
//            cash.compStack=cash.compStack+cash.pot;
//            cash.pot=0;
//
//            showBank.setText("0");
//            showCompStackValue.setText(""+cash.compStack);
//            showMyBet.setText("0");
//            showCompBet.setText("0");
//
//        }
//
//        public void split(){
//            cash.pot=cash.pot+cash.myBet+cash.compBet;
//            cash.myBet=0;
//            cash.compBet=0;
//            if (cash.pot%2==1) {
//                if (compDealer) {
//                    cash.pot--;
//                    cash.myStack++;
//                } else {
//                    cash.pot--;
//                    cash.compStack++;
//                }
//            }
//            cash.myStack=cash.myStack+(cash.pot)/2;
//            cash.compStack=cash.compStack+(cash.pot)/2;
//            cash.pot=0;
//
//
//            showCompStackValue.setText(""+cash.compStack);
//            showCompStackValue.setText(""+cash.myStack);
//            showBank.setText("0");
//            showMyBet.setText("0");
//            showCompBet.setText("0");
//
//
//        }
//    }
//
//
//    // класс для анализа и принятия решения о действиях компьютера
//
//    public class Analysis {
//        int [] preflopStrategy = new int[8];
//        int [] flopStrategy = new int[8];
//        int [] turnStrategy = new int[8];
//        int [] riverStrategy = new int[8];
//
//        String [] power = new String[] {
//                "323023o",
//                "332024o",
//                "340826o", "342925o", "345827o",
//                "351534o", "359832s",
//                "360836o","362735o", "366037o","368328o","368342s",
//                "374838o","376762s","378552s",
//                "380146o","381645o","381672s","385547o","386443s",
//                "391029o","394748o","395363s","396953s","399456o",
//                "400239o","400473s","402782s","405157o","406749o","408783s",
//                "413364s","414358o","414554s","41692to","418574s",
//                "423267o","424292s","42603to","426759o","427084s",
//                "431365s","432468o","432693s","43504to","436875s","438694s",
//                "44235to","44352jo","444969o","445585s","4484t2s",
//                "450578o","45283jo","4569t3s","457295s","458776s",
//                "46106to","46194jo","462486s","463079o","4653t4s",
//                "47185jo","4722t5s","47302qo","4738j2s","474396s","47846jo","47917to","479487s",
//                "481089o","48223qo","4823j3s","4894t6s",
//                "4907j4s","491297s","49134qo","49687jo","49728to","4999j5s",
//                "50125qo","5017q2s","503322o","50512ko","5061j6s","5064t7s","508098s",
//                "5102q3s","51026qo","51433ko","51498jo","51539to","51777qo","5186q4s",
//                "52334ko","5233t8s","5233j7s","5277q5s",
//                "5321k2s","53259jo","53315ko","53608qo","5361q6s","536933o",
//                "5402j8s","5403t9s","5406k3s","54226ko","5430q7s","5489k4s","54932ao",
//                "55197ko","5529tjo","55369qo","5566j9s","5579k5s","55853ao",
//                "5602q8s","56028ko","5664k6s","56734ao",
//                "570244o","5730tqo","5738a2s","5753jts","5754k7s","5766q9s","57686ao","57705ao","57819ko",
//                "5814jqo","5822a3s","5831k8s","58847ao",
//                "5903a4s","5940tko","5947qts","59878ao","5991a6s","5992a5s","5999k9s",
//                "6026qjs","603355o","6057jko","60779ao","6098a7s",
//                "6146qko","6179kts","6194a8s",
//                "6257kjs","6272tao","6278a9s",
//                "632966o","6340kqs","6356jao",
//                "6443qao","6460ats",
//                "6532kao","6540ajs",
//                "6621aqs","662477o",
//                "6705aks",
//                "691688o",
//                "720699o",
//                "7501tto",
//                "7747jjo",
//                "7993qqo",
//                "8240kko",
//                "8520aao"};
//
//        public Analysis(){
//
//        }
//
//
//        public int[] WinCombination (int card1, int card2){
//            int[] result = new int[6];
//            int[] nabor = new int[7];
//            nabor[0] = card1;
//            nabor[1] = card2;
//            // !!!!!!расписать постепенное заполнение остальных ячеек по мере движения фазы, чтобы одним методом проверять наличие комбинации на любой стадии.
//            nabor[2] = deck.getCard(5);
//            nabor[3] = deck.getCard(6);
//            nabor[4] = deck.getCard(7);
//            nabor[5] = deck.getCard(8);
//            nabor[6] = deck.getCard(9);
//
//
//
//            // Проверка на роял флеш
//
//            HashMap <Integer, String> royal = new HashMap<>();
//            royal.put(nabor[0], "");
//            royal.put(nabor[1], "");
//            royal.put(nabor[2], "");
//            royal.put(nabor[3], "");
//            royal.put(nabor[4], "");
//            royal.put(nabor[5], "");
//            royal.put(nabor[6], "");
//
//            if ((royal.containsKey(101))&&(royal.containsKey(110))&&(royal.containsKey(111))&&(royal.containsKey(112))&&(royal.containsKey(113))) {
//                System.out.println("Найден флеш!!!");
//                showTempText.setText(showTempText.getText()+" Рояль ");
//                result[0]=9;
//                return result;
//            }
//
//            if ((royal.containsKey(201))&&(royal.containsKey(210))&&(royal.containsKey(211))&&(royal.containsKey(212))&&(royal.containsKey(213))) {
//                System.out.println("Найден флеш!!!");
//                showTempText.setText(showTempText.getText()+" Рояль ");
//                result[0]=9;
//                return result;
//            }
//
//            if ((royal.containsKey(301))&&(royal.containsKey(310))&&(royal.containsKey(311))&&(royal.containsKey(312))&&(royal.containsKey(313))) {
//                System.out.println("Найден флеш!!!");
//                showTempText.setText(showTempText.getText()+" Рояль ");
//                result[0]=9;
//                return result;
//            }
//
//            if ((royal.containsKey(401))&&(royal.containsKey(410))&&(royal.containsKey(411))&&(royal.containsKey(412))&&(royal.containsKey(413))) {
//                System.out.println("Найден флеш!!!");
//                showTempText.setText(showTempText.getText()+" Рояль ");
//                result[0]=9;
//                return result;
//            }
//
//            // Проверка на стреет флеш
//
//
//
//            HashMap <Integer, String> straitFlash = new HashMap<>();
//            straitFlash.put(nabor[0], "");
//            straitFlash.put(nabor[1], "");
//            straitFlash.put(nabor[2], "");
//            straitFlash.put(nabor[3], "");
//            straitFlash.put(nabor[4], "");
//            straitFlash.put(nabor[5], "");
//            straitFlash.put(nabor[6], "");
//
//            int i=0;
//            while (i<7){
//                Integer key = nabor[i];
//                Integer key1= key-1;
//                Integer key2=key-2;
//                Integer key3=key-3;
//                Integer key4=key-4;
//
//                Integer key5=key+1;
//                Integer key6=key+2;
//
//                if ((straitFlash.containsKey(key1))&&(straitFlash.containsKey(key2))&&(straitFlash.containsKey(key3))&&(straitFlash.containsKey(key4))) {
//                    System.out.println("Редкий случай Стрит флэш!!!!");
//
//                    result[0]=8;
//                    if (straitFlash.containsKey(key5)){
//                        if (straitFlash.containsKey(key6)){result[1]=key6;} else{result[1]=key5;}
//                    } else {result[1]=key;}
//                    showTempText.setText(showTempText.getText()+" Стреет флэш "+result[1]);
//                    return result;
//                }
//
//                i++;
//            }
//
//
//
//            // Проверка на каре
//
//            i=0;
//            int [] care = new int[7];
//            i=0;
//            while (i<7){
//                care[i]=nabor[i]-(nabor[i]/100)*100;
//                if (care[i]==1) {care[i]=14;}
//                i++;
//            }
//
//            int[] checkCare = new int[15];
//
//            i=0;
//            while (i<7){
//                checkCare[care[i]]++;
//                i++;
//            }
//            i=0;
//            while (i>0){
//                if (checkCare[i]>3) {
//                    System.out.println("Найдена каре!!!!");
//                    showTempText.setText(showTempText.getText()+" Каре ");
//                    result[0]=7;
//                    result[1]=i;
//                    int k=14;
//                    while (k>0){
//                        if ((k!=i)&&(checkCare[k]>0)){
//                            result[2]=k;
//                            k=1; //для выхода из цикла
//                        }
//                        k=k-1;
//                    }
//                    showTempText.setText(showTempText.getText()+" Каре " + result[1] + " " + result[2]);
//                    return result;
//                }
//                i++;
//            }
//
//
//            // Проверка на фулл
//
//
//
//            int [] full = new int[7];
//            i=0;
//            while (i<7){
//                full[i]=nabor[i]-(nabor[i]/100)*100;
//                if(full[i]==1){full[i]=14;}
//                i++;
//            }
//
//            int[] checkFull = new int[15];
//
//            i=0;
//            while (i<7){
//                checkFull[full[i]]++;
//                i++;
//            }
//            i=14;
//            while (i>0){
//                if (checkFull[i]==3) {
//
//                    int j=14;
//                    while (j>0){
//                        if ((checkFull[j]>=2)&&(i!=j)){
//                            System.out.println("Найден фулл-хаус!!!!");
//                            result[0]=6;
//                            result[1]=i;
//                            result[2]=j;
//                            showTempText.setText(showTempText.getText()+" Фулл-хаус " + result[1]+" " + result[2]);
//                            return result;
//                        }
//                        j--;
//                    }
//                }
//                i--;
//            }
//
//
//
//
//            // Проверка на ФЛЕШ
//            int [] flash = new int[7];
//            i=0;
//            while (i<7) {
//                flash[i]=nabor[i]/100;
//                if (flash[i]==1){flash[i]=14;}
//                i++;
//            }
//            int s=0;
//            int h=0;
//            int d=0;
//            int c=0;
//
//            i=0;
//            while (i<7){
//                if (flash[i]==1) {c++;}
//                if (flash[i]==2) {d++;}
//                if (flash[i]==3) {h++;}
//                if (flash[i]==4) {s++;}
//                i++;
//            }
//
//            if ((c>4)||(d>4)||(h>4)||(s>4)) {
//                System.out.println("Найден флеш!!!");
//
//                result[0]=5;
//                int maxLimit=415; // максимальный ранг карты не мойет быть выше
//                int minLimit=100;
//                if (c>4){maxLimit=115;}
//                if (d>4) {minLimit=200;maxLimit=215;}
//                if (h>4) {minLimit=300; maxLimit=315;}
//                if (s>4) {minLimit=400;}
//
//                int[] checkFlash = new int[15];
//
//                i=0;
//                while (i<7){
//                    if ((nabor[i]>minLimit)&&(nabor[i]<maxLimit)){
//                        checkFlash[nabor[i]-minLimit]++;}
//                    i++;
//                }
//
//                System.out.println("Flash" + Arrays.toString(checkFlash));
//
//                i=14;
//                int k=1;
//
//                while(i>0){
//                    if (checkFlash[i]>0){
//                        result[k]=i;
//                        k++;
//                    }
//                    if(k==6){i=1;}
//                    i--;
//                }
//                showTempText.setText(showTempText.getText()+" Флеш " + result[1]+" " + result[2]+ " " + result[3]);
//                return result;
//            }
//            // окончание проверки на ФЛЕШ
//
//
//            // Проверка на стреет
//
//
//            int [] straight = new int[7];
//            i=0;
//            while (i<7){
//                straight[i]=nabor[i]-(nabor[i]/100)*100;
//                if (straight[i]==1){
//                    straight[i]=14;
//                }
//                i++;
//            }
//
//            int[] checkStraight = new int[15];
//
//            i=0;
//            while (i<7){
//                checkStraight[straight[i]]++;
//                i++;
//            }
//
//            if(checkStraight[14]!=0) {
//                checkStraight[1]=1;
//            }
//
//            i=14;
//
//            System.out.println("preStraight" + Arrays.toString(straight));
//            System.out.println("Straight" + Arrays.toString(checkStraight));
//            while(i>4){
//
//                if((checkStraight[i])*(checkStraight[i-1])*(checkStraight[i-2])*(checkStraight[i-3])*(checkStraight[i-4])!=0){
//                    System.out.println("Найден Стрит!!!!!");
//                    result[0]=4;
//                    result[1]=i;
//                    showTempText.setText(showTempText.getText()+" Стрит " + result[1]);
//                    return result;
//                }
//
//                i=i-1;
//
//            }
//
//
//            // Проверка на тройку
//
//
//            int [] trips = new int[7];
//            i=0;
//            while (i<7){
//                trips[i]=nabor[i]-(nabor[i]/100)*100;
//                if (trips[i]==1){trips[i]=14;}
//                i++;
//            }
//
//            int[] checkTrips = new int[15];
//
//            i=0;
//            while (i<7){
//                checkTrips[trips[i]]++;
//                i++;
//            }
//
//            i=14;
//            while (i>0){
//                if (checkTrips[i]>2) {
//                    System.out.println("Найдена тройка!!!!");
//                    result[0]=3;
//                    result[1]=i;
//                    int k=14;
//                    int l=2;
//                    while(k>0){
//                        if((i!=k)&&(checkTrips[k]>0)){
//                            result[l]=k;
//                            l++;
//
//                        }
//                        if (l==4){k=1;}
//                        k--;
//                    }
//                    showTempText.setText(showTempText.getText()+" Тройка " + result[1]+ " "+ result[2] + " " + result[3]);
//                    return result;
//                }
//                i--;
//            }
//
//            // Проверка на две пары
//
//
//
//            int [] twoPair = new int[7];
//            i=0;
//            while (i<7){
//                twoPair[i]=nabor[i]-(nabor[i]/100)*100;
//                if(twoPair[i]==1){twoPair[i]=14;}
//                i++;
//            }
//
//            int[] checkTwoPair = new int[15];
//
//            i=0;
//            while (i<7){
//                checkTwoPair[twoPair[i]]++;
//                i++;
//            }
//            i=14;
//            while (i>0){
//                if (checkTwoPair[i]==2) {
//
//                    int j=14;
//                    while (j>0){
//                        if ((checkTwoPair[j]==2)&&(i!=j)){
//                            System.out.println("Найденo ДВЕ Пары");
//
//                            result[0]=2;
//                            result[1]=i;
//                            result[2]=j;
//                            int l=14;
//                            while (l>0){
//                                if ((l!=i)&&(l!=j)&&(checkTwoPair[l]>0)){
//                                    result[3]=l;
//                                    l=1;
//                                }
//                                l--;
//                            }
//                            showTempText.setText(showTempText.getText()+" ДВЕ Пары " + result[1] + " " + result[2] + " "+ result[3]);
//                            return result;
//                        }
//                        j--;
//                    }
//                }
//                i--;
//            }
//
//
//
//            // Проверка на пару
//            int [] pair = new int[7];
//            i=0;
//            while (i<7){
//                pair[i]=nabor[i]-(nabor[i]/100)*100;
//                if(pair[i]==1) {pair[i]=14;}
//                i++;
//            }
//
//            int[] checkPair = new int[15];
//
//            i=0;
//            while (i<7){
//                checkPair[pair[i]]++;
//                i++;
//            }
//
//            System.out.println("Ранги" + Arrays.toString(checkPair));
//
//            i=14;
//            while (i>0){
//                if (checkPair[i]>1) {
//                    System.out.println("Найдена пара!!!!");
//
//                    result[0]=1;
//                    result[1]=i;
//                    int j=14;
//                    int k=2;
//                    while (j>0){
//                        if((j!=i)&&(checkPair[j]>0)){
//                            result[k]=j;
//                            k++;
//                        }
//                        if(k==5){j=1;}
//                        j--;
//                    }
//                    showTempText.setText(showTempText.getText()+" Пара " + result[1] + " " +result[2] + " "+result[3]);
//                    return result;}
//
//                i--;
//            }
//
//
//
//
//
//            // Проверка на хай карту
//
//            int [] high = new int[7];
//            i=0;
//            while (i<7){
//                high[i]=nabor[i]-(nabor[i]/100)*100;
//                if (high[i]==1){
//                    high[i]=14;
//                }
//                i++;
//            }
//
//            int[] checkHigh = new int[15];
//
//            i=0;
//            while (i<7){
//                checkHigh[high[i]]++;
//                i++;
//            }
//
//            result[0]=0;
//            i=14;
//            int k=1;
//            while((i>0)&&(k<6)){
//                if(checkHigh[i]>0){
//                    result[k]=i;
//                    k++;
//                }
//                i=i-1;
//            }
//
//            System.out.println("Всего лишь старшая карта.");
//            showTempText.setText(showTempText.getText()+" Хай " + result[1] + " " + result[2]);
//            return result;
//        }
//
//
//
//        // Методы определяюшие поведение компьютера
//
//        public void preflopStrategyDispetcher() {
//            preflopGreenGreen();
//            //preflopGreenYelow();
//            //preflopGreenOrange();
//            //preflopGreenRed();
//            //preflopYelowGreen();
//            //preflopYelowYelow();
//            //preflopYelowOrange();
//            //preflopYelowRed();
//            //preflopOrangeGreen();
//            //preflopOrangeYelow();
//            //preflopOrangeOrange();
//            //preflopOrangeRed();
//
//
//        }
//
//
//
//        public void flopStrategyDispetcher() {}
//
//
//        public void turnStrategyDispetcher() {}
//
//
//        public void riverStrategyDispetcher() {}
//
//
//        // разработка стратегии на префлопе для обоих м больше 100
//        public void preflopGreenGreen(){
//
//            step=false;
//
//            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(3) + ".jpg"; // временный показ карт компьютера
//            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(4) + ".jpg";
//            Image preflop1 = new Image(temp1, 100.0, 200.0, true, true);
//            Image preflop2 = new Image(temp2, 100.0, 200.0, true, true);
//            compCard1.setImage(preflop1);
//            compCard2.setImage(preflop2);
//
//
//
//            System.out.println("Начало анализа.");
//            Arrays.fill(preflopStrategy, 0);
//            String compHand=stringHand(deck.getCard(3), deck.getCard(4));
//            //System.out.println(deck.getCard(3) + " " + deck.getCard(4));
//            String altHand=""+compHand.charAt(1)+compHand.charAt(0)+compHand.charAt(2);
//            //System.out.println(compHand+" "+altHand);
//            String procent="";
//            int i=0;
//            while (i<169) {
//
//                if ((analysis.power[i].endsWith(compHand))||(analysis.power[i].endsWith(altHand))){
//                    procent=analysis.power[i].substring(0,4);
//                }
//                i++;
//            }
//
//            System.out.println(procent);
//            int chance = Integer.parseInt(procent);
//            String desition ="";
//            if (chance<4990) {
//                desition="Я бы пассaнул...        ";
//                int last=handLog.size()-1;
//                String lastbetSize1 =handLog.get(last).substring(8); // чек с плохой картой на блайнде
//                String lastbetSize2 =handLog.get(last-1).substring(8);
//                //System.out.println(lastbetSize1 + " " + lastbetSize2);
//                if(lastbetSize1.equals(lastbetSize2)) {
//                    cash.compChecCall();
//                    System.out.println("Комп играет чек  на блайнде");
//                } else {
//                    cash.compPass();}
//            }
//            if ((chance>=4990)&&(chance<5180)){
//                desition="Играю колл пасс.      ";
//                cash.compChecCall();
//            }
//            if ((chance>=5180)&&(chance<5900)) {
//                desition="Играю колл колл.       ";
//                cash.compChecCall();
//            }
//            if ((chance>=5900)&&(chance<6300)) {
//                desition="Играю бет разумный колл.        ";
//                cash.compRaise();
//            }
//            if ((chance>=6300)&&(chance<6600)) {
//                desition="Играю бет большой колл.         ";
//                cash.compRaise();
//            }
//            if ((chance>=6600)) {
//                desition="Играю бет оллин.           ";
//                cash.compRaise();
//            }
//            showTempText.setText(desition);
//            superBrain();
//        }
//
//        public String stringHand (int card1, int card2){
//            String begin="";
//            String middle="";
//            String end="";
//            int rang1 = card1-(card1/100)*100;
//            int rang2 = card2-(card2/100)*100;
//            if (rang1==1) {begin="a";}
//            if (rang2==1) {middle="a";}
//            if ((rang1>1)&&(rang1<10)) {begin=""+rang1;}
//            if ((rang2>1)&&(rang2<10)) {middle=""+rang2;}
//            if (rang1==10) {begin="t";}
//            if (rang1==11) {begin="j";}
//            if (rang1==12) {begin="q";}
//            if (rang1==13) {begin="k";}
//            if (rang2==10) {middle="t";}
//            if (rang2==11) {middle="j";}
//            if (rang2==12) {middle="q";}
//            if (rang2==13) {middle="k";}
//            if (card1/100==card2/100) {end="s";} else {end="o";}
//            String result = begin+middle+end;
//            return result;
//        }
//
//
//        public void handEnd (){
//            int [] humaComb=new int[6];
//            humaComb=analysis.WinCombination(deck.getCard(1), deck.getCard(2));
//            int [] compComb = new int[6];
//            compComb=analysis.WinCombination(deck.getCard(3),deck.getCard(4));
//            System.out.println("Человек " + Arrays.toString(humaComb));
//            System.out.println("Компьютер " + Arrays.toString(compComb));
//            whoWin(humaComb, compComb);
//        }
//
//    }
//
//
//    // Класс обходящий все дерево компьтера в поисках нужной папки.
//
//    public class PrintFiles extends SimpleFileVisitor<Path> {
//
//        // Поиск нужной дирректории.
//        @Override
//        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//
//
//            if (((dir.endsWith("Program Files"))||(dir.endsWith("Applications")))&&(finded)){
//
//                altPath=""+dir;
//                finded=false;
//                System.out.println("Потенциально "+ dir+ " Размер " + altPath.length() + " " + finded );
//            }
//
//            if (dir.endsWith("HUPoker")){
//                System.out.println("Найдена дирректория");
//                mainPath=""+ dir;
//                System.out.println(mainPath);
//                dirStatus.setText(mainPath);
//                return FileVisitResult.TERMINATE;
//
//            }
//            return FileVisitResult.CONTINUE;
//        }
//
//        // Отлавливание всякиx ошибок.
//        @Override
//        public FileVisitResult visitFileFailed(Path file, IOException exc) {
//            System.err.println(exc);
//            return FileVisitResult.CONTINUE;
//        }
//
//
//
//
//
//    }
//
//
//    public class Opponent implements Serializable {
//        String name;
//        int oppHands;
//        double oppWinnings;
//        double oppOverBet;
//
//        double oppVpp;
//        double oppPfr;
//        double opp3bet;
//        double opp4bet;
//        double oppFold3bet;
//
//        double oppContbet;
//        double oppFoldcontbet;
//        double oppCheckraise;
//
//        double oppBetRiver;
//        double oppblockBetRiver;
//        double oppOverBettRiver;
//
//
//        double oppWentShowdown;
//        double oppWinshodown;
//        double oppWinriveraction;
//        double oppWinBlockBetRiver;
//        double oppWinOverBetRiver;
//
//        public Opponent(){
//
//        }
//
//
//    }
//
//
//
//}