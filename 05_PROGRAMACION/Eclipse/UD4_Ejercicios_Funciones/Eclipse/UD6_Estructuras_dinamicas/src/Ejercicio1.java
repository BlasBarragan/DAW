
/**
 * Ejercicio 1. Practicando listas dinamicas
 * 
 * Pedir enteros positivos hasta introducir un negativo
 * todos menos el negativo se guardaran en una lista dinamica
 * Se van añadiendo funcionalidades
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = 0;
		Integer b = 101;
		Integer c = -1;

		// ### Importamos java.util.ArrayList ###
		ArrayList<Integer> numeritos = new ArrayList<Integer>();
		/*
		 * System.out.println("Añade enteros positivos a la lista."); while (a >= 0) {
		 * System.out.println("Si has acabado, ingresa -1"); a = sc.nextInt(); if (a >=
		 * 0) { numeritos.add(a); } }
		 */
		System.out.println("*** Añadimos numeros por programa para agilizar las pruebas ***");
//Añado numeros por programa para las pruebas
		numeritos.add(33);
		numeritos.add(15);
		numeritos.add(20);
		numeritos.add(34);
		numeritos.add(8);
		numeritos.add(12);

		// A. Muestra la lista por defecto.
		System.out.println("Ahora, la lista contiene: " + numeritos);

		// B. Inserta 101 en primera posicion.
		numeritos.add(0, 101);
		System.out.println("Añadimos el numero 101 a la primera posicion. " + numeritos);

		// C. Busca 101 y -1 en la lista y muestra "X:Encontrado" o "X:No encontrado".
		if (numeritos.contains(b)) {
			System.out.println(b + ":Encontrado");
		} else {
			System.out.println(b + ": No encontrado");
		}
		if (numeritos.contains(c)) {
			System.out.println(c + ":Encontrado");
		} else {
			System.out.println(c + ": No encontrado");
		}

		// D. Obten la media aritmetica de los valores introducidos.
		// Obtenggo el tamaño de la lista
		int tamanoLista = numeritos.size();
		// Recorremos la lista sumando los numeros en una variable auxiliar
		int aux = 0;
		for (int i = 0; i < tamanoLista; i++) {
			aux = aux + numeritos.get(i);
		}
		// Calculamos la media y devolvemos el valor
		System.out.println("La media aritmetica de la lista es: " + (aux / tamanoLista) + " , donde " + tamanoLista
				+ " es el tamaño de la lista y " + aux + " la suma de todos sus valores.");

		// E. Busca el valor del indice introducido por el usuario.
		System.out.println("Introduce el indice del valor a buscar:");
		int indiceBuscar = sc.nextInt();
		while (indiceBuscar < 0 || indiceBuscar > tamanoLista - 1) {
			System.out.println("Indice fuera de rango");
			indiceBuscar = sc.nextInt();
		}
		System.out
				.println("El valor correspondiente al indice: " + indiceBuscar + " es: " + numeritos.get(indiceBuscar));

		// F. Incrementa el valor en ultima posicion en 1.
		System.out.println("La ultima posicion de la lista es la num. " + numeritos.size() + " con valor: "
				+ numeritos.get(numeritos.size() - 1));
		System.out.println("Incrementamos el ultimo valor en 1.");
		int ultimoIndice = numeritos.size() - 1;
		int ultimoValor = numeritos.get(ultimoIndice);
		numeritos.set(ultimoIndice, (ultimoValor + 1)); // Modificamos un valor ya existente

		System.out.println(
				"Valor de la posicion: " + numeritos.size() + " es ahora de: " + numeritos.get(numeritos.size() - 1));
		System.out.println(numeritos);

		// G. Elimina elemento que esta en la primera posicion.
		numeritos.remove(0);
		System.out.println("Eliminamos la primera posicion de la lista: " + numeritos);

		// ### Importamos java.util.Collections ###
		// H. Ordena de forma ascendente la lista.
		Collections.sort(numeritos);
		System.out.println("Ordenamos la lista de manera ascendente: " + numeritos);

		// I. Ordena de forma descendente la lista.
		Collections.sort(numeritos, Collections.reverseOrder());
		System.out.println("Ordenamos la lista de manera descendente: " + numeritos);

		// J. Desordenamos alatoriamente los valores de la lista.
		System.out.println("Desordenamos la lista de forma aleatoria: " + numeritos);
		Collections.shuffle(numeritos);

		// ### Importamos java.util.Random ###
		// K. Creamos otra lista con la misma cantidad de numeros aleatorios entre 5 y
		// 100 y comparamos.
		ArrayList<Integer> aleatorios = new ArrayList<Integer>(); // Creamos la lista nueva
		Random rnd = new Random(); // Creamos nuevo objeto random
		// Añadimos tantos numeros aleatorios como numeros hay en la primera lista
		for (int i = 0; i < numeritos.size(); i++) {
			aleatorios.add((int) (rnd.nextDouble() * 100 + 5));
		}
		System.out.println("Esta es la lista con los numeros aleatorios: " + aleatorios);
		// Comparamos las listas
		if (numeritos.containsAll(aleatorios)) {
			System.out.println("Las listas -numeritos- y -aleatorios- son iguales");
		} else {
			System.out.println("Las listas -numeritos- y -aleatorios- son diferentes");
		}

		// L. Añadimos los valores de las dos listas a una tercera lista
		ArrayList<Integer> tercera = new ArrayList<Integer>();
		tercera.addAll(numeritos);
		tercera.addAll(aleatorios);
		System.out.println("Juntamos las dos listas en -tercera- : " + tercera);
	}
}
