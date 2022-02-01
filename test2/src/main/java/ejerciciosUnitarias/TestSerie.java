package ejerciciosUnitarias;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestSerie {

	private Serie serie1;
	private Serie serie2;

	@Before
	public void setUp() throws Exception {

		serie1 = new Serie("Stranger Things", 3, "Ciencia-Ficcion", "Hermanos Duffer");
		serie2 = new Serie("Modern Family", 11, "Comedia", "Christopher Lloyd");
	}

	@Test
	public void compruebaTitulo() {
		assertEquals("El titulo es Stranger Things", "Stranger Things", serie1.getTitulo());
		serie1.setTitulo("Hola");
		assertEquals("El titulo ha sido cambiado correctamente", "Hola", serie1.getTitulo());
		assertEquals("El titulo es Modern Family", "Modern Family", serie2.getTitulo());
	}

	@Test
	public void comprobarEstados() {
		assertFalse("El estado inicial de isEntregado debe ser false", serie1.isEntregado());
		serie1.entregar();
		assertTrue("Se cambia correctamente el estado a entregado", serie1.isEntregado());
		serie1.devolver();
		assertFalse("Se cambia correctamente el estado a devuelto", serie1.isEntregado());
	}
	
	@Test
	public void compruebaNumTemporadas() {
		assertEquals("Serie 1 tiene tres temporadas", 3, serie1.getnumeroTemporadas());
		serie1.setnumeroTemporadas(5);
		assertEquals("El número de temporadas ha sido correctamente modificado", 5, serie1.getnumeroTemporadas());
		assertEquals("Serie 2 tiene once temporadas", 11, serie2.getnumeroTemporadas());
	}
	
	@Test
	public void compruebaGenero() {
		assertEquals("El género de serie 1 es Ciencia-Ficcion", "Ciencia-Ficcion", serie1.getGenero());
		serie1.setGenero("Drama");
		assertEquals("El género de la serie ha sido correctamente modificado", "Drama", serie1.getGenero());
		assertEquals("El género de serie 2 es Comedia", "Comedia", serie2.getGenero());
	}
	
	@Test
	public void compruebaCreadoresDeLaSerie() {
		assertEquals("Los creadores de la serie 1 son Los hermanos Duffer ", "Hermanos Duffer", serie1.getcreador());
		serie1.setcreador("Steven Spielberg");
		assertEquals("El creador ha sido modificado correctamente", "Steven Spielberg", serie1.getcreador());
		assertEquals("El creador de la serie 2 es Christopher Lloyd", "Christopher Lloyd", serie2.getcreador());
	}

	@Test
	public void comprobandoComparaciones() {
		int comparado = serie1.compareTo(serie2);
		assertEquals("Stranger Things es menor a Modern Family", Serie.MENOR , comparado);
		comparado = serie2.compareTo(serie1);
		assertEquals("Modern Family es mayor a Stranger Things", Serie.MAYOR, comparado);
		serie1.setnumeroTemporadas(serie2.getnumeroTemporadas());
		comparado = serie1.compareTo(serie2);
		assertEquals("Ahora Stranger Things tiene las mismas temporadas que Modern Family", Serie.IGUAL, comparado);
	}
	
	@Test
	public void comparandoSeries() {
		boolean mismo = serie1.equals(serie2);
		assertFalse("Las series inicialmente no son iguales", mismo);
		
		serie1.setTitulo(serie2.getTitulo());
		serie1.setcreador(serie2.getcreador());
		mismo = serie1.equals(serie2);
		assertTrue("Las series ahora son iguales", mismo);
		
		serie1.setcreador("Benicio del Toro");
		mismo = serie1.equals(serie2);
		assertFalse("Los titulos son iguales, pero no los creadores", mismo);
		
		serie1.setcreador(serie2.getcreador());
		serie1.setTitulo("Vikingos");
		mismo = serie1.equals(serie2);
		assertFalse("Los creadores son iguales, pero no los títulos", mismo);	
	}
}
