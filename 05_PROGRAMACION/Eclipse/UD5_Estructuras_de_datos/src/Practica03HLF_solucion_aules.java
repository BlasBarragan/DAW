import java.util.Random;
import java.util.Scanner;

public class Practica03HLF {
	/*
	 *Descripción: mostramos el tablero del jugador actualizado despues de cada disparo.
	 */
    public static void mostrarTablero(char[][] tableroJugador) {
		 
        int filas = tableroJugador.length;
        int columnas = tableroJugador[0].length;

        System.out.println("Tablero del Jugador:");
        System.out.print("  ");
        for (int j = 0; j < columnas; j++) {
            System.out.print(j + " ");
        }
        System.out.println();

        for (int i = 0; i < filas; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < columnas; j++) {
                char celda = tableroJugador[i][j];
                if (celda == 'X' || celda == 'A') {
                    System.out.print(celda + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
    }
/*
 * Descripcion: Insertamos barcos y chequeamos si el espacio esta ocupado por otro o no y que esten dentro de los límites
 * del tablero.
 */
public static char[][] insertarBarco(char[][] tablero, int lancha, int buque, int acorazado, int portaaviones) {
    
    Random rd = new Random();
    
    int contador = 0;
    int numAleatorioFila, numAleatorioColumna;
    int filas = tablero.length;
    int columnas = tablero[0].length;
    
    do {
         numAleatorioFila = rd.nextInt(filas);
         numAleatorioColumna = rd.nextInt(columnas);

        if (tablero[numAleatorioFila][numAleatorioColumna] != 'L' && numAleatorioColumna +1<= columnas) {
            tablero[numAleatorioFila][numAleatorioColumna] = 'L';
            contador++;
        }
    } while (contador < lancha);
    
    contador=0;

    do {
        numAleatorioFila = rd.nextInt(filas);
        numAleatorioColumna = rd.nextInt(columnas);

       if (tablero[numAleatorioFila][numAleatorioColumna] != 'L' && tablero[numAleatorioFila][numAleatorioColumna] != 'B' 
               && numAleatorioColumna+2<columnas) {
           tablero[numAleatorioFila][numAleatorioColumna] = 'B';
           tablero[numAleatorioFila][numAleatorioColumna + 1] = 'B';
           tablero[numAleatorioFila][numAleatorioColumna + 2] = 'B';
           contador++;
       }
   } while (contador < buque);
    
   contador=0;
   
    do {
        numAleatorioFila = rd.nextInt(filas);
        numAleatorioColumna = rd.nextInt(columnas);

        if (tablero[numAleatorioFila][numAleatorioColumna] != 'L' && tablero[numAleatorioFila][numAleatorioColumna] != 'B' &&
                tablero[numAleatorioFila][numAleatorioColumna] != 'Z' && numAleatorioColumna+4<columnas) {
            tablero[numAleatorioFila][numAleatorioColumna] = 'Z';
            tablero[numAleatorioFila][numAleatorioColumna + 1] = 'Z';
            tablero[numAleatorioFila][numAleatorioColumna + 2] = 'Z';
            tablero[numAleatorioFila][numAleatorioColumna + 3] = 'Z';
            contador++;
        }
    } while (contador < acorazado);
    contador=0;
     
    do {
        numAleatorioFila = rd.nextInt(filas);
        numAleatorioColumna = rd.nextInt(columnas);

        if (tablero[numAleatorioFila][numAleatorioColumna] != 'L' && tablero[numAleatorioFila][numAleatorioColumna] != 'B' &&
                tablero[numAleatorioFila][numAleatorioColumna] != 'Z' && numAleatorioFila+5<columnas) {
            tablero[numAleatorioFila][numAleatorioColumna] = 'P';
            tablero[numAleatorioFila+1][numAleatorioColumna] = 'P';
            tablero[numAleatorioFila+2][numAleatorioColumna] = 'P';
            tablero[numAleatorioFila+3][numAleatorioColumna] = 'P';
            tablero[numAleatorioFila+4][numAleatorioColumna] = 'P';

            contador++;
        }
    } while (contador < portaaviones);
    
    return tablero;
}

/*
 * Descripción: Aprovechamos este método para 3 cosas. Creamos tablero para visualizarlo al comienzo del juego,
 * devolvemos longitud del array bidemensional para crear tablero ordenador + posteriormente el del jugador
 * y damos instrucciones del juego. 
 */

public static char[][] crearTablero (int x, int y, int intentos, int nivelJuego){
    
    System.out.println("La siguiente cuadricula, es la representación del campo de juego,\n" +
            "en ella veras los aciertos marcados con un 'X' y los errores con una 'A'.");
            System.out.println();

    char[][] tablero = new char [x][y];
    int columnasNum =0;

    for(int i=0; i<x+1; i++){
      if (i<1){
        System.out.print(" ");
      } else {
      System.out.print(columnasNum+ " ");
      columnasNum++;
      }
    }
    System.out.println();

    for (int i = 0; i <x; i++) {
        System.out.print((char) ('A' + i));
        for (int j = 0; j <y; j++) {
               System.out.print("-" + " ");
        }
        System.out.println();
    }
    System.out.println();

    System.out.println("Para marcar una casilla, primero tendras que escoger una fila,\n"
            + "escribir la letra correspondiente y a continuación la columna con un número.\n"
            + "Tienes " + intentos + " intentos para hundir todos los barcos en el nivel escogido.\n"
            + "Hay " + nivelJuego + " casillas coupadas cos barcos en este nivel.");
    System.out.println();
    
    return tablero;
}

/*
 *Descripción: creamos una copia del tablero, que sera el que utilizaremos para mostrar al jugador,
 *e ir actualizando con cada disparo.
 */

public static char[][] tableroJugador(char[][] tablero) {
                
    int filas = tablero.length;
    int columnas = tablero[0].length;

    char[][] copia = new char[filas][columnas];

    for (int i = 0; i < filas; i++) {
        System.arraycopy(tablero[i], 0, copia[i], 0, columnas);
    }
    return copia;
}

/*
 *Descripción: metodo para actulizar la cuadricula del jugador con la del ordenador despues de cada disparo,
 *para marcar si la casilla esta ocupada o no.
 */

public static void disparo (char[][] tableroJugador, char[][] tablero, String posicionBarco) {
    
    char fil = Character.toUpperCase(posicionBarco.charAt(0));
    
    int fila = fil - 'A';
    
    int columna = Character.getNumericValue(posicionBarco.charAt(1));
   
    if (tablero[fila][columna] == ('L') || tablero[fila][columna] == ('B') ||
            tablero[fila][columna] == ('Z') || tablero[fila][columna] == ('P')) {
        tableroJugador[fila][columna] = ('X');
      } else {
          tableroJugador[fila][columna] = ('A');
      }
}

/*
 * Descripción: recogemos en nivel del juego escogido por el jugador para actualizar el método comprobarJuego.
 */

public static int nivelJuego (int opcion, int lancha, int buque, int acorazado, int portaaviones) {
    
    int nivel = 0;
    
    if(opcion == 1) {
        return nivel = 23;
    } else if(opcion == 2) {
        return nivel = 14;
    } else if(opcion == 3) {
        return nivel = 4;
    } else if(opcion == 4) {
        return nivel = (lancha*1) + (buque*3) + (acorazado*4) + (portaaviones *5);
    } else {
        System.out.println("Error al introducir el nivel del juego.");
    }
    return nivel;
}

/*
 * Descripción: buscamos los aciertos en el tablero para calcular si se han hundido todos los barcos.
 */

public static boolean comprobarJuego(char[][] tableroJugador, int nivelJuego) {
    
    boolean finalJuego = true;
    int contador = 0;
    
    for(int i=0; i<tableroJugador.length; i++) {
        for(int j=0; j<tableroJugador[i].length; j++) {
            if(tableroJugador[i][j]== 'X') {
                contador++;
            }
        }
    }
    if(contador == nivelJuego) {
        return finalJuego = false;
    } else {
        return finalJuego;
    }
}

/*
 * Descripción: Metodo main
 */

public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);

    int opcion = 0;
    int contador=0;
    String posicionBarco;
    int x;
    int y;
    int lancha;
    int buque;
    int acorazado;
    int portaaviones;
    char[][] tablero;
    int nivelJuego;
    char[][] tableroJugador;
    boolean comprobarJuego;
    int intentos=0;

    do{
        do {
            System.out.println("----Undir la flota----");
            System.out.println();
            System.out.println("Escoge la dificultad(debes de introducir un número): " +
            "\nFacil/1."+
            "\nSalir/5.");
  
            opcion=sc.nextInt();
            sc.nextLine();

        }
        while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5 );

        switch (opcion) {

            case 1:
                
                lancha=5;
                buque=3;
                acorazado=1;
                portaaviones=1;
                x=10;
                y=10;
                intentos=50;

                nivelJuego = nivelJuego(opcion, lancha, buque, acorazado, portaaviones);

                tablero= crearTablero(x, y, intentos, nivelJuego);
                
                insertarBarco(tablero, lancha, buque, acorazado, portaaviones);
                
                nivelJuego = nivelJuego(opcion, lancha, buque, acorazado, portaaviones);

                tableroJugador= tableroJugador(tablero);
                
                comprobarJuego = comprobarJuego(tableroJugador, nivelJuego);

                do{
                    do{
                        System.out.print("Introduce la posición donde crees que hay un barco: ");
                        posicionBarco=sc.nextLine();
                    }
                    while(posicionBarco.isEmpty() || posicionBarco.length()!=2);
                             
                    disparo( tableroJugador, tablero, posicionBarco);
                    System.out.println();
                    

                    mostrarTablero(tableroJugador);
                                            
                    contador++;
                }
                while(contador !=intentos && comprobarJuego);
                
                if(comprobarJuego == false) {
                    System.out.println("!Enhorabuena has ganado¡");
                } else {
                    System.out.println("Lo siento, has perdido");
                }
                break;
                
            case 2:
                
                lancha=2;
                buque=1;
                acorazado=1;
                portaaviones=1;
                x=10;
                y=10;
                intentos=30;

                nivelJuego = nivelJuego(opcion, lancha, buque, acorazado, portaaviones);

                tablero= crearTablero (x, y, intentos, nivelJuego);
                
                insertarBarco(tablero, lancha, buque, acorazado, portaaviones);
                
                tableroJugador= tableroJugador(tablero);
                           
                comprobarJuego = comprobarJuego(tableroJugador, nivelJuego);

                do{                   
                    do{
                        System.out.print("Introduce la posición donde crees que hay un barco: ");
                        posicionBarco=sc.nextLine();
                    }
                    while(posicionBarco.isEmpty() || posicionBarco.length()!=2);
                             
                    disparo( tableroJugador, tablero, posicionBarco);
                    System.out.println();

                    mostrarTablero(tableroJugador);
                                            
                    contador++;
                }
                while(contador !=intentos && comprobarJuego);
                
                if(comprobarJuego == false) {
                    System.out.println("!Enhorabuena has ganado¡");
                } else {
                    System.out.println("Lo siento, has perdido");
                }

                break;

            case 3:
                
                lancha=1;
                buque=1;
                acorazado=0;
                portaaviones=0;
                x=10;
                y=10;
                intentos=10;
                
                nivelJuego = nivelJuego(opcion, lancha, buque, acorazado, portaaviones);

                tablero= crearTablero (x, y, intentos, nivelJuego);
                
                insertarBarco(tablero, lancha, buque, acorazado, portaaviones);
                
                tableroJugador= tableroJugador(tablero);
                           
                comprobarJuego = comprobarJuego(tableroJugador, nivelJuego);
                
                do{                    
                     do{
                        System.out.print("Introduce la posición donde crees que hay un barco: ");
                        posicionBarco=sc.nextLine();
                    }
                    while(posicionBarco.isEmpty() || posicionBarco.length()!=2);
                             
                    disparo( tableroJugador, tablero, posicionBarco);
                    System.out.println();

                    mostrarTablero(tableroJugador);
                                            
                    contador++;
                }
                while(contador !=intentos && comprobarJuego);
                
                if(comprobarJuego == false) {
                    System.out.println("!Enhorabuena has ganado¡");
                } else {
                    System.out.println("Lo siento, has perdido");
                }

                break;

            case 4:
                System.out.print("Introduce cuantas filas quieres que tenga la cuadrícula :");
                x = sc.nextInt();
                
                System.out.print("Introduce cuantas columnas quieres que tenga la cuadrícula :");
                y = sc.nextInt();
                
                System.out.print("Introduce cuantos intentos quieres tener :");
                intentos=sc.nextInt();
                
                System.out.print("Introduce cuantas lanchas quieres que tenga la cuadrícula :");
                lancha=sc.nextInt();
                
                System.out.print("Introduce cuantos buques quieres que tenga la cuadrícula :");
                buque=sc.nextInt();
                
                System.out.print("Introduce cuantos acorazados quieres que tenga la cuadrícula :");
                acorazado=sc.nextInt();
                
                System.out.print("Introduce cuantos portaaviones quieres que tenga la cuadrícula :");
                portaaviones=sc.nextInt();
                sc.nextLine();
                
                nivelJuego = nivelJuego(opcion, lancha, buque, acorazado, portaaviones);

                tablero= crearTablero (x, y, intentos, nivelJuego);

                insertarBarco(tablero, lancha, buque, acorazado, portaaviones);
                
                tableroJugador= tableroJugador(tablero);
                           
                comprobarJuego = comprobarJuego(tableroJugador, nivelJuego);
                
                do{              
                     do{
                        System.out.print("Introduce la posición donde crees que hay un barco: ");
                        posicionBarco=sc.nextLine();
                    }
                    while(posicionBarco.isEmpty() || posicionBarco.length()!=2);
                             
                    disparo( tableroJugador, tablero, posicionBarco);
                    System.out.println();

                    mostrarTablero(tableroJugador);
                                            
                    contador++;
                }
                while(contador !=intentos && comprobarJuego);
                
                if(comprobarJuego == false) {
                    System.out.println("!Enhorabuena has ganado¡");
                } else {
                    System.out.println("Lo siento, has perdido");
                }
                break;
                
            case 5:
                System.out.println("Hasta pronto!");
                break;

            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    while(opcion!=5);
    
    sc.close();
	}
}