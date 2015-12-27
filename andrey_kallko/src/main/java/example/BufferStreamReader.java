package example;

/**
 * Created by elenabugercuk on 26.12.15.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;



public class BufferStreamReader {
    public BufferStreamReader() {
    }

    public static void main(String[] args) throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        new BufferedReader(isr);
        FileInputStream fis = new FileInputStream("/Users/elenabugercuk/Documents/workspace/Foundation29/file.txt");
        String result = "";
        int codeChar = 10;

        while(codeChar > -1) {
            codeChar = fis.read();
            int cif = codeChar - 48;
            result = result + cif;
            System.out.println(codeChar + " = [" + (char)codeChar + "]" + " = " + cif);
            System.out.println(result);
        }

        System.out.println(result);

        while(!result.equals("-49")) {
            int end = result.indexOf("-");
            String temp = result.substring(0, end);
            int toPrint = Integer.parseInt(temp) * 2;
            System.out.print(toPrint);
            result = result.substring(end, result.length());
            if(result.startsWith("-16")) {
                System.out.print(" ");
            } else {
                System.out.println();
            }

            if(!result.equals("-49")) {
                result = result.substring(3, result.length());
            }
        }

    }
}
