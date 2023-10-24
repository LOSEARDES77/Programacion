package org.example;

public class Cell {
    private int state;
    private final int id;

    public Cell(int position) {
        this.id = position;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return switch (this.state){
          case 0 -> String.valueOf(this.id);
          case -1 -> "X";
          case 1 -> "O";
          default -> throw new IllegalStateException("Unexpected value: " + this.state);
        };
    }
}
