package poo;
import java.util.*;
// Practica no recomendada
// Definicion de todas las clases y metodos en un unico fichero fuente
public class Uso_Empleado {

	public static void main(String[] args) {
	// Instancia por declaracion en main 
		/*
		Empleado e1 = new Empleado("Blas", 21000, 2018, 9, 23); 
		Empleado e2 = new Empleado("Sandra Yuguero", 35000, 2015, 12, 2); 
		Empleado e3 = new Empleado("Marcos", 1000, 2024, 4, 4);
		
		e1.setSubeSueldo(5);
		e2.setSubeSueldo(5);
		e3.setSubeSueldo(5);
		
		System.out.println("Nombre: " + e1.getNombre() + " Sueldo: " + e1.getSueldo() + " Fecha de alta: "+ e1.getFecha());
		System.out.println("Nombre: " + e2.getNombre() + " Sueldo: " + e2.getSueldo() + " Fecha de alta: "+ e2.getFecha());
		System.out.println("Nombre: " + e3.getNombre() + " Sueldo: " + e3.getSueldo() + " Fecha de alta: "+ e3.getFecha());
		*/
	// Instancia con Array
		Empleado[] misEmpleados = new Empleado[3]; // Creamos array con la clase creada
		// Almacenamos elementos en el array
		misEmpleados[0]=new Empleado("Blas", 21000, 23, 9, 1988);
		misEmpleados[1]=new Empleado("Sandra", 43000, 23, 6, 1993);
		misEmpleados[2]=new Empleado("Marcos", 1000, 4, 4, 2024);
		
		
		
	// Usamos el bucle for para subir sueldo
		/*
		for(int i=0; i<3; i++) {
			
			misEmpleados[i].setSubeSueldo(5);
		}
		*/
	// Uso for mejorado
		for(Empleado e: misEmpleados) {
			
			e.setSubeSueldo(5);
		}
		
	// Usamos el bucle for para imprimir por pantalla
		/*
		for(int i=0; i<misEmpleados.length; i++) {
			
			System.out.println("Nombre: " + misEmpleados[i].getNombre() + " Sueldo: " + misEmpleados[i].getSueldo() 
					+ " Fecha de alta: "+ misEmpleados[i].getFecha());
		}
		*/
		
		Arrays.sort(misEmpleados); // Implementamos la ordenacion por medio de la implementacion de la interfaz comparable
		
	// Uso for mejorado
		for(Empleado e: misEmpleados) {
			
			System.out.println("Nombre: " + e.getNombre() + " Sueldo: " + e.getSueldo() 
					+ " Fecha de alta: "+ e.getFecha());
		}
	}
}


class Empleado implements Comparable {
	
	public Empleado(String nom, double sue, int agno, int mes, int dia) {
		
		nombre = nom;
		sueldo = sue;
		GregorianCalendar fecha = new GregorianCalendar(agno,mes-1,dia);
		altaContrato = fecha.getTime();
		
	}
	
	// GETTERS
	public String getNombre() {
		
		return nombre;
	}
	
	public double getSueldo() {
		
		return sueldo;
	}
	
	public Date getFecha() {
		
		return altaContrato;
	}
	
	// SETTERS
	public void setSubeSueldo(double porcentaje) {
		
		double aumento = sueldo*porcentaje/100;
		sueldo +=aumento; 
	}
	
	// Tal y como pide la implementacion, debemos incluir el metodo compareTo() en nuestra clase.
	public int compareTo(Object miObjeto) {
		
		Empleado otroEmpleado= (Empleado) miObjeto; // Con esto le decimos que el objeto recibido es de tipo Empleado para poder compararlo con otro objeto de tipo Empleado
		// Debemos devolver los datos segun nos pide el metodo, donde si el valor es menor devuelve -1, si es mayor 1 y si es igual delvolvera 0
		if(this.sueldo < otroEmpleado.sueldo) {
			return -1;
		}
		if(this.sueldo > otroEmpleado.sueldo) {
			return 1;
		}
		return 0; // En nuestro caso nunca sera igual y nos ahorramos el if(==){}.
		
	}
	
	private String nombre;
	private double sueldo;
	private Date altaContrato;
	
}
