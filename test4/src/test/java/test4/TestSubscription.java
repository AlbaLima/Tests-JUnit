package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSubscription {

	private Subscripcion suscripcion;

	@Before
	public void setUp() throws Exception {
		suscripcion = new Subscripcion(50, 2);
	}

	@Test
	public void comprobarPrecioMes() {
		assertTrue("El precio de la suscripción es correcto", 25 == suscripcion.precioPorMes());
	}

	@Test
	public void comprobarCancelado() {
		suscripcion.cancel();
		assertTrue("El precio de la suscripción cancelada es correcto", 0 == suscripcion.precioPorMes());
	}

}
