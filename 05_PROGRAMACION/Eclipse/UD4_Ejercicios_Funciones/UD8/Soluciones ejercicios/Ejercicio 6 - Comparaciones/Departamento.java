public class Departamento implements Comparable<Departamento> {
    private String nombre;
    private int numEmpleados;

    public Departamento(String nombre, int numEmpleados) {
        this.nombre = nombre;
        this.numEmpleados = numEmpleados;
    }

    @Override
    public int compareTo(Departamento d) {
        if (this.numEmpleados != d.numEmpleados) {
            if (this.numEmpleados > d.numEmpleados)
            	return 1;
            else
            	return -1;
        } else {
            return this.nombre.compareTo(d.nombre);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departamento that = (Departamento) o;
        return numEmpleados == that.numEmpleados &&
                nombre.equals(that.nombre);
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "nombre='" + nombre + '\'' +
                ", numEmpleados=" + numEmpleados +
                '}';
    }
}
