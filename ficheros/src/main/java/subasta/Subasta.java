package subasta;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Subasta {
    public static void main(String[] args) {

        JFrame frame = new JFrame();

        JPanel panel = new JPanel(new BorderLayout());

        File carpetaSubastas = new File("Subastas");
        if (!carpetaSubastas.exists()){
            return;
        }
        String[][] ficheros = new String[carpetaSubastas.list().length][1];
        for (int i = 0; i < carpetaSubastas.list().length; i++){
            ficheros[i][0] = carpetaSubastas.list()[i];
        }
        JTable tabla = new JTable(ficheros, new String[]{"Ficheros"});;
        JScrollPane sp = new JScrollPane(tabla);

        panel.add(sp);
        panel.add(new JLabel(" "));
        frame.add(panel);
        sp.setBounds(30, 30, 350, 200);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

    }

}
