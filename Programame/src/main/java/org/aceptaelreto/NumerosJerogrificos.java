package org.aceptaelreto;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class NumerosJerogrificos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in;
        ArrayList<Integer> ins = new ArrayList<>();

        while (!Objects.equals(in = s.nextLine(), "0")){
            ins.add(Integer.parseInt(in));
        }

        for (int i : ins){
            StringBuilder res = new StringBuilder();
            while (i > 0){
                while (i >= 1000000){
                    i -= 1000000;
                    res.append("H");
                }
                while (i >= 100000){
                    i -= 1000000;
                    res.append("R");
                }
                while (i >= 10000){
                    i -= 10000;
                    res.append("D");
                }
                while (i >= 1000){
                    i -= 1000;
                    res.append("F");
                }
                while (i >= 100){
                    i -= 100;
                    res.append("C");
                }
                while (i >= 10){
                    i -= 10;
                    res.append("G");
                }while (i >= 1){
                    i -= 1;
                    res.append("T");
                }
            }
            System.out.println(res);
        }
    }
}
