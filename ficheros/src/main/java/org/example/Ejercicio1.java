package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("File verifyer");
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        PlaceholderTextField textField = new PlaceholderTextField();
        textField.setPlaceholder("Enter file path");
        JCheckBox exists = new JCheckBox("Exists");
        exists.setEnabled(false);
        JCheckBox rwpermission = new JCheckBox("Read/Write");
        rwpermission.setEnabled(false);
        JLabel fileDirectory = new JLabel(" ");
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {}

            @Override
            public void keyPressed(KeyEvent e) {}

            @Override
            public void keyReleased(KeyEvent e) {
                File file = new File(textField.getText());
                exists.setSelected(file.exists());
                if (!file.exists()) {
                    rwpermission.setSelected(false);
                    fileDirectory.setText(" ");
                    return;
                }
                rwpermission.setSelected(file.canRead() && file.canWrite());
                fileDirectory.setText(file.isDirectory() ? "Directory" : "File");
            }
        });

        panel.add(textField);
        textField.setBounds(50, 10, 200, 30);
        panel.add(exists);
        exists.setBounds(50, 35, 200, 30);
        panel.add(rwpermission);
        rwpermission.setBounds(50, 55, 200, 30);
        panel.add(fileDirectory);
        fileDirectory.setBounds(55, 75, 200, 30);
        fileDirectory.setEnabled(false);
        panel.add(new JLabel(" "));
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}