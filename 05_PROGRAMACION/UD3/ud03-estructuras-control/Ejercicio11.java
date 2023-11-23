package U03EstructurasDeControl;

public class Ejercicio11 {

	public static void main(String[] args) {

		int n = 10;

		//******************************
		int i = n;
		while (i>=0) {
			System.out.println(i*i);
			i--;
		}
		System.out.println("");
		//******************************
		i = n+1;
		while (i>0) {
			i--;
			System.out.println(i*i);
		}
		System.out.println("");
		//******************************
		i = 0;
		while (i<=n) {
			System.out.println(i*i);
			i++;
		}
		System.out.println("");
		//******************************
		i = 0;
		while (i<=n) {
			System.out.println((n-i)*(n-i));
			i++;
		}
		System.out.println("");
		//******************************
		for (int j=n; j>=0; j--) {
			System.out.println(j*j);
		}
		System.out.println("");
		//******************************
		for (int j=0; j<=n; j++) {
			System.out.println((n-j)*(n-j));
		}

	}

}