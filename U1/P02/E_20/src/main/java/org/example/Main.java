package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password;
        do {
            System.out.print("Introduce una contraseña: ");
            password = scanner.nextLine();
            if (validate(password) == 1)
                System.out.println("Error 1: La contraseña debe tener al menos 2 caracteres");
            if (validate(password) == 2)
                System.out.println("Error 2: La contraseña debe tener como máximo 10 caracteres");
            if (validate(password) == 3)
                System.out.println("Error 3: La contraseña no puede contener espacios");
            if (validate(password) == 4)
                System.out.println("Error 4: La contraseña debe contener al menos un caracter especial (#, @, $, %, &)");
        } while (validate(password) != 0);
    }

    private static int validate(String password){
        if(password.length() < 2)
            return 1;
        if(password.length() > 10)
            return 2;
        if(password.contains(" "))
            return 3;
        if(password.contains("#") || password.contains("@") || password.contains("$") || password.contains("%") || password.contains("&"))
            return 4;

        return 0;
    }
}