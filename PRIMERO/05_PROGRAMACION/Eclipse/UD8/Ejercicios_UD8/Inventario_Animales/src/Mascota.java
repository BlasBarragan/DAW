 
public abstract class Mascota {

	// Atributos 
	private String nombre;
	private int edad;
	private String estado;
	private String fechaNacimiento;
	
	// Constructor
	public Mascota (String nombre, int edad, String estado, String fechaNacimiento) {
		
		this.nombre = nombre;
		this.edad = edad;
		this.estado = estado;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	// Metodos abstractos
	abstract void muestra();
	abstract void habla();
	
	// Metodos concretos
	public void cumpleaños() {
		
		this.edad = edad + 1;
	}
	
	public void morir() {
		this.estado = "muerto";
	}

	// GET Y SET
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
}
