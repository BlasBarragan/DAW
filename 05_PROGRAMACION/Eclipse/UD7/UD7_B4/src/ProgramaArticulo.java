
public class ProgramaArticulo {
	public static void main(String[] args) {
		
		Articulo art1 = new Articulo("Naranja",1.20,21,5);
		
		System.out.println(art1.nombre + " - Precio: " + art1.precio + "€ - IVA: " + art1.iva
				+ "% - PVP: " + (art1.precio + (art1.precio * art1.iva/100)) + "€" );
		
		Articulo art2 = new Articulo("Pan",0.95,10,0);
		
		System.out.println(art2.nombre + " - Precio: " + art2.precio + "€ - IVA: " + art2.iva
				+ "% - PVP: " + (art2.precio + (art2.precio * art2.iva/100)) + "€" );
		
		Articulo art3 = new Articulo("",1.20,21,20);
		
		System.out.println(art3.nombre + " - Precio: " + art3.precio + "€ - IVA: " + art3.iva
				+ "% - PVP: " + (art3.precio + (art3.precio * art3.iva/100)) + "€" );
	}
}
