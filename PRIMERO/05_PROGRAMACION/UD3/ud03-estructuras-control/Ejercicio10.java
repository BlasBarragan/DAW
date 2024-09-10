package U03EstructurasDeControl;

public class Ejercicio10 {

	public static void main(String[] args) {

		int n = 7;

		//******************************
		System.out.println("Primer bucle: ");
		int i = 3;
		while (i<=n) {
			System.out.println(i);
			i = i+3;
		}
		//******************************
		System.out.println("Segundo bucle: ");
		i = 0;
		while (i<n) {
			i = i+3;
			System.out.println(i);
		}
		//******************************
	}

}