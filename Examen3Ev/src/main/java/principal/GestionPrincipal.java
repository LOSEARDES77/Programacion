package principal;
import dao.AccesoBillete;
import dao.AccesoClase;
import dao.AccesoEstacion;
import dao.AccesoFicheroClase;
import dao.AccesoViajero;
import entrada.Teclado;

import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.util.Arrays;

public class GestionPrincipal {

	/**
	 * Visualiza en consola el menú de opciones del programa principal.
	 */
	public static void escribirMenuOpcionesPrincipal() {
		System.out.println();
		System.out.println("*********** MENÚ PRINCIPAL ***********");
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Exportar las clases a fichero de texto"); 
		System.out.println("(2) Sacar billete"); 
		System.out.println("(3) Actualizar viajero"); 
		System.out.println("(4) Consultar viajeros en estación y día"); 
	}
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int opcion;
		do {
			escribirMenuOpcionesPrincipal();
			opcion = Teclado.leerEntero("Opción: ");
			switch (opcion) {
			// Salir del programa.
			case 0:
				System.out.println("Finalizando programa.");
				break;
			case 1:
				System.out.println("\nExportando fichero...");
				String[] csv = AccesoClase.obtenerCsv();
				AccesoFicheroClase.escribirAlFichero(csv);

				System.out.println("Fichero exportado");

				break;

			case 2:
				int codViajero = Teclado.leerEntero("Introduce el codigo de viajero: ");
				if (!AccesoViajero.existeViajero(codViajero)){
					System.out.println("El viajero con codigo " + codViajero + " no existe");
					break;
				}
				String[] viajero = AccesoViajero.obtenerViajero(codViajero);
				if (viajero != null)
					for (String v : viajero)
						System.out.println(Arrays.toString(v.split(";")));

				String[] estaciones = AccesoEstacion.obtenerEstaciones();

				if (estaciones != null)
					for (String est : estaciones)
						System.out.println(Arrays.toString(est.split(";")));

				int codEstacionOrigen = Teclado.leerEntero("Introduce el codigo de la estacion origen: ");
				int codEstacionDestino = Teclado.leerEntero("Introducel el codigo de la estacion destiino: ");
				String fecha = Teclado.leerCadena("Introduce la fecha: ");
				String horaSalida = Teclado.leerCadena("Introduce la hoora de salida: ");
				String horaLlegada = Teclado.leerCadena("introduce la hora de llegada: ");
				double importe = Teclado.leerReal("Introduce el importe: ");

				boolean correcto = AccesoBillete.sacarBillete(codViajero, codEstacionOrigen, codEstacionDestino, fecha, horaSalida, horaLlegada, importe);

				if (!correcto){
					System.out.println("Error al sacar billete para el viajero.");
					break;
				}

				int codBillete = AccesoBillete.obtenerUltimoBillete();

				System.out.println("Se ha sacado un billete con codigo " +  codBillete);

				break;

			case 3:
				String[] viajeros = AccesoViajero.obtenerViajeros();
				if (viajeros != null)
					for (String v : viajeros)
						System.out.println(Arrays.toString(v.split(";")));

				int codViajeroActualizar = Teclado.leerEntero("Introduce el codigo de viajero: ");

				boolean res = AccesoViajero.actualizarViajero(codViajeroActualizar);
				if (!res){
					System.out.println("Error al actualizar los puntos del viajero.");
					break;
				}
				System.out.println("Se ha actualizado los puntos un viajero de la base de datos");
				break;

			case 4:

				int codEstacion = Teclado.leerEntero("Introduce el codigo de la estacion: ");
				String fechaPasado = Teclado.leerCadena("Introduce el dia: ");

				DefaultTableModel tm = AccesoViajero.obtenerTabla(codEstacion, fechaPasado);

				if (tm == null || tm.getRowCount() < 1){
					System.out.println("No exsteningun viajero que haya pasado por la estacion indicada el dia indicado");
					break;
				}


				JDialog dialog = new JDialog();
				JScrollPane sp = new JScrollPane();
				JTable table = new JTable();
				table.setModel(tm);
				dialog.add(sp);
				sp.getViewport().add(table);
				dialog.setSize(800, 600);

				dialog.setLocationRelativeTo(null);
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setVisible(true);


				break;
						 
			default:
				System.out.println("La opción de menú debe estar comprendida entre 0 y 4.");
			}
		}
		while (opcion != 0);
	}

}
