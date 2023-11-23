package U03EstructurasDeControl;

public class Ejercicio15 {

	public static void main(String[] args) {

		int n = 9;

		double resultado;
		int i;
		
		if (n<0) i = -n;
		else i = n;
		
		resultado = 0.0;
		
		System.out.println(i);
		
		while (i>=1) {
			resultado += (1.0/i);
			System.out.println(resultado);
			i--;
		}
		
		System.out.println( i + " - " + resultado );
	}

}