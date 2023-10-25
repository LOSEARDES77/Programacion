package org.example;

public class Cell {
    private char state = ' ';
    private final int id;

    public Cell(int id) {
        this.id = id;
    }

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return switch (this.state){
            case ' ' -> {
                if (this.id < 9) yield "  " + this.id;
                else yield String.valueOf(this.id );
            }
            case 'X' -> "X";
          case 'O' -> "O";
          default -> throw new IllegalStateException("Unexpected value: " + this.state);
        };
    }
}
