package org.example;

import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Listado de coches");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(512, 384);
        String[] tableHeader = {"Marca", "Modelo", "Precio"};
        int numCoches = 100;
        JPanel panel = createJpanel(numCoches, tableHeader);
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    private static JPanel createJpanel(int numCoches, String[] tableHeader) {
        Coches coches = new Coches(numCoches);
        JLabel image = new JLabel();
        ImageIcon icon = new ImageIcon("src/main/resources/coche_small.png");
        image.setIcon(icon);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(image);
        JTable table = new JTable(coches.listado(), tableHeader);
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setSize(512, 256);
        scrollPane.setViewportView(table);
        panel.add(scrollPane);
        return panel;
    }
}