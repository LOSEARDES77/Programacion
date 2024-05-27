package dao;

import entrada.Teclado;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccesoFicheroClase {

    private static final File archivo = new File("data/clases.txt");

    public static void escribirAlFichero(String[] lineas, char separador){
        if (archivo.exists() && archivo.isFile()){
            boolean estasSeguro = Teclado.leerBooleano("El fichero ya existe lo deseas sobreescribir? (y/n): ");
            if (!estasSeguro){
                return;
            }
        }
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            for (int i = 0; i < lineas.length; i++){
                for (String columna : lineas[i].split(String.valueOf(separador))){
                    bw.write(columna + ";");
                }
                if (i != lineas.length - 1)
                    bw.write("\n");

            }
            bw.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void escribirAlFichero(String[] lineas){
        escribirAlFichero(lineas, ';');
    }
			
}
