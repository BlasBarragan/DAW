/**
 * Unidad 2b: Ejercicio 8
 * 
 * @author jrsimo
 * 
 */

package U02bEjercicios;

import java.util.Scanner;

public class U02bEjercicio8 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("===================== ENTRADA DATOS CLIENTE =====================");
		
		// Pido dia mes y año por separado. Da igual que se introduzcan 
		// separados por espacios o por retorno de carro.
		System.out.print("Fecha de nacimiento: dia, mes y año? ");
		int dia = sc.nextInt();
		int mes = sc.nextInt();
		int anyo = sc.nextInt();
		sc.nextLine();
		
		// Pido el NIF y lo guardo en una variable tipo cadena (ya que lleva una letra)
		// Atención al uso del método trim()
		System.out.print("NIF? ");
		String dni = sc.nextLine().trim();
		
		System.out.print("Nombre? ");
		String nombre = sc.nextLine().trim();
		
		System.out.print("Dirección: calle y número? ");
		String direccion = sc.nextLine().trim();
		
		System.out.print("Código postal y población? ");
		String codigoPostalPoblacion = sc.nextLine().trim();
		
		// Guardo el teléfono en variable tipo cadena (por si pone prefijo +34 por ejemplo?)
		System.out.print("Teléfono Fijo? ");
		String fijo = sc.nextLine().trim();
		
		System.out.print("Teléfono Móvil? ");
		String movil = sc.nextLine().trim();
		
		System.out.print("Salario bruto? ");
		double salarioBruto = sc.nextDouble();
		
		System.out.print("Retención? ");
		double retencion = sc.nextDouble();

		// Calculo el salario neto...
		double salarioNeto = salarioBruto - (salarioBruto * retencion)/100;
		
		
		/*
		 * Muestro los datos de salida introducidos por el cliente
		 */
		System.out.println("\n===================== SALIDA DATOS CLIENTE =====================");
		System.out.println("Nombre.............: " + nombre);
		
		System.out.println("Dirección..........: " + direccion + "\n" + ""
				+ "                     " + codigoPostalPoblacion);
		
		System.out.println("\nTeléfono fijo......: " + fijo);
		System.out.println("Teléfono móvil.....: " + movil);
		
		System.out.println("\nNIF................: " + dni);
	
		System.out.printf("\nFecha de nacimiento: %02d/%02d/%02d \n", dia, mes, anyo);
		
		System.out.println("\nSalario bruto......: " + salarioBruto);
		System.out.println("Retención..........: " + retencion);
		System.out.println("Salario neto.......: " + salarioNeto);
		
	}

}
