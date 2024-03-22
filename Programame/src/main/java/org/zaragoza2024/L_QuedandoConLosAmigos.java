package org.zaragoza2024;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.Scanner;

public class L_QuedandoConLosAmigos {

    @Test
    public void test() {
        assertEquals("12", solve("3 3 4 2"));
        assertEquals("6", solve("2 3 2"));
        assertEquals("3", solve("2 3 3"));
        assertEquals("NUNCA", solve("3 2 3 1000000"));

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numDeCasos = Integer.parseInt(s.nextLine());
        for (int i = 0; i < numDeCasos; i++){
            System.out.println(solve(s.nextLine()));
        }

    }

    private static String solve(String entry){
        String[] parts = entry.split(" ");
        int numDeAmigos = Integer.parseInt(parts[0]);
        double[] tiempos = new double[numDeAmigos];
        for (int j = 0; j < tiempos.length; j++){
            tiempos[j] = Double.parseDouble(parts[j+1]);
            if (tiempos[j] == 1000000){
                return "NUNCA";
            }
        }

        double mcm = tiempos[0];
        for (int j = 1; j < tiempos.length; j++){
            mcm = (mcm * tiempos[j]) / mcd(mcm, tiempos[j]);
        }
        return String.valueOf((long) mcm);
    }

    private static double mcd(double a, double b){
        return b == 0 ? a : mcd(b, a % b);
    }
}
