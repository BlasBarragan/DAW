
public class Satelite extends Astro{
	
	// Atributos (variables)
	private double distPlaneta;
	private double orbitaPlaneta;
	private Planeta planeta;

	// Constructor
	public Satelite(double distPlaneta, double orbitaPlaneta, Planeta planeta, String nombre, double radio, double rotacion, double masa,
			 double temperatura, double gravedad) {
		
		//Referenciamos a la super clase (Astro) con "super"
		super(nombre, radio, rotacion, masa, temperatura, gravedad);
		this.distPlaneta = distPlaneta;
		this.orbitaPlaneta = orbitaPlaneta;
		this.planeta = planeta;
		
	}
	
	// Metodos de satelite
	public void muestra() {
		
		System.out.println("### SATELITE ###");
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Radio ecuatorial: " + this.getRadio());
		System.out.println("Rotacion sobre su eje: " + this.getRotacion());
		System.out.println("Masa: " + this.getMasa());
		System.out.println("Temperatura media: " + this.getTemperatura() + " grados");
		System.out.println("Gravedad: " + this.getGravedad());
		System.out.println("Distancia al planeta " + planeta.getNombre() + " es de: " + this.distPlaneta);
		System.out.println("Orbita al planeta " + planeta.getNombre() + " es de: " + this.orbitaPlaneta);
		
	}
	

}
