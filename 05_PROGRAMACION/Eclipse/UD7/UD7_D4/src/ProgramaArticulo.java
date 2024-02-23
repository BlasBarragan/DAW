
public class ProgramaArticulo {
	public static void main(String[] args) {
		
		Articulo art1 = new Articulo("Naranja",1.20,21,5);
		Articulo art2 = new Articulo("Pan",0.95,21,2);
		Articulo art3 = new Articulo("Leche",1.20,21,20);
		
		System.out.println(art1.getNombre() + " - Precio: " + art1.getPrecio() + "€ - IVA: " + art1.getIva()
				+ "% - PVP: " + (art1.getPrecio() + (art1.getPrecio() * art1.getIva()/100)) + "€" );
				
		System.out.println(art2.getNombre() + " - Precio: " + art2.getPrecio() + "€ - IVA: " + art2.getIva()
				+ "% - PVP: " + (art2.getPrecio() + (art2.getPrecio() * art2.getIva()/100)) + "€" );
				
		System.out.println(art3.getNombre() + " - Precio: " + art3.getPrecio() + "€ - IVA: " + art3.getIva()
				+ "% - PVP: " + (art3.getPrecio() + (art3.getPrecio() * art3.getIva()/100)) + "€" );
	
		art1.setCuantosQuedan(3);
		art1.setPrecio(2);
		
		art2.setCuantosQuedan(-1);
		art2.setCuantosQuedan(0);
		
		art3.setNombre("");
		art3.setIva(10);
		
		System.out.println(art1.getNombre() + " - Precio: " + art1.getPrecio() + "€ - IVA: " + art1.getIva()
				+ "% - PVP: " + (art1.getPrecio() + (art1.getPrecio() * art1.getIva()/100)) + "€" );
		
		System.out.println(art2.getNombre() + " - Precio: " + art2.getPrecio() + "€ - IVA: " + art2.getIva()
				+ "% - PVP: " + (art2.getPrecio() + (art2.getPrecio() * art2.getIva()/100)) + "€" );
		
		System.out.println(art3.getNombre() + " - Precio: " + art3.getPrecio() + "€ - IVA: " + art3.getIva()
				+ "% - PVP: " + (art3.getPrecio() + (art3.getPrecio() * art3.getIva()/100)) + "€" );
		
		art1.imprimir();
		art3.imprimir();
	}
}
