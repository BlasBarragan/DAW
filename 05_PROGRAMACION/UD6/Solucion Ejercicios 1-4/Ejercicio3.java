import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Ejercicio3 {

	public static void main(String[] args) {
		Queue<Integer> colaNumeros = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		// Pido los números enteros al usuario y los añado a la cola
		int numero = 0;
		
		while(numero >= 0) {
			numero = sc.nextInt();
			if (numero >= 0)
				colaNumeros.add(numero);
		}
				
		// a)	Obtener la cabeza de la cola.
		System.out.println("Cabeza cola: " + colaNumeros.peek());
		
		// b)	Eliminar la cabeza de la cola.
		colaNumeros.remove();
		System.out.println(colaNumeros);
		
		// c)	Imprimir el contenido de la cola.
		for (Integer valor : colaNumeros)
			System.out.print(valor + " ");
		System.out.println("");
		
		// d)	Eliminar todos los elementos de la pila, de golpe.
		colaNumeros.clear();
		
		// e)	Comprobar que la pila está vacía.
		System.out.println(colaNumeros.isEmpty());
	}
}
