public class CalentadorPorInduccion {
    private boolean encendido;
    private int temperatura;

    public CalentadorPorInduccion() {
        this.encendido = false;
        
        this.temperatura = 0;
    }

    public boolean encender() {
        if (!encendido) {
            encendido = true;
            System.out.println("El calentador por inducción está encendido.");
        } else {
            System.out.println("El calentador por inducción ya está encendido.");
        }
        return encendido;
    }

    public boolean apagar() {
        if (encendido) {
            encendido = false;
            temperatura = 0;
            System.out.println("El calentador por inducción está apagado.");
        } else {
            System.out.println("El calentador por inducción ya está apagado.");
        }
        return encendido;
    }

    public int ajustarTemperatura(int nuevaTemperatura) {
        if (temperatura != nuevaTemperatura) {
            temperatura = nuevaTemperatura;
            System.out.println("La temperatura se ha ajustado a " + temperatura + " grados Celsius.");
        } else {
            System.out.println("No se puede ajustar la temperatura porque el calentador está apagado.");
        }
        return temperatura;
    }

}
