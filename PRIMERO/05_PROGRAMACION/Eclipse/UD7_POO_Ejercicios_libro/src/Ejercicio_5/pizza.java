package Ejercicio_5;

public class pizza {

	// Atributos 
	private String tamaño;
	private String tipo;
	private String estado;
	
	private static int pedidas = 0;
	private static int servidas = 0;
	
	// Constructor
	public pizza(String tipo, String tamaño) {
		
		this.tamaño = tamaño;
		this.tipo = tipo;
		this.estado = "pedida";
		pizza.pedidas = pedidas +1;

	}
	
	// Metodos 
	
	public void sirve() {
		if (this.estado.equals("pedida")) {
			this.estado = "servida"; 
			pizza.servidas ++;;	
		}
		else{
			System.out.println("Esta pizza ya se ha servido");
		}
	}
	
	public String toString() { 
		
		return "Pizza " + this.tipo + " " + this.tamaño + " " + this.estado;
	}
	
	public static int getTotalPedidas() {
		
		return pizza.pedidas;
	}
	
	public static int getTotalServidas() {
		
		return pizza.servidas;
	}
	
}
