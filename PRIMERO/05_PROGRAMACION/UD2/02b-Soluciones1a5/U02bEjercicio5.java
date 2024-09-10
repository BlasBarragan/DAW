package ud02bEjercicios;

public class U02bEjercicio5 {

	public static void main(String[] args) {
		//Escribe un programa que sume, reste, multiplique y divida 
		//dos números introducidos por teclado.
		
		final String suma     = "suma";
		final String resta    = "resta";
		final String producto = "producto";
		final String cociente = "cociente";
		
		int x = 9;
		int y = 4;
		
		System.out.printf("%18S%13S%13S%13S%n", suma, resta, producto, cociente);
		for (int i = 0; i < 60; i++) {
			System.out.print("-");
		}
		System.out.printf("%n");
		
		System.out.printf("  x=%d y=%d %8d%13d%13d%13.2f%n", x, y, (x+y), (x-y), (x*y), ((double)x/(double)y));
		for (int i = 0; i < 60; i++) {
			System.out.print("-");
		}
		System.out.printf("%n");
	}

}
