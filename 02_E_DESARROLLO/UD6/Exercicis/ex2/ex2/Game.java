package ex2;

public class Game {
	
	//Constantes
	final String right = "Derecha";
	final String left = "Izquierda";
	final String up = "Arriba";
	final String down = "Abajo";
	
	Player player1 = new Player();
	
	public void movement(String m) {
		if(m.equalsIgnoreCase(right)) {
			player1.setX(player1.getX() + 1);
			System.out.println(player1.getX() + ", " + player1.getY());
		}
		if(m.equalsIgnoreCase(left)) {
			player1.setX(player1.getX() - 1);
			System.out.println(player1.getX() + ", " + player1.getY());
		}
		if(m.equalsIgnoreCase(up)) {
			player1.setY(player1.getY() - 1);
			System.out.println(player1.getX() + ", " + player1.getY());
		}
		if(m.equalsIgnoreCase(down)) {
			player1.setY(player1.getY() + 1);
			System.out.println(player1.getX() + ", " + player1.getY());
		}
	}
}
