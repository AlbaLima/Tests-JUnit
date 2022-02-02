package test5;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

//Realiza los tests de las clases Cuenta, Movimiento, Credito y Debito


public class TestMovimiento {
	
	private Movimiento mov;

	@Before
	public void setUp() throws Exception {
		mov = new Movimiento();
	}

	@Test
	public void comprobarImporte{
		mov.setImporte(200.50);
		assertEquals(200.50, mov.getImporte());
	}
	
	
	
	
	
	@After
	public void tearDown() throws Exception {
	}

	

}
