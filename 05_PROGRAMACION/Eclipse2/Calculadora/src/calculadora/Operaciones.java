package calculadora;

public class Operaciones {
	
	static int resultado = 0;
	
	public static void main(String[] args) {
		System.out.println(suma(1,2));
		
	}
	
	public int acumular(String operacion, int b) {

		try {
		
			switch (operacion) {
			case "suma": {
				resultado = suma(resultado,b);
				break;
			}
			case "resta":{
				resultado = resta(resultado,b);
				break;
			}
			case "division":{
				resultado = division(resultado,b);
				break;
			}
			case "multiplicacion":{
				resultado = multiplicacion(resultado,b);
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " );
			}
			
		}catch (ArithmeticException e) {
			System.out.println("Error");
		}
		
		return resultado;
	}

	public static int suma(int a, int b) {

		try {
		
			try {
				resultado = a + b;
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
		}catch (ArithmeticException e) {
			System.out.println("Error");
		}
		
		return resultado;
	}
	
	public int resta(int a, int b) {

		try {
		
			resultado = a - b; 
			
		}catch (ArithmeticException e) {
			System.out.println("Error");
		}
		
		return resultado;
	}
	
	public int division(int a, int b) {

		try {
		
			resultado = a / b; 
			
		}catch (ArithmeticException e) {
			System.out.println("Error");
		}
		
		return resultado;
	}
	
	public int multiplicacion(int a, int b) {

		try {
		
			resultado = a * b; 
			
		}catch (ArithmeticException e) {
			System.out.println("Error");
		}
		
		return resultado;
	}
	
}
