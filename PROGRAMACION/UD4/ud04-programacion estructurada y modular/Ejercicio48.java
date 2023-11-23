import java.util.Scanner;

public class Ejercicio48
{
    public static void main(String[] args)
    {
        int num1, num2;
        char operacion;

        if (args.length != 3)
            System.out.println("Error: números de argumentos incorrecto");
        else
        {
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[1]);
            operacion = args[2].charAt(0);

            int resultado = 0;

            switch (operacion)
            {
                case 's': // suma
                    resultado = num1 + num2;
                    break;
                case 'r': // resta
                    resultado = num1 - num2;
                    break;
                case 'm': // multiplica
                    resultado = num1 * num2;
                    break;
                case 'd': // divide
                    if (num2 == 0)
                        System.out.println("Error: no se puede dividir por 0");
                    else
                        resultado = num1 / num2;
                    break;
                default:
                    System.out.println("Error: operación no valida.");
            }

            System.out.println("El resultado de la operación es: " + resultado);
        }
    }
}
