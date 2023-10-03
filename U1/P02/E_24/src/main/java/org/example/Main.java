package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            arr1.add((int) (Math.random() * 10) +1);
            arr2.add((int) (Math.random() * 10) +1);
        }
        System.out.println("Array 1: " + arr1);
        System.out.println("Array 2: " + arr2);
        System.out.println("Suma:    " + suma(arr1, arr2));
    }

    private static ArrayList<Integer> suma(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> suma = new ArrayList<>();
        for (int i = 0; i < Math.max(arr1.size(), arr2.size()); i++) {
            suma.add(arr1.get(i) + arr2.get(i));
        }
        return suma;
    }
}