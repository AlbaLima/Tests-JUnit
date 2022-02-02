package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestOperador {

	@Test
	public void comprobarSumar() {
		int suma5 = OperadorAritmetico.suma(2, 3);
		assertTrue("El valor de la suma es 5", 5 == suma5);
	}

	@Test
	public void comprobarDivision() {
		try {
			int division = OperadorAritmetico.division(9, 2);
			assertTrue("El valor de la división debe ser 4.5", division == 4.5);
		}catch (Exception e) {
			fail("La operación de división ha dado un error");
		}
	}

	@Test
	public void comprobarDivisionPorCero() {
		try {
			OperadorAritmetico.division(9, 0);
			fail("Un número divido debe devolver Exception");
		} catch (Exception e) {

		}
	}

}
