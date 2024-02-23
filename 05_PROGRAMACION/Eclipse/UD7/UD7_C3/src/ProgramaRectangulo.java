
public class ProgramaRectangulo {

	public static void main(String[] args) {
		
		Rectangulo r1 = new Rectangulo(0,0,5,5);
		Rectangulo r2 = new Rectangulo(7,9,2,3);
		
		 //Imprimimos las coordenadas        
        System.out.println("Coordenadas del Rectangulo 1 (" + r1.getX1() + ","+ r1.getY1() + "),(" + r1.getX2() + ","+ r1.getY2() + ")");
        System.out.println("Coordenadas del Rectangulo 2 (" + r2.getX1() + ","+ r2.getY1() + "),(" + r2.getX2() + ","+ r2.getY2() + ")");
        System.out.println();
		
        //Imprimimos el perimetro       
        System.out.println("Perimetro del Rectangulo 1 (" + perimetro(r1) + ")");
        System.out.println("Perimetro del Rectangulo 2 (" + perimetro(r2) + ")");
        System.out.println();
        
        //Imprimimos el area       
        System.out.println("Area del Rectangulo 1 (" + area(r1) + ")");
        System.out.println("Area del Rectangulo 2 (" + area(r2) + ")");
        System.out.println();
        
        r1.setX1(10);
		r1.setY1(10);
		r1.setX2(25);
		r1.setY2(25);
		
		r2.setX1(74);
		r2.setY1(92);
		r2.setX2(22);
		r2.setY2(31);
		
		 //Imprimimos las coordenadas        
        System.out.println("Coordenadas del Rectangulo 1 (" + r1.getX1() + ","+ r1.getY1() + "),(" + r1.getX2() + ","+ r1.getY2() + ")");
        System.out.println("Coordenadas del Rectangulo 2 (" + r2.getX1() + ","+ r2.getY1() + "),(" + r2.getX2() + ","+ r2.getY2() + ")");
        System.out.println();
		
        //Imprimimos el perimetro       
        System.out.println("Perimetro del Rectangulo 1 (" + perimetro(r1) + ")");
        System.out.println("Perimetro del Rectangulo 2 (" + perimetro(r2) + ")");
        System.out.println();
        
        //Imprimimos el area       
        System.out.println("Area del Rectangulo 1 (" + area(r1) + ")");
        System.out.println("Area del Rectangulo 2 (" + area(r2) + ")");
        System.out.println();
	}
	
	public static double perimetro(Rectangulo rect) {
		int lado1 = Math.abs(rect.getX1() - rect.getX2());
		int lado2 = Math.abs(rect.getY1() - rect.getY2());
		
		return (lado1 + lado2) * 2;
	}
	
	public static double area(Rectangulo rect) {
		int lado1 = Math.abs(rect.getX1() - rect.getX2());
		int lado2 = Math.abs(rect.getY1() - rect.getY2());
		
		return lado1*lado2;
	}

}
