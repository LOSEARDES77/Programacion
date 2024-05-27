package dao;

import config.ConfigBDMySql;

import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class AccesoViajero {
    public static boolean existeViajero(int id){
        try{
            Connection c = ConfigBDMySql.abrirConexion();
            Statement st = c.createStatement();
            String query = "SELECT COUNT(*) FROM viajero WHERE codigo = " + id;
            ResultSet rs = st.executeQuery(query);
            int columCount = rs.getMetaData().getColumnCount();
            while (rs.next()){
                for (int i = 1; i <= columCount; i++){
                    if (rs.getInt(i) != 0){
                        ConfigBDMySql.cerrarConexion(c);
                        return true;
                    }
                }
            }
            ConfigBDMySql.cerrarConexion(c);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static String[] obtenerViajero(int id){
        try {
            Connection c = ConfigBDMySql.abrirConexion();
            Statement st = c.createStatement();
            String query = "SELECT COUNT(*) FROM viajero WHERE codigo = " + id;
            ResultSet rs = st.executeQuery(query);
            int columCount = rs.getMetaData().getColumnCount();
            ArrayList<String> viajeros = new ArrayList<>();
            while (rs.next()) {
                StringBuilder viajero = new StringBuilder();
                for (int i = 1; i <= columCount; i++) {
                    viajero.append(rs.getObject(i).toString()).append(";");
                }
                viajeros.add(viajero.toString());
            }
            return viajeros.toArray(new String[0]);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static String[] obtenerViajeros() {
        try {
            Connection c = ConfigBDMySql.abrirConexion();
            Statement st = c.createStatement();
            String query = "SELECT * FROM viajero";
            ResultSet rs = st.executeQuery(query);
            int columCount = rs.getMetaData().getColumnCount();
            ArrayList<String> viajeros = new ArrayList<>();
            while (rs.next()) {
                StringBuilder viajero = new StringBuilder();
                for (int i = 1; i <= columCount; i++) {
                    viajero.append(rs.getObject(i).toString()).append(";");
                }
                viajeros.add(viajero.toString());
            }
            return viajeros.toArray(new String[0]);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public static boolean actualizarViajero(int codViajeroActualizar) {
        // SET puntos of viajero to 0
        try {
            Connection c = ConfigBDMySql.abrirConexion();
            Statement st = c.createStatement();
            String sql = "UPDATE viajero SET puntos = 0 where codigo = " + codViajeroActualizar;
            st.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static DefaultTableModel obtenerTabla(int codEstacion, String fechaPasado) {
       try {
           Connection c = ConfigBDMySql.abrirConexion();
           String query = "SELECT v.* from viajero v right JOIN billete b on v.codigo = b.codigo_viajero where (b.codigo_estacion_destino = " + codEstacion + " OR codigo_estacion_origen = " + codEstacion
                   + ") AND b.fecha = '" + fechaPasado + "' order by v.nombre";
           Statement st = c.createStatement();
           ResultSet rs = st.executeQuery(query);

           ResultSetMetaData metaData = rs.getMetaData();

           Vector<String> columnNames = new Vector<>();
           int columnCount = metaData.getColumnCount();
           for (int column = 1; column <= columnCount; column++) {
               columnNames.add(metaData.getColumnName(column));
           }

           Vector<Vector<Object>> data = new Vector<>();
           while (rs.next()) {
               Vector<Object> vector = new Vector<>();
               for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                   vector.add(rs.getObject(columnIndex));
               }
               data.add(vector);
           }

           return new DefaultTableModel(data, columnNames);
       }catch (SQLException e){
           e.printStackTrace();
       }
       return null;
    }
}
