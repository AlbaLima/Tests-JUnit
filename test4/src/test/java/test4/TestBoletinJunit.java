package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
1. Realizar todos los test de prueba necesarios para tener una cobertura del 100% 
	en las clases Subscripcion y OperadorArimetico.
2. Realizar todos los test de prueba necesarios para tener una cobertura del 100% 
	en la clase Pila
3. Realiza las pruebas parametrizadas necesarias para comprobar todos los posibles casos
 	de los métodos de la clase Boa
4. Realiza pruebas parametrizadas para la clase Fridge.
5. Crea una suite para lanzar todas las pruebas realizadas.
6. Crea las pruebas necesarias para realizar una cobertura del código de la clase 
	Account superior al 90%. Si detectas algún error en la clase trata de arreglarlo.
7. Crea una nueva prueba para la clase Account que detecte un defecto más sútil. 
	Pista: Mira la clase BadMoney
*/


public class TestBoletinJunit {
	
	private Subscripcion suscripcion;
	private OperadorAritmetico OA;

	@Before
	public void setUp() throws Exception {
		
		suscripcion = new Subscripcion(50, 2);
		OA = new OperadorAritmetico();
		
	}

	@Test
	public void comprobarCancelacion() {
		
		assertEquals(0,suscripcion.cancel());
	}	
	
	/**
	@Test
	public void comprobarCalculandoPrecioMensual() {
		assertTrue("La suscripcion es correcta", 25.0 == suscripcion.precioPorMes());
		suscripcion = new Subscripcion(100, 3);
		double precio = suscripcion.precioPorMes();
		assertTrue("El redondeo de la suscripcion es correcto", 34.0 == precio);		
	}
	*/
	
	@Test
	public void comprobarSuma() {
		OA.suma(2, 4);
		assertTrue("", 6 == OA.suma());
	}

	
	
	@After
	public void tearDown() throws Exception {
	}



}
