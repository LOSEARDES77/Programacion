package org.example;

import java.util.HashMap;

public class Grid {
    private Cell[] grid;
    private final int size = 3;
    // private final HashMap<String, Cell> cells;

    public Grid() {
        this.grid = this.genGrid();
    }


    private final int[][] win = {{0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}};

    private boolean checkWin(char c){
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
/*    private String genCellPossition(String lastPos){
        if (lastPos.isEmpty()) return "0:0";
        int x = Integer.parseInt(String.valueOf(lastPos.charAt(0)));
        int y = Integer.parseInt(String.valueOf(lastPos.charAt(2)));
        if(x == this.size-1) {y++; x = 0;}
        else x++;
        return posToString(x,y);
    }*/
    public Cell[] genGrid() {
        Cell[] cells = new Cell[(int) Math.pow(this.size, 2)];
        for (int i = 0; i < Math.pow(this.size, 2); i++){
            cells[i] = new Cell(i + 1);
        }
        return cells;
    }

    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < this.size; i++){
            result.append("————".repeat(this.size));
            result.append("—\n");
            for (int j = this.size * i; j < this.size * (i+1); j++)
                result.append("| ").append(grid[j].toString()).append(" ");
            result.append("|\n");
        }
        result.append("————".repeat(this.size));
        result.append("—\n");
        return result.toString();

    }


/*    private String posToString(int x, int y){
        return x + ":" + y;
    }
    private String posToString(int[] pos){
        return pos[0] + ":" + pos[1];
    }*/

   /* private int[] getNeighbourStates(Cell cell){
        int[] neighbourStates = new int[9];
        int contador = 0;
        for(int[] pos : cell.getParentPositions()){
            neighbourStates[contador] = this.cells.get(posToString(pos)).getState();
            contador++;
        }
        return neighbourStates;
    }*/

/*    private Cell cellAt(int x, int y){
        return this.cells.get(posToString(x,y));
    }*/
    public boolean isMathOver() {
        return checkWin('X') || checkWin('O');
    }

    public void player1() {
    }

    public void player2() {
    }
}
