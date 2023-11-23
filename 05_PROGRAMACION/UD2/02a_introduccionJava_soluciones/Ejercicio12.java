package ud2_introduccionJava;

public class Ejercicio12 {

	public static void main(String[] args) {

		int cont   = 10;
		int limite = 20;
		
		boolean condicion;
		
		condicion = (cont == 0) && (limite < 20);		
		System.out.println( "a) " + condicion); 
		
		condicion = (limite >= 20) || (cont < 5);
		System.out.println( "b) " + condicion); 
		
		//condicion = ((limite/(cont-10)) > 7) || (limite < 20);
		System.out.println( "c) " + condicion); 
		
		condicion = (limite<=20) || ((limite/(cont-10)) > 7);
		System.out.println( "d) " + condicion); 
		
		//condicion = ((limite/(cont-10)) > 7) && (limite < 0);
		System.out.println( "e) " + condicion); 
		
		condicion = (limite < 0) && ((limite/(cont-10)) > 7);
		System.out.println( "f) " + condicion); 		
	}

}