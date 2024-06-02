package traductor;
import java.io.Serializable;
import java.util.ArrayList;

public class instruccionBASIC implements Serializable{

	// Atributos
	int n_instruccion;	
	Comando c;
	String resto_linea ="";
	String linea;
	private static ArrayList<instruccionBASIC> instrucciones = new ArrayList<>();
	
	// Constructor
	public instruccionBASIC (int n_instruccion, Comando c, String resto_linea) {
		
		this.n_instruccion = n_instruccion;
		this.c = c;
		this.resto_linea = resto_linea;
		
	}
	
	public instruccionBASIC (String linea) {
		
		this.linea = linea; 
		
		String[] palabras = linea.split(" ");
        //for (String p : palabras)System.out.println(p);
		
        this.n_instruccion = Integer.parseInt(palabras[0]);
        Comando c = Comando.valueOf(palabras[1]);
        this.c = c;
        for (int i = 2; i< palabras.length; i++) {
    		this.resto_linea += " " + palabras[i] + " ";
        }
        
	}
	
	// Metodos
	public void ImprimirInstruccion() {
		// Imprimir las instrucciones almacenadas en el ArrayList
        for (instruccionBASIC instruccion : instrucciones) {
            System.out.println(instruccion.getN_instruccion() + ": " + instruccion.getC() + " = "+ instruccion.getResto_linea());
        }
	}

	// GET & SET
	public static ArrayList<instruccionBASIC> getInstrucciones(){
		
		return instrucciones;
	}
	
	public int getN_instruccion() {
		return n_instruccion;
	}

	public void setN_instruccion(int n_instruccion) {
		this.n_instruccion = n_instruccion;
	}

	public Comando getC() {
		return c;
	}

	public void setC(Comando c) {
		this.c = c;
	}

	public String getResto_linea() {
		return resto_linea;
	}

	public void setResto_linea(String resto_linea) {
		this.resto_linea = resto_linea;
	}
	
	
}
