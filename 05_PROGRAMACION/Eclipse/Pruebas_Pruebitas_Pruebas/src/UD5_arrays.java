import java.util.Scanner;
import java.util.Random;

public class PracticaHLF {

    // Función principal que inicia el juego y gestiona la lógica del mismo.
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Bienvenido a Hundir la Flota!");

        int intentos = elegirDificultad(sc);
        char[][] tablero;

        if (intentos == -1) {
            int filas = obtenerEntrada(sc, "Ingresa el número de filas del tablero (mínimo 5):", 5);
            int columnas = obtenerEntrada(sc, "Ingresa el número de columnas del tablero (mínimo 4):", 4);
            int numBarcos = obtenerEntrada(sc, "Ingresa el número de barcos:", 1);
            intentos = obtenerEntrada(sc, "Ingresa el número de intentos:", 1);

            tablero = inicializarTableroPersonalizado(filas, columnas, intentos, numBarcos);
            if (tablero == null) {
                // Hubo un error al inicializar el tablero personalizado
                return;
            }
        } else {
            tablero = inicializarTablero();
        }

        while (intentos > 0 && tablero != null) {
            mostrarTablero(tablero);
            intentos = disparo(sc, tablero, intentos);
            if (todosLosBarcosHundidos(tablero)) {
                System.out.println("¡Has ganado!");
                break;
            }
        }

        if (intentos == 0) {
            System.out.println("¡Has perdido! Intenta de nuevo.");
            mostrarTableroCompleto(tablero);
        }

