import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String ruta; 
		
		do {
			System.out.println("Dame ruta: ");
			ruta = sc.nextLine();
			
			if (!ruta.isEmpty()) {
				
				System.out.println("Dame extensión: ");
				String extension = sc.nextLine();
				
				File fichero = new File(ruta);
		
				ArrayList<String> ficherosFiltrados = filtrarPorExtension(fichero, extension);
		
				for(String fila : ficherosFiltrados)
					System.out.println(fila);

				System.out.println("---------------------------\n");
			}
		}while(!ruta.isEmpty());
		
		sc.close();
		
		System.out.println("FIN DEL PROGRAMA");
	}

	public static ArrayList<String> filtrarPorExtension(File fichero, String extension) {
		String[] listado = fichero.list();
		
		ArrayList<String> ficherosFiltrados = new ArrayList<String>();
		
		for(String fila : listado) {
			String expresionRegular = "\\S+." + extension;
			if (fila.matches(expresionRegular)) {
				ficherosFiltrados.add(fila);
			}
		}
		
		return ficherosFiltrados;
	}
}