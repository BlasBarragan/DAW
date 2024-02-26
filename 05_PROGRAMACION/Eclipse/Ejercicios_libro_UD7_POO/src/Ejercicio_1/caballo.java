package Ejercicio_1;

public class caballo {

	// Atributos 
	String nombre;
	String raza;
	String color;
	int edad;
	int carrerasGanadas;
	
	// Constructor
	public caballo(String nombre, String raza, String color, int edad, int carrerasGanadas) {
		
		this.nombre = nombre;
		this.raza = raza;
		this.color = color;
		this.edad = edad;
		this.carrerasGanadas = carrerasGanadas;
		
	}
	
	// Metodos
	public void cabalga() {

		System.out.println(this.nombre + " cabalga.");;
	}
	
	public boolean rumia() {
		boolean rumiando = true;
		
		return rumiando;
	}
	
	public String relincha() { 
		
		return this.nombre + " relincha";
	}
	
	public boolean trota() {
		boolean trotando = true;
		
		return trotando;
	}
	
}
