import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;

class FicheroEmpleados {
	
	private String nombreArchivo;
	private FileOutputStream fichero = null;
	private ObjectOutputStream salida = null;
	private FileInputStream ficheroIn = null;
	private ObjectInputStream entrada = null; 

	public FicheroEmpleados(String nombreArchivo) {
		
		this.nombreArchivo = nombreArchivo;
		
		try { 
			fichero = new FileOutputStream(nombreArchivo,true);
			salida = new ObjectOutputStream(fichero);
		}catch (FileNotFoundException e) {
			 System.out.println("No se ha podido encontrar el fichero.");
		}catch (IOException e) {
			 System.out.println("Error al abrir el archivo.");
			 e.printStackTrace();
		}
	}

	public void agregarEmpleado(Empleado empleado) {
		
		try {

			// Escribimos el objeto en el archivo
			salida.writeObject(empleado);
			System.out.println("Empleado agregado correctamente.");
		}
		catch (IOException e) {
			 System.out.println("No se ha podido escribir en el fichero.");
			 e.printStackTrace();
		} 
		
	}

	public void mostrarEmpleados() {

		try {
			// Instancia archivo para lectura
			ficheroIn = new FileInputStream(nombreArchivo);
			// Instancia objeto para lectura
			entrada = new ObjectInputStream(ficheroIn);
			System.out.println("Nombre\tEdad\tSalario");

			while (true) {
				try { 
					// Lectura de objeto con casting
					Empleado empleado = (Empleado) entrada.readObject();
					System.out.println(empleado.getNombreCompleto() + "\t" + empleado.getEdad() + "\t" + empleado.getSalario());
				} catch (EOFException e) {
	                System.out.println("Se ha alcanzado el final del fichero.");
	                break;
	            } catch (StreamCorruptedException e) {
	            	System.out.println("Se ha alcanzado el final del fichero.");
	            	break;
	            }
			}
		}catch (FileNotFoundException e) {
			System.out.println("El archivo no existe.");
		}catch (EOFException e) {
				System.out.println("Se ha alcanzado el final del fichero.");
		}catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (entrada != null) entrada.close();
	            if (ficheroIn != null) ficheroIn.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
}
