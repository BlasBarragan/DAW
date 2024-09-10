package ex1;

public class Profesor extends Persona {
	
	String nombre;
	int edad;
	String numtlf;
	List<Prestamo> prestamos;
	
	//Constructor heredado
	public Profesor(String nombre, int edad, String numtlf) {
		super(numtlf);
		this.nombre = nombre;
		this.edad = edad;
	}
	
	//Getters y setters
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
	public String getNumeroDeTelefono() {
		return numtlf;
	}
	public void setNumeroDeTelefono(String numtlf) {
		this.numtlf = numtlf;
	}
	//----------------
	
	public void printInformacioPersonal() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Edad: " + edad);
		System.out.println("Telefono: " + numtlf);
		
	}
	
	public void printListaPrestamos() {
		
		for (Prestamo p: prestamos) {
			System.out.println(p);
		}
	}

}
