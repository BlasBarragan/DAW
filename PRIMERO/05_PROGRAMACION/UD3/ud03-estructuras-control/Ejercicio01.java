package U03EstructurasDeControl;

public class Ejercicio01 {

	public static void main(String[] args) {

		double consumo = 0;
		int velocidad  = 120;

		if (velocidad > 80) {
			consumo = 10.00;
		}
		else if (velocidad > 100) {
			consumo = 12.00;
		}
		else if (velocidad > 120) {
			consumo = 15.00;
		}
		
		System.out.println( consumo );
	}
	
}