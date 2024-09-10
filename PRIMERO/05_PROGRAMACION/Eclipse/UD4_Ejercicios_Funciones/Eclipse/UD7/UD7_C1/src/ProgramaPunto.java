

public class ProgramaPunto {

	public static void main(String[] args) {
		
		Punto punto1 = new Punto(5,0);
		Punto punto2 = new Punto(10,10);
		Punto punto3 = new Punto(-3,7);
		
		 //Imprimimos las coordenadas de los tres puntos        
        System.out.println("Coordenadas del punto2 (" + punto1.getX() + "," + punto1.getY() + ")");
        System.out.println("Coordenadas del punto2 (" + punto2.getX() + "," + punto2.getY() + ")");
        System.out.println("Coordenadas del punto3 (" + punto3.getX() + "," + punto3.getY() + ")");
        System.out.println();
		
      //Modificamos las coordenadas de los tres puntos
        punto1.setX(punto1.getX()+3);
        punto1.setY(6);

        punto2.setX(punto2.getX()/2);
        punto2.setY(punto2.getY()*2);

        punto3.setX(punto3.getX()-5);
        punto3.setY(punto3.getY()%2);
		
        //Imprimimos las nuevas coordenadas de los tres puntos        
        System.out.println("Coordenadas del punto1 (" + punto1.getX() + "," + punto1.getY() + ")");
        System.out.println("Coordenadas del punto2 (" + punto2.getX() + "," + punto2.getY() + ")");
        System.out.println("Coordenadas del punto3 (" + punto3.getX() + "," + punto3.getY() + ")");
        System.out.println();

	}

}
