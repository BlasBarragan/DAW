import java.util.function.ToIntFunction;

public class Punto {
	
	private int x;
	private int y;
	
	public Punto (int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void imprime() {
		System.out.println("La coordenadas son: ("+ getX()+ ","+ getY()+")");
	}
	
	public void setXY(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void desplaza(int dx, int dy) {
		this.x = this.getX() + dx;
		this.y = this.getY() + dy;
	}
	
	public int distancia (Punto p) {
		double dblDistancia = Math.sqrt((Math.pow(((p.getX()) - (this.getX())),2))+(Math.pow(((p.getY())-(this.getY())),2)));
		return (int)dblDistancia;
	}
	
}
