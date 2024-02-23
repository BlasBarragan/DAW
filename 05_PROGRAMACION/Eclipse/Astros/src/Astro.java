
public abstract class Astro {

	// Atributos (variables)
	private String nombre;
	private double radio;
	private double rotacion;
	private double masa;
	private double temperatura;
	private double gravedad;
	
	// Constructor
	public Astro(String nombre, double radio, double rotacion, double masa,
			 double temperatura, double gravedad) {
		
		this.nombre = nombre;
		this.radio = radio;
		this.rotacion = rotacion;
		this.masa = masa;
		this.temperatura = temperatura;
		this.gravedad = gravedad;
		
	}
	
	// Metodo abstracto. El que se hereda "muestra()"
	public abstract void muestra();
	
	// Get Set
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public double getRotacion() {
		return rotacion;
	}

	public void setRotacion(double rotacion) {
		this.rotacion = rotacion;
	}

	public double getMasa() {
		return masa;
	}

	public void setMasa(double masa) {
		this.masa = masa;
	}

	public double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(double temperatura) {
		this.temperatura = temperatura;
	}

	public double getGravedad() {
		return gravedad;
	}

	public void setGravedad(double gravedad) {
		this.gravedad = gravedad;
	}
	
}
