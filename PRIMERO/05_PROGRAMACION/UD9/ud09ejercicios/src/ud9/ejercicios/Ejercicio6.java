package ud9.ejercicios;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) throws Exception{
        
        Scanner sc = new Scanner(System.in);
        int num;        

        for(int i = 0; i < 5; i++) {
            try {
                System.out.print("Introduce un entero positivo: ");
                num = sc.nextInt();
                imprimePositivo(num);
                
                System.out.print("Introduce un entero negativo: ");
                num = sc.nextInt();
                imprimeNegativo(num);
            }
            catch(InputMismatchException e) {
                System.out.println("Valor introducido incorrecto");
                sc.nextLine();                
            }
            catch(Exception e) {
                System.out.println(e);            
            } 
        }
    }
    
    static void imprimePositivo(int positivo) throws Exception {
        if(positivo < 0)
            throw new NegativoPositivoExcepcion("Error: número negativo");
        
        System.out.println("El número positivo es el: " + positivo);        
    }
    
    static void imprimeNegativo(int negativo) throws Exception {
        if(negativo >= 0)
            throw new NegativoPositivoExcepcion("Error: número positivo");
        
        System.out.println("El número negativo es el: " + negativo);
    }
}
