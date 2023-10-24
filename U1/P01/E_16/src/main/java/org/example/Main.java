package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un numero entero: "));
        int numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro numero entero: "));
        System.out.println("Tabla de multiplicar de " + numero1 + " hasta "+ numero2);
        int contador = 0;
        while (contador < (numero2 + 1)){
            System.out.println(numero1 + " x " + contador + " = " + (numero1 * contador));
            contador++;
        }
    }
}