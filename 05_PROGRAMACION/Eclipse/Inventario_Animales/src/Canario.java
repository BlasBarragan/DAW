
class Canario extends Ave {
	
	// Atributos
	private String color;
	private Boolean canta;
	
	// Constructor
	public Canario (String nombre, int edad, String estado, String fechaNacimiento, String pico, Boolean vuela, String color, Boolean canta) {
		
		super(nombre, edad, estado,fechaNacimiento, pico, vuela);
		this.color = color;
		this.canta = canta;
	}
	
	// Metodos 
	void muestra() {
		
		System.out.println(this.getNombre());
		System.out.println(this.getEdad());
		System.out.println(this.getEstado());
		System.out.println(this.getFechaNacimiento());
		System.out.println(this.getPico());
		System.out.println(this.getVuela());
		System.out.println(this.getColor());
		System.out.println(this.getCanta());
	}
	
	void habla() {
		
        System.out.println("PIO PIO");
    }
	
	void volar() {
		
		this.setEstado("Volando");
	}

	// GET Y SET
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getCanta() {
		return canta;
	}

	public void setCanta(Boolean canta) {
		this.canta = canta;
	}
}

