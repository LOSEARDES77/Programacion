package org.example;

public class Main {
    public static void main(String[] args) {
        int[] tiradas = new int[6];
        int i = 0;
        while ( i < Integer.MAX_VALUE){
            i++;
            int numero = randomNumber();
            tiradas[numero-1]++;
        }
        for (i = 1; i <= tiradas.length; i++) {
            System.out.println(i + " -> " + tiradas[i-1]);
        }

    }

    public static int randomNumber(){
        return (int) (Math.random() * 6) + 1;
    }









    /*
    switch (numero){
                case 1 -> tiradas[0]++;
                case 2 -> tiradas[1]++;
                case 3 -> tiradas[2]++;
                case 4 -> tiradas[3]++;
                case 5 -> tiradas[4]++;
                case 6 -> tiradas[5]++;
            }
     */
}