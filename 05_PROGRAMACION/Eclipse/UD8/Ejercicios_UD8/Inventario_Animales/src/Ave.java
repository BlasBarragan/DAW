
abstract class Ave extends Mascota {
	
	// Atributos
	private String pico;
	private boolean vuela;
	
	// Constructor 
	public Ave (String nombre, int edad, String estado, String fechaNacimiento, String pico, boolean vuela) {
		
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

	public boolean getVuela() {
		return vuela;
	}

	public void setVuela(boolean vuela) {
		this.vuela = vuela;
	}
	
}
