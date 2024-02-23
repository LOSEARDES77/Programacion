package org.zaragoza2023;

import java.util.Objects;
import java.util.Scanner;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class EspiralesTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String entrada = s.nextLine();
        while (!Objects.equals(entrada, "0")){
            int n = Integer.parseInt(entrada);
            int[][] matriz = new int[n][n];
            for (int i = 0; i < n; i++){
                String[] fila = s.nextLine().split(" ");
                for (int j = 0; j < n; j++) {
                    matriz[i][j] = Integer.parseInt(fila[j]);
                }
            }
            System.out.println(galacticSpiral(matriz));
            entrada = s.nextLine();
        }
    }

    @Test(timeout = 10000)
    public void testEspiral3x3(){
        assertEquals(9, galacticSpiral(new int[][]{
                new int[]{3, 3, 4},
                new int[]{2, 2, 7},
                new int[]{1, 3, 5}
        }));
    }

    @Test(timeout = 10000)
    public void testEspiral5x5(){
        assertEquals(41, galacticSpiral(new int[][]{
                new int[]{2, 4, 4, 4, 4},
                new int[]{2, 3, 3, 4, 5},
                new int[]{5, 2, 2, 7, 1},
                new int[]{2, 1, 3, 5, 3},
                new int[]{2, 4, 3, 1, 2}
        }));
    }

    @Test(timeout = 10000)
    public void testEspiral7x7(){
        assertEquals(54, galacticSpiral(new int[][]{
                new int[]{2, 1, 2, 2, 3, 2, 3},
                new int[]{4, 2, 4, 4, 4, 4, 4},
                new int[]{3, 2, 3, 3, 4, 5, 3},
                new int[]{4, 5, 2, 2, 7, 1, 2},
                new int[]{5, 2, 1, 3, 5, 3, 6},
                new int[]{4, 2, 4, 3, 1, 2, 0},
                new int[]{3, 9, 9, 9, 9, 2, 9}
        }));
    }

    @Test(timeout = 10000)
    public void testEspiral9x9(){
        assertEquals(114, galacticSpiral(new int[][]{
                new int[]{1, 2, 4, 6, 2, 3, 5, 7, 0},
                new int[]{2, 2, 1, 2, 2, 3, 2, 3, 1},
                new int[]{1, 4, 2, 4, 4, 4, 4, 4, 1},
                new int[]{0, 3, 2, 3, 3, 4, 5, 3, 2},
                new int[]{3, 4, 5, 2, 2, 7, 1, 2, 3},
                new int[]{1, 5, 2, 1, 3, 5, 3, 6, 1},
                new int[]{2, 4, 2, 4, 3, 1, 2, 0, 2},
                new int[]{2, 3, 9, 9, 9, 9, 2, 9, 3},
                new int[]{7, 8, 4, 2, 1, 0, 1, 7, 5}
        }));
    }

    private static int galacticSpiral(int[][] matriz) {
        int n = matriz.length;
        int[] casillaCentral = new int[]{n / 2, n / 2};
        int[] siguienteCasilla = new int[]{0, 0, 0};
        int suma = 0;
        int contador = 1;
        while (isPosValid(matriz, new int[]{siguienteCasilla[0] + casillaCentral[0], siguienteCasilla[1] + casillaCentral[1] })) {
            for (int i = 0; i < contador; i++) {
                // if (!isPosValid(matriz, new int[]{siguienteCasilla[0] + casillaCentral[0], siguienteCasilla[1] + casillaCentral[1] })) break;
                suma += matriz[siguienteCasilla[0] + casillaCentral[0]][siguienteCasilla[1] + casillaCentral[1]];
                calcularSiguienteCasilla(siguienteCasilla);
            }
            if (siguienteCasilla[2] == 3) {
                siguienteCasilla[2] = 0;
            } else {
                siguienteCasilla[2]++;
            }
            contador++;
        }

        return suma;
    }

    private static boolean isPosValid(int[][] matrix, int[] pos){
        try{
            int ignored = matrix[pos[0]][pos[1]];
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
    }

    private static void calcularSiguienteCasilla(int[] siguienteCasilla) {
            switch (siguienteCasilla[2]) {
                case 0: {
                    siguienteCasilla[0]--;
                    break;
                }
                case 1: {
                    siguienteCasilla[1]++;
                    break;
                }
                case 2: {
                    siguienteCasilla[0]++;
                    break;
                }
                case 3: {
                    siguienteCasilla[1]--;
                    break;
                }
            }
    }


}
