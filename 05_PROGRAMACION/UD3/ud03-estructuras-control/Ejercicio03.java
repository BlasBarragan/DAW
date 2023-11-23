package U03EstructurasDeControl;

public class Ejercicio03 {

	public static void main(String[] args) {

		int x = 0;

		if (x >= 0)
			x++;
		else if (x >= 1)
			x = x+2;

		System.out.println("1.- " + x);

		//****************

		x = 0;

		if (x >= 0)
			x++;
		if (x >= 1)
			x = x+2;

		System.out.println("2.- " + x);

		//****************

		x = 0;

		if (x < 0)
			x = x+2;
		else x++;
		x--;

		System.out.println("3.- " + x);

		//****************

		x = 0;

		if (x > 0)
			if (x <= 1)
				x++;
			else x--;

		System.out.println("4.- " + x);		
	}

}
