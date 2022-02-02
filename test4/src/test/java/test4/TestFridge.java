package test4;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class TestFridge {
	private Fridge frigo;

	private String[] lista;



	@Parameters
	public static Collection<String[][]> data() {
		return Arrays.asList(new String[][][] { 
			{ {"manzana", "pera", "platano"} },
		});
	}


	public TestFridge(String[] lista) {
		this.frigo = new Fridge();
		this.lista = lista;
	}

	@Test
	public void comprobarFuncionamiento() throws NoSuchItemException {

		for (String fruta : this.lista) {
			assertTrue("Se han introducido la fruta en el frigo", frigo.put(fruta));
			assertTrue("La fruta está en el frigo", frigo.contains(fruta));

			frigo.take(fruta);
			assertFalse("La fruta se ha sacado correctamente", frigo.contains(fruta));

			try {
				frigo.take(fruta);
				fail("Se ha borrado un elemento que no existe");
			} catch (NoSuchItemException e) {
			}
		}
	}

}
