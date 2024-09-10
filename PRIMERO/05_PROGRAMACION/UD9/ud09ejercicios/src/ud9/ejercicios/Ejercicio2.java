package ud9.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a,b, resultado;       
        
        try {
            System.out.println("Introduce el numerador: ");
            a = sc.nextInt();
            
            System.out.println("Introduce el denominador: ");
            b = sc.nextInt();
            
            resultado = a / b;
            
            System.out.println(a + " / " + b + " = " + resultado);         
            
        }
        catch (InputMismatchException e) {
            System.out.println("Valor introducido incorrecto");
            e.printStackTrace();             
        }
        catch (ArithmeticException e) {
            System.out.println("División entre cero: " + e); 
            e.printStackTrace(); 
        }
        
        System.out.println("Fin del programa");
    }
}
