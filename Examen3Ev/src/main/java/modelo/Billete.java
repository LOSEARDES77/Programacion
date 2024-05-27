package modelo;

public class Billete {

	private int codigo;
	private Viajero viajero;
	private Estacion estacionOrigen;
	private Estacion estacionDestino;
	private String fecha;
	private String horaSalida;
	private String horaLlegada;
	private double importe;
	
	public Billete(Viajero viajero, Estacion estacionOrigen, Estacion estacionDestino, 
	               String fecha, String horaSalida, String horaLlegada, double importe) {
		this.viajero = viajero;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.importe = importe;
	}
	
	public Billete(int codigo, Viajero viajero, Estacion estacionOrigen, Estacion estacionDestino, 
	               String fecha, String horaSalida, String horaLlegada, double importe) {
		this.codigo = codigo;
		this.viajero = viajero;
		this.estacionOrigen = estacionOrigen;
		this.estacionDestino = estacionDestino;
		this.fecha = fecha;
		this.horaSalida = horaSalida;
		this.horaLlegada = horaLlegada;
		this.importe = importe;
	}

	@Override
	public String toString() {
		return 
			"Billete [Código = " + this.codigo + ",\n" +
			"         Viajero = " + this.viajero.toString() + ",\n" + 
			"         EstaciónOrigen = " + this.estacionOrigen.toString() + ",\n" + 
			"         EstaciónDestino = " + this.estacionDestino.toString() + ",\n" +
			"         Fecha = " + this.fecha + 
			", HoraSalida = " + this.horaSalida + 
			", HoraLlegada = " + this.horaLlegada + 
			", Importe = " + String.format("%.2f", this.importe) + 
			"]";
	}
	
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Viajero getViajero() {
		return this.viajero;
	}

	public void setViajero(Viajero viajero) {
		this.viajero = viajero;
	}

	public Estacion getEstacionOrigen() {
		return this.estacionOrigen;
	}

	public void setEstacionOrigen(Estacion estacionOrigen) {
		this.estacionOrigen = estacionOrigen;
	}

	public Estacion getEstacionDestino() {
		return this.estacionDestino;
	}

	public void setEstacionDestino(Estacion estacionDestino) {
		this.estacionDestino = estacionDestino;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHoraSalida() {
		return this.horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getHoraLlegada() {
		return this.horaLlegada;
	}

	public void setHoraLlegada(String horaLlegada) {
		this.horaLlegada = horaLlegada;
	}

	public double getImporte() {
		return this.importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}
	
}
