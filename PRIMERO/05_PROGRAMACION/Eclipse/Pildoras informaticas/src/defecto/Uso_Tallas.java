package defecto;
import java.util.Scanner;

public class Uso_Tallas {

	
	// Esto se usa por la necesidad de almacenar en una variable x valores y no queremos que se almacenen mas o se modifiquen en un futuro
	
	enum Talla{MINI, MEDIANO, GRANDE, MUY_GRANDE}; // Se declara siempre fuera de MAIN e incluye inucamente los distintos valores que se podran elegir.
	
	// Si necesitamos usar constructores con setters y getters podemos hacerlo de la siguiente manera: (
	
	enum Pie{
		
		PEQUE("PS"), MEDI("PM"), GRAN("PG");	// Declaramos las opciones con el parametro que se le va a pasar al constructor (abreviatura)
		
		private String abreviatura; // Creamos variable que se pasara como parametro. 
		
		private Pie(String abreviatura) {	// Creamos un cosntructor para la clase. Es private por que ENUM no admite la creacion de mas obtejos desde fuera.
			this.abreviatura = abreviatura; // usamos el constructor como setter que le da la abreviatura
		}
		
		public String nombreAbreviado() {	// Getter que nos devuelve la abreviatura asignada
			return abreviatura;
		}
	
		
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Talla s=Talla.MINI; // Le decimos que la talla s corresponde al objeto MINI
		Talla m=Talla.MEDIANO;
		Talla l=Talla.GRANDE;
		Talla xl=Talla.MUY_GRANDE;
		
		Scanner sc = new Scanner(System.in);
		// De la siguiente forma, podemos hacer que el usuario indique la creacion de elemento deseada
		System.out.println("Escribe una talla:");
		String datosUsuario= sc.next().toUpperCase();	// Recibimos en mayusculas el indicador de la seleccion deseada.

		Pie bebe= Enum.valueOf(Pie.class, datosUsuario);	// Creamos el objeto con el nombre bebe y la seleccions del usuario
		
		System.out.println(bebe);
		System.out.println(bebe.nombreAbreviado());
		
		
		
	}

}
