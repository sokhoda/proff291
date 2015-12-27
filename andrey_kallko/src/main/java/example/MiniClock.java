package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
import java.util.Date;
import java.util.Scanner;

public class MiniClock {
    public MiniClock() {
    }

    public static void main(String[] args) {
        MiniClock.Way1 obj = new MiniClock.Way1();
        obj.start();
        Scanner keyboard = new Scanner(System.in);
        String order = keyboard.nextLine();
        if(order.equals("stop")) {
            obj.interrupt();
        }

        System.out.println(obj.getState());
    }

    public static class Way1 extends Thread {
        public Way1() {
        }

        public void run() {
            for(int i = 0; i < 100; ++i) {
                if(this.isInterrupted()) {
                    System.out.println("Остановлен");
                    break;
                }

                try {
                    sleep(2000L);
                    Date e = new Date();
                    e.getTime();
                    System.out.println(e);
                } catch (Exception var3) {
                    System.out.println("Черз эксептион");
                    this.interrupt();
                }
            }

        }
    }
}
