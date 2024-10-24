
public class Persona {
	private String dni, nombre, apellidos;
	private int edad;
	
	public Persona (String dni, String nombre, String apellidos, int edad) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.edad = edad;
	}

	public Persona ( String nombre1, String apellidos1, int edad1) {
		nombre = nombre1;
		apellidos = apellidos1;
		edad = edad1;
	}

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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
	public void imprime() {
		System.out.println("DNI: "+ this.dni);
		System.out.println("Nombre: "+ this.nombre);
		System.out.println("Apellidos: "+ this.apellidos);
		System.out.println("Edad: "+ this.edad);
	}
	public boolean esMayorEdad() {
		return this.edad >= 18;
	}
	public boolean esJubilado() {
		return this.edad >= 65; 
	}
	public int diferenciaEdad(Persona p) {
		int diferencia;
		if (p.edad>this.edad) {
			diferencia = p.edad-this.edad;
		}else {
			diferencia = this.edad-p.edad;
		}
		return diferencia;
	}
}
