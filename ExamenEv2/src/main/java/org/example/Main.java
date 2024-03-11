package org.example;

public class Main {

	public static int escribirMenuOpciones() {
		System.out.println();
		System.out.println("(0) Salir del programa.");
		System.out.println("(1) Dar de alta un socio premium en el club.");
		System.out.println("(2) Dar de alta un socio basico en el club.");
		System.out.println("(3) Consultar todos los socios del club ordenados por DNI.");
		System.out.println("(4) Dar de baja un socio, por DNI, del club.");
		System.out.println("(5) Cambiar el turno de un socio basico, por DNI");
		System.out.println("(6) Consultar los DNI de los socios premium del club que tienen carnet de estudiante");
		System.out.println("(7) Consultar los socios del club que pagan la cuota mas alta de todo el club.");
		System.out.println("(8)	Cambiar un socio basico, por DNI, a socio premium.");
        return Teclado.leerEntero("Opcion (0-8)");
	}

	public static void main(String[] args) {

		int opcion;
		ClubDeportivo cd = new ClubDeportivo("Los Enlaces");
		do {
			opcion = escribirMenuOpciones();
			System.out.println();
			switch (opcion) {
			case 0:
				break;
			case 1:
				cd.darDeAlta('P');
				break;
			case 2:
				cd.darDeAlta('B');
				break;
			case 3:
				cd.consultarSociosPorDni();
				break;
			case 4:
				cd.darDeBaja();
				break;
			case 5:
				cd.cambiarTurno();
				break;
			case 6:
				cd.consultarSociosPremiumConCarnetDeEstudiante();
				break;
			case 7:
				cd.consultarSociosQueMasPagan();
				break;
			case 8:
				cd.cambiarSocioBasicoAPremium();
				break;
			default:
				System.out.println("La opcion de menu debe estar comprendida entre 0 y 8.");
			}
			System.out.println();
		} while (opcion != 0);

		System.out.println("Programa finalizado sin errores.");
	}
}