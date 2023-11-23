package U03EstructurasDeControl;

public class Ejercicio02 {

	public static void main(String[] args) {

		int x  = -10;
		char c = 'd';

		if (x<0 && c=='x')       System.out.println("Caso 1");
		else if (x<0 && c!='x')  System.out.println("Caso 2");
		else if (x>=0 && c=='y') System.out.println("Caso 3");
		else if (x>=0 && c!='y') System.out.println("Caso 4");

		if ( x < 0 ) {
			if (c=='x') {
				System.out.println("Caso 1");
			}
			else {
				System.out.println("Caso 2");
			}
		}
		else {
			if (c=='y') {
				System.out.println("Caso 3");
			}
			else {
				System.out.println("Caso 4");
			}
		}
	}

}