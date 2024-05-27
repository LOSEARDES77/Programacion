package modelo;

public class Clase {

	private static final String SEPARADOR = ";";

	private int codigo;
	private String nombre;
	private double consumoMinimoAnual;
	private double porcentajeAdicional;

	public Clase(String nombre, double consumoMinimoAnual, double porcentajeAdicional) {
		this.nombre = nombre;
		this.consumoMinimoAnual = consumoMinimoAnual;
		this.porcentajeAdicional = porcentajeAdicional;
	}

	public Clase(int codigo, String nombre, double consumoMinimoAnual, double porcentajeAdicional) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.consumoMinimoAnual = consumoMinimoAnual;
		this.porcentajeAdicional = porcentajeAdicional;
	}
	
	public Clase(int codigo) {
		this.codigo = codigo;	
	}
	
	public Clase(String linea) {
		String[] datos = linea.split(SEPARADOR);
		this.nombre = datos[0];
		this.consumoMinimoAnual = Double.parseDouble(datos[1]);
		this.porcentajeAdicional = Double.parseDouble(datos[2]);
	}

	@Override
	public String toString() {
		return "Clase [Código = " + this.codigo + ", Nombre = " + this.nombre + ", ConsumoMínimoAnual = "
				+ String.format("%.2f", this.consumoMinimoAnual) + ", PorcentajeAdicional = "
				+ String.format("%.1f", this.porcentajeAdicional) + "]";
	}

	
	public String toStringWithSeparators() {
		return this.codigo + SEPARADOR + this.nombre + SEPARADOR + 
				String.format("%.2f", this.consumoMinimoAnual).replace(',', '.') + 
				SEPARADOR + String.format("%.1f",  this.porcentajeAdicional).replace(',', '.');
	}

	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getConsumoMinimoAnual() {
		return this.consumoMinimoAnual;
	}

	public void setConsumoMinimoAnual(double consumoMinimoAnual) {
		this.consumoMinimoAnual = consumoMinimoAnual;
	}

	public double getPorcentajeAdicional() {
		return this.porcentajeAdicional;
	}

	public void setPorcentajeAdicional(double porcentajeAdicional) {
		this.porcentajeAdicional = porcentajeAdicional;
	}

}
