import java.util.ArrayList;

public class ArrayListDoubleEstadistica implements Estadisticable {
   private ArrayList<Double> valores;

   public ArrayListDoubleEstadistica() {
      valores = new ArrayList<Double>();
   }

   public void insertarValor(double valor) {
      valores.add(valor);
   }

   public double minimo() {
      double minimo = Double.POSITIVE_INFINITY;
      for (double valor : valores) {
         if (valor < minimo) {
            minimo = valor;
         }
      }
      return minimo;
   }

   public double maximo() {
      double maximo = Double.NEGATIVE_INFINITY;
      for (double valor : valores) {
         if (valor > maximo) {
            maximo = valor;
         }
      }
      return maximo;
   }

   public double media() {
      double suma = 0;
      for (double valor : valores) {
         suma += valor;
      }
      return suma / valores.size();
   }

   public int cuantos() {
      return valores.size();
   }
}
