package org.example;

import java.io.*;
import java.nio.file.Path;
import java.util.HashMap;

import static java.nio.file.Files.createFile;


public class GestorUsuarios {
    private final HashMap<String, Usuario> usuarios;

    public GestorUsuarios() {
        this.usuarios = new HashMap<>();
        try {
            loadData();
        }catch (FileNotFoundException e){
            try {
                createFile(Path.of("database.db"));
            }catch (IOException a){
                System.out.println("Coudn't create file");
                System.exit(1);
            }
        }
    }

    public void addUser(Usuario u) {
        usuarios.put(u.getEmail(), u);
    }

    public void saveData() throws IOException {
        PrintWriter w = new PrintWriter("database.db");
        for (Usuario u : usuarios.values()){
            w.write(u.toString() + "\n");
        }
        w.close();
    }

    private static String encode(String password){
        StringBuilder b = new StringBuilder();
        for (Character c : password.toCharArray()){
            b.append(c + 2);
        }
        return b.toString();
    }

    private static String decode(String password){
        StringBuilder b = new StringBuilder();
        for (Character c : password.toCharArray()){
            b.append(c - 2);
        }
        return b.toString();
    }

    public void loadData() throws FileNotFoundException {
        BufferedReader r = new BufferedReader(new FileReader("database.db"));
    }
}
