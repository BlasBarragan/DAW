package teoria;

import java.util.Scanner;

public class C06_Bucles {

	public static void main(String[] args) {

		//Bucles
		
		//1.- for
		
		//Simple
		for (int i = 0; i < 10; i++) {
			
			System.out.println(i);			
		}
		
		//Anidado
		for (int i = 1; i < 4; i++) {	
			
			for (int j = 1; j < 4; j++) {			
				
				System.out.println(  i + " - " + j );			
			}						
		}		
		
		//2.- while (){  } --> 0 o mas veces
		
		int i = 0;
		
		while (i < 10) {
			
			System.out.println( i+1 );
			
			i++;
		}		
		
		//3.- do... while --> 1 o mas veces
		
		Scanner sc = new Scanner(System.in);
		
		String passOK = "eureka";
		String pass   = "";
		int intentos  = 0;		
		
		do {			
			pass = sc.nextLine();			
			intentos++;
			
		} while ((intentos < 3) || (pass.equals(passOK)));

	}

}