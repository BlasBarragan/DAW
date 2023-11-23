/*
 * 
 * Ejercicio3.java (Solución con bucle while)
 *
 * Sueldo máximo y mínimo para un número de empleados indefinido y bucle infinito
 * 
 * Solución del profesor
 * 
 */

import java.util.Scanner;

public class Ejercicio3b
{
	public static void main(String[] args)
	{
		int sueldo = 0;
		int sueldoMaximo = 0;
		int sueldoMinimo = 0;
		int contEmpleados = 0;

		Scanner sc = new Scanner(System.in);

		System.out.print("Dame sueldo del empleado " + (++contEmpleados) + ": " );
		sueldo = sc.nextInt();

		sueldoMaximo = sueldo;
		sueldoMinimo = sueldo;

		if (sueldo <= 0)
			System.out.println("No hay empleados.");
		else // Hay empleados
		{	
			while (true) // bucle infinito
			{
				System.out.print("Dame sueldo del empleado " + (++contEmpleados) + ": " );
				sueldo = sc.nextInt();

				if (sueldo == 0)
					break;
				else
				{
					if (sueldo > sueldoMaximo)
						sueldoMaximo = sueldo;
					else if (sueldo < sueldoMinimo)
						sueldoMinimo = sueldo;
				}

			} // Termina el bucle infinito

			// Muestro resultados
			System.out.println("El sueldo máximo es: " + sueldoMaximo + "€");
			System.out.println("El sueldo mínimo es: " + sueldoMinimo + "€");
		}
	}	
}
