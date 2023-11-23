package U03EstructurasDeControl;

public class Ejercicio05 {

	public static void main(String[] args) {

		int primOpcion = 2;

		switch (primOpcion + 1) {
		case 1: System.out.print("Ensalada ");
		break;
		case 2: System.out.print("Paella ");
		break;
		case 3: System.out.print("Emperador ");
		case 4: System.out.print("Helado ");
		break;
		default: System.out.print("Buen provecho");
		}
	}

}