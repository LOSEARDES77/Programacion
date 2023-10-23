package com.loseardes77;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner t = new Scanner(System.in);
        System.out.print("De que tamaño quieres que sea la tabla?: ");
        int size = t.nextInt();
        Grid grid = new Grid(new int[]{size, size});
        System.out.print("Cuantas generaciones quieres jugar?: ");
        int generaciones = t.nextInt();
        for (int i = 0; i < generaciones; i++){
            System.out.println("Generacion " + (i+1) + ":\n");
            grid.printGrid();
            grid.nextGen();
            System.out.println("\n================================\n");
        }
    }
}