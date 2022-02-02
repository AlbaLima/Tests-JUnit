package test4;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSubscription extends CoreMatchers {

	private Subscripcion suscripcion;

	@Before
	public void setUp() throws Exception {
		suscripcion = new Subscripcion(50, 2);
	}

	@Test
	public void comprobarPrecioMes() {
		double precioEsperado = 25.00;
		double precioDevuelto = suscripcion.precioPorMes();
		assertThat("El precio es doble", precioDevuelto, isA(Double.class));
		assertThat("El precio es correcto", precioDevuelto, is(precioEsperado));
	}

	@Test
	public void comprobarPrecio0() {
		suscripcion = new Subscripcion(0, 2);
		double suscripcionPrecio = suscripcion.precioPorMes();
		assertThat("El precio de la suscripción es correcto", suscripcionPrecio, is (0.0));
		assertThat("El tipo de dato es correcto", suscripcionPrecio, isA(Double.class));
		
	}
	
	@Test
	public void comprobarPrecioMes0() {
		suscripcion = new Subscripcion(50, 0);
		double suscripcionPeriodo = suscripcion.precioPorMes();
		assertThat("El precio de la suscripción es correcto", suscripcionPeriodo, is (0.0));
		assertThat("El tipo de dato es correcto", suscripcionPeriodo, isA(Double.class));
	}
	
	@Test
	public void comprobarPrecioMesRedondeo() {
		suscripcion = new Subscripcion(100, 3);
		double precio = suscripcion.precioPorMes();
		double precioEsperado = ( 100.0 / 3.0 ) + 1;
		assertThat("El precio de la suscripción es correcto", precio, is (precioEsperado));
		assertThat("El tipo de dato es correcto", precio, isA(Double.class));
	}
	@Test
	public void comprobarCancelado() {
		suscripcion.cancel();
		assertThat("El tipo de dato es correcto", suscripcion.precioPorMes(), isA(Double.class));
		assertThat("La suscripción es 0", suscripcion.precioPorMes(), is(0.0));
	}

}
