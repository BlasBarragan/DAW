/**
 * Unidad 2b: Ejercicio 8
 * 
 * @author jrsimo
 * 
 */

package U02bEjercicios;

import java.util.Scanner;

public class U02bEjercicio6 {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		/*
		 * Atención, este ejercicio se puede hacer de varias maneras.
		 * Mi propuesta es jugar con los padding de printf.
		 * 
		 * Se podría ampliar este ejercicio pidiendo los datos de entrada
		 * al cliente.
		 */
		System.out.printf("%70s%n", "NºFactura: 1234");
		System.out.println("Cliente: Aitor Tilla                    NIF: 12345678Z");
		System.out.println("Domicilio: C/Ruez del percebe           Pago: Efectivo");
		
		System.out.println("");

		System.out.printf("%n%-20s %-40s %-10s %s", "Cantidad", "Concepto-Referencia", "Precio", "Importe");
		System.out.printf("%n%-20s %-40s %-10s %s", "1", "Lenovo Thinkpad", "600€", "600€");
		System.out.printf("%n%-20s %-40s %-10s %s", "3", "Logitech M510", "50€", "150");
		
		System.out.println("");
		
		System.out.printf("%n%-20s %-20s %-30s %s", "Total Bruto", "Descuento", "Iva", "Total");
		System.out.printf("%n%40s %5s   %-5s %s", "Base", "%", "Importe", "R.E.");
		
		System.out.printf("%n%-20s %-23s %-27s %.2f", "750€", "0€", "21%", 750*0.21f);

	}
}
