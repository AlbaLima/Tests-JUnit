package test3;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestShoppingCart {

	Product pera;
	Product manzana;
	Product platano;

	private ShoppingCart sc;

	@Before
	public void setUp() throws Exception {

		sc = new ShoppingCart();

		pera = new Product("pera", 0.5);
		manzana = new Product("manzana", 1.2);
		platano = new Product("platano", 3.5);
	}


	@Test
	public void comprobarCarritoVacio() {
		assertEquals("El carrito está vacío", 0, sc.getItemCount());
	}

	@Test
	public void comprobarIncrementoProducto() {
		sc.addItem(pera);
		sc.addItem(manzana);
		sc.addItem(platano);
		assertEquals("El carrito ahora tiene un artículo", 3, sc.getItemCount());
	}

	@Test
	public void comprobarDecrementoProducto() {
		try {
			sc.addItem(platano);
			sc.addItem(manzana);
			sc.removeItem(manzana);
			assertEquals("El carrito ahora tiene 2 artículos", 1, sc.getItemCount());
			sc.removeItem(pera);
			fail("Se ha eliminado un producto que no existe en el carrito");
		} catch (ProductNotFoundException exception) {
		}
	}
	
	@Test
	public void comprobarVaciadoDeCarrito() {

		sc.empty();
		assertEquals("El carrito se ha vaciado", 0, sc.getItemCount());
	}

	@Test
	public void comprobarSumaBalance() {
		sc.addItem(manzana);
		double subtotal = sc.getBalance();
		sc.addItem(platano);
		platano.getPrice();
		double total = subtotal + platano.getPrice();
		assertTrue("Es verdad que la suma del carro es correcta", total == sc.getBalance());
	}
}
