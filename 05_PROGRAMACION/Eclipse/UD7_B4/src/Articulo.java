
public class Articulo {
	String nombre;
	double precio;
	int  iva, cuantosQuedan;
	
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
	
}
