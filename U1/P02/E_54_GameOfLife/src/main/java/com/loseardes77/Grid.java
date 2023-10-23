package com.loseardes77;

import java.util.ArrayList;

public class Grid {
    private final int[] size;
    private final ArrayList<Cell> cells;

    public Grid(int[] size) {
        this.size = size;
        this.cells = this.genCells();
    }

    public Grid(int[] size, ArrayList<Cell> cells) {
        this.size = size;
        this.cells = cells;
    }

    public ArrayList<Cell> genCells(){
        if (!areThereCells()){
            ArrayList<Cell> cells = new ArrayList<>();
            for(int i = 0; i < this.size[0] - 1; i++){
                for (int j = 0; j < this.size[1] - 1; j++){
                    boolean state = 1 < (int) (Math.random() * 5) + 1;
                    cells.add(new Cell(state, i, j));
                }
            }
            return cells;
        }
        return null;
    }
    public void printGrid(){
        for (int j = 0; j < this.size[1]; j++) {
            for (int i = 0; i < this.size[0]-1; i++) {
                System.out.print("-----");
            }
            System.out.println();
            for (int i = 0; i < this.size[0]-1; i++) {
                System.out.print("| " + this.getCellState(i, j) + " |");
            }
            System.out.println();
            for (int i = 0; i < this.size[0]-1; i++) {
                System.out.print("-----");
            }
        }


    }

    private int getCellState(int i, int j) {
        boolean state = this.cells.get(i)[j].getState()[0];
        if (state) return 1;
        else return 0;
    }

    private boolean areThereCells(){
        try{
            this.cells.get(0)[0].getState();
            return true;
        }catch (IndexOutOfBoundsException e){
            return false;
        }
    }
}
