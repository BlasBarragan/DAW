
public class ProgramaArticulo {
	public static void main(String[] args) {
		
		Articulo art1 = new Articulo();
		
		art1.nombre = "Naranja";
		art1.precio = 1.20;
		art1.iva = 21.0;
		art1.cuantosQuedan = 20;
		
		System.out.println(art1.nombre + " - Precio: " + art1.precio + "€ - IVA: " + art1.iva
				+ "% - PVP: " + (art1.precio + (art1.iva/100)) + "€" );
		
		art1.precio = 2.00;
		
		System.out.println(art1.nombre + " - Precio: " + art1.precio + "€ - IVA: " + art1.iva
				+ "% - PVP: " + (art1.precio + (art1.iva/100)) + "€" );
	}
}
