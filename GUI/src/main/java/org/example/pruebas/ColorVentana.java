package org.example.pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ColorVentana {
    private static JPanel panel;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        PlaceholderTextField textField = new PlaceholderTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setPlaceholder("Enter a color");
        textField.setEditable(true);
        textField.setSize(150, 20);

        JButton b = new JButton("Select");
        b.addActionListener((e) -> {
           String color = textField.getText();
           panel.setBackground(new Color(Integer.parseInt(color, 16)));
        });
        JLabel filler = new JLabel(" ");
        panel.add(textField, BorderLayout.CENTER);
        textField.setBounds(50, 15, 200, 35);
        panel.add(b, BorderLayout.CENTER);
        b.setBounds(105, 60, 90, 20);
        panel.add(filler, BorderLayout.CENTER);
        Runnable r = () -> {};
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == KeyEvent.VK_ENTER) {
                    String color = textField.getText();
                    panel.setBackground(new Color(Integer.parseInt(color, 16)));
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        frame.add(panel);
        frame.setSize(300, 100);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
