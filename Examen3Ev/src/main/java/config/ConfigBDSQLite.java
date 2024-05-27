package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.sqlite.SQLiteConfig;

public class ConfigBDSQLite {
	private static final String DRIVER = "org.sqlite.JDBC";
	private static final String URLBD = "jdbc:sqlite:data/transporte_ferroviario.db";

	public static Connection abrirConexion() {
		Connection conexion = null;
		try {
			// Cargar el driver
			Class.forName(DRIVER);
			SQLiteConfig config = new SQLiteConfig();
			config.enforceForeignKeys(true);
			// Abrir la conexion mediante la url donde se encuentra la BD
			conexion = DriverManager.getConnection(URLBD, config.toProperties());
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
