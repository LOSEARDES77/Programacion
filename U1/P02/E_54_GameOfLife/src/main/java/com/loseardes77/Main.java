package com.loseardes77;

import javax.swing.JOptionPane;


public class Main {
    public static void main(String[] args) {
        int size = Integer.parseInt(JOptionPane.showInputDialog("De que tamaño quieres que sea la tabla?"));;
        Grid grid = new Grid(new int[]{size, size});
        int generaciones = Integer.parseInt(JOptionPane.showInputDialog("Cuantas generaciones quieres jugar?"));
        for (int i = 0; i < generaciones; i++){
            System.out.println("Generacion " + (i+1) + ":\n");
            grid.printGrid();
            grid.nextGen();
            System.out.println("\n================================\n");
        }
    }
}