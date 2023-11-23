import java.util.Scanner;

public class Ejercicio47
{
    static boolean estaAprobado(int nota, int notaMinima)
    {
        boolean aprobado = true;

        if (nota < notaMinima)
            aprobado = false;

        return aprobado;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("¡Profesor!, dame nota mínima para aprobar: ");
        int notaMinima = sc.nextInt();

        int notaAlumno = 0;
        do
        {
            System.out.print("¡Alumno!, dime que nota has obtenido: ");
            notaAlumno = sc.nextInt();

            if (notaAlumno >= 0 && notaAlumno <= 10)
            {
                boolean aprobado = estaAprobado(notaAlumno, notaMinima);

                if (aprobado)
                    System.out.println("Aprobado.");
                else
                    System.out.println("Suspendido.");
            }
            else
                System.out.println("Nota incorrecta.");
        }
        while (notaAlumno != -1);
    }
}
