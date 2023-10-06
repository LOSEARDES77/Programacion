package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Integer> arr;
    public static void main(String[] args) {
        genNumero();
        System.out.println("Array desordenado: " + arr);
        Collections.sort(arr);
        System.out.println("Array ordenado: " + arr);

    }

    private static void genNumero(){
        arr = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int num = (int) (Math.random() * 100);
            if (arr.contains(num)) i--;
            else arr.add(num);
        }
    }
}