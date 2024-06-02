package traductor;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class traductorBSJV {

	// Creamos ArrayList para almacenar instrucciones
	static ArrayList<instruccionBASIC> instrucciones = new ArrayList<>(); 
	static Scanner sc = new Scanner(System.in);
	static String archivo;

	public static void main(String[] args) {

		// Preguntamos al usuario por el archivo a traducir
		System.out.println("Indica el nombre del archivo a abrir: ");
		archivo = sc.nextLine()+".txt";
		//archivo = "codigobasicdesordenado.bas.txt"; // para TEST

		abrirArchivoBasic();

		pasarJava();

	}

	public static void pasarJava() {

		PrintWriter pw = null;
		FileWriter fw = null;

		File fichero = new File(archivo+ ".java");
		try {
			// crea el fichero para escritura
			fw = new FileWriter(fichero);
			// crea el PrintWriter para usar los métodos printXXX
			pw = new PrintWriter(fw);
			// escribimos codigo java
			pw.println("import java.util.Scanner;");
			pw.println();
			pw.println("public class Principal {");
			pw.println();
			pw.println("    public static void main(String[] args) {");
			pw.println();
			pw.println("	    Scanner sc = new Scanner(System.in);");
			pw.println();
			
			//segun la instruccion obtenida creamos codigo de entrada o de salida en java e imprimimos traduccion por consola
			System.out.printf("%-40s | %-40s%n", "CODIGO BASIC", "CODIGO JAVA");
			for (instruccionBASIC instruccion : instrucciones) {
			    String codigoBasic = instruccion.getN_instruccion() + ": " + instruccion.getC() + " = "+ instruccion.getResto_linea();
			    String codigoJava;
			    if (instruccion.getC().name().equalsIgnoreCase("INPUT")) {
			        codigoJava = "int " + instruccion.getResto_linea() + " = Integer.valueOf(sc.nextInt());";
			    } else {
			        codigoJava = "System.out.println(" + instruccion.getResto_linea() + ");";
			    }
			    System.out.printf("%-40s | %-40s%n", codigoBasic, codigoJava);
			}

			pw.println();
			pw.println("    }");
			pw.println("}");

		} catch (IOException e) {
			System.out.println("No se ha podido escribir en el fichero.");
		} finally {
			pw.close(); // no lanza excepción, no requiere tratarla
		}
	}

	public static void abrirArchivoBasic() {

		BufferedReader br = null;
		FileReader fr = null;
		File fichero = new File(archivo);


		try {
			// Abrimos el fichero para lectura
			fr = new FileReader(fichero);
			br = new BufferedReader(fr);

			// mientras haya lineas para leer...
			String linea;

			while ((linea = br.readLine()) != null) {
				if ( linea.isEmpty()){
					//System.out.println(linea);
				}else {
					// Creamos un objeto instruccionBASIC por cada linea
					instruccionBASIC instruccion = new instruccionBASIC(linea);
					// Agregamos la instrucción al ArrayList
					instrucciones.add(instruccion); 
				}
			}
			// Ordenamos el ArrayList segun n_instruccion
			Collections.sort(instrucciones, new Comparator<instruccionBASIC>() {
				public int compare(instruccionBASIC i1, instruccionBASIC i2) {
					return Integer.compare(i1.getN_instruccion(), i2.getN_instruccion());
				}
			});

		} catch (FileNotFoundException e) { // Si no existe el archivo
			System.out.println("No se ha podido encontrar el fichero.");
		} catch (IOException e) { // Si hay otro error
			System.out.println("No se ha podido leer el fichero.");
		} 
	}
}
