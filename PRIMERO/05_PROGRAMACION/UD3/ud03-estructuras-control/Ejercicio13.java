package U03EstructurasDeControl;

public class Ejercicio13 {

	public static void main(String[] args) {

		for (int i=1; i<4; i++) {
			
			System.out.print(i);
			System.out.print(" ");
			
			for (int j=i; j>=1; j--) {
				System.out.print(j);
				System.out.print(" ");
			}
			
			System.out.print("\n");
		}
	}

}