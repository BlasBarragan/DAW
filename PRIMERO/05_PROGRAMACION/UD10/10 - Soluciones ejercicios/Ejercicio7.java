/*
Ejercicio 7. El archivo ‘alumnos_notas.txt’ contiene una lista de 10 alumnos y las notas que han obtenido en
cada asignatura. El número de asignaturas de cada alumno es variable. Implementa un programa que muestre
por pantalla la nota media de cada alumno junto a su nombre y apellido, ordenado por nota media de mayor
a menor.
*/

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Alumno {
    String nombre;
    List<Double> notas;
    double notaMedia;

    Alumno(String nombre, List<Double> notas) {
        this.nombre = nombre;
        this.notas = notas;
        this.notaMedia = calcularNotaMedia();
    }

    private double calcularNotaMedia() {
        double suma = 0;
        for (double nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }
}

public class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("alumnos_notas.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(", ");
                String nombre = partes[0];
                List<Double> notas = new ArrayList<>();
                for (int i = 1; i < partes.length; i++) {
                    notas.add(Double.parseDouble(partes[i]));
                }
                alumnos.add(new Alumno(nombre, notas));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        alumnos = alumnos.stream()
                         .sorted((a1, a2) -> Double.compare(a2.notaMedia, a1.notaMedia))
                         .collect(Collectors.toList());

        for (Alumno alumno : alumnos) {
            System.out.printf("%s: %.2f\n", alumno.nombre, alumno.notaMedia);
        }
    }
}
