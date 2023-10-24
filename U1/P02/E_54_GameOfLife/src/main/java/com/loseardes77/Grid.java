package com.loseardes77;

import java.util.HashMap;

public class Grid {
    private final int[] size;
    private final HashMap<String, Cell> cells;


    public Grid(int[] size) {
        super();
        this.size = size;
        this.cells = new HashMap<>();
        this.genCells();
    }

    public Grid(int[] size, HashMap<String, Cell> cells) {
        super();
        this.size = size;
        this.cells = cells;
    }

    public void genCells(){
        if (cells.isEmpty()){
            for(int i = 0; i < this.size[0]; i++){
                for (int j = 0; j < this.size[1]; j++){
                    boolean state = 2 > (int) (Math.random() * 5) + 1;
                    cells.put(i + ":" + j, new Cell(state, i, j));
                }
            }
        }
    }
    public void printGrid(){
        for (int i = 0; i < this.size[1]; i++) {

            for (int j = 0; j < this.size[0]; j++)
                System.out.print("————");

            System.out.println("—");

            for (int j = 0; j < this.size[0]; j++) {
                System.out.print("| " + this.cells.get(i + ":" + j).intState() + " ");
            }
            System.out.println("|");
        }
        for (int j = 0; j < this.size[0]; j++)
            System.out.print("————");
        System.out.println("—");
    }

    public void nextGen() {
        // HashMap<String, Cell> tempGrid = new HashMap<>();
        for (Cell cell : this.cells.values()){
            int[][] neighboursPositions = cell.getNeighbours();
            boolean[] neighboursStates = new boolean[9];
            for (int i = 0; i < neighboursPositions.length; i++){
                boolean neighbourState;
                if( neighboursPositions[i][0] < 0 || neighboursPositions[i][1] < 0){
                    neighbourState = false;
                }else {
                    Cell neighbourCell = this.cells.get(neighboursPositions[i][0] + ":" + neighboursPositions[i][1]);
                    if (neighbourCell == null) neighbourState = false;
                    else neighbourState = neighbourCell.getState();
                }neighboursStates[i] = neighbourState;
            }
            cell.updateState(neighboursStates);
        }
    }

    public static void main(String[] args) {
        Grid grid = new Grid(new int[]{3,3});
        grid.printGrid();
        grid.nextGen();
        grid.printGrid();
    }
}
