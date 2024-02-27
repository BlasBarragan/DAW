import java.util.ArrayList;
import java.util.Collections;

public class UD8_Departamento {
    public static void main(String[] args) {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        departamentos.add(new Departamento("Ventas", 10));
        departamentos.add(new Departamento("Marketing", 5));
        departamentos.add(new Departamento("Recursos Humanos", 8));

        System.out.println("Lista sin ordenar:");
        for (Departamento d : departamentos) {
            System.out.println(d);
        }

        Collections.sort(departamentos);
        System.out.println("Lista ordenada:");
        for (Departamento d : departamentos) {
            System.out.println(d);
        }
    }
}
