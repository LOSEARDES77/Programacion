package org.example.pruebas;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.*;
import java.awt.*;


public class Main {

    private static JLabel label;
    private static JLabel name;
    private static PlaceholderTextField textArea;

    private static int counter = 0;
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ignored) {

        }

        JPanel panel1 = getjPanel();
        JPanel panel2 = getjPanel2();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        JFrame frame = new JFrame("Hello World");
        name = new JLabel();
        textArea = new PlaceholderTextField();
        textArea.setEditable(true);
        textArea.setColumns(18);
        textArea.setPlaceholder("Enter your name");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel3.add(textArea);
        panel4.add(name);
        panel3.add(panel2);
        panel3.add(panel4);
        panel3.add(panel1);
        frame.add(panel3);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private static void updateCounter(int type){
        if (type == 1) {
            counter++;
            String value = textArea.getText();
            if (!value.isBlank())
                name.setText("Hello, " + value);
        }
        else {
            counter--;
            name.setText("");
        }

        label.setText(String.valueOf(counter));

    }

    private static JPanel getjPanel() {

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton removeButton = new JButton("Remove");
        JButton addButton = new JButton("Add");
        removeButton.addActionListener(e -> {
            updateCounter(2);
        });
        addButton.addActionListener(e -> {
            updateCounter(1);
        });


        panel.add(addButton);
        panel.add(removeButton);
        return panel;
    }

    private static JPanel getjPanel2() {
        label = new JLabel(String.valueOf(counter));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(label);

        label.setFont(new Font(null, Font.PLAIN, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        return panel;
    }
}