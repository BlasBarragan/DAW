
abstract class Ave extends Mascota {
	
	// Atributos
	private String pico;
	private Boolean vuela;
	
	// Constructor 
	public Ave (String nombre, int edad, String estado, String fechaNacimiento, String pico, Boolean vuela) {
		
		super (nombre, edad, estado,fechaNacimiento);
		this.pico = pico;
		this.vuela = vuela;
	}
	
	// Metodos abstractos
	abstract void muestra();
	abstract void habla();
	abstract void volar();

	// GET Y SET
	public String getPico() {
		return pico;
	}

	public void setPico(String pico) {
		this.pico = pico;
	}

	public Boolean getVuela() {
		return vuela;
	}

	public void setVuela(Boolean vuela) {
		this.vuela = vuela;
	}
	
}
