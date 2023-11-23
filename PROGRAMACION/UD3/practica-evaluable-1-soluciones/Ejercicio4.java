/*
 * 
 * Ejercicio4.java
 *
 * Caja fuerte Superindente Vicente
 * 
 * Solución del profesor
 * 
 */
 
import java.util.Scanner;

public class Ejercicio4 
{
	public static void main(String[] args) 
	{
		int numeroIntroducido, copia;
		int clave = 0;
		int cuentaDigitos = 0;
		int digito = 0;
		int ultimoDigito = 0;
		
		Scanner sc = new Scanner(System.in);
    
		System.out.print("Introduce un número: ");
		numeroIntroducido = sc.nextInt();
		copia = numeroIntroducido;

		while (numeroIntroducido > 0) 
		{
		  digito = numeroIntroducido % 10;
		 
		  if (digito % 2 == 1)
			digito = digito - 1;
		  else
			digito = digito + 1;
			
		  ultimoDigito = digito;
		  
		  for (int i = 0; i < cuentaDigitos; i++)
			ultimoDigito = ultimoDigito * 10;
		  
		  clave = clave + ultimoDigito;
		  
		  numeroIntroducido /= 10;
		  cuentaDigitos++;
		}

		// Pequeño truco para el caso en el que el último dígito sea un 0 y aparezca en la clave que ve el usuario...
		// En caso de introducir un dígito no añade 0 (por ejemplo, en caso de que introduzca 0 ó 1 no apareca 00)
		if(ultimoDigito == 0 && cuentaDigitos > 1)
			System.out.println("La clave generado para el número " + copia + " sale el " + "0" + clave);
		else
			System.out.println("La clave generado para el número " + copia + " sale el " + clave);
	}
}
