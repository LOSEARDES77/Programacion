package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperties());
        int i = 0;
        while (i != -1){
            i = fn();
        }
    }
    private static int fn(){
        int response = JOptionPane.showConfirmDialog(null, "Hola", "Test", JOptionPane.OK_CANCEL_OPTION);
        String msg = "You pressed ";
        switch (response){
            case -1 -> msg += "Close window";
            case 0 -> msg += "Yes";
            case 1 -> msg += "No";
            case 2 -> msg += "Cancel";
            default -> {
                JOptionPane.showMessageDialog(null, "Codigo " + response);
                System.exit(1);
            }
        }
        JOptionPane.showMessageDialog(null, msg);
        return response;
    }
}