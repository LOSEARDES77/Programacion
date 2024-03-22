package org.zaragoza2024;

import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.*;

public class H_Laberinto {

    @Test
    public void test() {
        boolean res1 = solve(new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, true},
                {true, true, true, false, false},
        });
        System.out.println(res1 ? "SI" : "NO");
        assertTrue(res1);
        boolean res2 = solve(new boolean[][]{
                {false, false, false, false, false},
                {false, false, false, false, true},
                {true, true, true, true, false},
        });
        System.out.println(res2 ? "SI" : "NO");
        assertFalse(res2);
        boolean res3 = solve(new boolean[][]{
                {false, true, true, true, true},
                {false, false, true, true, true},
                {true, false, false, true, true},
                {true, true, false, false, true},
                {true, true, true, false, false},
        });
        System.out.println(res3 ? "SI" : "NO");
        assertTrue(res3);
        boolean res4 = solve(new boolean[][]{
                {false, false, false, false, false},
                {true, true, true, true, false},
                {false, false, false, false, false},
                {false, true, true, true, true},
                {false, false, false, false, false},
        });
        System.out.println(res4 ? "SI" : "NO");
        assertTrue(res4);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        try {
            while (true){
                String[] parts = s.nextLine().split(" ");
                int a = Integer.parseInt(parts[0]);
                int b = Integer.parseInt(parts[1]);
                boolean[][] laberinto = new boolean[a][b];
                for (int i = 0; i < a; i++){
                    String fila = s.nextLine();
                    for (int j = 0; j < b; j++){
                        laberinto[i][j] = fila.charAt(j) != '.';
                    }
                }
                System.out.println(solve(laberinto) ? "SI" : "NO");
            }
        } catch (Exception e) {
            s.close();
        }

    }


    public static boolean solve(boolean[][] laberinto) {
        return dfs(0, 0, laberinto);
    }

    private static boolean dfs(int i, int j, boolean[][] laberinto) {
        int rows = laberinto.length;
        int cols = laberinto[0].length;

        if (i == rows - 1 && j == cols - 1) {
            return true;
        }

        if (i < 0 || i >= rows || j < 0 || j >= cols || laberinto[i][j]) {
            return false;
        }
        laberinto[i][j] = true;

        boolean foundPath = dfs(i + 1, j, laberinto) || // Down
                dfs(i - 1, j, laberinto) || // Up
                dfs(i, j + 1, laberinto) || // Right
                dfs(i, j - 1, laberinto);  // Left

        laberinto[i][j] = false;
        return foundPath;
    }
}
