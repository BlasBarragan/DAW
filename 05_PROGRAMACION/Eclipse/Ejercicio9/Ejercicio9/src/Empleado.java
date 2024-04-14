import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombreCompleto;
    private int edad;
    private double salario;

    public Empleado(String nombreCompleto, int edad, double salario) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.salario = salario;
    }

    // Getters y Setters
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
