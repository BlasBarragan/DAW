
public class ProgramaPersona {

	public static void main(String[] args) {
		
		Persona persona1 = new Persona("53758536S", "Blas", "Barragan Roman", 35);
		Persona persona2 = new Persona("Marcos", "Barragan Yuguero", 0);
		
		if (persona1.getEdad() >= 18) {
			System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni() + " es mayor de edad.");
		}else {

			System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni() + " no es mayor de edad.");
		}
		if (persona2.getEdad() >= 18) {
			System.out.println(persona2.getNombre() + " " + persona2.getApellidos() + " es mayor de edad.");
		}else {

			System.out.println(persona2.getNombre() + " " + persona2.getApellidos() + " no es mayor de edad.");
		}
		
		persona1.setNombre("Sandra");
		persona1.setApellidos("Yuguero Calvete");
		persona1.setEdad(30);
		System.out.println(persona1.getNombre() + " " + persona1.getApellidos() + " con DNI " + persona1.getDni() + " es mayor de edad.");

	}
}
