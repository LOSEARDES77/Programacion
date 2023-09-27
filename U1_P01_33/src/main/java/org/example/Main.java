package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int x = 0, y = 0;
        Scanner teclado = new Scanner(System.in);
        while (y < 15 && !estaEnElAgua(x)){
            System.out.print("Introduce un numero: ");
            int numero = teclado.nextInt();
            ArrayList<Integer> temp = handleMovement(x, y, numero);
            x = temp.get(0);
            y = temp.get(1);
        }
        if(estaEnElAgua(x)){
            System.out.println("El marinero se ahogo");
        } else if (y >= 15) {
            System.out.println("El marinero llego a su barco");
        }

    }

    public static ArrayList<Integer> handleMovement(int xpos, int ypos, int numero){
        ArrayList<Integer> posicion = new ArrayList<>();
        int x = xpos, y = ypos;
        if (numero < 0){
            System.out.println("El marinero se durmio");
        } else if (numero % 2 == 0) {
            y++;
            System.out.println("El marinero avanzo un paso");
        } else if ((numero-1) % 4 == 0 ) {
            x++;
            System.out.println("El marinero avanzo hacia la derecha");
        } else {
            x--;
            System.out.println("El marinero avanzo hacia la izquierda");
        }
        posicion.add(0, x);
        posicion.add(1, y);
        System.out.println("Posicion: " + posicion);
        return posicion;
    }

    public static boolean estaEnElAgua(int x){
        return x > 2 || x < -2;
    }
}