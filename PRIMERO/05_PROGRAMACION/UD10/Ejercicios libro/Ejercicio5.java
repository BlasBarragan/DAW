/*
Escribe un programa capaz de quitar los comentarios de un programa de Java.
Se utilizaría de la siguiente manera:
quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO
Por ejemplo:
quita_comentarios hola.java holav2.java
crea un fichero con nombre holav2.java que contiene el código de hola.java pero
sin los comentarios.
*/

import java.io.*;

public class QuitarComentarios {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso: quita_commentarios PROGRAMA_ORIGINAL PROGRAMA_LIMPIO");
            return;
        }

        String nombreOriginal = args[0];
        String nombreLimpio = args[1];

        try (BufferedReader br = new BufferedReader(new FileReader(nombreOriginal));
             BufferedWriter bw = new BufferedWriter(new FileWriter(nombreLimpio))) {

            String linea;
            while ((linea = br.readLine()) != null) {
                String lineaSinComentarios = quitarComentarios(linea);
                bw.write(lineaSinComentarios);
                bw.newLine();
            }

            System.out.println("Comentarios eliminados correctamente. Archivo guardado como: " + nombreLimpio);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String quitarComentarios(String linea) {
        StringBuilder sb = new StringBuilder();
        boolean dentroComentarioBloque = false;
        boolean dentroComentarioLinea = false;

        for (int i = 0; i < linea.length(); i++) {
            if (!dentroComentarioBloque && !dentroComentarioLinea) {
                if (i + 1 < linea.length() && linea.charAt(i) == '/' && linea.charAt(i + 1) == '*') {
                    dentroComentarioBloque = true;
                    i++;
                } else if (i + 1 < linea.length() && linea.charAt(i) == '/' && linea.charAt(i + 1) == '/') {
                    dentroComentarioLinea = true;
                    i++;
                } else {
                    sb.append(linea.charAt(i));
                }
            } else if (dentroComentarioBloque && i + 1 < linea.length() && linea.charAt(i) == '*' && linea.charAt(i + 1) == '/') {
                dentroComentarioBloque = false;
                i++;
            }

            if (!dentroComentarioLinea && !dentroComentarioBloque) {
                sb.append(linea.charAt(i));
            }
        }

        return sb.toString();
    }
}
