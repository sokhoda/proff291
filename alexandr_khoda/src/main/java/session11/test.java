package session11;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by s_okhoda on 06.02.2016.
 */
public class test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите ид пользователя:");
        long id = -1;
        boolean flag = true;
        while (flag) {
            try {
                id = Long.parseLong(scan.nextLine());
                flag = false;
            }
            catch (NumberFormatException e) {
                System.out.println("Некорректный ид. Попробуйте еще раз.");
            }
        }

        System.out.println("=" + id);
    }
}
