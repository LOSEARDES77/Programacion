package org.example;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.WindowConstants;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Oracle {
    public static void main(String[] args) throws SQLException {
        // Schema jdbc:oracle:{driver:variants:thin:Thin=thin,OCI=oci,OCI8=oci8}:[{user}[/{password}]]@{host::localhost}?[:{port::1521}]:{SID:identifier:XE}
        String usuario = "jardineria";
        String contrasenia = "case";
        // Connection con = DriverManager.getConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", DATABASE_NAME), "root", "");
        Connection con = DriverManager.getConnection(String.format("jdbc:oracle:thin:%s/%s@localhost:1521:XE", usuario, contrasenia));
        Statement st = con.createStatement();
        String query = "SELECT * FROM PRODUCTO ";
        ResultSet rs = st.executeQuery(query);
        JTable t = new JTable();
        t.setModel(Utils.rsToTableModel(rs));
        st.close();
        con.close();
        JFrame window = new JFrame("Tabla");
        JScrollPane sp = new JScrollPane(t);

        sp.setSize(800, 500);

        window.add(sp);
        window.setVisible(true);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        window.setSize(800, 500);
        window.setLocationRelativeTo(null);

    }

}