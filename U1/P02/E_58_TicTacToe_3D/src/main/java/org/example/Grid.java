package org.example;

import javax.swing.*;
import java.util.HashMap;

public class Grid {
    private Cell[][] grid;
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

    private final int[][] win = {
            // 2D win conditions
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6},
            // Vertical win conditions
            {0, 9, 18}, {1, 10, 19}, {2, 11, 20},
            {3, 12, 21}, {4, 13, 22}, {5, 14, 23},
            {6, 15, 24}, {7, 16, 25}, {8, 17, 26},
            // Horizontal win conditions
            {0, 10, 20}, {3, 13, 23}, {6, 16, 26},
            {2, 10, 18}, {5, 13, 21}, {8, 16, 24},
            // Diagonal win conditions
            {0, 13, 26}, {2, 13, 24}
    };

    private boolean checkWin(char c){
        char[] board = this.getBoard();
        for (int i = 0; i < 8; i++)
            if (board[this.win[i][0]] == c && board[this.win[i][1]] == c && board[this.win[i][2]] == c)
                return true;

        return false;
    }

    private char[] getBoard(){
        char[] board = new char[(int) Math.pow(this.size, 3)];
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < Math.pow(this.size, 2); j++)
                board[i+j] = grid[i][j].getState();

        return board;
    }
    public Cell[][] genGrid() {
        Cell[][] cells = new Cell[this.size][(int) Math.pow(this.size, 2)];
        for (int i = 0; i < this.size; i++)
            for (int j = 0; j < Math.pow(this.size, 2); j++)
                cells[i][j] = new Cell(coordToIndex(new int[]{i, j}) + 1);

        return cells;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append("Best of 3 match\n").append("————".repeat(this.size)).append("—\n     ").append(players[0].getName()).append(": ").append(players[0].getWins()).append("          ").append(players[1].getName()).append(": ").append(players[1].getWins()).append("\n");
        for (int i = 0; i < this.size; i++){
            for (int j = 0; j < this.size; j++){
                result.append("————".repeat(this.size));
                result.append("—\n");
                for (int k = this.size * j; k < this.size * (j+1); k++)
                    result.append("|       ").append(grid[i][k]).append("       ");
                result.append("|\n");
            }
            result.append("————".repeat(this.size));
            result.append("—\n");
        }
        return result.toString();
    }
    public boolean isMathOver() {
        if( checkWin('X') || checkWin('O')) return true;
        for (Cell[] cellArr : this.grid)
            for (Cell cell : cellArr)
                if (cell.getState() == ' ') return false;
        return true;
    }
    private int[] indexToCoord(int index) {
        if (index < 0 || index > 26) throw new NumberFormatException();
        int i, j;
        if (index < 9){
            i = 0;
            j = index;
        }else if (index < 18) {
            i = 1;
            j = index - 9;
        }else {
            i = 2;
            j = index - 18;
        }
        return new int[]{i, j};
    }

    private int coordToIndex(int[] coord) {
        if (coord[0] < 0 || coord[0] > 2 || coord[1] < 0 || coord[1] > 9) throw new NumberFormatException();
        return coord[0] * 9 + coord[1];
    }

    public Cell getCell(int index) {
        int[] coord = this.indexToCoord(index);
        return this.grid[coord[0]][coord[1]];
    }

    private boolean isValidMove(int move) {
        return move < 28 && move > -1 && this.getCell(move).getState() == ' ' ;
    }

    public void player1() {
        int move = Integer.parseInt(JOptionPane.showInputDialog(this + "\n" + players[0].getName() + "\nEnter a number")) - 1;
        if (this.isValidMove(move)) {
            this.getCell(move).setState('X');
        }
        else{
            JOptionPane.showMessageDialog(null, "Invalid move");
            player1();
        }
    }

    public void player2() {
        int move = Integer.parseInt(JOptionPane.showInputDialog(this + "\n" + players[1].getName() + "\nEnter a number")) - 1;
        if (this.isValidMove(move))
            this.getCell(move).setState('O');
        else{
            JOptionPane.showMessageDialog(null, "Invalid move");
            player2();

        }
    }

}
