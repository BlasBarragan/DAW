package ud9.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {
        
        Scanner in = new Scanner (System.in);
        
        int N = (int)(Math.random() * 100 + 1);
        int[] valores = new int[N];
        
        for(int i = 0; i < N; i++) {
            valores[i] = (int)(Math.random() * 10 + 1);
        }
        
        int valor = 0;
        
        do{
            try {
                System.out.println("Introduce la posición del array para mostrar: (número negativo para salir)");
                valor = in.nextInt();
                System.out.println("Valor en el array: " + valores[valor]);  
                in.nextLine();                
            }
            catch(InputMismatchException e) {
                System.out.println("Excepción: Valor introducido incorrecto");
                e.printStackTrace();            
                in.nextLine();                
            }
            catch(ArrayIndexOutOfBoundsException e) {
                if(valor >= 0)
                    System.out.println("Excepción: Posición fuera de los límites del array");      
                e.printStackTrace();            
            }                    
            
        } while(valor >= 0);
        
        System.out.println("Salida del programa");  
    }    
}
