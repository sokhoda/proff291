package hw3.chat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import session4.Chatable;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


/**
 * Created by s_okhoda on 31.12.2015.
 */
public class AsyncChat extends Application implements
        Runnable, Chatable {
    private String clientName;
    private ServerSocketChannel serverSocketChannel;
    private SocketChannel clientSocketChannel;
    private SocketChannel makeChan = null;

    private ByteBuffer bufSend = ByteBuffer.allocate(BuffSize);
    private ByteBuffer bufReceive = ByteBuffer.allocate(BuffSize);

    private int ListenOnPort;
    private int SendToPort;
    private String IpAddress;

    private TextField ipAddrText;
    private TextField sendToPortText;
    private TextField listenOnPortText;

    private TextArea chatText;
    private TextArea inputText;
    private boolean crossPort;
    private Button connectButton;
    private Button sendButton;
    private String partnerName = null;

    private int sendReceiveStat = -1;

    public AsyncChat() {

    }

    public AsyncChat(String name) {

        try {
            serverSocketChannel = ServerSocketChannel.open();
            this.clientName = name;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private int boundListener() {
        int listenPort;
        String ipAddress;
        if (listenOnPortText == null || ipAddrText == null) return -1;
        try {
            listenPort = checkIntValue("ListenOnPort", listenOnPortText
                    .getText(), MinPortNumber, MaxPortNumber);
            ipAddress = checkIPaddressValue("IP Address", ipAddrText
                    .getText());
            try {
                if (serverSocketChannel.socket().isBound()) {
                    serverSocketChannel.close();
                    serverSocketChannel = ServerSocketChannel.open();
                }
                serverSocketChannel.socket().bind(new InetSocketAddress
                        (ipAddress, listenPort));
                serverSocketChannel.configureBlocking(false);
            }
            catch (IOException e) {
                e.printStackTrace();
                String message = getClientName().toUpperCase() + " failed to " +
                        "bind on " + ipAddress + ":" + listenPort;
                showWarning(message);
                Platform.runLater(() -> chatText.appendText("\n" + message));
                return -1;
            }
            Platform.runLater(() -> chatText.appendText("\n" + getClientName()
                    .toUpperCase() + " is LISTENING ON " +
                    serverSocketChannel.socket().toString()));
            return 1;
        }
        catch (NumberFormatException e) {
            showWarning(e.getMessage());
            return -1;
        }
    }

    private void manageGUIAttrib() {
        String color;
        if (makeChan != null || clientSocketChannel != null) {
            color = "moccasin";
            Platform.runLater(() -> connectButton.setText(DisconnectText));
        }
        else {
            color = "white";
            Platform.runLater(() -> connectButton.setText(ConnectText));
        }

        Region region = (Region) chatText.lookup(".content");
        BackgroundFill color3 = new BackgroundFill(Color.web(color),
                CornerRadii.EMPTY, Insets.EMPTY);
        region.setBackground(new Background(color3));
    }

    public void process() {
        try {
            manageGUIAttrib();
            int readBytesNum = 0;

            if (makeChan != null) {
                readChann(makeChan);
                return;
            }

            if (clientSocketChannel == null) {
                clientSocketChannel = serverSocketChannel.accept();
                try {
                    Thread.sleep(SleepTime);
                    if (clientSocketChannel != null) {
                        manageGUIAttrib();
                        //                    clientSocketChannel.configureBlocking(false);
                        sendMessage(clientSocketChannel, getClientName() +
                                Delimiter + ("Connection with " +
                                getClientName() + " successfully established on \"")
                                .toUpperCase() + getAddress
                                (clientSocketChannel) + "\"\n", false);
                    }
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (clientSocketChannel != null) {
                readChann(clientSocketChannel);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }

    }


    private int readChann(SocketChannel ch) throws IOException {
        int readBytesNum = 0;
        if (!ch.isOpen() || ch.socket().isClosed() || !ch.socket().isBound()) {
            return readBytesNum;
        }

        try {
            while ((readBytesNum = ch.read(bufReceive)) > 0) {
                String receivedMessage = buffToString(bufReceive, readBytesNum);
                if (partnerName == null) {
                    String[] connectionMessage = receivedMessage.split
                            (Delimiter);
                    if (receivedMessage.indexOf(Delimiter) >= 0 &&
                            connectionMessage.length > 1) {
                        partnerName = connectionMessage[0];
                        getChatText().appendText("\n" + connectionMessage[1]);
                    }
                    else {
                        getChatText().appendText("\nINVALID CONNECTION " +
                                "MESSAGE FORMAT RECEIVED.");
                    }
                }
                else {

                    if (!receivedMessage.equals(DisconnectMessage)) {
//                    getChatText().appendText("\n" + getClientName() + " \"" +
//                            getAddress(ch) + "\" received: " + "\n" + receivedMessage);
                        getChatText().appendText("\n" + (sendReceiveStat != 0 ?
                                getPartner() + " says:\n" : "") +
                                receivedMessage);
                        setSendReceiveStat(0);
                    }
                    else {
                        getChatText().appendText(DisconnectMessage);
                        makeDisconnect(false);
                    }
                }
                bufReceive.clear();
            }
        }
        catch (AsynchronousCloseException e) {
            // System.out.println(e.getMessage());
        }
        catch (ClosedChannelException e) {
            // System.out.println(e.getMessage());
        }
        return readBytesNum;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        boundListener();
        System.out.println(getClientName() + " serverSocketChannel: " +
                serverSocketChannel.socket().toString());

        while (true) {
            process();
        }
    }

    public void showGUI(Stage stage, boolean crossPort) {
        this.crossPort = crossPort;
        start(stage);
    }

    @Override
    public void init() {
//        List<String> params = getParameters().getRaw();
//        this.clientName = !params.isEmpty() ? params.get(0):"";
        System.out.println("init() " + this.clientName);

    }

    private void makeDisconnect(boolean verbose) {
        try {
            if (makeChan != null && makeChan.isOpen()) {
                if (verbose) sendMessage(makeChan, DisconnectMessage, false);
                makeChan.close();
            }
            if (clientSocketChannel != null && clientSocketChannel.isOpen()) {
                if (verbose)
                    sendMessage(clientSocketChannel, DisconnectMessage, false);
                clientSocketChannel.close();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (verbose) getChatText().appendText(DisconnectMessage);
            makeChan = null;
            clientSocketChannel = null;
            partnerName = null;
            setSendReceiveStat(-1);
        }
    }

    private void makeConnect() {
        int sendPort, listenPort;
        String ipAddress;
        try {
            sendPort = checkIntValue("SendToPort", sendToPortText
                    .getText(), MinPortNumber, MaxPortNumber);
            ipAddress = checkIPaddressValue("IP Address", ipAddrText
                    .getText());
            listenPort = checkIntValue("ListenOnPort", listenOnPortText
                    .getText(), MinPortNumber, MaxPortNumber);
            if (!checkServerSocketBound(serverSocketChannel, ipAddress,
                    listenPort)) {
                boundListener();
            }
            try {
                makeChan = SocketChannel.open(new InetSocketAddress
                        (ipAddress, sendPort));
//                makeChan.configureBlocking(false);
                sendMessage(makeChan, getClientName() + Delimiter +
                        (getClientName() + " has successfully " +
                                "connected to you on \"").toUpperCase() +
                        getAddress(makeChan) + "\"\n", false);

//                System.out.println(clientName + " connect pressed: " +
//                        "makeChan " + makeChan.socket().toString());
            }
            catch (Exception e) {
                //e.printStackTrace();
                Platform.runLater(() -> {
                    String message = "\n" + getClientName().toUpperCase() +
                            " failed to bind on " + ipAddress + ":" +
                            sendPort + ". IP address and/or port " +
                            "number might not match.\n";
                    chatText.appendText(message);
                });


            }
        }
        catch (NumberFormatException e) {
            showWarning(e.getMessage());
        }

    }

    private void sendMessage(SocketChannel channel, String message, boolean
            verbose) {
        if (channel == null || message == null) return;

        bufSend.clear();
        bufSend.put(message.getBytes());
        bufSend.flip();
        try {
            while (bufSend.hasRemaining()) {
                channel.write(bufSend);
                if (verbose) {
//                    chatText.appendText("\n"
//                            + getClientName() + " sends on \"" +
//                            getAddress(channel) + "\"\n" +
//                            buffToString(bufSend, bufSend.limit()));
                    chatText.appendText((sendReceiveStat != 1 ? "\n\tYour " +
                            "answer:":"") + "\n\t" +
                            buffToString(bufSend, bufSend.limit()));
                    setSendReceiveStat(1);
                }
            }
            bufSend.flip();
//            System.out.println(buffToString(bufSend, bufSend.limit()));
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }


    @Override
    public void start(Stage stage) {
        stage.setTitle("Asynchronous Chat v1.3 by O.Khodakovskyi: " +
                getClientName().toUpperCase());

        connectButton = new Button(ConnectText);
        connectButton.setMinWidth(170);
        connectButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (connectButton.getText().equals(ConnectText))
                    makeConnect();
                else {
                    makeDisconnect(true);
                }
            }
        });

        sendButton = new Button("Send");
        sendButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                sendMessage(makeChan != null ? makeChan : clientSocketChannel,
                        getInputText().getText(), true);
                getInputText().clear();
            }
        });

        Button exitButton = new Button("Exit");
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (makeChan != null || clientSocketChannel != null) {
                    connectButton.fire();
                }
                try {
                    Thread.sleep(SleepTime);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.exit(0);
            }
        });
        ipAddrText = new TextField(IpAddressDefault);
        ipAddrText.setMaxWidth(400);

        if (!crossPort) {
            sendToPortText = new TextField(Integer.toString(SendToPortDefault));
            listenOnPortText = new TextField(Integer.toString(ListenOnPortDefault));
        }
        else {
            sendToPortText = new TextField(Integer.toString(ListenOnPortDefault));
            listenOnPortText = new TextField(Integer.toString(SendToPortDefault));
        }
        sendToPortText.setMaxWidth(100);
        listenOnPortText.setMaxWidth(100);

        chatText = new TextArea("");
        chatText.setScrollTop(Double.MAX_VALUE);
        chatText.setEditable(false);
        chatText.setStyle("-fx-text-inner-color: blue;");

        inputText = new TextArea("");
        inputText.setMaxHeight(100);
        setStyleText(inputText, 14, "#0017F0");

        Scene scene = new Scene(new Group(), 920, 500);

        GridPane grid = new GridPane();
        grid.setVgap(4);
        grid.setHgap(10);
        grid.setPadding(new Insets(5, 5, 5, 5));

        grid.add(new Label("IP Address: "), 0, 0);
        grid.add(ipAddrText, 1, 0);

        grid.add(new Label("SendToPort: "), 2, 0);
        grid.add(sendToPortText, 3, 0);

        grid.add(new Label("ListenOnPort: "), 4, 0);
        grid.add(listenOnPortText, 5, 0);
        grid.add(connectButton, 6, 0);

        grid.add(new Label("ChatText: "), 0, 1);
        grid.add(chatText, 1, 1, 6, 3);
        grid.add(new Label("InputText: "), 0, 4);
        grid.add(inputText, 1, 4, 6, 1);

        grid.add(sendButton, 1, 5);
        grid.add(exitButton, 6, 5);

////                stage.setTitle(stage.getTitle().replaceAll("\\d", Integer

        Group root = (Group) scene.getRoot();
        root.getChildren().add(grid);
        stage.setScene(scene);
        stage.show();
    }

    public String getClientName() {
        return clientName;
    }

    public void setInputText(TextArea inputText) {
        this.inputText = inputText;
    }

    public TextArea getChatText() {
        return chatText;
    }

    public TextArea getInputText() {
        return inputText;
    }

    public void setClientSocketChannel(SocketChannel clientSocketChannel) {
        this.clientSocketChannel = clientSocketChannel;
    }

    public Button getConnectButton() {
        return connectButton;
    }

    public String getPartner() {
        return partnerName;
    }

    public void setSendReceiveStat(int sendReceiveStat) {
        this.sendReceiveStat = sendReceiveStat;
    }
}

