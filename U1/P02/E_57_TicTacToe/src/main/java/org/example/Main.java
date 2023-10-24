package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        int winner = 0;
        // System.out.println(grid);
        while(winner == 0){
            grid.player1();
            // System.out.println(grid);
            winner = grid.determineWinner();
            if (grid.isMathOver()){
                break;
            }
            grid.player2();
            // System.out.println(grid);
            winner = grid.determineWinner();
            if (grid.isMathOver()){
                break;
            }
        }
        switch (winner){
            case 1 -> JOptionPane.showMessageDialog(null, "Player 1 wins");
            case 2 -> JOptionPane.showMessageDialog(null, "Player 2 wins");
            default -> JOptionPane.showMessageDialog(null, "Draw");
        }
    }
}