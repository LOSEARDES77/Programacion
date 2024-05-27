package config;

import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigBDMySql {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URLBD = "jdbc:mysql://localhost:3306/transporte_ferroviario";
	private static final String USER = "root";
	private static final String PASS = "mysql";

	public static Connection abrirConexion() {
		Connection conexion = null;
		try {
			// Cargar el driver
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// Abrir la conexion mediante la url donde se encuentra la BD
			conexion = DriverManager.getConnection(URLBD, USER, PASS);
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		return conexion;
	}

	public static void cerrarConexion(Connection conexion) {
		try {
			conexion.close();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}
