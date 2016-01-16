package poker;/**
 * Created by tri___ton on 04.01.16.
 */



import javafx.animation.*;
import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.stage.WindowEvent;
import javafx.util.Duration;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;


public class Table extends Application {
    Stage plane = new Stage();
    private Text nextTime = new Text();  //счетчик до следующего уровня
    private Countdown level = new Countdown(1); // класс поток обратный таймер
    private Preflop preflop = new Preflop(); // класс поток раздача префлоп
    private Flop flop = new Flop(); // класс поток раздача флоп
    private Turn turn = new Turn();
    private River river = new River();
    private NewHand newHand = new NewHand(); // класс поток начало новой руки. Сброс графики к началу.
    Cash cash = new Cash(); // класс работы с фишками
    Deck deck = new Deck(); // класс работы c колодой
    Analysis analysis=new Analysis(); // класс работы для анализа и принятия решения компьютером
    ImageView myCard1 = new ImageView(); // картинка моя карта1
    ImageView myCard2 = new ImageView(); // картинка моя карта2
    ImageView compCard1 = new ImageView(); // картинка комп карта1
    ImageView compCard2 = new ImageView(); // картинка комп карта2
    ImageView button = new ImageView(); // картинка кнопка диллера
    Text blind = new Text("10/20"); // текст текущий уровень блайндов
    Text nextLevel = new Text("15/30"); // текст следующий уровень блайндов
    TextField betSize = new TextField(); // текстовое поле для определения уровня бета
    int dealerY=240; // y-координата кнопки диллера
    Text showMyBet = new Text(); // текст размер моей ставки в этом раунде
    Text showCompBet = new Text(); // текст размер ставки компьютера в этом раунде;
    Text showMyStackValue = new Text(); // текст размер моего стека
    Text showCompStackValue = new Text(); //текст размер стека компьютера
    Group gPlane = new Group(); // группа картинок для графики стола
    ImageView flop1 = new ImageView(); // картинка первоя карты флопа
    ImageView flop2 = new ImageView(); // картинка второй карты флопа
    ImageView flop3 = new ImageView(); // картинка третьей карты флопа
    ImageView showturn = new ImageView(); // картинка карты терна
    ImageView showriver = new ImageView(); // картинка карты ривера


    ArrayList <String> handLog = new ArrayList<>();// запись истории руки.




    Text probablyStrategy = new Text(); //временное поле текст стратегия игры компа и другие тестовые данные
    String phase = "pref";// возможные значения pref, flop, turn, rive;




