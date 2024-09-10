/*
 * 
 * Ejercicio2.java
 *
 * Sueldo máximo y mínimo
 * 
 * Solución del profesor
 * 
 */

import java.util.Scanner;

public class Ejercicio2
{
	public static void main(String[] args)
	{
		int numEmpleados = 0; 
		int sueldo = 0;
		int sueldoMaximo = 0;
		int sueldoMinimo = 0;
		int contEmpleados = 0; // Para identificar a cada empleado

		Scanner sc = new Scanner(System.in);

		// Entrada de datos
		System.out.print("¿Cuántos empleados hay?: ");
		numEmpleados = sc.nextInt();

		if(numEmpleados <= 0)
			System.out.println("No hay empleados.");
		else
		{	
			contEmpleados++; // Esto también se podría hacer dentro del System.out.print con un preincremento como en la siguiente línea comentada
			//System.out.print("Dame sueldo del empleado " + (++contEmpleados) + ": " );
			System.out.print("Dame sueldo del empleado " + contEmpleados + ": " );
			sueldo = sc.nextInt();

			// Considero que el sueldo del primer empleado es el más alto y el más bajo
			sueldoMaximo = sueldo;
			sueldoMinimo = sueldo;

			for (int i = 0; i < numEmpleados - 1; i++)
			{
				contEmpleados++;
				//System.out.print("Dame sueldo del empleado " + (++contEmpleados) + ": " );
				System.out.print("Dame sueldo del empleado " + contEmpleados + ": ");
				sueldo = sc.nextInt();

				// Calculo el sueldo máximo y mínimo
				if (sueldo > sueldoMaximo)
					sueldoMaximo = sueldo;
				else if (sueldo < sueldoMinimo)
					sueldoMinimo = sueldo;
			}

			// Muestro los resultados
			System.out.println("El sueldo máximo es: " + sueldoMaximo);
			System.out.println("El sueldo mínimo es: " + sueldoMinimo);
		}
	}
}	

