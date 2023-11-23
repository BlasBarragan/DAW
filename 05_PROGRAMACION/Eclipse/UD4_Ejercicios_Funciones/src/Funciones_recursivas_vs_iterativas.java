import java.util.Scanner;

public class Funciones_recursivas_vs_iterativas {

	public static int suma(int n)
	{
		for (int i=n-1; i>0; i--)
		{
			n = n+i;
		}
		return n;
	}

	public static int sumaRec(int n)
	{
		if (n==1)
			return 1;
		else
			return n + sumaRec(n-1);
	}
	
	public static int potencia(int base, int exponente)
	{
		int num = base;
		for (int i=0;i<exponente-1;i++) {
			base = base*num;
		}return base;			
	}
	
	public static int potenciaRec(int base, int exponente) 
	{
		if (exponente == 1)
			return base;
		else
			return base * potenciaRec(base,exponente-1);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Dame un numerito!");
		int n = sc.nextInt();
		System.out.println("La suma iterativa es: "+ suma(n));
		System.out.println("La suma recursiva es: "+ sumaRec(n));

		System.out.println("Dame un numerito base!");
		int base = sc.nextInt();
		System.out.println("Dame LA POTENCIA!");
		int exponente = sc.nextInt();
		System.out.println("La potencia iterativa es: "+ potencia(base, exponente));
		System.out.println("La potencia recursiva es: "+ potenciaRec(base, exponente));

		
		
	}
}
