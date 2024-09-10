public class UD8_Estadisticas {
    public static void main(String[] args) {
        ArrayListDoubleEstadistica arrayListEstadistica = new ArrayListDoubleEstadistica();
        arrayListEstadistica.insertarValor(2.0);
        arrayListEstadistica.insertarValor(4.0);
        arrayListEstadistica.insertarValor(3.0);
        arrayListEstadistica.insertarValor(1.0);
        
        System.out.println("ArrayList Estadistica");
        System.out.println("Valor mínimo: " + arrayListEstadistica.minimo());
        System.out.println("Valor máximo: " + arrayListEstadistica.maximo());
        System.out.println("Valor media: " + arrayListEstadistica.media());
        System.out.println("Número de elementos: " + arrayListEstadistica.cuantos());
        
        ArrayDoubleEstadistica arrayEstadistica = new ArrayDoubleEstadistica(4);
        arrayEstadistica.insertarValor(5.0);
        arrayEstadistica.insertarValor(6.0);
        arrayEstadistica.insertarValor(7.0);
        arrayEstadistica.insertarValor(8.0);
        
        System.out.println("Array Estadistica");
        System.out.println("Valor mínimo: " + arrayEstadistica.minimo());
        System.out.println("Valor máximo: " + arrayEstadistica.maximo());
        System.out.println("Valor media: " + arrayEstadistica.media());
        System.out.println("Número de elementos: " + arrayEstadistica.cuantos());
    }
}
