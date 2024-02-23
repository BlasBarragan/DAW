
class Perro extends Mascota {

	// Atributos
	private String raza;
	private Boolean pulgas;
	
	// Constructor
	public Perro (String nombre, int edad, String estado, String fechaNacimiento, String raza, Boolean pulgas) {
		
		super(nombre, edad, estado,fechaNacimiento);
		this.pulgas = pulgas;
		this.raza = raza;
	}
	
	// Metodos 
	void muestra() {
		
		System.out.println(this.getNombre());
		System.out.println(this.getEdad());
		System.out.println(this.getEstado());
		System.out.println(this.getFechaNacimiento());
		System.out.println(this.getRaza());
		System.out.println(this.getPulgas());
	}
	
	void habla() {
		
        System.out.println("GUAU GUAU");
    }
	
	// GET Y SET
	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Boolean getPulgas() {
		return pulgas;
	}

	public void setPulgas(Boolean pulgas) {
		this.pulgas = pulgas;
	}


}

