package dao;

import config.ConfigBDMySql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoBillete {


    public static boolean sacarBillete(int codViajero, int codEstacionOrigen, int codEstacionDestino, String fecha, String horaSalida, String horaLlegada, double importe) {
        try{
            Connection c = ConfigBDMySql.abrirConexion();
            String sql = "INSERT INTO billete ( codigo_viajero, codigo_estacion_origen, codigo_estacion_destino, fecha, hora_salida, hora_llegada, importe) " +
                    "values ("+codViajero+","+codEstacionOrigen+","+codEstacionDestino+",'"+fecha+"','"+horaSalida+"','"+horaLlegada+"',"+importe+" )";
            Statement st = c.createStatement();
            st.executeUpdate(sql);
            return true;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    public static int obtenerUltimoBillete() {
        try{
            Connection c = ConfigBDMySql.abrirConexion();
            String sql = "SELECT * FROM billete";
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            int codBillete = -1;
            while (rs.next()){
                codBillete = Math.max(rs.getInt("codigo_billete"), codBillete);
            }

            ConfigBDMySql.cerrarConexion(c);
            return codBillete;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
