import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ruta; 
		
		do {
			System.out.print("Dame ruta: ");
			ruta = sc.nextLine();
			
			if (!ruta.isEmpty()) {
				File fichero = new File(ruta);
				
				String[] listado = fichero.list();
				
				for(String fila : listado)
					System.out.println(fila);
			}
			
			System.out.println("---------------------------\n");
		}while (!ruta.isEmpty());
		
		System.out.println("FIN DEL PROGRAMA");
		
		sc.close();
	}
}