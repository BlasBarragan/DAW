import java.util.Scanner;

public class Ejercicio45
{
    static void dibujarRectangulo(int ancho, int alto, char letra)
    {
        for (int i = 0; i < alto; i++)
        {
            escribirRepetido(letra, ancho);
            System.out.println();
        }
    }

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

        dibujarRectangulo(nveces,3,letra);
    }
}
