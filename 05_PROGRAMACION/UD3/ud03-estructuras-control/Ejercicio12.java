package U03EstructurasDeControl;

public class Ejercicio12 {

	public static void main(String[] args) {

		System.out.println("Con bucle while...");
		int num=10;
		while (num<=100) {
			System.out.println(num);
			num += 10;
		}

		//TODO hacer con un do... while
		System.out.println("\nCon bucle do-while...");
		num = 10;
		do {
			System.out.println(num);
			num+=10;
		} while(num <=100);
		
		
		//TODO hacer con un for
		System.out.println("\nCon bucle for...");
		for(num = 10;num<=100;num+=10)
			System.out.println(num);	
	}

}