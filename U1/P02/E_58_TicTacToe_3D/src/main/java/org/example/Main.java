package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Grid grid = new Grid();
        Player[] players = grid.getPlayers();
        while(true){
            grid.player1();
            if (grid.isMathOver()){
                players[0].addWin();
                grid = new Grid(players);
                players = grid.getPlayers();
                if(players[0].getWins() >= 2 || players[1].getWins() >= 2)
                    break;
            }
            grid.player2();
            if (grid.isMathOver()){
                players[1].addWin();
                grid = new Grid(players);
                if(players[0].getWins() >= 2 || players[1].getWins() >= 2)
                    break;

            }
        }
        if (players[0].getWins() == 2) {
            JOptionPane.showMessageDialog(null, players[0].getName() + " wins");
        } else if (players[1].getWins() == 2) {
            JOptionPane.showMessageDialog(null, players[1].getName() + " wins");
        } else {
            JOptionPane.showMessageDialog(null, "Draw");
        }
    }
}