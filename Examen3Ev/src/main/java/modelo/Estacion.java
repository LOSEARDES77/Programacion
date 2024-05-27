package modelo;

public class Estacion {
	
	private int codigo;
	private String nombre;
	private String ubicacion;
	private int agnoInauguracion;
	private int vias;
	
	
	public Estacion(int codigo) {
		this.codigo = codigo;
	}
	
	
	public Estacion(String nombre, String ubicacion, 
	                int agnoInauguracion, int vias) {
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.agnoInauguracion = agnoInauguracion;
		this.vias = vias;
	}
	
	public Estacion(int codigo, String nombre, String ubicacion, 
	                int agnoInauguracion, int vias) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.ubicacion = ubicacion;
		this.agnoInauguracion = agnoInauguracion;
		this.vias = vias;
	}
	
	@Override
	public String toString() {
		return 
			"Estación [Código = " + this.codigo + 
			", Nombre = " + this.nombre + 
			", Ubicación = " + this.ubicacion + 
			", AñoInauguración = " + this.agnoInauguracion + 
			", Vías = " + this.vias + 
			"]";
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

	public String getUbicacion() {
		return this.ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public int getAgnoInauguracion() {
		return this.agnoInauguracion;
	}

	public void setAgnoInauguracion(int agnoInauguracion) {
		this.agnoInauguracion = agnoInauguracion;
	}

	public int getVias() {
		return this.vias;
	}

	public void setVias(int vias) {
		this.vias = vias;
	}
	
}
