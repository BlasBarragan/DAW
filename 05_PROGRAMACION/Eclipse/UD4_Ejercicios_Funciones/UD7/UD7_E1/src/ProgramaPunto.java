

public class ProgramaPunto {

	public static void main(String[] args) {
		
		Punto punto1 = new Punto(5,0);
		Punto punto2 = new Punto(10,10);
		Punto punto3 = new Punto(-3,7);
		Punto punto4 = Punto.puntoAleatorio();
		punto4.imprime();
		
		//Imprimimos las coordenadas de los tres puntos        
        System.out.println("Coordenadas del punto2 (" + punto1.getX() + "," + punto1.getY() + ")");
        punto1.imprime();
        System.out.println("Coordenadas del punto2 (" + punto2.getX() + "," + punto2.getY() + ")");
        punto2.imprime();
        System.out.println("Coordenadas del punto3 (" + punto3.getX() + "," + punto3.getY() + ")");
        punto3.imprime();
        System.out.println();
        
		
        //Modificamos las coordenadas de los tres puntos
        punto1.setX(punto1.getX()+3);
        punto1.setY(6);

        punto2.setX(punto2.getX()/2);
        punto2.setY(punto2.getY()*2);

        punto3.setX(punto3.getX()-5);
        punto3.setY(punto3.getY()%2);
		
        //Imprimimos las nuevas coordenadas de los tres puntos        
        punto1.imprime();
        punto2.imprime();
        punto3.imprime();
        System.out.println();
        //Modificamos las coordenadas con setXY
        punto1.setXY(2, 4);
        punto2.setXY(3, 6);
        punto1.imprime();
        punto2.imprime();
        System.out.println();
        // Desplazamos los puntos
        punto1.desplaza(-2, -4);
        punto2.desplaza(1, -1);
        punto3.desplaza(18,9);
        punto1.imprime();
        punto2.imprime();
        punto3.imprime();
        System.out.println();
        // Calculamos distancia
        System.out.println("Distancia: "+ punto1.distancia(punto3));
        System.out.println("Distancia: "+ punto2.distancia(punto1));
        System.out.println("Distancia: "+ punto3.distancia(punto2));
	}

}
