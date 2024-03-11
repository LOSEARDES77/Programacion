package org.example;

public abstract class Socio {

	protected String dni;
	protected String nombre;
	protected int edad;
	protected double horasEntrenadorPersonal;

	public Socio(String dni, String nombre, int edad, double horasEntrenadorPersonal) {
		this.dni = dni;
		this.nombre = nombre;
		this.edad = edad;
		this.horasEntrenadorPersonal = horasEntrenadorPersonal;
	}

	@Override
	public String toString() {
		String tipo = "Socio";
		if (this instanceof SocioBasico)
			tipo += " Basico";
		else if (this instanceof SocioPremium)
			tipo += " Premium";

		return tipo + ":\n" +
				"\tdni ->\t\t\t\t\t\t" + dni + '\n' +
				"\tnombre ->\t\t\t\t\t" + nombre + '\n' +
				"\tedad ->\t\t\t\t\t\t" + edad + '\n' +
				"\thorasEntrenadorPersonal ->\t" + horasEntrenadorPersonal + '\n' +
				"\tcuotaMensual ->\t\t\t\t" + this.calcularCuotaMensual();
	}

	public abstract double calcularCuotaMensual();

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public double getHorasEntrenadorPersonal() {
		return horasEntrenadorPersonal;
	}

	public void setHorasEntrenadorPersonal(double horasEntrenadorPersonal) {
		this.horasEntrenadorPersonal = horasEntrenadorPersonal;
	}

}
