package clasesEjemplo;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;

public class ClasePrintf {

	public static void main(String[] args) {

		//Declaración de variables
		int a = 8;
		int b = 3;
		int resultado = 0;
		double res = 0.0;		
		
		//1.- Imprimir números enteros
		
		//%d se sustituye por la variable entera, resultado
		//%n indica un salto de línea
		resultado = (a + b);
		System.out.printf("La suma es: %d %n", resultado);
		
		System.out.printf("La suma de %d más %d es %d %n", a, b, resultado);
		System.out.println("La suma de " + a + " más " + b + " es " + resultado);		
		
		resultado = (a - b);
		System.out.printf("La resta es: %d %n", resultado);
		resultado = (a * b);
		System.out.printf("La multiplicación es: %d %n", resultado);
		
		//2.- Imprimir números decimales

		//%f se sustituye por la variable decimal, res
		//2.6666666666666667
		res = (double) a / b;
		System.out.printf("La división es: %f\n", res);

		//Se pueden imprimir diferentes variables en una misma instrucción
		System.out.printf("La división entre %d y %d es igual a %f \n", a, b, res);

		//3.- Imprimir texto

		//%s se sustituye por la variable de texto, para que imprima en minúsculas
		//%S se sustituye por la variable de texto, para que imprima en mayúsculas
		//El salto de línea se puede indicar con \n o %n
		String texto = "Mayor";		
		System.out.printf("El resultado es: %s \n", texto);
		System.out.printf("El resultado es: %S %n", texto);	
		 
		//4.- Más formatos para imprimir números decimales
		
		//2,67
		System.out.printf("%.2f %n", res);		
		// 2,67
		System.out.printf("%10.2f %n", res);		
		//  2,667 
		System.out.printf("%7.3f %n", res);
		//002,667 
		System.out.printf("%07.3f %n", res);
		//    2,6667 
		System.out.printf("%10.4f %n", res);
		//2,667 
		System.out.printf ("%5.3f %n", res);
		//   2,66667 
		System.out.printf ("%10.5f %n", res);
		//0002,66667 
		System.out.printf ("%010.0f %n", res);

		System.out.println ("-------------------------------------------------");
		
		//5.- Uso de la clase Decimal Format

		DecimalFormat formateador = new DecimalFormat("####.####");
		//Imprime esto con cuatro decimales, es decir: 7,1234
		System.out.println(formateador.format(7.12342383));
		
		formateador = new DecimalFormat("0000.0000");
		//Imprime con 4 cifras enteras y 4 decimales: 0001,8200
		System.out.println(formateador.format (1.82));

		//Redondeo
		double aa = 1.2345;
		double bb = 1.2356;

		formateador = new DecimalFormat("#.##");

		System.out.println(formateador.format( aa ));   // La salida es 1,23
		System.out.println(formateador.format( bb ));   // La salida es 1,24

		//Porcentajes
		formateador = new DecimalFormat("###.##%");
		// Imprime: 68,44%
		System.out.println (formateador.format(0.6844));
				
		//Simbolos
		DecimalFormatSymbols simbolos = new DecimalFormatSymbols();
		simbolos.setDecimalSeparator('.');
		formateador = new DecimalFormat("####.####", simbolos);
		// Imprime: 3.4324
		System.out.println (formateador.format (3.43242383));		

	}
}