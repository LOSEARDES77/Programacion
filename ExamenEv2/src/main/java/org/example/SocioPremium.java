package org.example;

public class SocioPremium extends Socio {

	public boolean carnetEstudiante;

	public SocioPremium(String dni, String nombre, int edad, double horasEntrenadorPersonal, boolean carnetEstudiante) {
		super(dni, nombre, edad, horasEntrenadorPersonal);
		this.carnetEstudiante = carnetEstudiante;
	}

	public boolean isCarnetEstudiante() {
		return carnetEstudiante;
	}

	public void setCarnetEstudiante(boolean carnetEstudiante) {
		this.carnetEstudiante = carnetEstudiante;
	}

	@Override
	public double calcularCuotaMensual() {
		double cantidad = 0;
		if (edad > 65)
			cantidad += 40;
		else
			cantidad += 60;
		cantidad += (horasEntrenadorPersonal * 35);
		if (carnetEstudiante)
			cantidad *= 0.9;
		return cantidad;
	}

	@Override
	public String toString() {
		return super.toString() + '\n' +
				"\tcarnetEstudiante ->\t\t\t" + ((carnetEstudiante) ? "Si" : "No");
	}
}
