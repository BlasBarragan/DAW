package Ejercicio_6;

public class Tiempo {

	// Atributos
	private int segundos;
	
	
	// Constructor
	public Tiempo(int h, int m, int segundos) {
		
		this.segundos = (h * 3600)+(m*60)+ segundos;
	}
	
	public Tiempo(int s) {
		
		this.segundos = s;
	}
	// Metodos
	
	public String toString() {
		
		int segundos = this.segundos;
		int horas = segundos / 3600;
		
		segundos -= horas * 3600;
		
		int minutos = segundos / 60;
		
		segundos -= minutos * 60;
		
		if (this.segundos < 0) {
			
			return "-(" + (-horas) + "h " + (-minutos) + "m " + (-segundos) + "s)";
		} 
		else {
			
			return horas + "h " + minutos + "m " + segundos + "s";
		}
	}
	
	
	private int getSegundos() {
	
		return this.segundos;
	}
	
	public Tiempo suma(Tiempo t) {
	
		return new Tiempo(this.segundos + t.getSegundos());
	}
	
	public Tiempo resta(Tiempo t) {
	
		return new Tiempo(this.segundos - t.getSegundos());
	}
}
