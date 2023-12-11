package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        test();
        while (true){
            String input = JOptionPane.showInputDialog("Introduce un DNI");
            if (input == null || input.isEmpty()){
                JOptionPane.showMessageDialog(null, "Hasta pronto");
                System.exit(0);
                break;
            }
            DNI dni = new DNI(input);
            if (dni.DNICorrecto()){
                JOptionPane.showMessageDialog(null, "DNI correcto\n" + dni);
            } else {
                JOptionPane.showMessageDialog(null, "DNI incorrecto");
            }
        }
    }


    private static void test(){
        String[] tests = new String[]{
                "125544f",
                "y22j",
                "H35444d",
                "12jj221m",
                "X25",
                "12345"
        };

        for (String test : tests){
            DNI dni = new DNI(test);
            System.out.println(dni);
            // System.out.println(dni.DNICorrecto());
        }
    }
}