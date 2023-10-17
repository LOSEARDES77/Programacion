package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un numero: ");
        String numero = scanner.next();
        System.out.print("Introduce la base: ");
        int base = scanner.nextInt();
        System.out.print("En que lo quieres convertir?: ");
        int baseTarget = scanner.nextInt();
        System.out.println("Numero: " + numero + "  Base: " + base + "\nNumero: " + convertirBase(numero, base, baseTarget) + "  Base: " + baseTarget);
    }

    public static String convertirBase(String numero, int base, int baseTarget) {
        String[] parts = numero.split("\\.");
        String parteEntera = parts[0];
        String parteDecimal = parts.length > 1 ? parts[1] : "0";

        String resultParteEntera = fromBaseTen(parteEntera, base, baseTarget);
        String resultParteDecimal = fromBaseDecimal(parteDecimal, base, baseTarget);

        if (resultParteDecimal.isEmpty()) {
            return resultParteEntera;
        } else {
            return resultParteEntera + "." + resultParteDecimal;
        }
    }

    public static String fromBaseTen(String num, int base, int baseTarget) {
        if (num.equals("0")) {
            return "0";
        }
        StringBuilder result = new StringBuilder();
        long decimalValue = Long.parseLong(num, base);
        while (decimalValue > 0) {
            long remainder = decimalValue % baseTarget;
            if (remainder >= 10) {
                result.insert(0, (char) ('a' + remainder - 10));
            } else {
                result.insert(0, remainder);
            }
            decimalValue /= baseTarget;
        }
        return result.toString();
    }

    public static String fromBaseDecimal(String num, int base, int baseTarget) {
        if (num.equals("0")) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        double decimalValue = Double.parseDouble("0." + num);
        for (int i = 0; i < 10; i++) {  // You can adjust the precision here
            decimalValue *= baseTarget;
            int digit = (int) decimalValue;
            if (digit >= 10) {
                result.append((char) ('a' + digit - 10));
            } else {
                result.append(digit);
            }
            decimalValue -= digit;
        }
        return result.toString();
    }
}
