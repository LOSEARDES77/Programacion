package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        while(!grid.isMathOver()) {
            System.out.println(grid);
            grid.player1();
            System.out.println(grid);
            if (grid.isMathOver()){
                break;
            }
            grid.player2();
        }

    }
}