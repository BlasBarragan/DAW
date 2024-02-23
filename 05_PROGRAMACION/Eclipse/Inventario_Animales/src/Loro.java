
class Loro extends Ave {
	
	// Atributos
	private String origen;
	private boolean habla;
	
	// Constructor
	public Loro (String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela, String origen, boolean habla) {
		
		super(nombre, edad, estado,fechaNacimiento, pico, vuela);
		this.origen = origen;
		this.habla = habla;
	}
	
	// Metodos 
	void muestra() {
		
		System.out.println(this.getNombre());
		System.out.println(this.getEdad());
		System.out.println(this.getEstado());
		System.out.println(this.getFechaNacimiento());
		System.out.println(this.getPico());
		System.out.println(this.getVuela());
		System.out.println(this.getOrigen());
		System.out.println(this.getHabla());
	}
	
	void saluda() {
		
        System.out.println("HOLA PAJARITO");
    }
	void habla() {
        System.out.println("HOLA HOLA");
    }
	
	void volar() {
		
		this.setEstado("Volando");
	}

	// GET Y SET
	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public Boolean getHabla() {
		return habla;
	}

	public void setHabla(Boolean habla) {
		this.habla = habla;
	}
}
