package hacker;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int t = in.nextInt();
            for(int a0 = 0; a0 < t; a0++){
                int n = in.nextInt();
                checkCif(n);
            }
        }

   public static void checkCif(int n){
       String temp=""+n;
       char[] cifrus = temp.toCharArray();
       int size=cifrus.length;
       int i=0;
       int count=0;
       while(i<size){
           int cif = (int)cifrus[i]-48;
           System.out.println(cif);
           if(cif!=0){
               if (n%cif==0){
                   count++;
               }
           }
           i++;
       }

       System.out.println(count);

    }

    }