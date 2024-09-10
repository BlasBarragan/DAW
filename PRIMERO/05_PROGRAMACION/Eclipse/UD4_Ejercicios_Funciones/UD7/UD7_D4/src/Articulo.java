
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
	/**
	 * • Método para imprimir la información del artículo por pantalla.
	• Método getPVP que devuelva el precio de venta al público (PVP) con iva incluido.
	• Método getPVPDescuento que devuelva el PVP con un descuento pasado como argumento.
	• Método vender que actualiza los atributos del objeto tras vender una cantidad ‘x’ (si es posible).
	Devolverá true si ha sido posible (false en caso contrario).
	• Método almacenar que actualiza los atributos del objeto tras almacenar una cantidad ‘x’ (si es
	posible). Devolverá true si ha sido posible (false en caso contrario).
	 */
	public double getPVP() {
		return this.precio + (this.precio / 100 * this.iva);
	}
	public double getPVPDescuento (double descuento) {
		return this.precio + (this.precio / 100 * descuento);
	}
	public boolean vender (int cantidad) {
		if (this.cuantosQuedan>cantidad) {
			this.setCuantosQuedan(cuantosQuedan-cantidad);
			return true;
		}else {
			return false;
		}
	}	
	public boolean almacenar(int cantidad) {
		if (this.cuantosQuedan + cantidad > this.cuantosQuedan) {
			this.setCuantosQuedan(cuantosQuedan+cantidad);
			return true;
		}else {
			return false;
		}
	}
	public void imprimir() { 
		System.out.println("Nombre: "+this.getNombre()+", IVA: "+this.iva+", Precio: "+this.getPVP()+", Cantidad: "+this.getCuantosQuedan());
	}
	
}
