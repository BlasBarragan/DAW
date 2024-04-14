import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Random aleatorio = new Random();
		int dimension = aleatorio.nextInt(10)+1; // para que sea un valor entre 1 y 100
		
		int[] miArray = new int[dimension];
		
		int posicion = 0; 
		
		// Llenamos el array
		for (int i = 0; i<dimension; i++) {
			int valor = aleatorio.nextInt(100)+1;
			miArray[i]= valor;
		}
		
		do { 
			
			try {
				System.out.println("Que posicion deseas revisar? ");
				posicion = sc.nextInt();
				System.out.println("El valor de la posicion: " + posicion + " es: " + miArray[posicion]);
			}
			catch (InputMismatchException e) {
				System.out.println("Valor introducido incorrecto. \nIntroduce un entero");
				e.printStackTrace();
				sc.nextLine();
			}
			catch (ArrayIndexOutOfBoundsException e) {
				if(posicion >= 0)
					System.out.println("Posicion fuera de rango");
				e.printStackTrace();
				System.out.println("El array contiene " + miArray.length + " posiciones.");
				
			}
			
		}while ( posicion > -1 );
			
					
		
	}
}
