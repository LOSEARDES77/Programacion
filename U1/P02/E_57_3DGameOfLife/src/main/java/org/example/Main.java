package org.example;

public class Main {
    public static void main(String[] args) {
        int size = 3;
        int layers = 3;
        int generations = 3;
        Grid grid = new Grid(size, layers);
        System.out.printf("Initial state:\n%s\n", grid);
        for (int i = 0; i < generations; i++){
            grid.nextGen();
            System.out.printf("Generation %d:\n", i + 1);
            System.out.println(grid);
        }
    }
}