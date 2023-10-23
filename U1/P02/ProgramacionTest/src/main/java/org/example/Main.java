package org.example;

public class Main {
    public static void main(String[] args) {
        int[] tiradas = new int[6];
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            int numero = randomNumber();
            tiradas[numero-1]++;
        }
        for (int i = 1; i <= tiradas.length; i++) {
            System.out.println(i + " -> " + tiradas[i-1]);
        }

    }

    public static int randomNumber(){
        return (int) (Math.random() * 6) + 1;
    }
}