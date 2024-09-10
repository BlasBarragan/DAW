package ud9.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio1 {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int a;       
        
        try {
            System.out.print("Introduce un número entero: ");
            a = sc.nextInt();
            
            System.out.println("Valor introducido: " + a); 

        }
        catch(InputMismatchException e) {
            System.out.println("Valor introducido incorrecto");
            e.printStackTrace();            
        }
        
        System.out.println("Fin del programa");   
    }  
}
