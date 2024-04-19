package org.example;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        Persona[] personas = null;
        File savefile = new File("personas.dat");
        if (!savefile.exists()){
            personas = new Persona[10];
            for (int i = 0; i < personas.length; i++){
                personas[i] = new Persona();
                for (int j = 0; j < 10; j++){
                    personas[i].comprarCoche(new Coche());
                    personas[i].adoptarMascota(new Mascota());
                }
            }
        } else {
            try {
                ois = new ObjectInputStream(new FileInputStream(savefile));
                personas = (Persona[]) ois.readObject();
            } catch (Exception e){
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (ois != null){
                        ois.close();
                    }
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }

        for (Persona persona : personas){
            System.out.println(persona);
        }

        try {
            oos = new ObjectOutputStream(new FileOutputStream(savefile));
            oos.writeObject(personas);
        } catch (Exception e){
            System.out.println(e.getMessage());
        } finally {
            try {
                if (oos != null){
                    oos.close();
                }
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

    }
}