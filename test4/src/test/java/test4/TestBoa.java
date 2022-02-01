package test4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoa {
	static final String COMIDA_SALUDABLE = "granola bars";
	static final String COMIDA_NO_SALUDABLE = "niños";
	static final String NOMBRE_BOA = "Kaa";
	static final int LONGITUD_BOA = 3;
	static final int JAULA_GRANDE = 10;
	static final int JAULA_CHICA = 2;

	@Test
	public void comprobarSalud() {
		Boa b = new Boa(NOMBRE_BOA, LONGITUD_BOA,  COMIDA_SALUDABLE);
		assertTrue("Es saludable", b.isHealthy());
		
		b = new Boa(NOMBRE_BOA, LONGITUD_BOA,  COMIDA_NO_SALUDABLE);
		assertFalse("No es saludable", b.isHealthy());
	}

	@Test
	public void comprobarJaula() {
		Boa b = new Boa(NOMBRE_BOA, LONGITUD_BOA,  COMIDA_SALUDABLE);
		assertTrue("La jaula es adecuada", b.fitsInCage(JAULA_GRANDE));
		assertFalse("La jaula no es adecuada", b.fitsInCage(JAULA_CHICA));
	}
}
