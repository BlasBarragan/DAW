package ex2;

//Programa main
public class menu {
	
public static void main(String[] args) {
		
		//Crear objeto que va a ejecutar el método
		Game partida1 = new Game ();
		
		partida1.movement("Abajo");
		partida1.movement("Derecha");
		partida1.movement("Derecha");
		partida1.movement("Abajo");
		partida1.movement("Arriba");
						
	}
}
