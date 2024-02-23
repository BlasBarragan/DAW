package poo;

public class Coche {
	
	// Atributos

    // Declaramos variables (caracteristicas que tienen todos los objetos Coche)
    // Se usa la encapsulacion (private) para que solo podamos modificar los valores desde la propia clase y no desde otra
	private int ruedas;
	private int ancho;
	private int largo;
	private int motor;
	private int peso;
	private int peso_plataforma;
	private String color;
	private int peso_total;
	private boolean asientosCuero, climatizador;
	
	// Constructor(Le da un estado inicial a nuestro objeto)
    // Siempre tendra el mismo nombre que la clase
	public Coche() {
		
		ruedas = 4;

        largo = 2000;

        ancho = 300;

        motor = 1600;

        peso = 500;

        peso_plataforma = 500;
        
	}
	
	// Metodos
	
	// GETTERS Y SETTERS
	public String datosGenerales() {
		
		return "La plataforma del vehiculo tiene " + ruedas + " ruedas " + ". Mide "
		        + largo/1000 + " metros con un ancho de " + ancho + " cm y un peso de plataforma de "
		        + peso_plataforma + " kg.";
	}
	public String getLargo (){ // GETTER, Adquiere valor

        return "El largo del coche " + largo;
    }

    public void setColor (String color_coche) { // SETTER, Establece valor
       // color = "Azul"; // Al definir aqui el color, solo se establece al llamar al metodo, mientras tanto el valor es null
        color = color_coche;
    }

    public String getColor (){ // getter

        return "El color del coche es " + color;
    }

    public void setAsientos(String asientosCuero){ // setter

        if (asientosCuero.equalsIgnoreCase("si")){

            this.asientosCuero= true;
        }else{
            this.asientosCuero = false;
        }
    }

    public String getAsientos(){ // getter
        if (asientosCuero == true){
            return "Este coche tiene asientos de cuero";
        }else{
            return "Este coche tiene asientos de tela";
        }
    }
    
    public void setClima(String climatizador){ // setter
    	
    	if (climatizador.equalsIgnoreCase("si")) {
    		
    		this.climatizador = true;
    	}else{
    		this.climatizador = false;
    	}
    }
    
    public String getClima() { // getter
    	
    	if (climatizador == true) {
    		return "El coche lleva climatizador";
    	}else{
    		return "El coche lleva AACC";
    	}
    }
    
    public String getSETPesoCoche() { // metodo GET Y SET EN UNO // OJO MALA PRAXIS // no recomendado
    	// por un lado establece el valor y por otro devuelve el dato
    	
    	int pesoCarroceria = 500;
    	
    	peso_total = peso_plataforma + pesoCarroceria;
    	
    	if (asientosCuero == true) {
    		
    		peso_total = peso_total + 50;
    	}
    	if (climatizador == true) {
    		
    		peso_total = peso_total + 20;
    	}
    	
    	return "El peso del coche es " + peso_total;
    	
    }
    
    public int precioCoche() { // Getter / por que no recoge el valor de ninguna variable ya declarada. 
    	
    	int precioFinal = 10000;
    	
    	if (asientosCuero == true) {
    		
    		precioFinal += 2000;
    	}
    	if (climatizador == true) {
    		
    		precioFinal += 1500;
    	}
    	
    	return precioFinal;
    	
    }
    
    
	
}
