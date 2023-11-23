package ud2_introduccionJava;

public class Ejercicio07_Ecuacion {

	public static void main(String[] args) {
		
		double x, y, z;
		
		// x =  1;  y =  1;  z = 4
		// x =  2;  y =  2;  z = 1.125
		// x =  4;  y =  4;  z = 0.390625
		// x = -1;  y = -2;  z = 0.5
		
		x = -1;
		y = -2;
		
		z = (1 + (x*x/y)) / ((x*x*x)/(1+y));
		
		System.out.println( z );
	}

}