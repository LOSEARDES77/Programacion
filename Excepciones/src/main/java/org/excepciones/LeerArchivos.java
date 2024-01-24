package org.excepciones;

import javax.swing.JOptionPane;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class LeerArchivos {
    public static void main(String[] args) {
        try {
            String archivo = JOptionPane.showInputDialog("India el nombre de archvo que quieres leer: ");
            BufferedReader r = new BufferedReader(new FileReader(archivo));
            String line;
            while ((line = r.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            System.out.println("Archivo no encontrado");
        }
    }
}