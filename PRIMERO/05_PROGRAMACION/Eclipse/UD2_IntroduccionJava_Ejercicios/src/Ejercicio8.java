/**
 * Blas Barragan Roman 
 * 
 * UD2 Introduccion a Java
 * 
 * Ejercicio 8 
 * Hacer una traza del siguiente programa:
 * public class TestOperador {
 * 	public static void main(String[] args) {
 * 	
 * 		int a = 12, b = 8, c = 6;
 * 	
 * 		System.out.println(a + " " + b + " " + c);
 * 		a = c;
 * 		System.out.println(a + " " + b + " " + c);
 * 		c += b;
 * 		System.out.println(a + " " + b + " " + c);
 * 		a = b + c;
 * 		System.out.println(a + " " + b + " " + c);
 * 		a++;
 * 		b++;
 * 		System.out.println(a + " " + b + " " + c);
 * 		c = a++ + ++b;
 * 		System.out.println(a + " " + b + " " + c);
 * 	}
 * }
 */
public class Ejercicio8 {

	public static void main(String[] args) {
		int a = 12, b = 8, c = 6;
		  	
		 System.out.println(a + " " + b + " " + c);// 12 8 6
		 a = c;
		 System.out.println(a + " " + b + " " + c);// 6 8 6
		 c += b;
		 System.out.println(a + " " + b + " " + c);// 6 8 14
		 a = b + c;
		 System.out.println(a + " " + b + " " + c);// 22 8 14
		 a++;
		 b++;
		 System.out.println(a + " " + b + " " + c);// 23 9 14
		 c = a++ + ++b;
		 System.out.println(a + " " + b + " " + c);// 24 10 33
	}

}
