import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Ejercicio2 {

	public static void main(String[] args) {
		Stack<Integer> pilaNumeros = new Stack<Integer>();
		Scanner sc = new Scanner(System.in);
		
		// Pido los números enteros al usuario y los añado a la pila
		int numero = 0;
		
		while(numero >= 0) {
			numero = sc.nextInt();
			if (numero >= 0)
				pilaNumeros.push(numero);
		}
				
		// a)	Obtener la cima de la pila.
		System.out.println("Cima pila: " + pilaNumeros.peek());
		
		// b)	Eliminar la cima de la pila.
		pilaNumeros.pop();
		System.out.println(pilaNumeros);
		
		// c)	Imprimir el contenido de la pila.
		Stack<Integer> pilaAuxiliar = new Stack<Integer>();

		// Para mostrar los elementos conforme están en la pila
		// necesitamos de otra pila. De esta manera los podremos
		// mostrar conforme es el concepto de pila.
		while (!pilaNumeros.empty()) {
			int aux = pilaNumeros.pop();
			System.out.println(aux);
			pilaAuxiliar.push(aux);
		}
		
		// Restauro la pila original
		while (!pilaAuxiliar.empty())
			pilaNumeros.push(pilaAuxiliar.pop());

		System.out.println(pilaNumeros);

		// d)	Eliminar todos los elementos de la pila, de golpe.
		pilaNumeros.clear();
		
		// e)	Comprobar que la pila está vacía.
		System.out.println(pilaNumeros.isEmpty());
	}
}
