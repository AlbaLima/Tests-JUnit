package ejerciciosUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestVideojuego {
	
	private Videojuego vj1;
	private Videojuego vj2;

	@Before
	public void setUp() throws Exception {
		
		vj1 = new Videojuego("Call of Duty", 200, "bélico", "Infinity Ward");
		vj2 = new Videojuego("Minecraft", 350, "sandbox", "Mojang Studio");
	}

	@Test
	public void compruebaTitulo() {
		assertEquals("El titulo es Call of Duty", "Call of Duty", vj1.getTitulo());
		vj1.setTitulo("Hero");
		assertEquals("El titulo ha sido cambiado correctamente", "Hero", vj1.getTitulo());
		assertEquals("El titulo es Minecraft", "Minecraft", vj2.getTitulo());
	}
	
	@Test
	public void compruebaHorasEstimadas() {
		assertEquals("Videojuego 1 tiene 200 horas estimadas", 200, vj1.getHorasEstimadas());
		vj1.setHorasEstimadas(300);
		assertEquals("El número de horas estimadas ha sido correctamente modificada", 300, vj1.getHorasEstimadas());
		assertEquals("Videojuego 2 tiene 150 horas estimadas", 350, vj2.getHorasEstimadas());
	}
	
	@Test
	public void compruebaGenero() {
		assertEquals("El género del videojuego 1 es bélico", "bélico", vj1.getGenero());
		vj1.setGenero("accion");
		assertEquals("El género del videojuego 1 ha sido correctamente modificado", "accion", vj1.getGenero());
		assertEquals("El género del videojuego 2 es sandbox", "sandbox", vj2.getGenero());
	}
	
	@Test
	public void compruebaCompagnia() {
		assertEquals("La compagnia del videojuego 1 es Infinity Ward", "Infinity Ward", vj1.getcompagnia());
		vj1.setcompagnia("EDGE");
		assertEquals(" La compagnia del videojuego 1 ha sido correctamente modificado", "EDGE", vj1.getcompagnia());
		assertEquals("La compagnia del videojuego 2 es Mojang Studio", "Mojang Studio", vj2.getcompagnia());
	}
	
	@Test
	public void comprobarEstados() {
		assertFalse("El estado inicial de isEntregado debe ser false", vj1.isEntregado());
		vj1.entregar();
		assertTrue("Se cambia correctamente el estado a entregado", vj1.isEntregado());
		vj1.devolver();
		assertFalse("Se cambia correctamente el estado a devuelto", vj1.isEntregado());
	}
	
	@Test
	public void comprobandoComparaciones() {
		int comparado = vj1.compareTo(vj2);
		assertEquals("Call of Duty tiene menos páginas que Minecraft", Videojuego.MENOR , comparado);
		comparado = vj2.compareTo(vj1);
		assertEquals("Minecraft tiene más páginas que Call of Duty", Videojuego.MAYOR, comparado);
		vj1.setHorasEstimadas(vj2.getHorasEstimadas());
		comparado = vj1.compareTo(vj2);
		assertEquals("Ahora Call of Duty tiene las mismas páginas que Minecraft", Videojuego.IGUAL, comparado);
	}
	
	@Test
	public void comparandoVideojuegos() {
		boolean mismo = vj1.equals(vj2);
		assertFalse("Los videojuegos inicialmente no son iguales", mismo);
		
		vj1.setTitulo(vj2.getTitulo());
		vj1.setcompagnia(vj2.getcompagnia());
		mismo = vj1.equals(vj2);
		assertTrue("Los videojuegos ahora son iguales", mismo);
		
		vj1.setcompagnia("EDGE");
		mismo = vj1.equals(vj2);
		assertFalse("Los titulos son iguales, pero no las compagnia", mismo);
		
		vj1.setcompagnia(vj2.getcompagnia());
		vj1.setTitulo("HERO");
		mismo = vj1.equals(vj2);
		assertFalse("Las compagnias son iguales, pero no los títulos", mismo);	
	}
}
