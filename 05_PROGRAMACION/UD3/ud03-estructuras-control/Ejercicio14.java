package U03EstructurasDeControl;

public class Ejercicio14 {

	public static void main(String[] args) {

		int i, j;
		i = 1;
		while (i*i<10) {
			j = i;
			while (j*j<100) {
				System.out.print(i + j);
				System.out.print(" ");
				j *= 2;
			}
			i++;
			System.out.print("\n");
		}
		System.out.print("\n*****");
	}

}