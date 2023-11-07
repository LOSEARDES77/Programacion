package org.example;

import java.util.HashMap;

public class Grid {
    private final int size;
    private final int layers;
    private Cell[][][] grid;


    public Grid(int size, int layers) {
        this.size = size;
        this.layers = layers;
        this.grid = genGrid();
    }

    private Cell[][][] genGrid(){
        Cell[][][] tmpgrid = new Cell[layers][size][size];
        for (int i = 0; i < layers; i++){
            for (int j = 0; j < size; j++){
                for (int k = 0; k < size; k++){
                    boolean state = (int) (Math.random() * 10) < 2;
                    // Debug System.out.printf("Cell at %d, %d, %d is %s\n", i, j, k, state ? "alive" : "dead");
                    tmpgrid[i][j][k] = new Cell(state, new int[]{i, j, k});
                }
            }
        }
        return tmpgrid;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < layers; i++){
            result.append("\n" + "Layer ").append(i + 1).append("\n");
            for (int j = 0; j < size; j++){
                result.append("\n").append("---".repeat(size)).append("\n");
                for (int k = 0; k < size; k++) {
                    result.append("|").append(grid[i][j][k].toString()).append("|");
                }
            }
            result.append("\n").append("---".repeat(size));
        }
        return result.toString();
    }

    private boolean[][][] getNeighbourStates(Cell a){
        boolean[][][] states = new boolean[layers][size][size];
        for (int i = -1; i < 1; i++){
            for (int j = -1; j < 1; j++){
                for (int k = -1; k < 1; k++){
                    if (doesCellExist(a.getPossition()[0] + i, a.getPossition()[1] + j, a.getPossition()[2] + k))
                        states[i + 1][j + 1][k + 1] = grid[a.getPossition()[0] + i][a.getPossition()[1] + j][a.getPossition()[2] + k].getState();
                }
            }
        }
        return states;
    }

    private boolean doesCellExist(int i, int j, int k) {
        return i >= 0 && i < layers && j >= 0 && j < size && k >= 0 && k < size;
    }

    private boolean predictCellState(Cell a){
        return a.predictCellState(getNeighbourStates(a));
    }

    public void nextGen(){
        Cell[][][] tmpgrid = grid;
        for (int i = 0; i < layers; i++){
            for (int j = 0; j < size; j++){
                for (int k = 0; k < size; k++){
                    tmpgrid[i][j][k].setState(predictCellState(tmpgrid[i][j][k]));
                }
            }
        }
        grid = tmpgrid;
    }


}
