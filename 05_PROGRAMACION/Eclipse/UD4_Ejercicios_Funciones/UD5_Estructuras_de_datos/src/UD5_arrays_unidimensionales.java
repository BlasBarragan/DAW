import java.util.Scanner;

public class UD5_arrays_unidimensionales {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		/** Ejercicio 1
		 *  Escribe un programa que pida al usuario 6 números enteros cortos
		 *  y luego los muestre en orden inverso
		 *	(pista: usa un array para almacenarlos
		 *  y "for" para mostrarlos). 
		 *  Declara una variable constante para el tamaño
		 *	del array. 
		 */
		/*
		int tamaño = 6;
		int [] my_array = new int[tamaño];
		
		Scanner sc = new Scanner(System.in);
		
		for (int i=0; i<my_array.length; i++) {
			System.out.println("Dame un numerito:");
			my_array[i]= sc.nextInt();			
		}
		for (int j=5; j>0; j--) {
			System.out.println(my_array[j]);
		}
		*/
		
		/**Ejercicio 2
		 * Escribe un programa que pida 10 reales enteros
		 * por teclado,los almacene en un array, 
		 * y luego muestre la media aritmética de estos valores.
		 * Utiliza necesariamente el método length 
		 * de la clase array.
		 */
		/*
		int size = 10;
		int [] media = new int[size];
		int aritmetica = 0;
		
		for (int i=0; i<media.length; i++) {
			System.out.println("Aqui van los reales: ");
			media[i]=sc.nextInt();
		}
		for (int j=0; j<size; j++) {
			aritmetica += media[j];
		}
		System.out.println("La media aritmetica del array es: " + aritmetica/size);
		*/
		
	}

}
