package org.example;


import java.sql.*;

public class Mysql {
    public static void main(String[] args) throws SQLException {
        //Connection con = DriverManager.getConnection(String.format("jdbc:mysql://127.0.0.1:3306/%s", DATABASE_NAME), "root", "");
        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/PRUEBAS", "root", "mysql");
        Statement st = con.createStatement();
        st.executeUpdate("DROP TABLE IF EXISTS TEST");
        st.executeUpdate("CREATE TABLE TEST(id NUMERIC PRIMARY KEY , nombre VARCHAR(20) NOT NULL )");
        st.executeUpdate("INSERT INTO TEST VALUES (1, 'Pepe')");
        st.executeUpdate("INSERT INTO TEST VALUES (2, 'Jimena')");
        st.executeUpdate("INSERT INTO TEST VALUES (3, 'Concepcion')");
        st.executeUpdate("INSERT INTO TEST VALUES (4, 'Alberto')");
        st.executeUpdate("INSERT INTO TEST VALUES (5, 'Juan')");
    }
}
