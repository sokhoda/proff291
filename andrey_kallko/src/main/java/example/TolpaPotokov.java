package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */
public class TolpaPotokov {
    public TolpaPotokov() {
    }

    public static void main(String[] args) {
        TolpaPotokov.Way[] roads = new TolpaPotokov.Way[100];

        for(int i = 0; i < 100; ++i) {
            String name = "Поток " + i;
            roads[i] = new TolpaPotokov.Way(name);
            roads[i].start();
        }

    }

    public static class Way extends Thread {
        String name;

        public Way() {
        }

        public Way(String name) {
            this.name = name;
        }

        public void run() {
            System.out.println("My name is " + this.name);

            while(!this.isInterrupted()) {
                ;
            }

        }
    }
}
