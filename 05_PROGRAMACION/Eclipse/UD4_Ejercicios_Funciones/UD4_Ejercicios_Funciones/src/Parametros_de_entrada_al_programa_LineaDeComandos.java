public class Parametros_de_entrada_al_programa_LineaDeComandos {

	public static void calculadora(int a, int b, char operacion)
	{
		int resultado=0;

		switch(operacion)
		{
		case 's': resultado = a+b; break;
		case 'r': resultado = a-b; break;
		case 'm': resultado = a*b; break;
		case 'd': 
			if (a == 0 || b == 0) 
			{
				System.out.println("Error: No se puede dividir 0");
			}
			else
			{
				resultado = a/b; break;
			}
		default: System.out.println("Error: Operacion no valida");
		}
		System.out.println("El resultado es: " + resultado);
	}

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Error: Numero de argumentos incorrecto");
		}else
		{			
			int a = Integer.parseInt(args[0]);
			int b = Integer.parseInt(args[1]);
			char operacion = args[2].charAt(0);
			calculadora(a,b,operacion);		
		}
	}
}
