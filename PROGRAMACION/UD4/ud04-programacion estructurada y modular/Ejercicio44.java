import java.util.Scanner;

public class Ejercicio44
{

    static void escribirRepetido(char letra, int nveces)
    {
        for (int i = 0; i < nveces; i++)
            System.out.print(letra + " ");
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame letra: ");
        char letra = sc.next().charAt(0);

        System.out.print("Dame número de repeticiones de la letra: ");
        int nveces = sc.nextInt();

        escribirRepetido(letra, nveces);
    }
}