        //sc.close();
    }

    /**
     * Funcion elegirDificultad
     * Muestra un menú al jugador para que elija la dificultad deseada.
     * La función devuelve el número de intentos disponibles para cada nivel.
     */
    static int elegirDificultad(Scanner sc) {
        System.out.println("Elige el nivel de dificultad:");
        System.out.println("1. Fácil");
        System.out.println("2. Medio");
        System.out.println("3. Difícil");
        System.out.println("4. Personalizado");

        int opcion = sc.nextInt();

        switch (opcion) {
            case 1:
                return 50;
            case 2:
                return 30;
            case 3:
                return 10;
            case 4:
                return -1; // Indica que se seleccionó personalizado
            default:
                System.out.println("Opción no válida. Seleccionando fácil por defecto.");
                return 50;
        }
    }

    /**
     * Funcion inicializarTablero
     * Se crea una matriz de 10x10 e inicializa el tablero con barcos aleatorios.
     */
    static char[][] inicializarTablero() {
        char[][] tablero = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                tablero[i][j] = '-';
            }
        }

        colocarBarcosAleatorios(tablero);

        return tablero;
    }

    /**
     * Funcion inicializarTableroPersonalizado
     * Consulta al jugador el número de filas, columnas, intentos y barcos.
     * Crea el tablero personalizado según las especificaciones del jugador.
     */
    static char[][] inicializarTableroPersonalizado(int filas, int columnas, int numIntentos, int numBarcos) {
        // Verificar que las dimensiones cumplan con los requisitos mínimos
        if (filas < 5 || columnas < 4) {
            System.out.println("Error: Las dimensiones del tablero deben ser de al menos 5 filas y 4 columnas.");
            return null; // Devolver null para indicar un error
        }

        char[][] tablero = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = '-';
            }
        }

        // Colocar barcos según el número especificado
        for (int k = 0; k < numBarcos; k++) {
            Random rd = new Random();
            int tamano = rd.nextInt(3) + 1; // Tamaño aleatorio entre 1 y 3

            // Intentar colocar el barco hasta encontrar una posición válida
            boolean barcoColocado = false;
            while (!barcoColocado) {
                int fila = rd.nextInt(filas);
                int columna = rd.nextInt(columnas);

                if (puedeColocarBarco(tablero, fila, columna, tamano, rd.nextBoolean())) {
                    colocarBarco(tablero, "B", tamano, fila, columna);
                    barcoColocado = true;
                }
            }
        }

        return tablero;
    }

    /**
     * Funcion obtenerEntrada
     * Analiza que las entradas de teclado sean números y los compara con el valor mínimo especificado.
     */
    static int obtenerEntrada(Scanner sc, String mensaje, int minimo) {
        int entrada;
        do {
            System.out.println(mensaje);
            while (!sc.hasNextInt()) {
                System.out.println("Entrada no válida. Inténtalo de nuevo.");
            }
            entrada = sc.nextInt();
        } while (entrada < minimo);
        return entrada;
    }

    /**
     * Funcion colocarBarcosAleatorios
     * Añade los barcos al tablero creado de forma aleatoria.
     */
    static void colocarBarcosAleatorios(char[][] tablero) {
        Random rd = new Random();

        colocarBarco(tablero, "L", 1, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "L", 1, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "L", 1, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "L", 1, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "L", 1, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));

        colocarBarco(tablero, "B", 3, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "B", 3, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
        colocarBarco(tablero, "B", 3, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));

        colocarBarco(tablero, "Z", 4, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));

        colocarBarco(tablero, "P", 5, rd.nextInt(tablero.length), rd.nextInt(tablero[0].length));
    }

    /**
     * Funcion colocarBarco
     * Coloca un barco en el tablero en una posición específica.
     */
    static void colocarBarco(char[][] tablero, String tipo, int tamano, int fila, int columna) {
        if (puedeColocarBarco(tablero, fila, columna, tamano, tipo.equals("P"))) {
            for (int i = 0; i < tamano; i++) {
                if (tipo.equals("P")) {
                    tablero[fila + i][columna] = tipo.charAt(0);
                } else {
                    tablero[fila][columna + i] = tipo.charAt(0);
                }
            }
        } else {
            colocarBarco(tablero, tipo, tamano, new Random().nextInt(tablero.length), new Random().nextInt(tablero[0].length));
        }
    }

    /**
     * Funcion puedeColocarBarco
     * Verifica si es posible colocar un barco en una posición específica del tablero.
     */
    static boolean puedeColocarBarco(char[][] tablero, int fila, int columna, int tamano, boolean esVertical) {
        if (esVertical) {
            if (fila + tamano > tablero.length) {
                return false;
            }
            for (int i = fila; i < fila + tamano; i++) {
                if (tablero[i][columna] != '-') {
                    return false;
                }
            }
        } else {
            if (columna + tamano > tablero[0].length) {
                return false;
            }
            for (int j = columna; j < columna + tamano; j++) {
                if (tablero[fila][j] != '-') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Funcion mostrarTablero
     * Muestra el tablero actual durante el juego.
     */
    static void mostrarTablero(char[][] tablero) {
        System.out.println("Tablero:");
        System.out.print("  ");
        for (int i = 0; i < tablero[0].length; i++) {
            System.out.print((char) ('A' + i) + " ");
        }
        System.out.println();

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] == '-' || tablero[i][j] == 'A' || tablero[i][j] == 'X') {
                    System.out.print(tablero[i][j] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    /**
     * Funcion mostrarTableroCompleto
     * Muestra el tablero completo al final del juego.
     */
    static void mostrarTableroCompleto(char[][] tablero) {
        System.out.println("Tablero Completo:");
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * Funcion disparo
     * Gestiona la lógica del disparo del jugador y actualiza el tablero.
     */
    static int disparo(Scanner sc, char[][] tablero, int intentos) {
        System.out.println("Ingrese la posición del disparo (por ejemplo, A3):");
        String entrada = sc.next().toUpperCase();

        if (entrada.length() < 2) {
            System.out.println("Entrada inválida. Inténtalo de nuevo.");
            return disparo(sc, tablero, intentos);
        }

        char columna = entrada.charAt(0);
        int fila = Character.getNumericValue(entrada.charAt(1));

        if (fila < 0 || fila >= tablero.length || columna < 'A' || columna > 'A' + tablero[0].length) {
            System.out.println("Posición fuera de rango. Inténtalo de nuevo.");
            return disparo(sc, tablero, intentos);
        }

        if (tablero[fila][columna - 'A'] == 'A' || tablero[fila][columna - 'A'] == 'X') {
            System.out.println("Ya has disparado en esa posición. Inténtalo de nuevo.");
        } else {
            if (realizarDisparo(tablero, fila, columna - 'A')) {
                System.out.println("¡Tocado!");
            } else {
                System.out.println("Agua");
            }
            intentos--;
        }
        return intentos;
    }

    /**
     * Funcion realizarDisparo
     * Actualiza el tablero según el resultado del disparo del jugador.
     */
    static boolean realizarDisparo(char[][] tablero, int fila, int columna) {
        if (tablero[fila][columna] != '-') {
            tablero[fila][columna] = 'X';
            return true;
        } else {
            tablero[fila][columna] = 'A';
            return false;
        }
    }

    /**
     * Funcion todosLosBarcosHundidos
     * Verifica si todos los barcos han sido hundidos en el tablero.
     */
    static boolean todosLosBarcosHundidos(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (tablero[i][j] != '-' && tablero[i][j] != 'X') {
                    return false;
                }
            }
        }
        return true;
    }
}
