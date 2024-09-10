import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
	
	public static void main(String[] args) {
		
		double[] miArray = new double[5];
		Scanner sc = new Scanner(System.in);
		
		for (int i = 0; i < miArray.length; i++) {
			try {
					System.out.println("Introduce el valor para la posicion " + i);
					miArray[i] = sc.nextDouble();
			}
			catch (InputMismatchException e) {
				System.out.println("Valor introducido erroneo. Introduce un valor distinto");
				e.printStackTrace();
				sc.nextLine();
				i--;
			}
		}
	}
}
