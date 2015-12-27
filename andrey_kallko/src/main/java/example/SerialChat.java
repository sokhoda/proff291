package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class SerialChat implements Serializable {
    public SerialChat() {
    }

    public static void main(String[] args) {
        SerialChat.Server way2 = new SerialChat().new Server();
        way2.start();
        SerialChat.Client way1 = new SerialChat().new Client();
        way1.start();
    }

    public class Server extends Thread implements Serializable {
        public Server() {
            System.out.println("Сервер создан.");
        }

        public void run() {
            ArrayList list = new ArrayList();
            System.out.println("Сервер запущен.");
            int i = 0;

            while(true) {
                ++i;

                try {
                    sleep(2000L);
                } catch (Exception var29) {
                    System.out.println("Исключение");
                } finally {
                    ;
                }

                File destination = new File("/Users/elenabugercuk/Documents/workspace/TempChat/");
                File[] files = destination.listFiles();
                File[] var5 = files;
                int var6 = files.length;

                for(int var7 = 0; var7 < var6; ++var7) {
                    File temp = var5[var7];
                    String check = "" + temp;
                    if(check.endsWith(".cht")) {
                        FileInputStream fis = null;

                        try {
                            fis = new FileInputStream(temp);
                        } catch (FileNotFoundException var28) {
                            var28.printStackTrace();
                        }

                        ObjectInputStream ois = null;

                        try {
                            ois = new ObjectInputStream(fis);
                        } catch (IOException var27) {
                            var27.printStackTrace();
                        }

                        String toAdd = null;

                        try {
                            toAdd = (String)ois.readObject();
                        } catch (ClassNotFoundException var25) {
                            var25.printStackTrace();
                        } catch (IOException var26) {
                            var26.printStackTrace();
                        }

                        list.add(toAdd);

                        try {
                            ois.close();
                        } catch (IOException var24) {
                            var24.printStackTrace();
                        }

                        try {
                            fis.close();
                        } catch (IOException var23) {
                            var23.printStackTrace();
                        }

                        int size = list.size();

                        for(int j = 0; j < size; ++j) {
                            System.out.println(" " + (String)list.get(j));
                        }

                        temp.renameTo(new File(temp + "arh"));
                    }
                }
            }
        }
    }

    public class Client extends Thread implements Serializable {
        public Client() {
            System.out.println("Клиент создан.");
        }

        public void run() {
            System.out.println("Клиент стартовал.");
            System.out.println("Можете начинать печатать.");
            int i = 0;

            while(true) {
                ++i;
                Scanner keyboard = new Scanner(System.in);
                String message = keyboard.nextLine();
                String fName = "/Users/elenabugercuk/Documents/workspace/TempChat/" + i + ".cht";
                FileOutputStream fos = null;

                try {
                    fos = new FileOutputStream(fName);
                } catch (FileNotFoundException var29) {
                    var29.printStackTrace();
                }

                ObjectOutputStream oos = null;

                try {
                    oos = new ObjectOutputStream(fos);
                } catch (IOException var28) {
                    var28.printStackTrace();
                }

                try {
                    oos.writeObject(message);
                } catch (Exception var26) {
                    ;
                } finally {
                    try {
                        oos.close();
                    } catch (IOException var23) {
                        var23.printStackTrace();
                    }

                    try {
                        fos.close();
                    } catch (IOException var22) {
                        var22.printStackTrace();
                    }

                }

                try {
                    oos.close();
                } catch (IOException var25) {
                    var25.printStackTrace();
                }

                try {
                    fos.close();
                } catch (IOException var24) {
                    var24.printStackTrace();
                }
            }
        }
    }
}