    // основной блок графики стола
    public Table(){

    }

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        Table current = new Table();
        current.begin();

    }

    public void superBrain(){
        // задача superbrain определить стадию раздачи и запустить один из вариантов:
        // * анализ и разработку стратегии компа на данной стадии
        // * передать ход компьютеру
        // * передать ход человеку
        // * отрисовать флоп/терн/ривер
        // * передать ход определителю победителя
        
    }

    public void begin () throws Exception {





        plane.setTitle("HeadsUp Trainer.     (c) tri___ton");


        Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true);
        Image dealer = new Image("file:/Users/elenabugercuk/Documents/workspace/img/dealer.gif", 50.0, 50.0, true, true);



        myCard1.setImage(back);
        myCard1.setLayoutX(5);
        myCard1.setLayoutY(370);



        myCard2.setImage(back);
        myCard2.setLayoutX(110);
        myCard2.setLayoutY(370);


        compCard1.setImage(back);
        compCard1.setLayoutX(5);
        compCard1.setLayoutY(5);


        compCard2.setImage(back);
        compCard2.setLayoutX(110);
        compCard2.setLayoutY(5);


        flop1.setImage(back);
        flop1.setLayoutX(240);
        flop1.setLayoutY(190);


        flop2.setImage(back);
        flop2.setLayoutX(350);
        flop2.setLayoutY(190);


        flop3.setImage(back);
        flop3.setLayoutX(460);
        flop3.setLayoutY(190);


        showturn.setImage(back);
        showturn.setLayoutX(580);
        showturn.setLayoutY(190);


        showriver.setImage(back);
        showriver.setLayoutX(700);
        showriver.setLayoutY(190);


        button.setImage(dealer);
        button.setLayoutX(220);
        button.setLayoutY(dealerY);


        TextField bank = new TextField();
        bank.setAlignment(Pos.BASELINE_RIGHT);
        bank.setLayoutX(130);
        bank.setLayoutY(250);
        bank.setMaxWidth(80);
        bank.setEditable(false);
        bank.setText("0");


        Text bankText = new Text();
        bankText.setText("Pot");
        bankText.setLayoutX(98);
        bankText.setLayoutY(270);


        showMyBet.setText("0");
        showMyBet.setLayoutX(50);
        showMyBet.setLayoutY(350);


        showCompBet.setText("0");
        showCompBet.setLayoutX(50);
        showCompBet.setLayoutY(180);

        Text myStack = new Text();
        myStack.setText("Stack");
        myStack.setLayoutX(250);
        myStack.setLayoutY(500);


        showMyStackValue.setFont(Font.font(20.0));
        showMyStackValue.setText("1500");
        showMyStackValue.setLayoutX(290);
        showMyStackValue.setLayoutY(500);


        Text compStack = new Text();
        compStack.setText("Stack");
        compStack.setLayoutX(250);
        compStack.setLayoutY(40);


        showCompStackValue.setFont(Font.font(20.0));
        showCompStackValue.setText("1500");
        showCompStackValue.setLayoutX(290);
        showCompStackValue.setLayoutY(40);

        Button toss = new Button();// клавиша жеребьевки первого хода. Исчезает после первого использования
        toss.minHeight(200);
        toss.minWidth(100);
        toss.maxHeight(200);
        toss.maxWidth(100);
        toss.setFont(Font.font(40.0));
        toss.setText("Toss");
        toss.setLayoutX(670);
        toss.setLayoutY(450);


        Button start = new Button(); // клавиша старта игры. Появляется после жеребьевки.
        start.minHeight(200);
        start.minWidth(100);
        start.maxHeight(200);
        start.maxWidth(100);
        start.setFont(Font.font(40.0));
        start.setText("Start");
        start.setLayoutX(670);
        start.setLayoutY(350);


        Text status = new Text("Small/Big blind");
        status.setLayoutX(650);
        status.setLayoutY(20);


        blind.setText((cash.blind[cash.level]) / 2 + "/" + cash.blind[cash.level]);
        blind.setLayoutX(770);
        blind.setLayoutY(20);


        Text next = new Text("Next Level");
        next.setLayoutX(650);
        next.setLayoutY(40);


        nextLevel.setText((cash.blind[cash.level + 1]) / 2 + "/" + cash.blind[cash.level + 1]);
        nextLevel.setLayoutX(770);
        nextLevel.setLayoutY(40);


        Text timeAnnot = new Text("Time to next level");
        timeAnnot.setLayoutX(650);
        timeAnnot.setLayoutY(60);


        nextTime.setText("10:00");
        nextTime.setLayoutX(770);
        nextTime.setLayoutY(60);


        Button act1 = new Button();//кнопка пасс
        act1.setText("Pass");
        act1.setLayoutX(400);
        act1.setLayoutY(480);


        Button act2 = new Button(); // кнопка чек/колл
        act2.setText("Check | Call");
        act2.setLayoutX(450);
        act2.setLayoutY(480);


        betSize.setAlignment(Pos.BASELINE_RIGHT);
        betSize.setLayoutX(545);
        betSize.setLayoutY(480);
        betSize.setMaxWidth(80);
        betSize.setEditable(true);
        betSize.setText("0");


        Button act3 = new Button();// кнопка бет/рейз
        act3.setText("Bet | Raise");
        act3.setLayoutX(630);
        act3.setLayoutY(480);

        Button act4 = new Button();// кнопка оллин
        act4.setText("All In");
        act4.setLayoutX(715);
        act4.setLayoutY(480);


        probablyStrategy.setLayoutY(150);
        probablyStrategy.setLayoutX(400);
        probablyStrategy.setText("Буду думать...");


        gPlane.getChildren().add(myCard1);
        gPlane.getChildren().add(myCard2);
        gPlane.getChildren().add(compCard1);
        gPlane.getChildren().add(compCard2);
        gPlane.getChildren().add(flop1);
        gPlane.getChildren().add(flop2);
        gPlane.getChildren().add(flop3);
        gPlane.getChildren().add(showturn);
        gPlane.getChildren().add(showriver);
        gPlane.getChildren().add(button);  //dealer img
        gPlane.getChildren().add(bank);
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
        gPlane.getChildren().add(probablyStrategy);


        // жеребьевка и добавление клавиш для основной игры
        toss.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                gPlane.getChildren().remove(toss);
                gPlane.getChildren().add(start);
                gPlane.getChildren().add(act1);
                gPlane.getChildren().add(act2);
                gPlane.getChildren().add(act3);
                gPlane.getChildren().add(act4);
                gPlane.getChildren().add(betSize);
                toss();


            }
        });


        // запуск игры
        start.setOnAction(new EventHandler() {
            @Override
            public void handle(Event startevent) {
                gPlane.getChildren().remove(start);
                level.start();
                myCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true));
                compCard1.setImage(new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100.0, 200.0, true, true));
                cash.makeBlind();
                preflop.start();
            }
        });


    // действие по кнопке пасс
        act1.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                preflop.interrupt();
                probablyStrategy.setText("Буду думать...");
                betSize.setText("0");
            cash.pot = cash.myBet+cash.compBet;
            cash.compStack=cash.compStack+cash.pot;


                if (cash.compDealer) {
                    cash.compDealer=false;
                    dealerY=370;
                    button.setLayoutY(dealerY);
                } else {
                    cash.compDealer=true;
                    dealerY=90;
                    button.setLayoutY(dealerY);

                }
                newHand.run();




            }
        });



        // действие по кнопке Чек/Колл

        act2.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                betSize.setText("0");
                cash.myStack=cash.myStack+cash.myBet;
                cash.myBet=0;
                cash.myBet=cash.compBet;
                cash.myStack=cash.myStack-cash.myBet;
                showMyStackValue.setText(""+cash.myStack);
                showMyBet.setText(""+cash.myBet);
                String toLog="huma"+phase+cash.myBet;
                handLog.add(toLog);
                analysis.preflopGreenGren();
                analysis.WinCombination(deck.getCard(1), deck.getCard(2));
                System.out.println(handLog.toString());

                flop.run();
                turn.run();
                river.run();

            }
        });


        // действие по кнопке оллин

        act4.setOnAction(new EventHandler() {
            @Override
            public void handle(Event event) {
                int bet = cash.myStack;
                betSize.setText(""+bet);

            }
        });



        // закрытие потоков после закрытия основного окна

        plane.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                preflop.interrupt();
                level.interrupt();
                flop.interrupt();
                newHand.interrupt();

            }
        });

        Scene planeScene = new Scene(gPlane, 840, 540);
        plane.setScene(planeScene);
        plane.show();




    }









