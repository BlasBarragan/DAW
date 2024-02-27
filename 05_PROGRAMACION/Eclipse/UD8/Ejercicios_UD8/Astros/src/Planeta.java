import java.util.ArrayList;

public class Planeta extends Astro{
	
	//Atributos (variables) 
	private double distancia;
	private double orbita;
	private boolean tieneSat;
	private ArrayList<Satelite> satelites;
	
	// Constructor
	public Planeta (double distancia, double orbita, boolean tieneSat, String nombre, double radio, 
			double rotacion, double masa, double temperatura, double gravedad) {
		
		//Referenciamos a la super clase (Astro) con "super"
		super(nombre, radio, rotacion, masa, temperatura, gravedad);
		this.distancia = distancia;
		this.orbita = orbita;
		this.tieneSat = tieneSat;
		this.satelites = new ArrayList();
		
	}
	
	// Metodos de Planeta
	public void muestra() {
		
		System.out.println("### PLANETA ###");
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Radio ecuatorial: " + this.getRadio());
		System.out.println("Rotacion sobre su eje: " + this.getRotacion());
		System.out.println("Masa: " + this.getMasa());
		System.out.println("Temperatura media: " + this.getTemperatura() + " grados");
		System.out.println("Gravedad: " + this.getGravedad());
		System.out.println("Distancia al sol: " + this.distancia);
		System.out.println("Orbita al sol: " + this.orbita);
		
		if (this.tieneSat = true) {
			
			System.out.println("Sus satelites son: " + this.satelites);
		}
		
		else { 

			System.out.println("Este planeta, no tiene satelites.");
		}
	}
	
	// Añadimos un satélite
    public void añadirSatelite(Satelite s) {
        satelites.add(s);
        this.tieneSat = true;
    }

}
