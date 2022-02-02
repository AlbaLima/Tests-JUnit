package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class TestPila {
	
	private Pila miPila;

	@Before
	public void setUp() throws Exception {
		miPila = new Pila();
	}

	@Test
	public void comprobarPilaVacia() {
		assertTrue("La pila inicialmente está vacia", miPila.isEmpty());
	}

	@Test
	public void comprobarLimitesDePush() {
		miPila.push(2);
		assertTrue("La pila no admite valores menores a 3", miPila.isEmpty());

		miPila.push(20);
		assertTrue("La pila no admite valores mayores a 19", miPila.isEmpty());
	}

	@Test
	public void comprobarPushPop() {
		int valorInsertado = 5;
		miPila.push(valorInsertado);
		assertTrue("La pila ha insertado correctamente", valorInsertado == miPila.pop());
		assertTrue("La función pop de la pila elimina correctamente", miPila.isEmpty());
		assertTrue("Cuando la pila está vacia el valor de pop es null", miPila.pop() == null);
	}
	

	@Test
	public void comprobarTop() {
		assertTrue("Cuando la pila está vacia el valor de top es null", miPila.top() == null);

		int valorInsertado = 5;
		miPila.push(valorInsertado);
		assertTrue("El primer valor de la pila es correcto", valorInsertado == miPila.top());
		valorInsertado = 3;
		miPila.push(valorInsertado);
		assertTrue("El primer valor de la pila es correcto", valorInsertado == miPila.top());
	}
	

}
