package ud2_introduccionJava;

import java.util.Scanner;

public class Ejercicio04_NinosNinas {

	public static void main(String[] args) {
		
		Scanner Teclado=new Scanner(System.in);
		
		int ninos = 0;
		int ninas = 0;
		float porcentajeNinos = 0;
		float porcentajeNinas = 0;

		//La variable "sc" se usará para leer los datos
		Scanner sc = new Scanner(System.in);

		//Preguntar el número de niños
		System.out.println("Introducir el número de niños: ");    	    

		//Leer un entero
		ninos = sc.nextInt();

		//Preguntar el número de niñas
		System.out.println("Introducir el número de niñas: ");    	    

		//Leer un entero
		ninas = sc.nextInt();

		//Calcular y mostrar el resultado
		porcentajeNinos = (float) (ninos*100)/(ninos + ninas);
		porcentajeNinas = (float) (ninas*100)/(ninos + ninas);
	
		System.out.println("El porcentaje de niños es: " + porcentajeNinos);
		System.out.println("El porcentaje de niñas es: " + porcentajeNinas);

	}
	
}