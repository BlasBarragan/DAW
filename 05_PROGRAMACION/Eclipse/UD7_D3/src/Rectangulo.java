import static java.lang.Math.abs;

public class Rectangulo {
	
	private int x1,x2,y1,y2;
	
	public Rectangulo (int x1, int y1, int x2, int y2) {
		
		if ((x1 < x2) && (y1 < y2)) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}else {
			System.err.println("ERROR al instanciar Rectangulo: (" + x1 + ","+ y1 + "),("+ x2 + ","+ y2 + ")");
		}
	}

	public int getX1() {
		return x1;
	}
	public int getX2() {
		return x2;
	}
	public int getY1() {
		return y1;
	}
	public int getY2() {
		return y2;
	}
	
	public void setX1(int x1) {
		if (x1 > this.x2) {
			System.err.println("El valor de X1 no puede ser mayor que X2");
		}else {
			this.x1 = x1;
		}
	}
	public void setX2(int x2) {
		if (x2 < this.x1) {
			System.err.println("El valor de X2 no puede ser menor que X1");
		}else {
			this.x2 = x2;
		}
	}
	public void setY1(int y1) {
		if (y1 > this.y2) {
			System.err.println("El valor de Y1 no puede ser mayor que Y2");
		}else {
			this.y1 = y1;
		}
	}
	public void setY2(int y2) {
		if (y2 < this.y1) {
			System.err.println("El valor de Y2 no puede ser menor que Y1");
		}else {
			this.y2 = y2;
		}
	}
	
	public void imprimir() {
		System.out.println("("+this.x1+","+this.y1+")"+"("+this.x2+","+this.y2+")");
	}
	public void setX1Y1(int x1, int y1) {
		x1=this.x1;
		y1=this.y1;
	}
	public void setX2Y2(int x2, int y2) {
		x2=this.x2;
		y2=this.y2;
	}
	public void setAll(int x1, int y1, int x2, int y2) { 
		x1=this.x1;
		y1=this.y1;
		x2=this.x2;
		y2=this.y2;
	}
	public int getPerimetro() {
		return abs(this.x1 - this.x2)*2 + abs(this.y1 - this.y2)*2;
	}
	public int getArea() {
		return abs(this.x1 - this.x2)*abs(this.y1 - this.y2);
	}
}
