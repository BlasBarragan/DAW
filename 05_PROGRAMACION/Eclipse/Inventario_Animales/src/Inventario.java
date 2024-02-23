import java.util.ArrayList;

public class Inventario {
	
	// Aqui, definimos las funciones que realizara el programa
	
	// Creamos arrayList para almacenar las mascotas
	private ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
	
	// Obtenemos el tipo de mascota
	private String tipoMascota(Mascota m) {
		
		if (m instanceof Perro) {return "Perro";}
		
		if (m instanceof Gato) {return "Gato";}
		
		if (m instanceof Loro) {return "Loro";}
		
		if (m instanceof Canario) {return "Canario";}
		
		else {return null;}
	}
	
	// Mostramos lista de animales
	public void ListadoAnimales() {
		
		System.out.println("....Listado de Mascotas....");
		System.out.println("No.:.Tipo.:.Nombre.");
		
		for ( int i = 0; mascotas.size()> i; i++) {
			
			Mascota m = mascotas.get(i);
			System.out.println(i + " : " + tipoMascota(m) + " : " + m.getNombre());
		}
	}
	
	
	public void insertarAnimal(Mascota a) {
		
        mascotas.add(a);
    }
}
