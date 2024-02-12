package org.Ej2;

import java.util.ArrayList;

public class Personal {
    static ArrayList<Cooperante> listadoPersonal = new ArrayList<>();

    void altaAsalariado(Asalariado a){
        listadoPersonal.add(a);
    }
    void altaVoluntario(Voluntario v){
        listadoPersonal.add(v);
    }
    void listarCooperantes(){
        for (Cooperante c : listadoPersonal){
            System.out.println(c);
        }
    }

    void listadoAsalariados(){
        for (Cooperante c : listadoPersonal){
            if (c instanceof Asalariado)
                System.out.println(c);
        }
    }

    void listadoVoluntarios(){
        for (Cooperante c : listadoPersonal){
            if (c instanceof Voluntario)
                System.out.println(c);
        }
    }
}
