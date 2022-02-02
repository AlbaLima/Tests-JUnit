package test4;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import junit.framework.AssertionFailedError;

public class TestOperador extends CoreMatchers {

	@Test
	public void comprobarSumar() {
		int suma5 = OperadorAritmetico.suma(2, 3);
		assertThat("El valor de la suma es 5", suma5, is (5));
		assertThat("El tipo de dato es correcto", suma5, isA (Integer.class));
	}

	@Test (expected = Exception.class)
	public void comprobarDivision()  throws Exception{
		try {
			double division = OperadorAritmetico.division(9, 2);
			assertThat("El valor de la división debe ser 4.5", division, is (4.5));
			assertThat("El tipo de dato es correcto", division, isA (Double.class));
			
		} catch (Exception e) {
		}
	}

	@Test(expected = Exception.class)
	public void comprobarDivisionPorCero() throws Exception {
		try {
			OperadorAritmetico.division(9, 0);
			fail("Un número divido debe devolver Exception");
		} catch (Exception e) {
			assertThat(e, isA(Exception.class));
		}
	}

}
