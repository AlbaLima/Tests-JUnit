package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestFridge {
	private Fridge frigo;

	@Before
	public void setUp() throws Exception {

		frigo = new Fridge();
	}

	@Test
	public void comprobarMeterComida() {
		assertTrue("Se ha introducido un platano en el frigo", frigo.put("platano"));
	}

	@Test
	public void comprobarContenido() {
		frigo.put("platano");
		assertFalse("No se ha introducido ninguna manzana", frigo.contains("manzana"));
		assertTrue("Se ha introducido un platano", frigo.contains("platano"));
	}
	
	@Test
	public void comprobarVaciado() {

		try {
			frigo.put("platano");
			frigo.take("platano");
			assertFalse("Se ha introducido un platano", frigo.contains("platano"));
			frigo.take("platano");
			fail("Se ha borrado un elemento que no existe");
		} catch (NoSuchItemException e) {	
		}
	}
	
	

	@After
	public void tearDown() throws Exception {
	}

}
