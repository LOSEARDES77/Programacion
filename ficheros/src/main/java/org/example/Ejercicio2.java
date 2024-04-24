package org.example;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;

public class Ejercicio2 {
    /*
        Realiza un programa en java con una ventana con un campo de texto y un botón.
        Al pulsar el botón se debe abrir una nueva ventana que muestre en una tabla todos los ficheros que contiene el directorio que se ha escrito en el campo de texto.
        La ventana del listado debe tener un botón "volver” para volver a la ventana anterior.
    */

    private static final JFrame frame = new JFrame("File verifyer");
    private static final JFrame listFrame = new JFrame("List files");

    public static void main(String[] args) {

        JPanel mainPanel = new JPanel();
        JPanel listPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        listPanel.setLayout(new BorderLayout());
        PlaceholderTextField textField = new PlaceholderTextField();
        textField.setPlaceholder("Enter file path");
        JButton button = new JButton("List files");
        JTable table = new JTable();
        JScrollPane scrollPane = new JScrollPane(table);
        JButton backButton = createBackButton();

        button.addActionListener(e -> {
            String path = textField.getText();
            File[] files = new File(path).listFiles();
            if (files == null) {
                JOptionPane.showMessageDialog(frame, "Invalid path", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String[] columnNames = {"Name", "Size", "Directory"};
            DefaultTableModel model = new DefaultTableModel(columnNames, 0);
            for (File file : files) {
                model.addRow(new Object[]{file.getName(), file.length(), file.isDirectory()});
            }

            table.setModel(model);
            listPanel.add(scrollPane);
            scrollPane.setBounds(50, 10, 200, 200);
            listPanel.add(backButton);
            backButton.setBounds(50, 205, 200, 30);
            listPanel.add(new JLabel(" "));
            listFrame.setSize(300, 300);
            listFrame.setVisible(true);
            frame.setVisible(false);
        });

        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        mainPanel.add(textField);
        listFrame.add(listPanel);
        backButton.setBounds(50, 35, 200, 30);
        listFrame.setLocationRelativeTo(frame);
        listFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textField.setBounds(50, 10, 200, 30);
        mainPanel.add(button);
        button.setBounds(50, 35, 200, 30);
        mainPanel.add(new JLabel(" "));
        frame.add(mainPanel);
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static JButton createBackButton(){
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            listFrame.setVisible(false);
            frame.setVisible(true);
        });
        return backButton;
    }


    public static Rectangle getCenteredBounds(JComponent component, JComponent container){
       int x = (container.getWidth() - component.getWidth()) / 2;
       int y = (container.getHeight() - component.getHeight()) / 2;
       return new Rectangle(x, y, component.getWidth(), component.getHeight());
    }

}
