package U03EstructurasDeControl;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Dime n:");
		int n = sc.nextInt();
		int res;
		
		for (int i = 1; i <= n; i++) {
			
			for (int j = i; j <= n; j++) {
		
				res = i + j + 2 * i * j;
				System.out.printf("Par %d,%d: %d + %d + 2 * %d * %d + vale %d %n", i, j, i, j, i, j, res);
			}
		}
	}

}