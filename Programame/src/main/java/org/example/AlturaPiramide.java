package org.example;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class AlturaPiramide {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String in;
        ArrayList<Integer> ins = new ArrayList<>();

        while (!Objects.equals(in = s.nextLine(), "0")){
            ins.add(Integer.parseInt(in));
        }
        for (int i : ins){
            long bloquesMaximos = 1;
            int bloquesMinimos = 1;
            int pisos = 1;
            while (bloquesMinimos < i){
                bloquesMaximos += (pisos * 2L + 1) * (pisos * 2L + 1);
                bloquesMinimos = (pisos * 2 + 1) * (pisos * 2 + 1);
                if (i > bloquesMaximos && bloquesMinimos < i) {
                    pisos++;
                }else break;
            }
            System.out.println(pisos);
        }
    }
}
