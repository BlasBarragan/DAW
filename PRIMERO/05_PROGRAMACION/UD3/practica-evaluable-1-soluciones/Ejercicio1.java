/*
 * 
 * Ejercicio1.java
 * 
 * Notas de alumnos (Profesor bacterio)
 * 
 * Solución del profesor
 * 
 */

import java.util.Scanner;

public class Ejercicio1
{
	public static void main(String[] args)
	{		
		// Contadores de notas
		int brillantes = 0;
		int aprobados = 0; 
		int condicionados = 0;
		int suspensos = 0;
		int cazurros = 0;

		int nota = 0; // Almacena nota de cada alumno

		Scanner sc = new Scanner(System.in);

		// Introducción y control de las notas
		for (int i = 0; i < 3; i++)
		{
			System.out.print("Dame nota: ");
			nota = sc.nextInt();

			switch (nota)
			{
			case 0:
				cazurros++;
				break;
			case 1: // Si saco un 1, un 2 o un 3...
			case 2:
			case 3:
				suspensos++;
				break;
			case 4:
				condicionados++;
				break;
			case 5: // Si saco un 5, un 6, un 7 o un 8...
			case 6:
			case 7:
			case 8:
				aprobados++;
				break;
			case 9:
			case 10:
				brillantes++;
				break;
			default:
				System.out.println("Error: nota incorrecta");
			}
		}			

		// Muestro los resultados
		System.out.println("\n=======RESULTADOS=======");
		System.out.println(brillantes + " alumno/s brillantes");
		System.out.println(aprobados + " alumno/s aprobados");
		System.out.println(condicionados + " alumno/s condicionados");
		System.out.println(suspensos + " alumno/s suspensos");
		System.out.println(cazurros + " alumno/s cazurros");
	}
}
