

public class ProgramaPunto {

	public static void main(String[] args) {
		
		Punto punto1 = new Punto();
		Punto punto2 = new Punto();
		Punto punto3 = new Punto();
		
		punto1.x = 5;
		punto1.y = 0;
		
		punto2.x = 10;
		punto2.y = 10;
		
		punto3.x = -3;
		punto3.y = 7;
		
		 //Imprimimos las coordenadas de los tres puntos        
        System.out.println("Coordenadas del punto1 (" + punto1.x + "," + punto1.y + ")");
        System.out.println("Coordenadas del punto2 (" + punto2.x + "," + punto2.y + ")");
        System.out.println("Coordenadas del punto3 (" + punto3.x + "," + punto3.y + ")");
        System.out.println();
		
      //Modificamos las coordenadas de los tres puntos
        punto1.x += 3;
        punto1.y = 6;

        punto2.x /= 2;
        punto2.y *= 2;

        punto3.x -= 5;
        punto3.y %= 2;
		
        //Imprimimos las nuevas coordenadas de los tres puntos        
        System.out.println("Coordenadas del punto1 (" + punto1.x + "," + punto1.y + ")");
        System.out.println("Coordenadas del punto2 (" + punto2.x + "," + punto2.y + ")");
        System.out.println("Coordenadas del punto3 (" + punto3.x + "," + punto3.y + ")");
        System.out.println();

	}

}
