package entrada;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Teclado {
    public Teclado() {
    }

    public static boolean leerBooleano(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String lineaTexto = "";
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);

                for(lineaTexto = teclado.readLine(); !lineaTexto.equalsIgnoreCase("true") && !lineaTexto.equalsIgnoreCase("false") && !lineaTexto.equalsIgnoreCase("verdadero") && !lineaTexto.equalsIgnoreCase("y") && !lineaTexto.equalsIgnoreCase("yes") && !lineaTexto.equalsIgnoreCase("no") && !lineaTexto.equalsIgnoreCase("n") && !lineaTexto.equalsIgnoreCase("falso"); lineaTexto = teclado.readLine()) {
                    System.out.println("El dato introducido debe ser verdadero o falso.");
                    System.out.print(mensaje);
                }

                error = false;
            } catch (IOException var5) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return lineaTexto.equalsIgnoreCase("true") || lineaTexto.equalsIgnoreCase("verdadero") || lineaTexto.equalsIgnoreCase("y") || lineaTexto.equalsIgnoreCase("yes");
    }

    public static int leerNatural(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int numeroNatural = 0;
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);

                for(numeroNatural = Integer.parseInt(teclado.readLine()); numeroNatural <= 0; numeroNatural = Integer.parseInt(teclado.readLine())) {
                    System.out.println("El dato introducido debe ser mayor que cero.");
                    System.out.print(mensaje);
                }

                error = false;
            } catch (NumberFormatException var5) {
                System.out.println("El dato introducido no tiene formato de número natural.");
                error = true;
            } catch (IOException var6) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return numeroNatural;
    }

    public static int leerEntero(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        int numeroEntero = 0;
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);
                numeroEntero = Integer.parseInt(teclado.readLine());
                error = false;
            } catch (NumberFormatException var5) {
                System.out.println("El dato introducido no tiene formato de número entero.");
                error = true;
            } catch (IOException var6) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return numeroEntero;
    }

    public static double leerReal(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        double numeroReal = 0.0;
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);
                numeroReal = Double.parseDouble(teclado.readLine());
                error = false;
            } catch (NumberFormatException var6) {
                System.out.println("El dato introducido no tiene formato de número real.");
                error = true;
            } catch (IOException var7) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return numeroReal;
    }

    public static char leerCaracter(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String lineaTexto = "";
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);

                for(lineaTexto = teclado.readLine(); lineaTexto.length() != 1; lineaTexto = teclado.readLine()) {
                    System.out.println("El dato introducido debe ser un único carácter.");
                    System.out.print(mensaje);
                }

                error = false;
            } catch (IOException var5) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return lineaTexto.charAt(0);
    }

    public static String leerCadena(String mensaje) {
        BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
        String lineaTexto = "";
        boolean error = true;

        while(error) {
            try {
                System.out.print(mensaje);
                lineaTexto = teclado.readLine();
                error = false;
            } catch (IOException var5) {
                System.out.println("Se ha producido un error de entrada/salida.");
                error = true;
            }
        }

        return lineaTexto;
    }
}
