package org.example;

import javax.swing.*;
import java.util.HashMap;

public class Grid {
    private Cell[] grid;
    private final int size = 3;

    private final Player[] players;

    public Grid() {
        this.grid = this.genGrid();
        this.players = new Player[2];
        this.players[0] = new Player(JOptionPane.showInputDialog("Enter Player 1 name"));
        this.players[1] = new Player(JOptionPane.showInputDialog("Enter Player 2 name"));
    }
    public Grid(Player[] players) {
        this.grid = this.genGrid();
        this.players = players;
    }
    public Player[] getPlayers(){
        return this.players;
    }

    private final int[][] win = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}};

    public boolean checkWin(char c){
        char[] board = this.getBoard();
        for (int i = 0; i < 8; i++)
            if (board[this.win[i][0]] == c && board[this.win[i][1]] == c && board[this.win[i][2]] == c)
                return true;

        return false;
    }

    private char[] getBoard(){
        char[] board = new char[9];
        for (int i = 0; i < 9; i++){
            board[i] = grid[i].getState();
        }
        return board;
    }
    public Cell[] genGrid() {
        Cell[] cells = new Cell[(int) Math.pow(this.size, 2)];
        for (int i = 0; i < Math.pow(this.size, 2); i++){
            cells[i] = new Cell(i + 1);
        }
        return cells;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Best of 3 match\n").append("————".repeat(this.size)).append("—\n     ").append(players[0].getName()).append(": ").append(players[0].getWins()).append("          ").append(players[1].getName()).append(": ").append(players[1].getWins()).append("\n");
        for (int i = 0; i < this.size; i++){
            result.append("————".repeat(this.size));
            result.append("—\n");
            for (int j = this.size * i; j < this.size * (i+1); j++)
                result.append("|       ").append(grid[j]).append("       ");
            result.append("|\n");
        }
        result.append("————".repeat(this.size));
        result.append("—\n");
        return result.toString();

    }
    public boolean isMathOver() {
        if( checkWin('X') || checkWin('O')) return true;
        for (Cell cell : this.grid)
            if (cell.getState() == ' ') return false;
        return true;
    }

    private boolean isValidMove(int move) {
        return move < 9 && move > -1 && this.grid[move].getState() == ' ' ;
    }

    public void player1() {
        int move = Integer.parseInt(JOptionPane.showInputDialog(this + "\n" + players[0].getName() + "\nEnter a number")) - 1;
        if (this.isValidMove(move)) {
            this.grid[move].setState('X');
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid move");
            player1();
        }
    }

    public void player2() {
        int move = Integer.parseInt(JOptionPane.showInputDialog(this + "\n" + players[1].getName() + "\nEnter a number")) - 1;
        if (this.isValidMove(move))
            this.grid[move].setState('O');
        else{
            JOptionPane.showMessageDialog(null, "Invalid move");
            player2();

        }
    }

}
