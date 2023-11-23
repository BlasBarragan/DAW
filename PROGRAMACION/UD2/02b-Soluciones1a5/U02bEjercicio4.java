package ud02bEjercicios;

import java.util.Scanner;

public class U02bEjercicio4 {

	public static void main(String[] args) {
		
		// Utilizamos la clase Scanner para leer valores de entrada.
		Scanner sc = new Scanner(System.in);
		
		double mbytes = 0;
		
		System.out.println("Introduce el cantidad de MB del fichero:");
		mbytes = sc.nextInt();
		
		// Nota: esta línea es para capturar el retorno de carro
		sc.nextLine();
		
		// Transformo los valores equivalentes
		double kbytes = mbytes*1024;
		double gbytes = mbytes/1024;
		double tbytes = gbytes/1024;
		
		// Formateo la salida con printf para que tabule correctamente los resultados
		System.out.printf("%-10s %-10s %-10s%-10s\n","MB","KB","GB","TB");
		System.out.println("===========================================================");
		System.out.printf("%-10.0f %-10.0f %-10.0f %-10.0f\n", mbytes,kbytes,gbytes,tbytes);
	}

}
