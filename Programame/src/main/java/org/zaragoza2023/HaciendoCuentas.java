package org.zaragoza2023;

import java.util.ArrayList;
import java.util.Scanner;

public class HaciendoCuentas {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int cantidadInicial = Integer.parseInt(s.nextLine());
        ArrayList<Movimiento> movimientos = new ArrayList<>();
        String line;
        while (!(line = s.nextLine()).isEmpty()){
            movimientos.add(Movimiento.parseMovimiento(line));
        }

        String[] meses = new String[]{
                "Enero",
                "Febrero",
                "Marzo",
                "Abril",
                "Mayo",
                "Junio",
                "Julio",
                "Agosto",
                "Septiembre",
                "Octubre",
                "Noviembre",
                "Diciembre"
        };

        for (int i = 0; i < meses.length; i++){
            for (Movimiento m : movimientos){
                if (m.getMes() == i){
                    if (m.isIngresoGasto()){
                        cantidadInicial += m.getCantidad();
                    }else {
                        cantidadInicial -= m.getCantidad();
                    }
                }
            }

            System.out.print(meses[i] + " " + cantidadInicial);
        }


    }

    private static class Movimiento {
        private final int mes;
        private final int cantidad;
        private final boolean ingresoGasto; // true: +  false: -

        public Movimiento(int mes, int cantidad, boolean ingresoGasto) {
            this.mes = --mes;
            this.cantidad = cantidad;
            this.ingresoGasto = ingresoGasto;
        }

        public static Movimiento parseMovimiento(String line){
            String[] parts = line.split(" ");
            String mes = parts[0].split("-")[1];
            boolean ingresoGasto = parts[1].charAt(0) == '+';
            int cantidad = Integer.parseInt(parts[1].substring(1));

            return new Movimiento(Integer.parseInt(mes), cantidad, ingresoGasto);
        }

        public int getMes() {
            return mes;
        }

        public int getCantidad() {
            return cantidad;
        }

        public boolean isIngresoGasto() {
            return ingresoGasto;
        }
    }
}
