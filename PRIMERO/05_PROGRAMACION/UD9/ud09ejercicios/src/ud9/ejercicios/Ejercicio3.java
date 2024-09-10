package ud9.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio3 {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        double[] valores = new double[5];       
        
        for(int i = 0; i < valores.length; i++) {
            try {            
                System.out.println("Introduce el valor de la posición " + i);
                valores[i] = sc.nextDouble();
            }
            catch(InputMismatchException e) {
                System.out.println("Valor introducido incorrecto. Vuelve a introducir el valor...");
                e.printStackTrace(); 
                sc.nextLine();
                i--;
            }             
        }
        
        mostrarArray(valores);   
    }
    
    public static void mostrarArray(double[] valores) {
       System.out.print("Datos del array [ ");

        for(int j = 0; j < valores.length; j++) {
            System.out.print(valores[j] + ", ");
        }

        System.out.println("\b\b ]"); 
    }
}
