package org.example;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Enter the time");
        TimeFormatter time = new TimeFormatter(input);
        while(true) {
            String option = JOptionPane.showInputDialog("What do you want to do?\n   1) Show time\n   2) 12h fotmat\n   3) 24h format\n   4) Enter new time\n   5) exit");
            switch (option) {
                case "1":
                    JOptionPane.showMessageDialog(null, time.toString());
                    break;
                case "2":
                    time.setFormat(1);
                    JOptionPane.showMessageDialog(null, time.toString());
                    break;
                case "3":
                    time.setFormat(0);
                    JOptionPane.showMessageDialog(null, time.toString());
                    break;
                case "4":
                    input = JOptionPane.showInputDialog("Enter the time");
                    time = new TimeFormatter(input);
                    break;
                case "5", "":
                    System.exit(0);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Unknown option: " + option);
                    break;
            }
        }
    }
}