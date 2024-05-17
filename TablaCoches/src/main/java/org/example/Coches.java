package org.example;

import java.util.ArrayList;

public class Coches extends ArrayList<Coche> {
    private final ArrayList<Coche> coches = new ArrayList<>();

    public Coches(int numCoches) {
        for (int i = 0; i < numCoches; i++) {
            coches.add(new Coche());
        }
    }

    public String[][] listado() {
        String[][] array = new String[coches.size()][3];
        for (int i = 0; i < coches.size(); i++) {
            array[i] = coches.get(i).toArray();
        }
        return array;
    }


}
