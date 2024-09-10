/*
 * 
 * Ejercicio3.java (Solución con bucle do-while)
 *
 * Sueldo máximo y mínimo para un número de empleados indefinido y bucle infinito
 * 
 * Solución del profesor
 * 
 */

import java.util.Scanner;

public class Ejercicio3
{
	public static void main(String[] args)
	{
		int sueldo = 0;
		int sueldoMaximo = 0;
		int sueldoMinimo = 0;
		int contEmpleados = 0;

		Scanner sc = new Scanner(System.in);

		// Hago preincremento con numeroEmpleados (primero incrementa el valor y luego lo muestra)
		System.out.print("Dame sueldo del empleado " + (++contEmpleados)  + ": ");
		sueldo = sc.nextInt();

		if(sueldo <= 0)
			System.out.println("No hay empleados.");
		else
		{	
			sueldoMaximo = sueldo;
			sueldoMinimo = sueldo;

			do
			{
				System.out.print("Dame sueldo del empleado " + (++contEmpleados)  + ": ");
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
			}
			while (true); // bucle infinito

			// Muestro resultados
			System.out.println("El sueldo máximo es: " + sueldoMaximo + "€");
			System.out.println("El sueldo mínimo es: " + sueldoMinimo + "€");
		}
	}	
}
