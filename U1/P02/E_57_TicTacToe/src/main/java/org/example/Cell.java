package org.example;

public class Cell {
    private char state;
    private final int id;

    public Cell(int id) {
        this.id = id;
        // this.position = position;
    }

    /*public int[] getPosition() {
        assert this.position != null;
        return new int[]{
            Integer.parseInt(String.valueOf(this.position.charAt(0))),
            Integer.parseInt(String.valueOf(this.position.charAt(2)))
        };
    }*/

    public char getState() {
        return state;
    }

    public void setState(char state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return switch (this.state){
          case ' ' -> String.valueOf(this.id);
          case 'X' -> "X";
          case 'O' -> "O";
          default -> throw new IllegalStateException("Unexpected value: " + this.state);
        };
    }
    /*public int[][] getParentPositions(){
        return new int[][]{
                {this.x. this.y+1},
                {this.getPosition()[0] - 1, this.getPosition()[1]    },{this.getPosition()[0], this.getPosition()[1]    },{this.getPosition()[0] + 1, this.getPosition()[1]    },
                {this.getPosition()[0] - 1, this.getPosition()[1] + 1},{this.getPosition()[0], this.getPosition()[1] + 1},{this.getPosition()[0] + 1, this.getPosition()[1] + 1}
        };
    }*/
}
