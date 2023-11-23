package ud02bEjercicios;

public class U02bEjercicio1 {

	public static void main(String[] args) {
		
		System.out.println("===============================================");
		System.out.println("Español      Inglés");
		System.out.println("===============================================");
		System.out.println("Ratón\t\tMouse");
		System.out.println("Teclado\t\tKeyboard");
		System.out.println("Mesa\t\tTable");
		System.out.println("Boli\t\tPen");
		System.out.println("Silla\t\tChair");
		System.out.println("Café\t\tCoffee");
		System.out.println("Lápiz\t\tPencil");
		System.out.println("Grapa\t\tStaple");
		System.out.println("Tijeras\t\tScissors");
		System.out.println("Manzana\t\tApple");
		
		/* 
		 * Otra forma de hacerlo 
		 * utilizando la función 
		 * printf. Puede que más adecuada.
		 * */
		
		System.out.println(""); // salto de línea
		
		System.out.println("Solución utilizando printf:\n");
		System.out.println("===============================================");
		System.out.println("Español      Inglés");
		System.out.println("===============================================");
		System.out.printf("%-10s      %-10s\n",  "Ratón", "Mouse");
		System.out.printf("%-10s      %-10s\n",  "Teclado", "Keyboard");
		System.out.printf("%-10s      %-10s\n",  "Mesa", "Table");
		System.out.printf("%-10s      %-10s\n",  "Boli", "Pen");
		System.out.printf("%-10s      %-10s\n",  "Silla", "Chair");
		System.out.printf("%-10s      %-10s\n",  "Café", "Coffee");
		System.out.printf("%-10s      %-10s\n",  "Lápiz", "Pencil");
		System.out.printf("%-10s      %-10s\n",  "Grapa", "Staple");
		System.out.printf("%-10s      %-10s\n",  "Tijeras", "Scissors");
		System.out.printf("%-10s      %-10s\n",  "Manzana", "Apple");
	}

}
