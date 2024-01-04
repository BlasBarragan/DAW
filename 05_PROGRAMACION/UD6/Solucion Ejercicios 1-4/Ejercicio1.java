import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Ejercicio1 {
	public static void main(String[] args) {
		ArrayList<Integer> listaNumeros = new ArrayList<Integer>();
		Scanner sc = new Scanner(System.in);
		
		// Pido los n�meros enteros al usuario y los a�ado a la lista
		int numero = 0;
		
		while(numero >= 0) {
			numero = sc.nextInt();
			if (numero >= 0)
				listaNumeros.add(numero);
		}
		
		// a) Muestra la lista por defecto
		System.out.println(listaNumeros);
		
		// b) Inserta el 101 en la primera posici�n.
		listaNumeros.add(0, 101);
		System.out.println(listaNumeros);
		
		// c) Comprueba que el 101 y el -1 est�n en la lista.
		if (listaNumeros.contains(101))
			System.out.println(101 + ":Encontrado");
		else
			System.out.println(101 + ":No encontrado");
		
		if (listaNumeros.contains(-1))
			System.out.println(-1 + ":Encontrado");
		else
			System.out.println(-1 + ":No encontrado");
		
		// d) Obt�n la media aritm�tica de los valores introducidos.
		int suma = 0;
		for (Integer valor : listaNumeros)
			suma += valor;
		float media = (float)suma/listaNumeros.size();
		System.out.println("Media: " + media);
		
		// e) Lee el elemento que est� en la posici�n X, siendo X un valor introducido por el usuario. 
		//    Comprueba que est� dentro del rango de �ndices de la lista.	
		System.out.print("Dame la posici�n en la lista: ");
		int posicion = sc.nextInt();
		
		if (posicion >= 0 && posicion <= listaNumeros.size()-1)
			System.out.println("Elemento buscado: " + listaNumeros.get(posicion));
		else
			System.out.println("Fuera de rango.");
		
		// f) Actualiza el valor que est� en la �ltima posici�n increment�ndolo en 1.
		int valorAux = listaNumeros.get(listaNumeros.size()-1);
		listaNumeros.set(listaNumeros.size()-1, ++valorAux); // preincremento
		System.out.println(listaNumeros);
		
		// g) Elimina el elemento que est� en la primera posici�n. 
		listaNumeros.remove(0);
		
		// h) Ordena de forma ascendente la lista.
		Collections.sort(listaNumeros);
		System.out.println("Ordenado asc: " + listaNumeros);
				
		// i) Ordena de forma descendente la lista.
		Collections.reverse(listaNumeros);
		System.out.println("Ordenado desc: " +listaNumeros);
		
		// j) Ordena de forma descendente la lista.
		Collections.shuffle(listaNumeros);
		System.out.println("Mezclado: " + listaNumeros);
		
		// k) Pide al usuario otra vez una serie de n�meros enteros y 
		//    gu�rdalos en otra lista din�mica. 
		//    Compara esta nueva lista con la anterior e indica si son o no iguales.
		ArrayList<Integer> nuevaListaNumeros = new ArrayList<Integer>();
		Random r = new Random();
		
		for(int i = 0; i < listaNumeros.size(); i++)		
			nuevaListaNumeros.add(r.nextInt(5,100+1));
		System.out.println(nuevaListaNumeros);
		
		if (listaNumeros.equals(nuevaListaNumeros))
			System.out.println("Son iguales");
		else
			System.out.println("No son iguales");
		
		// l) Ahora que tienes dos listas �nelas en una tercera lista.
		ArrayList<Integer> otraListaNumeros = new ArrayList<Integer>();
		otraListaNumeros.addAll(listaNumeros);
		otraListaNumeros.addAll(nuevaListaNumeros);
		System.out.println(otraListaNumeros);
		
	}
}