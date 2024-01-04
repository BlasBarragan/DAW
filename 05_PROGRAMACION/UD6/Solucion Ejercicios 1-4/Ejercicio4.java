import java.util.HashSet;
import java.util.Scanner;

public class Ejercicio4 {

	public static void main(String[] args) {
		HashSet<Integer> dorsales = new HashSet<Integer>();
		Scanner sc = new Scanner(System.in);
		
		// Pido los dorsales y los añado al conjunto
		int dorsal = 0;
		
		while(dorsal >= 0) {
			dorsal = sc.nextInt();
			if (dorsal >= 0)
				dorsales.add(dorsal);
		}
		
		// a)	Comprobar si el dorsal existe en el equipo.
		if (dorsales.contains(10))
			System.out.println("Existe");
		else
			System.out.println("No existe");
		
		// b)	Muestra todos los dorsales del equipo.
		for (Integer valor : dorsales)
			System.out.print(valor + " ");
		System.out.println("");
		
		// c)	Elimina el dorsal 13 del equipo.
		dorsales.remove(13);		
		
		// d)	Elimina todos los dorsales del equipo.
		dorsales.clear();
		
		// e)	Comprueba que no hay dorsales en el equipo.
		System.out.println(dorsales.isEmpty());
	}
}
