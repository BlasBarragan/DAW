import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	final void testSuma() {
		double valorEsperado = 30;
		Calculadora calcu = new Calculadora(20,10);
		double resultado = calcu.suma();
		assertEquals(valorEsperado, resultado, 0);
	}

	@Test
	final void testResta() {
		double valorEsperado = 10;
		Calculadora calcu = new Calculadora(20,10);
		double resultado = calcu.resta();
		assertEquals(valorEsperado, resultado, 0);
	}

	@Test
	final void testMultiplica() {
		double valorEsperado = 200;
		Calculadora calcu = new Calculadora(20,50);
		double resultado = calcu.multiplica();
		assertEquals(valorEsperado, resultado, 0,"Fallo en la multiplicacion: ");
	}

	@Test
	final void testDivide() {
		double valorEsperado = 2;
		Calculadora calcu = new Calculadora(20,0);
		double resultado = calcu.divide();
		assertEquals(valorEsperado, resultado, 0);
	}
	
	public void testException() {
		try {
			Calculadora calcu = new Calculadora(20,0);
			double resultado = calcu.divide();
			fail("FALLO, Deberia haber lanzado excepcion");
		} catch (ArithmeticException e) {
			// PRUEBA satisfactoria
		}
	}

}
