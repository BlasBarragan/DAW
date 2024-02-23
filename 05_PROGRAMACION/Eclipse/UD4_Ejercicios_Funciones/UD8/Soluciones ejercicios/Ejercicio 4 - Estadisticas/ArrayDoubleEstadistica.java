public class ArrayDoubleEstadistica implements Estadisticable {
   private double[] valores;
   private int cantidad;

   public ArrayDoubleEstadistica(int tamano) {
      valores = new double[tamano];
      cantidad = 0;
   }

   public void insertarValor(double valor) {
      if (cantidad < valores.length) {
         valores[cantidad] = valor;
         cantidad++;
      }
   }

   public double minimo() {
      double minimo = Double.POSITIVE_INFINITY;
      for (int i = 0; i < cantidad; i++) {
         if (valores[i] < minimo) {
            minimo = valores[i];
         }
      }
      return minimo;
   }

   public double maximo() {
      double maximo = Double.NEGATIVE_INFINITY;
      for (int i = 0; i < cantidad; i++) {
         if (valores[i] > maximo) {
            maximo = valores[i];
         }
      }
      return maximo;
   }

   public double media() {
      double suma = 0;
      for (int i = 0; i < cantidad; i++) {
         suma += valores[i];
      }
      return suma / cantidad;
   }

   public int cuantos() {
      return cantidad;
   }
}
