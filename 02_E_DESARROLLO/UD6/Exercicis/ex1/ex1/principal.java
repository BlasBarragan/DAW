package ex1;

//Programa main
public class principal {
	
	public static void main(String[] args) {
		
		Profesor profe = new Profesor("Vicent", 21, "695263711");
		
		profe.printInformacioPersonal();
		
		profe.printListaPrestamos();
	}

}
