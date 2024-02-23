import java.util.Scanner;

public class ProgramaPersona {

	public static void main(String[] args) {
		
		Persona persona1 = new Persona();
		Persona persona2 = new Persona();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Añade los datos de la persona1: ");
		System.out.println("Nombre: ");
		persona1.nombre = sc.nextLine();
		System.out.println("Apellidos: ");
		persona1.apellidos = sc.nextLine();
		System.out.println("DNI: ");
		persona1.dni = sc.nextLine();
		System.out.println("Edad: ");
		persona1.edad = sc.nextInt();
		sc.nextLine();
		System.out.println("Añade los datos de la persona2: ");
		System.out.println("Nombre: ");
		persona2.nombre = sc.nextLine();
		System.out.println("Apellidos: ");
		persona2.apellidos = sc.nextLine();
		System.out.println("DNI: ");
		persona2.dni = sc.nextLine();
		System.out.println("Edad: ");
		persona2.edad = sc.nextInt();
		
		if (persona1.edad >= 18) {
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni + " es mayor de edad.");
		}else {

			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni + " no es mayor de edad.");
		}
		if (persona2.edad >= 18) {
			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni + " es mayor de edad.");
		}else {

			System.out.println(persona2.nombre + " " + persona2.apellidos + " con DNI " + persona2.dni + " no es mayor de edad.");
		}

	}

}
