package dao;

import config.ConfigBDMySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AccesoClase {

    public static String[] obtenerCsv() {
        try {
            Connection c = ConfigBDMySql.abrirConexion();
            String sql = "SELECT * from clase";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);

            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            ArrayList<String> csv = new ArrayList<>();
            while (rs.next()) {
                StringBuilder line = new StringBuilder();
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    line.append(rs.getObject(columnIndex).toString()).append(";");
                }
                csv.add(line.toString());
            }
            ConfigBDMySql.cerrarConexion(c);
            return csv.toArray(new String[0]);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
	
}
