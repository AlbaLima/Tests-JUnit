package test4;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestBoa {
	static final String COMIDA_SALUDABLE = "granola bars";
	static final String COMIDA_NO_SALUDABLE = "niños";
	static final String NOMBRE_BOA = "Kaa";
	static final int LONGITUD_BOA = 3;
	static final int JAULA_GRANDE = 10;
	static final int JAULA_CHICA = 2;

	@Parameters
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { 
			{ NOMBRE_BOA, LONGITUD_BOA, COMIDA_SALUDABLE, JAULA_CHICA, true, false },
			{ NOMBRE_BOA, LONGITUD_BOA, COMIDA_NO_SALUDABLE, JAULA_CHICA, false, false },
			{ NOMBRE_BOA, LONGITUD_BOA, COMIDA_SALUDABLE, JAULA_GRANDE, true, true },
			{ NOMBRE_BOA, LONGITUD_BOA, COMIDA_NO_SALUDABLE, JAULA_GRANDE, false, true }
		});
	}

	private String nombre;
	private int longitud;
	private String comida;
	private int sizeCaja;
	private boolean esSaludable;
	private boolean entraEnJaula;

	public TestBoa(String nombre, int longitud, String comida, int sizeCaja, boolean esSaludable,
			boolean entraEnJaula) {
		this.nombre = nombre;
		this.longitud = longitud;
		this.comida = comida;
		this.esSaludable = esSaludable;
		this.entraEnJaula = entraEnJaula;
		this.sizeCaja = sizeCaja;
	}

	@Test
	public void comprobarSalud() {
		Boa b = new Boa(this.nombre, this.longitud, this.comida);
		assertEquals("Salud comprobada", b.isHealthy(), this.esSaludable);
	}

	@Test
	public void comprobarJaula() {
		Boa b = new Boa(this.nombre, this.longitud, this.comida);
		assertEquals("Jaula comprobada", b.fitsInCage(this.sizeCaja), this.entraEnJaula);
	}
}
