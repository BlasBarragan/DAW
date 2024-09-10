package teoria;

public class C05_Condicionales {

	public static void main(String[] args) {

		//********************************
		//*   Estructuras condicionales  *
		//********************************
		
		int a = 9;
		int b = 4;

		//1.- Condicional SIMPLE
		if (a > 5) {
			System.out.println("A es MAYOR que 5");
		}
		
		//2.- Condicional DOBLE
		if  (a > 5) {
			System.out.println("A es MAYOR que 5");
		}
		else {
			System.out.println("A es MENOR o IGUAL que 5");
		}
		
		//3.- Condicional con condiciones MÚLTIPLES
		if ((a > 4) && (b < 4)){	

			System.out.println("SI cumple la condición");			
		}
		else {

			System.out.println("NO cumple la condición");
		}

		//4.- Condicional ANIDADO
		if (a > 0) {
			System.out.println("positivo");
		}
		else {	

			if (a == 0) {
				System.out.println("nulo");	
			}
			else {
				System.out.println("negativo");	
			}			
		}

		//5.- Operador condicional

		//Dto = 15% si eres menor o igual de 25años
		//Dto = 7%  si eres mayor de 25años

		int edad = 27;		
		
		//Esta instrucción...
		int dto = (edad > 25) ? 7 : 15;

		//...es equivalente a:
		if (edad > 25) {
			dto = 7;
		}
		else {
			dto = 15;
		}		

		System.out.println( dto );
	}

}