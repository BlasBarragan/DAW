
public class Articulo {
	private String nombre;
	private double precio;
	private int  iva, cuantosQuedan;
	
	public Articulo (String nombre, double precio, int iva, int cantidad) {
		if (nombre.equals("")) {
			System.err.println("ERROR: Nombre no valido");
		}else if (precio <= 0) {
			System.err.println("ERROR: Precio no valido");
		}else if (iva != 21) {
			System.err.println("ERROR: iva no valido");
		}else if (cantidad < 0) {
			System.err.println("ERROR: cantidad no valida");
		}else {
			this.nombre = nombre;
			this.precio = precio;
			this.iva = iva;
			cuantosQuedan = cantidad;
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre.equals("")) {
			System.err.println("ERROR: Nombre no valido");
		}else {
			this.nombre = nombre;	
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio <= 0) {
			System.err.println("ERROR: Precio no valido");
		}else {
			this.precio = precio;
		}
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		if (iva != 21) {
			System.err.println("ERROR: iva no valido");
		}else {
			this.iva = iva;
		}
	}

	public int getCuantosQuedan() {
		return cuantosQuedan;
	}

	public void setCuantosQuedan(int cantidad) {
		if (cantidad < 0) {
			System.err.println("ERROR: cantidad no valida");
		}else {
			this.cuantosQuedan = cantidad;
		}
	}
}
