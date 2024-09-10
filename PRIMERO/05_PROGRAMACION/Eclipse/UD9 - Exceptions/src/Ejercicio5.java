import java.util.Scanner;

public class Ejercicio5 {

	public static void imprimePositivo(int positivo) throws Exception {
		int p = positivo;
		
		if (p <0)
			throw new  Exception("El valor es mayor que 0");
		else
			System.out.println(p);
	}
	
	public static void imprimeNegativo(int negativo) throws Exception {
		int p = negativo;
		
		if (p >=0)
			throw new Exception("El valor es menor o igual que 0");
		else 
			System.out.println(p);
	}
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int a;
		int b;
		
		a = 9;
		b= 10;
		
		imprimePositivo(a);
		imprimeNegativo(a);
		imprimePositivo(b);
		imprimePositivo(b);
		
	}
}
