public class Ejercicio410
{
    public static int potencia(int base, int exponente)
    {
        int resultado = 1;

        for (int i = exponente; i > 0; i--)
            resultado *= base;

        return resultado;
    }

    public static int potenciaRec(int base, int exponente)
    {
        // Caso base: cualquier número elevado a 0 es igual a 1
        // Caso recursivo: x elevado a y = x * x elevado a x - 1

        if (exponente == 0) // caso base
            return 1;
        else
            return base * potenciaRec(base, exponente -1); // caso recursivo
    }
    public static void main(String[] args)
    {
        int base = 3;
        int exponente = 4;
        int resultado = 0;

        resultado = potencia(base, exponente);
        System.out.println("Iterativo: Resultado de " + base + " elevado a " + exponente + ": " + resultado);

        resultado = potenciaRec(base, exponente);
        System.out.println("Recursivo: Resultado de " + base + " elevado a " + exponente + ": " + resultado);

    }
}
