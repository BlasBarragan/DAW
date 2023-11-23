import java.util.Scanner;

public class Ejercicio46
{
    static float cubo(float num)
    {
        return num*num*num;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame numero: ");
        float numero = sc.nextFloat();

        float resultado = cubo(numero);
        System.out.printf(numero + " al cubo es: " + resultado);
    }
}
