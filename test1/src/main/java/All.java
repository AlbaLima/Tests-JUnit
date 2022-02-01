import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test1.Persona;

public class All{
	
private static Persona persona;
	
	@Before
	public void setUp() throws Exception {
		persona = new Persona();
	}
	
	
	@Test
	public void calcularIMC() {
		
		persona.setAltura(1.76);
		persona.setPeso(81);
		int imc = persona.calcularIMC();
		assertEquals("imc sobrepeso", Persona.SOBREPESO, imc);
		persona.setPeso(49);
		imc = persona.calcularIMC();
		assertEquals("imc infrapeso", Persona.INFRAPESO, imc);
		persona.setPeso(68);
		imc = persona.calcularIMC();
		assertEquals("imc ideal", Persona.PESO_IDEAL, imc);	
	}
	
	
	@Test
	public void esMayorDeEdad() {
		
		persona.setEdad(16);
		assertFalse ("Es menor de edad", persona.esMayorDeEdad());
		persona.setEdad(18);
		assertTrue ("Es mayor de edad", persona.esMayorDeEdad());
	}
	
	
	@After
	public void tearDown() throws Exception {
	}

}
