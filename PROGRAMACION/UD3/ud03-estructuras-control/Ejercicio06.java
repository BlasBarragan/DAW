package U03EstructurasDeControl;

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {

		/*
		 * el primer cuadrante x > 0 e y > 0,
		 * el segundo cuadrante x < 0 e y > 0,
		 * el tercer cuadrante x < 0 e y < 0,
		 * el cuarto cuadrante x > 0 e y < 0,
		 * el eje de abscisas x != 0 e y = 0,
		 * el eje de ordenadas x = 0 e y != 0
		 * el origen de coordenadas x = 0 e y = 0
		 * */

		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime la x:");
		int x = sc.nextInt();
		
		System.out.println("Dime la y:");
		int y = sc.nextInt();
		
		if (x>0 && y>0) System.out.println("Primer cuadrante");
		else if (x>0 && y<0) System.out.println("Cuarto cuadrante");
		else if (x<0 && y>0) System.out.println("Segundo cuadrante");
		else if (x<0 && y<0) System.out.println("Tercer cuadrante");		
		else if (x!=0 && y==0) System.out.println("Eje de abscisas");
		else if (x==0 && y!=0) System.out.println("Eje de ordenadas");
		else if (x==0 && y==0) System.out.println("Origen de coordenadas");	
	}

}