public class Ejercicio43
{
    static void dibujarRectangulo(int ancho, int alto)
    {
        for (int i = 0; i < alto; i++)
        {
            for (int j = 0; j < ancho; j++)
                System.out.print("*");
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        dibujarRectangulo(5,3);
    }
}
