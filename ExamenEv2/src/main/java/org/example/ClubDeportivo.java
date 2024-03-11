package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import static org.example.Teclado.*;

public class ClubDeportivo {
	public String nombreClub;
	private HashMap<String, Socio> socios; // key: dni, value: Socio

	public ClubDeportivo(String nombreClub) {
		this.nombreClub = nombreClub;
		this.socios = new HashMap<>();
	}

	@Override
	public String toString() {
		StringBuilder socios = new StringBuilder();
		if (this.socios.isEmpty()){
			socios.append("\n\t\tNo existen socios en este club");
		}else {
			for (Socio s : this.socios.values()) {
				socios.append("\n\t\t").append(s.toString());
			}
		}
		return "ClubDeportivo:\n" +
				"\tnombreClub ->\t" + nombreClub + '\n' +
				"\tsocios -> [" + socios + "\n\t]";
	}

	public void darDeAlta(char tipo){ // tipo: B = basico, P = premium
		String dni = leerCadena("Introduce el dni");
		if (socios.containsKey(dni)){
			System.out.println("Ya existe un socio con este dni");
			return;
		}
		String nombre = leerCadena("Introduce el nombre");
		int edad = leerEntero("Introduce la edad");
		double horasEntrenadorPersonal = leerReal("Introduce las horas del entrenador personal");
		if (tipo == 'B'){
			Turno turno = SocioBasico.parseTurno(leerCadena("Introduce el turno (Mañana, Tarde, Mediodia)"), "Introduce el turno (Mañana, Tarde, Mediodia)");
			boolean taquilla = leerBooleano("¿Tiene el socio tiene taquilla?");
			socios.put(dni, new SocioBasico(dni, nombre, edad, horasEntrenadorPersonal, turno, taquilla));
			System.out.println("Se ha insertado un socio basico en el club");
		}if (tipo == 'P'){
			boolean carnetEstudiante = leerBooleano("¿Tiene el socio carnet de estudiante?");
			socios.put(dni, new SocioPremium(dni, nombre, edad, horasEntrenadorPersonal, carnetEstudiante));
			System.out.println("Se ha insertado un socio premium en el club");
		}
	}

	public void consultarSociosPorDni(){
		if (socios.isEmpty()){
			System.out.println("El club esta vacio");
			return;
		}
		ArrayList<Socio> socios = new ArrayList<>(this.socios.values());
		socios.sort(Comparator.comparing(Socio::getDni));
		for (Socio s : socios){
			System.out.println(s);
		}
	}

	public void darDeBaja(){
		String dni = leerCadena("Introduce el dni");
		if (!socios.containsKey(dni)){
			System.out.println("No existe el socio con dni \"" + dni + '"');
			return;
		}
		socios.remove(dni);
	}

	public void cambiarTurno(){
		String dni = leerCadena("Introduce el dni");
		if (!socios.containsKey(dni)){
			System.out.println("No existe un socio con dni \"" + dni + '"');
			return;
		}
		Socio s = socios.get(dni);
		if (s instanceof SocioBasico sb) {
			Turno t = SocioBasico.parseTurno(leerCadena("Introduce el nuevo turno (Mañana, Tarde, Mediodia)"), "Introduce el nuevo turno (Mañana, Tarde, Mediodia)");
			sb.setTurno(t);
			return;
		}
		System.out.println("El socio con dni \"" + dni + "\" no es un socio basico");
	}

	public void consultarSociosPremiumConCarnetDeEstudiante(){
		for (Socio s : this.socios.values()){
			if (s instanceof SocioPremium sp){
				if (sp.isCarnetEstudiante()){
					System.out.println(s);
				}
			}
		}
	}

	public void consultarSociosQueMasPagan(){
		if (socios.isEmpty()){
			System.out.println("El club esta vacio");
			return;
		}
		double cuotaMaxima = 0;
		for (Socio s : socios.values()){
			cuotaMaxima = Math.max(cuotaMaxima, s.calcularCuotaMensual());
		}
		int cantidadDeSociosQuePaganLaCuotaMaxima = 0;
		for (Socio s : socios.values()){
			if (s.calcularCuotaMensual() == cuotaMaxima){
				cantidadDeSociosQuePaganLaCuotaMaxima++;
				System.out.println(s);
			}
		}
		System.out.println("Socios que pagan la cuota mas alta: " + cantidadDeSociosQuePaganLaCuotaMaxima);
	}

	public void cambiarSocioBasicoAPremium(){
		String dni = leerCadena("Introduce el dni");
		if (!socios.containsKey(dni)){
			System.out.println("No existe un socio con dni \"" + dni + '"');
			return;
		}
		Socio s = socios.get(dni);
		if (s instanceof SocioBasico sb){
			boolean carnetDeEstudiante = leerBooleano("¿Tiene el socio carnet de estudiante?");
			socios.put(dni, new SocioPremium(dni, sb.getNombre(), sb.getEdad(), sb.getHorasEntrenadorPersonal(), carnetDeEstudiante));
			System.out.println("Se ha actualizado el socio basico a premium");
			return;
		}
		System.out.println("El socio con dni \"" + dni + "\" ya es un socio premium");
	}
}
