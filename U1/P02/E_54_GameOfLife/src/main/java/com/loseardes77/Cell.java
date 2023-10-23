package com.loseardes77;

public class Cell {
    private boolean isAlive;
    private final int x;
    private final int y;

    public Cell(boolean isAlive, int x, int y) {
        this.isAlive = isAlive;
        this.x = x;
        this.y = y;
    }

    public boolean[] getState(){
        return new boolean[]{ this.isAlive};
    }

    public int[] getPos(){
        return new int[]{this.x,this.y};
    }

    public void updateState(boolean[] neighbours){
        int count = 0;
        for (int i = 0; i < neighbours.length; i++){
            if (i != 4)
                if (neighbours[i]) count++;
        }
        if (count == 2 || count == 3 && !this.isAlive){
            this.isAlive = true;
        }
    }

    public void printCell(){
        if(this.isAlive)
            System.out.println("=====\n| 1 |\n=====");
        else
            System.out.println("=====\n| 0 |\n=====");
    }
    public int[][] getNeighbours(){
        return new int[][]{
                {this.x - 1, this.y + 1},{this.x, this.y + 1},{this.x + 1, this.y + 1},
                {this.x - 1, this.y    },{this.x, this.y    },{this.x + 1, this.y    },
                {this.x - 1, this.y + 1},{this.x, this.y + 1},{this.x + 1, this.y + 1}
        };
    }

}
