package org.example;

public class Grid {
    private Cell[] grid;
    private final int size = 3;

    public Grid() {
        this.grid = this.genGrid();
    }

    public Cell[] genGrid(){
        Cell[] cells = new Cell[(int) Math.pow(this.size, 2)];
        for (int i = 0; i < Math.pow(this.size, 2); i++)
            cells[i] = new Cell(i+1);
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

    public boolean isMathOver() {
        // TODO Hacer esto
        return true;
    }
}
