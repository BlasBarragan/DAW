
public class Rectangulo {
	int x1,x2,y1,y2;
	
	public Rectangulo (int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
		
		if ((this.x1 > this.x2) && (this.y1 > this.y2)){
			System.err.println("ERROR al instanciar Rectangulo: (" + x1 + ","+ y1 + "), ("+ x2 + ","+ y2 + ").");
		}else {}
	}
}
