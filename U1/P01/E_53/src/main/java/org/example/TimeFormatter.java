package org.example;

import javax.swing.*;

public class TimeFormatter {

    private int horas;
    private final int minutos;
    private int formatId; // 0 = 19:43 | 1 = 7:43 PM
    private int AmPm; // 0 = NotSet | 1 = AM | 2 = PM

    public void setFormat(int format){
        if (this.formatId == format) return;
        if (format == 1){
            if (horas > 12) {
                horas -= 12;
                AmPm = 2;
            }else {
                AmPm = 1;
            }
            this.formatId = 1;
            return;
        }else {
            if (AmPm == 2) horas += 12;
            AmPm = 0;
            this.formatId = 0;
            return;
        }
    }

    public TimeFormatter(String input) {
        this.horas = getHoras(input.split(":")[0]);
        this.minutos = getMinutos(input.split(":")[1]);
        this.formatId = getFormatId(input.split(":")[1]);
    }

    private int getFormatId(String s) {
            StringBuilder AmPmData = new StringBuilder();
            for(int i = 0; i < s.length(); i++)
                if (String.valueOf(s.charAt(i)).matches("[a-zA-z]")){
                    AmPmData.append(s.charAt(i)).append(s.charAt(i + 1));
                    break;
                }
            if(AmPmData.toString().equalsIgnoreCase("AM"))
                this.AmPm = 1;
            else if (AmPmData.toString().equalsIgnoreCase("PM")) {
                this.AmPm = 2;
            }else
                return 0;
            return 1;
    }


    private static int getHoras(String horas){
        StringBuilder horasRefines = new StringBuilder();
        for (int i = horas.length() - 1; i < horas.length(); i++){
            if (String.valueOf(horas.charAt(i)).matches("[0-9]{1}"))
                horasRefines.append(horas.charAt(i));
        }
        return Integer.parseInt(horasRefines.toString());
    }
    private static int getMinutos(String minutos) {
        StringBuilder horasRefines = new StringBuilder();
        for (int i = 0; i < 2; i++){
            if (String.valueOf(minutos.charAt(i)).matches("[0-9]{1}"))
                horasRefines.append(minutos.charAt(i));
        }
        return Integer.parseInt(horasRefines.toString());
    }

    @Override
    public String toString() {
        if (this.formatId == 0){
            return String.format("%d:%02d", horas, minutos);
        }else {
            return String.format("%d:%02d %s", this.horas, this.minutos, switch (AmPm){
                case 0 -> "";
                case 1 -> " AM";
                case 2 -> " PM";
                default -> throw new IllegalStateException("Unexpected value: " + AmPm);
            });
        }
    }
}