// процесс жеребьевки

    public void toss()  {


        deck.shuffleDeck();
        int myToss = deck.getCard(1);
        String stringMyToss = "file:/Users/elenabugercuk/Documents/workspace/img/"+myToss+".jpg";
        int compToss = deck.getCard(2);
        String stringCompToss = "file:/Users/elenabugercuk/Documents/workspace/img/"+compToss+".jpg";
        Image imageMyToss = new Image(stringMyToss, 100.0, 200.0, true, true);
        Image imageCompToss = new Image(stringCompToss, 100.0, 200.0, true, true);
        myCard1.setImage(imageMyToss);
        compCard1.setImage(imageCompToss);


        if (myToss-(myToss/100)*100==1) {myToss=myToss+14;} // первод туза в самую старшую карту
        if (compToss-(compToss/100)*100==1) {compToss=compToss+14;}


        if (myToss-(myToss/100)*100>compToss-(compToss/100)*100) {
            cash.compDealer=false;
            dealerY=370;

        } else {
            cash.compDealer=true;
            dealerY=90;

        }

        if ((myToss-(myToss/100)*100==compToss-(compToss/100)*100)&&(myToss>compToss)) {
            cash.compDealer=false;
            dealerY=370;
        }

        button.setLayoutY(dealerY);


// выделение анимацией победившей карты


        RotateTransition proba = new RotateTransition(Duration.millis(1000));
        if (cash.compDealer) {proba.setNode(compCard1);} else {proba.setNode(myCard1);}
        proba.setByAngle(180f);
        proba.setCycleCount(1);
        proba.setAutoReverse(false);

        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        SequentialTransition sequence = new SequentialTransition(pause, proba);
        sequence.play();


    }


    // отрисовка ривера

    public class River extends Thread {
        public River (){

        }

        public void run() {

            int intRiver = deck.getCard(9);
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intRiver+".jpg";
            Image iRiver = new Image(temp1, 100.0, 200.0, true, true);
            showriver.setImage(iRiver);
            Thread.currentThread().interrupt();

        }
    }




