
public class ProgramaPersona {

	public static void main(String[] args) {
		
		Persona persona1 = new Persona("53758536S", "Blas", "Barragan Roman", 35);
		Persona persona2 = new Persona("Marcos", "Barragan Yuguero", 0);
		
		if (persona1.edad >= 18) {
			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni + " es mayor de edad.");
		}else {

			System.out.println(persona1.nombre + " " + persona1.apellidos + " con DNI " + persona1.dni + " no es mayor de edad.");
		}
		if (persona2.edad >= 18) {
			System.out.println(persona2.nombre + " " + persona2.apellidos + " es mayor de edad.");
		}else {

			System.out.println(persona2.nombre + " " + persona2.apellidos + " no es mayor de edad.");
		}
	}
}
