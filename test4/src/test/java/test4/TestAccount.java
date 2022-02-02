package test4;

import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestAccount extends CoreMatchers {

	final static String NOMBRE_DE_CUENTA = "Alba Lima";
	final static long NUMERO_DE_CUENTA = (long) 9e10;
	final static float BALANCE_INICIAL = (float) 0.0;

	private Account cuenta;

	@Before
	public void setUp() throws Exception {
		this.cuenta = new Account(NOMBRE_DE_CUENTA, NUMERO_DE_CUENTA, BALANCE_INICIAL);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void compruebaDatos() {
		assertThat("El numero de la cuenta es correcto", this.cuenta.getAccountNumber(), is(NUMERO_DE_CUENTA));
	}

	@Test
	public void compruebaDeposito() {
		float deposito10 = (float) 10.0;
		float deposito0 = (float) -1.0;
		assertTrue("Se ha hecho el deposito", this.cuenta.deposit(deposito10));
		assertFalse("No se ha hecho el deposito", this.cuenta.deposit(deposito0));
	}

	@Test
	public void compruebaRetirada() {
		float deposito10 = (float) 10.0;
		float deposito3 = (float) 3.0;
		float retirada10 = (float) 10.0;
		float tasa3 = (float) 3.0;
		this.cuenta.deposit(deposito10);
		assertFalse("No se puede hacer retirada", this.cuenta.withdraw(deposito10, tasa3));
		this.cuenta.deposit(deposito3);
		float balanceEsperado = deposito10 + deposito3;
		float balanceActual = this.cuenta.getBalance();
		assertThat("El balance esperado es correcto", this.cuenta.getBalance(), is(balanceEsperado));
		assertTrue("Se ha hecho la retirada correctamente", this.cuenta.withdraw(retirada10, tasa3));
		balanceEsperado = balanceEsperado - retirada10 - tasa3;
		assertThat("El balance esperado es correcto", this.cuenta.getBalance(), is(balanceEsperado));

	}

	@Test
	public void compruebaIntereses() {
		float deposito10 = (float) 10.0;
		float interes = (float) 4.5;
		this.cuenta.deposit(deposito10);
		this.cuenta.addInterest();
		float balanceEsperado = deposito10 * ((interes / 100) + 1);
		assertThat("El balance esperado es correcto", this.cuenta.getBalance(), is(balanceEsperado));

	}

}
