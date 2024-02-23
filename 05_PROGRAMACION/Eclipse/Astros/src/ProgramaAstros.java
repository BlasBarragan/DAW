import java.util.ArrayList;
import java.util.Scanner;

public class ProgramaAstros {
	
    // Imprime la lista de astros (solo sus nombres)
    public static void mostrarListaAstros(ArrayList astros) {
        System.out.println("=== LISTA DE ASTROS ===");
        for (int i = 0; i < astros.size(); i++) {
            Astro a = (Astro) astros.get(i);
            System.out.println("Astro " + i + ": " + a.getNombre());
        }
    }

	
	public static void main(String[] args) {
		
		// Creamos escaner para interaccion con usuario
		Scanner sc = new Scanner(System.in);
		
		// Creamos lista de astros con los elementos deseados para el programa
		ArrayList astros = new ArrayList();
		
		// Añadimos p[lanetas
		Planeta tierra = new Planeta(10, 20, true, "Tierra", 30, 40, 50, 30, 100);
		Planeta marte = new Planeta(100, 200, true, "Marte", 300, 400, 500, 40, 50);
		
        // Instanciamos satélites
        Satelite luna = new Satelite(90, 80, tierra, "Luna", 70, 60, 50, 25, 200);
        Satelite marcianos = new Satelite(900, 800, marte, "Marcianos", 700, 600, 500, 50, 250);
		
        // Añadimos los satelites a sus planetas
        tierra.añadirSatelite(luna);
        marte.añadirSatelite(marcianos);
        
     // Añadimos planetas y satélites a la lista
        astros.add(tierra);
        astros.add(marte);
        astros.add(luna);
        astros.add(marcianos);

        
     // Menú para elegir astro y mostrar su información. Se repite hasta introducir -1
        int opcion;
        do {
            // Mostramos lista de astros
            mostrarListaAstros(astros);
            
            // Pedimos nº de astro a mostrar
            System.out.print("Elige un nº de astro (-1 para salir): ");
            opcion = sc.nextInt();

            // Si nº válido, mostrar info del astro
            if (opcion >= 0 && opcion < astros.size()) {
                Astro a = (Astro) astros.get(opcion);
                a.muestra();
            } // Si -1, terminar
            else if (opcion == -1) {
                return;
            } // Si no, mensaje de error
            else {
                System.out.println("Opción incorrecta");
            }

            // Pedimos enter para continuar
            System.out.println("Enter para continuar");
            sc.nextLine();
            sc.nextLine();

        } while (true);
	}
	

}
