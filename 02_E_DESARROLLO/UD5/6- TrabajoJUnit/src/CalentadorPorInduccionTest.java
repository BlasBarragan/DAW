
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalentadorPorInduccionTest {

	@Test
	final void testEncender() {
		boolean valorEsperado = true;
		CalentadorPorInduccion calent = new CalentadorPorInduccion();
		boolean resultado = calent.apagar();
		assertTrue(resultado);
	}

	@Test
	final void testApagar() {
		boolean valorEsperado = false;
		CalentadorPorInduccion calent = new CalentadorPorInduccion();
		boolean resultado = calent.apagar();
		assertFalse(resultado);
	}

	@Test
	final void testAjustarTemperatura() {
		int tempDeseada = 850;
		CalentadorPorInduccion calent = new CalentadorPorInduccion();
		int tempAjustada = calent.ajustarTemperatura(85);
		assertEquals(tempDeseada, tempAjustada);
	}


}
