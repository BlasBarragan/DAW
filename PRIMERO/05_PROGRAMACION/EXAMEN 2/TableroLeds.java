package leds;

public class TableroLeds {
	
	// Atributos
	private int numeroFilas;
	private int numeroColum;
	private char[][] tablero;

	// Constructor
		// Creamos un array segun las filas y columnas indicadas
	public TableroLeds(int filas, int columnas) {
		
		this.numeroFilas = filas;
		this.numeroColum = columnas;
		this.tablero = new char[filas][columnas];
		
		// Creamos el array con los led apagados "."
		for (int i = 0; i < filas; i++) {
			
			for (int j = 0; j < columnas; j++) {
				
				this.tablero[i][j] = '.';
			}
		}
	}
	
	// mostrar() - Imprime el tablero completo
	public void mostrar() {
		System.out.println("Mostrando tablero de leds:");
		
		for (int i = 0; i < this.numeroFilas; i++) {
			
			for (int j = 0; j < this.numeroColum; j++) {
				
				System.out.print(this.tablero[i][j] + " ");
			}
			
			System.out.println();
		}
	}
	
	// encenderLed() - Modifica dentro del array el led indicado segun fila y columna 
	public void encenderLed(int fila, int columna) {
		
		if (fila <= 0 || fila > this.numeroFilas || columna <= 0 || columna > this.numeroColum) {
			
			// Si el led indicado sale de rango muestra un error
			System.out.println("=> Encendiendo led [" + fila + ", " + columna + "]... Error: El led no esta dentro del tablero.");
		} 
		else {
			
			// Si el led indicado esta en el tablero cambiar el caracter "." por "*"
			System.out.println("=> Encendiendo led [" + fila + ", " + columna + "]...");
			this.tablero[fila-1][columna-1] = '*';			
		}
	}
	
	// encenderLed() - Modifica dentro del array el led indicado segun fila y columna
	public void apagarLed(int fila, int columna) {
		
		if (fila <= 0 || fila > this.numeroFilas || columna <= 0 || columna > this.numeroColum) {
			
			// Si el led indicado sale de rango muestra un error
			System.out.println("=> Apagando led [" + fila + ", " + columna + "]... Error: El led no esta dentro del tablero.");
		} 
		else {
			
			// Si el led indicado esta en el tablero cambiar el caracter "*" por "."
			System.out.println("=> Apagando led [" + fila + ", " + columna + "]...");
			this.tablero[fila-1][columna-1] = '.';			
		}
	}
	
	// Ejercicio 2
	// calcularporcentaje() - Calcula el porcentaje de leds encendidos
	public double calcularporcentaje() {
		
		double porcentaje = 0;
		int ledEncendidos = 0;
		int numeroLeds = this.numeroFilas * this.numeroColum;
		
		for (int i = 0; i < this.numeroFilas; i++) {
			
			for (int j = 0; j < this.numeroColum; j++) {
				
				if (this.tablero[i][j] == '*') {
					
					// por cada led encendido sumamos al contador
					ledEncendidos++;
				}
			}
		}
		
		// calcula el porcentaje
		porcentaje = (ledEncendidos / (double)numeroLeds) * 100;
		
		return porcentaje;
	}
	
	// Ejercicio 3
	// modoNocturno() - reduce el tamaño del tablero
	public void modoNocturno() {
		
		for (int i = 0; i < this.numeroFilas; i++) {
			
			for (int j = 0; j < this.numeroColum; j++) {
				
				if (i == 0 || i == this.numeroFilas - 1 || j == 0 || j == this.numeroColum - 1) {
					
                    this.tablero[i][j] = '*';
                    
                } 
				else {
					
                    this.tablero[i][j] = '.';
                }
			}
		}
	}
	
	// Ejercicio 4
	// iluminacionAlternada() - enciende y apaga el panel segun el patron dado
	public void iluminacionAlternada(int intervalo) {
		
		for (int i = 0; i < this.numeroFilas; i++) {
			
			for (int j = 0; j < this.numeroColum; j++) {
				
				if (j % (2 * intervalo) < intervalo) {
                    
					this.tablero[i][j] = '*';
                } 
				else {
                    
					this.tablero[i][j] = '.';
                }
			}
		}
	}
}