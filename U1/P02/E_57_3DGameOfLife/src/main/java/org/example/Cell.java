package org.example;

import java.util.Arrays;

public class Cell {
    private boolean state;
    private final int[] possition;

    public boolean predictCellState(boolean[][][]  neighbours){
        int count = 0;
        boolean futureState = this.state;
        for( boolean[][] neighbours1 : neighbours)
            for (boolean[] neighbours2 : neighbours1)
                for (boolean neighbour : neighbours2)
                    if (neighbour) count++;
        if (count < 2 || count > 3) futureState = false;
        else if (!this.state && count == 3) futureState = true;
        return futureState;
    }

    public boolean getState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int[] getPossition() {
        return possition;
    }

    public Cell(boolean state, int[] possition) {
        this.state = state;
        this.possition = possition;
    }

    @Override
    public String toString() {
        if (this.state) return "1";
        else return "0";
    }
}