// отрисовка терна

    public class Turn extends Thread {
        public Turn(){

        }

        public void run() {

            int intTurn = deck.getCard(8);
            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intTurn+".jpg";
            Image iTurn = new Image(temp1, 100.0, 200.0, true, true);
            showturn.setImage(iTurn);
            Thread.currentThread().interrupt();

        }
    }


    // отрисовка флопа

    public class Flop extends Thread {
        public Flop (){
        }

        public void run (){
            int intFlop1 = deck.getCard(5);
            int intFlop2 = deck.getCard(6);
            int intFlop3 = deck.getCard(7);

            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop1+".jpg";
            String temp2= "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop2+".jpg";
            String temp3= "file:/Users/elenabugercuk/Documents/workspace/img/"+intFlop3+".jpg";
            Image iFlop1 = new Image(temp1, 100.0, 200.0, true, true);
            Image iFlop2 = new Image(temp2, 100.0, 200.0, true, true);
            Image iFlop3 = new Image(temp3, 100.0, 200.0, true, true);
            flop1.setImage(iFlop1);
            flop2.setImage(iFlop2);
            flop3.setImage(iFlop3);
            Thread.currentThread().interrupt();

        }

    }


    // сброс графики перед началом новой раздачи

    public class NewHand extends Thread {
        public NewHand(){

        }

        public void run(){
            handLog.clear();// очистка истории
            Image back = new Image("file:/Users/elenabugercuk/Documents/workspace/img/backside.jpg", 100, 200, true, true);
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
                sleep(1000l);

            } catch (InterruptedException e) {
                e.printStackTrace();
                this.interrupt();
                System.out.println("NewHand Остановлен в слипе");
            }
            cash.makeBlind();
            preflop.run();
            Thread.currentThread().interrupt();

        }
    }


    // отрисовка префлопа

    public class Preflop extends Thread {
        public Preflop (){

        }

        public void run(){

                deck.shuffleDeck();
                System.out.println("Shuffle");
                int my1 = deck.getCard(1);
                int my2 = deck.getCard(2);

                System.out.println(my1 + " " + my2);
                String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my1 + ".jpg";
                String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + my2 + ".jpg";
                Image preflop1 = new Image(temp1, 100.0, 200.0, true, true);
                Image preflop2 = new Image(temp2, 100.0, 200.0, true, true);
                myCard1.setImage(preflop1);
                myCard2.setImage(preflop2);
                Thread.currentThread().interrupt();


        }
    }



    // Класс поток обратного отсчета до следующего уровня блиндов

    public class Countdown extends Thread {
        private int minute=0;


        public Countdown(){

        }

        public Countdown (int minute){
            this.minute=minute;
        }

        public void run(){
            int maxTime=this.minute*60;
            int i=0;

            boolean repeat = true;
            while (repeat) {
                i=0;
                while (i < maxTime) {
                    try {
                        sleep(1000l);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        this.interrupt();
                        System.out.println("Timer Остановлен в слипе");
                    }
                    i++;
                    int temp = maxTime - i;

                    // перевод секунд в мм:сс

                    int minu = temp / 60;
                    int sec = temp - (minu * 60);
                    String secString;
                    if (sec < 10) {
                        secString = "0" + sec;
                    } else {
                        secString = "" + sec;
                    }

                    nextTime.setText(minu + ":" + secString);


                }
                System.out.println(cash.level);
                cash.level=cash.level+1;
                System.out.println(cash.level);

                blind.setText(("" + (cash.blind[cash.level]) / 2) + "/" + cash.blind[cash.level]);
                nextLevel.setText(""+ ((cash.blind[cash.level+1])/2)+"/"+ cash.blind[cash.level+1]);

                if (this.isInterrupted()) {
                    System.out.println("Timer Остановлен");
                    break;
                }


            }


        }


    }







    /**
     * Создание и перемешивание колоды карт.
     * пика 401 - 413
     * чирва 301 - 313
     * бубна 201 - 212
     * трефа 101 - 113
     */
    public class Deck {
        private  Integer[] deck = new Integer[52];

        public Deck(){
            int i=0;
            while (i<13){
                deck[i]=101+i;
                deck[i+13] = 201+i;
                deck[i+26] = 301+i;
                deck[i+39] = 401+i;
                i=i+1;
            }
        }



        public void shuffleDeck(){
            int i=0;
            Integer transit=0;
            while (i<10000){
                int firstCard= (int) (Math.random()*52);
                int secondCard = (int) (Math.random()*52);
                transit = this.getCard(firstCard);
                this.setCard(firstCard, this.getCard(secondCard));
                this.setCard(secondCard, transit);
                i++;
            }
        }




        public Integer[] getDeck() {
            return deck;
        }

        public Integer getCard(int i){
            return deck[i];
        }

        public void setCard(int number, Integer value){
            this.deck[number]=value;
        }

        public void setDeck(Integer[] deck) {
            this.deck = deck;
        }
    }








    public class Cash {
        int myStack;
        int compStack;
        int pot;
        int myBet;
        int compBet;
        int level;
        int[] blind;
        boolean compDealer;



        public Cash(){
            this.level=0;
            this.myStack=1500;
            this.myBet=0;
            this.compStack=1500;
            this.compBet=0;
            this.blind=new int [] {20, 30, 40, 50, 60, 80, 100, 120, 150, 200, 250, 300, 400, 500};
            this.compDealer=true;
            this.pot=0;

        }


        public void makeBlind (){


            if (compDealer) {
                if (blind[level]/2>compStack) {compBet=compStack;} else {compBet = blind[level]/2;}
                if (compBet==compStack) {myBet=compBet;}
                if (blind[level]>myStack) {myBet=myStack;} else {myBet=blind[level];}
                if (myBet<compBet) {compBet=myBet;}
                    handLog.add("compblin"+compBet);
                    handLog.add("humablin" + myBet);

            } else {
                if (blind[level]/2>myStack) {myBet=myStack;} else {myBet = blind[level]/2;}
                if (myBet==myStack) {compBet=myBet;}
                if (blind[level]>compStack) {compBet=compStack;} else {compBet=blind[level];}
                if (compBet<myBet) {myBet=compBet;}
                    handLog.add("humablin"+myBet);
                    handLog.add("compblin"+compBet);

            }
            compStack= compStack-compBet;
            myStack=myStack-myBet;
            showMyBet.setText(""+myBet);
            showCompBet.setText(""+compBet);
            showCompStackValue.setText(""+compStack);
            showMyStackValue.setText(""+myStack);


        }

    }


    // класс для анализа и принятия решения о действиях компьютера

    public class Analysis {
        int [] preflopStrategy = new int[8];
        int [] flopStrategy = new int[8];
        int [] turnStrategy = new int[8];
        int [] riverStrategy = new int[8];

        String [] power = new String[] {
                "323023o",
                "332024o",
                "340826o", "342925o", "345827o",
                "351534o", "359832s",
                "360836o","362735o", "366037o","368328o","368342s",
                "374838o","376762s","378552s",
                "380146o","381645o","381672s","385547o","386443s",
                "391029o","394748o","395363s","396953s","399456o",
                "400239o","400473s","402782s","405157o","406749o","408783s",
                "413364s","414358o","414554s","41692to","418574s",
                "423267o","424292s","42603to","426759o","427084s",
                "431365s","432468o","432693s","43504to","436875s","438694s",
                "44235to","44352jo","444969o","445585s","4484t2s",
                "450578o","45283jo","4569t3s","457295s","458776s",
                "46106to","46194jo","462486s","463079o","4653t4s",
                "47185jo","4722t5s","47302qo","4738j2s","474396s","47846jo","47917to","479487s",
                "481089o","48223qo","4823j3s","4894t6s",
                "4907j4s","491297s","49134qo","49687jo","49728to","4999j5s",
                "50125qo","5017q2s","503322o","50512ko","5061j6s","5064t7s","508098s",
                "5102q3s","51026qo","51433ko","51498jo","51539to","51777qo","5186q4s",
                "52334ko","5233t8s","5233j7s","5277q5s",
                "5321k2s","53259jo","53315ko","53608qo","5361q6s","536933o",
                "5402j8s","5403t9s","5406k3s","54226ko","5430q7s","5489k4s","54932ao",
                "55197ko","5529tjo","55369qo","5566j9s","5579k5s","55853ao",
                "5602q8s","56028ko","5664k6s","56734ao",
                "570244o","5730tqo","5738a2s","5753jts","5754k7s","5766q9s","57686ao","57705ao","57819ko",
                "5814jqo","5822a3s","5831k8s","58847ao",
                "5903a4s","5940tko","5947qts","59878ao","5991a6s","5992a5s","5999k9s",
                "6026qjs","603355o","6057jko","60779ao","6098a7s",
                "6146qko","6179kts","6194a8s",
                "6257kjs","6272tao","6278a9s",
                "632966o","6340kqs","6356jao",
                "6443qao","6460ats",
                "6532kao","6540ajs",
                "6621aqs","662477o",
                "6705aks",
                "691688o",
                "720699o",
                "7501tto",
                "7747jjo",
                "7993qqo",
                "8240kko",
                "8520aao"};

        public Analysis(){

        }


        public int[] WinCombination (int card1, int card2){
            int[] result = new int[6];
            int[] nabor = new int[7];
            nabor[0] = card1;
            nabor[1] = card2;
            // расписать постепенное заполнение остальных ячеек по мере движения фазы, чтобы одним методом проверять наличие комбинации на любой стадии.
            nabor[2] = deck.getCard(5);
            nabor[3] = deck.getCard(6);
            nabor[4] = deck.getCard(7);
            nabor[5] = deck.getCard(8);
            nabor[6] = deck.getCard(9);

            // Проверка 


            // Проверка на ФЛЕШ
            int [] flash = new int[7];
            int i=0;
            while (i<7) {
                flash[i]=nabor[i]/100;
                i++;
            }
            int s=0;
            int h=0;
            int d=0;
            int c=0;

            i=0;
            while (i<7){
                if (flash[i]==1) {c++;}
                if (flash[i]==2) {d++;}
                if (flash[i]==3) {h++;}
                if (flash[i]==4) {s++;}
                i++;
            }

            if ((c>4)||(d>4)||(h>4)||(s>4)) {
                System.out.println("Найден флеш!!!");
                probablyStrategy.setText(probablyStrategy.getText()+"А у вас флешик нашелся!!!!");
                return result;
            }
            // окончание проверки на ФЛЕШ



            
            // Проверка на пару тройку и каре
            int [] pair = new int[7];
            i=0;
            while (i<7){
                pair[i]=nabor[i]-(nabor[i]/100)*100;
                i++;
            }

            int[] checkPair = new int[14];

            i=0;
            while (i<7){
                checkPair[pair[i]]++;
                i++;
            }

            System.out.println("Ранги" + Arrays.toString(checkPair));
            i=0;
            while (i<14){
                if (checkPair[i]>3) {
                    System.out.println("Найдена каре!!!!");
                    probablyStrategy.setText(probablyStrategy.getText()+" А у вас есть четыре одинаковых!!!!");
                    return result;
                }
                i++;
            }
            i=0;
            while (i<14){
                if (checkPair[i]>2) {
                    System.out.println("Найдена тройка!!!!");
                    probablyStrategy.setText(probablyStrategy.getText()+" А у вас есть три одинаковых!!!!");
                    return result;
                }
                i++;
            }

            i=0;
            while (i<14){
                if (checkPair[i]>1) {
                    System.out.println("Найдена пара!!!!");
                    probablyStrategy.setText(probablyStrategy.getText()+" А у вас есть две одинаковых!!!!");
                    return result;}

                i++;
            }


            // Окончание проверки на пару.


            return result;

        }


        // разработка стратегии на префлопе для обоич м больше 100
        public void preflopGreenGren(){


            String temp1 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(3) + ".jpg";
            String temp2 = "file:/Users/elenabugercuk/Documents/workspace/img/" + deck.getCard(4) + ".jpg";
            Image preflop1 = new Image(temp1, 100.0, 200.0, true, true);
            Image preflop2 = new Image(temp2, 100.0, 200.0, true, true);
            compCard1.setImage(preflop1);
            compCard2.setImage(preflop2);



            System.out.println("Начало анализа.");
            Arrays.fill(preflopStrategy, 0);
            String compHand=stringHand(deck.getCard(3), deck.getCard(4));
            System.out.println(deck.getCard(3) + " " + deck.getCard(4));
            String altHand=""+compHand.charAt(1)+compHand.charAt(0)+compHand.charAt(2);
            System.out.println(compHand+" "+altHand);
            String procent="";
            int i=0;
            while (i<169) {

                if ((analysis.power[i].endsWith(compHand))||(analysis.power[i].endsWith(altHand))){
                    procent=analysis.power[i].substring(0,4);
                }
                i++;
            }

            System.out.println(procent);
            int chance = Integer.parseInt(procent);
            String desition ="";
            if (chance<4990) {desition="Я бы пассaнул...";}
            if ((chance>=4990)&&(chance<5180)){desition="Играю колл пасс.";}
            if ((chance>=5180)&&(chance<5900)) {desition="Играю колл колл";}
            if ((chance>=5900)&&(chance<6300)) {desition="Играю бет разумный колл";}
            if ((chance>=6300)&&(chance<6600)) {desition="Играю бет большой колл";}
            if ((chance>=6600)) {desition="Играю бет оллин";}
            probablyStrategy.setText(desition);

        }

        public String stringHand (int card1, int card2){
            String begin="";
            String middle="";
            String end="";
            int rang1 = card1-(card1/100)*100;
            int rang2 = card2-(card2/100)*100;
            if (rang1==1) {begin="a";}
            if (rang2==1) {middle="a";}
            if ((rang1>1)&&(rang1<10)) {begin=""+rang1;}
            if ((rang2>1)&&(rang2<10)) {middle=""+rang2;}
            if (rang1==10) {begin="t";}
            if (rang1==11) {begin="j";}
            if (rang1==12) {begin="q";}
            if (rang1==13) {begin="k";}
            if (rang2==10) {middle="t";}
            if (rang2==11) {middle="j";}
            if (rang2==12) {middle="q";}
            if (rang2==13) {middle="k";}
            if (card1/100==card2/100) {end="s";} else {end="o";}
            String result = begin+middle+end;
            return result;
        }

    }


}


