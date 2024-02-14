package org.zaragoza2023;

import java.util.Scanner;
 /*
5
Light Amplification by Stimulated Emission of Radiation
Objeto Volador NO Identificado
Aeropuertos Españoles y Navegacion Aerea
Tren Articulado Ligero GOICOECHEA ORIOL
United Nations Educational Scientific and Cultural Organization

  */
public class Acronimos {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numDeCasos = Integer.parseInt(s.nextLine());
        String[] acronimos = new String[numDeCasos];
        for (int i = 0; i < numDeCasos; i++){
            String casoDePrueba = s.nextLine();
            acronimos[i] = getAcronimo(casoDePrueba);
        }
        for (String acronimo : acronimos) {
            System.out.println(acronimo);
        }

    }

    private static String getAcronimo(String cdp){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < cdp.length(); i++) {
            if (i == 0 || (cdp.charAt(i-1) == ' ' && Character.isUpperCase(cdp.charAt(i)))) {
                res.append(cdp.charAt(i));
            }
        }
        return res.toString();
    }
}
