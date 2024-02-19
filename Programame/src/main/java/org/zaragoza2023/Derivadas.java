package org.zaragoza2023;

import java.util.Scanner;

public class Derivadas {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        while (true){
            String caso = s.nextLine();
            if (caso.isEmpty())
                break;
            String[] monomios = caso.split("\\+");
            System.out.println(getDerivada(monomios));
        }
    }
    private static String getDerivada(String[] caso) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < caso.length; i++){
            res.append(getDerivada(caso[i].trim()));
            if (i != caso.length-1 )
                if (!getDerivada(caso[i+1]).isEmpty())
                    res.append("+");

        }
        return res.toString();
    }
    private static String getDerivada(String m) {
        int n;
        if (m.contains("^")) {
            n = Integer.parseInt(m.split("\\^")[1]);
        } else if (m.contains("x")) {
            n = 1;
        }else {
            return "";
        }
        int coef;
        if (m.split("x").length > 0)
            coef = Integer.parseInt(m.split("x")[0]);
        else
            coef = 1;
        if (n > 2){
            return (coef * n) + "x^" + --n;
        }else if (n == 2){
            return (coef * n) + "x";
        }else {
            return String.valueOf((coef * n));
        }

    }
}
