package org.zaragoza2023;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LaCompraTest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        StringBuilder entrada = new StringBuilder(s.nextLine() + "\n");
        int numDeBloques = Integer.parseInt(s.nextLine());
        for (int i = 0; i < numDeBloques; i++){
            String e = s.nextLine();
            if (e.equals("0")) break;
            entrada.append(e);
        }
        System.out.println(hacerLaCompra(entrada.toString()));
    }
    public static String hacerLaCompra(String compra) {
        StringBuilder resultado = new StringBuilder();
        String[] entrada = compra.split("\n");
        int unidades = Integer.parseInt(entrada[0]);
        int[][] m = new int[entrada.length-1][2];
        for (int i = 1; i < entrada.length; i++) {
            String[] producto = entrada[i].split(" ");
            m[i-1][0] = Integer.parseInt(producto[0]);
            m[i-1][1] = Integer.parseInt(producto[1]);
        }
        Arrays.sort(m, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return - Integer.compare(o1[0], o2[0]);
            }
        });

        int contador = 0;
        int sobrantes = 0;
        for (int i = 0; i < m.length && contador < unidades; i++){
            while (m[i][1] > 0) {
                if (contador >= unidades) break;
                m[i][1]--;
                contador++;
            }
            if (i == m.length -1 && contador < unidades){
                sobrantes = unidades - contador;
            }
        }
        for (int i = 0; i < m.length; i++){
            resultado.append(m[i][0]).append(" ").append(m[i][1]).append("\n");
        }
        resultado.append(sobrantes);
        return resultado.toString();
    }
    @Test
    public void test(){
        assertEquals("5 0\n" +
                     "3 0\n" +
                     "2 0\n" +
                     "1 2\n" +
                     "0"
                , hacerLaCompra(
                        "9\n" +
                        "2 2\n" +
                        "1 2\n" +
                        "5 2\n" +
                        "3 5"
                )
        );
    }
}
