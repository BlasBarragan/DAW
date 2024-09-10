
public class ProgramaRectangulo {

	public static void main(String[] args) {
		
		Rectangulo r1 = new Rectangulo(0,0,5,5);
		Rectangulo r2 = new Rectangulo(7,9,2,3);
		
		 //Imprimimos las coordenadas        
        System.out.println("Coordenadas del Rectangulo 1 (" + r1.x1 + ","+ r1.y1 + "),(" + r1.x2 + ","+ r1.y2 + ")");
        System.out.println("Coordenadas del Rectangulo 2 (" + r2.x1 + ","+ r2.y1 + "),(" + r2.x2 + ","+ r2.y2 + ")");
        System.out.println();
		
        //Imprimimos el perimetro       
        System.out.println("Perimetro del Rectangulo 1 (" + perimetro(r1) + ")");
        System.out.println("Perimetro del Rectangulo 2 (" + perimetro(r2) + ")");
        System.out.println();
        
        //Imprimimos el area       
        System.out.println("Area del Rectangulo 1 (" + area(r1) + ")");
        System.out.println("Area del Rectangulo 2 (" + area(r2) + ")");
        System.out.println();
        
        r1.x1 = 10;
		r1.y1 = 10;
		r1.x2 = 25;
		r1.y2 = 25;
		
		r2.x1 = 74;
		r2.y1 = 92;
		r2.x2 = 22;
		r2.y2 = 31;
		
		 //Imprimimos las coordenadas        
        System.out.println("Coordenadas del Rectangulo 1 (" + r1.x1 + ","+ r1.y1 + "),(" + r1.x2 + ","+ r1.y2 + ")");
        System.out.println("Coordenadas del Rectangulo 2 (" + r2.x1 + ","+ r2.y1 + "),(" + r2.x2 + ","+ r2.y2 + ")");
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
		int lado1 = Math.abs(rect.x1 - rect.x2);
		int lado2 = Math.abs(rect.y1 - rect.y2);
		
		return (lado1 + lado2) * 2;
	}
	
	public static double area(Rectangulo rect) {
		int lado1 = Math.abs(rect.x1 - rect.x2);
		int lado2 = Math.abs(rect.y1 - rect.y2);
		
		return lado1*lado2;
	}

}
