import java.util.Scanner;

public class Ejercicio49 {
	
	public static int suma(int n) 
	{
		int resultado = 0;
		
		for(int i = 0; i <= n; i++)
			resultado += i;

		return resultado;
	}

	public static int sumaRecursiva(int n) 
	{
	    int resultado;
	     
	    if(n == 1)
	        return 1;
	    else
	    	resultado = n+sumaRecursiva(n-1);
	     
	    return resultado;
	}
    

	public static void main(String[] args) {	         
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Dame N: ");
		int n = sc.nextInt();
	    int resultado = 0;
	    
	    resultado = suma(n);
	    System.out.println("Resultado suma iterativa: " + resultado);
	
	    resultado = sumaRecursiva(n);
	    System.out.println("Resultado suma recursiva: " + resultado);
	     
	}

}
