
class Gato extends Mascota {

	// Atributos
	private String color;
	private Boolean peloLargo;
	
	// Constructor
	public Gato (String nombre, int edad, String estado, String fechaNacimiento, String color, Boolean peloLargo) {
		
		super(nombre, edad, estado,fechaNacimiento);
		this.color = color;
		this.peloLargo = peloLargo;
	}
	
	// Metodos 
	void muestra() {
		
		System.out.println(this.getNombre());
		System.out.println(this.getEdad());
		System.out.println(this.getEstado());
		System.out.println(this.getFechaNacimiento());
		System.out.println(this.getColor());
		System.out.println(this.getPeloLargo());
	}
	
	void habla() {
		
        System.out.println("MIAU MIAU");
    }
	
	// GET Y SET
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Boolean getPeloLargo() {
		return peloLargo;
	}

	public void setPeloLargo(Boolean peloLargo) {
		this.peloLargo = peloLargo;
	}


}

