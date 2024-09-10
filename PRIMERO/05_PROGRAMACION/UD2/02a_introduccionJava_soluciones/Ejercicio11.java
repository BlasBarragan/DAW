package ud2_introduccionJava;

public class Ejercicio11 {

	public static void main(String[] args) {

		int a = 5;
		int b = 3;		
		double res;
		double ok;

		//1.- 16.5
		res = 3/4*(a*a-b);
		ok  = (double) 3/4 * (a*a-b);
		System.out.println( res + "      " + ok );

		//2.- 1970.6666666667
		res = a/b*1000+304;		
		ok  = (double) a/b * 1000 + 304;
		System.out.println( res + "   " + ok );		

		//3.- 107.5
		res = (100/a+b/2)*5;
		ok  = ((100/a)+((double)b/2))*5;
		System.out.println( res + "    " + ok );
	}

}