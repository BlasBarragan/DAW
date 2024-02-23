package poo;

public class Uso_coche {

	public static void main(String[] args) {
		
        // Teniendo la clase Coche (estructura basica del coche) vamos a crear dos coches
        // Instanciamos una clase
        Coche Audi = new Coche(); // Instancia de la clase Coche. Crea un ejemplar de coche 
        
        System.out.println("Este coche tiene " + Audi.getLargo() + " ruedas."); // Accedemos a la propiedad de la instancia creada
        System.out.println( Audi.getLargo()); 

        Coche Opel = new Coche();
        //Opel.setColor(); // Al comentar esta linea nunca llamamos al metodo setColor y su valor es null.
        Opel.setColor("Amarillo");;
        System.out.println(Opel.getColor());

        System.out.println(Audi.datosGenerales());

        Opel.setAsientos("no");
        System.out.println(Opel.getAsientos());
        
        Opel.setClima("si");
        System.out.println(Opel.getClima());
        
        System.out.println(Opel.getSETPesoCoche());
        
        System.out.println("El precio final del coche es: " + Opel.precioCoche());
        
	}

}
