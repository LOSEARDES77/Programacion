package org.example;

public class SocioBasico extends Socio {

	public Turno turno;
	public boolean taquilla;

	public SocioBasico(String dni, String nombre, int edad, double horasEntrenadorPersonal, Turno turno, boolean taquilla) {
		super(dni, nombre, edad, horasEntrenadorPersonal);
		this.turno = turno;
		this.taquilla = taquilla;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public boolean tieneTaquilla() {
		return taquilla;
	}

	public void setTaquilla(boolean taquilla) {
		this.taquilla = taquilla;
	}

	@Override
	public double calcularCuotaMensual() {
		double cantidad = 0;
		if (this.edad > 65){
			if (turno == Turno.Maniana){
				cantidad += 25;
			}else if (turno == Turno.Tarde){
				cantidad += 30;
			}else if (turno == Turno.Mediodia){
				cantidad += 20;
			}
		}else {
			if (turno == Turno.Maniana){
				cantidad += 35;
			}else if (turno == Turno.Tarde){
				cantidad += 40;
			}else if (turno == Turno.Mediodia){
				cantidad += 30;
			}
		}
		if (taquilla){
			cantidad += 2;
		}
		cantidad += (horasEntrenadorPersonal * 40);
		return cantidad;
	}

	public static Turno parseTurno(String turno, String msg){
		String t = turno.toLowerCase();
		if (t.equals("maniana") || t.equals("mañana"))
			return Turno.Maniana;
		if (t.equals("tarde"))
			return Turno.Tarde;
		if (t.equals("mediodia"))
			return Turno.Mediodia;
		System.out.println("Turno no valido");
		return parseTurno(Teclado.leerCadena(msg), msg);
	}

	@Override
	public String toString() {
		return super.toString() + '\n' +
				"\tturno ->\t\t\t\t\t" + turno + '\n' +
				"\ttaquilla ->\t\t\t\t\t" + ((taquilla) ? "Si" : "No");
	}
}
