/*
Modifica la clase Gato vista anteriormente añadiendo el método apareaCon.
Este método debe comprobar que los gatos son de distinto sexo, tras lo
cual, genera un nuevo gato. Por ejemplo, sería válido algo como Gato cria
= garfield.apareaCon(lisa). En caso de que los gatos sean del mismo sexo,
el método debe generar la excepción ExcepcionApareamientoImposible. Crea un
programa desde el que se pruebe el método.
*/

// Definición de la excepción ExcepcionApareamientoImposible
class ExcepcionApareamientoImposible extends Exception {
    public ExcepcionApareamientoImposible() {
        super("Apareamiento imposible: Los gatos son del mismo sexo.");
    }
}

// Definición de la clase Gato
class Gato {
    private String nombre;
    private String sexo;

    // Constructor
    public Gato(String nombre, String sexo) {
        this.nombre = nombre;
        this.sexo = sexo;
    }

    // Método para aparearse con otro gato
    public Gato apareaCon(Gato pareja) throws ExcepcionApareamientoImposible {
        if (this.sexo.equals(pareja.sexo)) {
            throw new ExcepcionApareamientoImposible();
        }

        // Generar un nuevo gato con nombre combinado de los padres
        String nombreCria = this.nombre.substring(0, this.nombre.length() / 2) +
                            pareja.nombre.substring(pareja.nombre.length() / 2);
        return new Gato(nombreCria, "desconocido");
    }

    // Método para obtener el nombre del gato
    public String getNombre() {
        return nombre;
    }

    // Método para obtener el sexo del gato
    public String getSexo() {
        return sexo;
    }
}

// Programa de prueba
public class PruebaApareamientoGatos {
    public static void main(String[] args) {
        Gato garfield = new Gato("Garfield", "macho");
        Gato lisa = new Gato("Lisa", "hembra");

        try {
            Gato cria = garfield.apareaCon(lisa);
            System.out.println("¡Se ha generado una nueva cría de gato llamada " + cria.getNombre() + "!");
        } catch (ExcepcionApareamientoImposible e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
