import java.util.Scanner;

public class MenuEjemplo {
	public static int CalcularTemporada(int dia)
	{
		int recargo_temporada = 0;
				
		if (dia >=1 && dia <=10)
		{
			recargo_temporada = 35;
			System.out.println("Temporada: Dias Blancos");
		else if (dia >=15 && dia <=20)
			recargo_temporada = 0;
			System.out.println("Temporada: Dias Rojos");
		else if (dia >=11 && dia <=14 && dia >= 20 && dia <= 30)
			recargo_temporada = 10;
			System.out.println("Temporada: Dias Verdes");
		else
			System.out.println("Error: Dias no disponibles");
		
		
		return recargo_temporada;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int opcion = 0;

		// Mostramos el menú hasta opción Salir...
		do 
		{
			System.out.println("\n-- Menú Ejemplo --");
			System.out.println("1. Opción 1");
			System.out.println("2. Opción 2");
			System.out.println("3. Salir");
			System.out.print("\nElija una opción: ");

			opcion = sc.nextInt();

			switch(opcion) 
			{
				case 1: // opción 1
					System.out.println("\nOpción 1...");
					// ... otras instrucciones
					break;
				case 2: // opción 2
					System.out.println("\nOpción 2...");
					// .. otras instrucciones
					break;
				case 3: // salir
					break;
				default: // si pone opción que no existe
					System.out.println("Opción no válida.");
			}
		}
		while(opcion != 3);

		System.out.println("\nFin del programa!");
	}
}