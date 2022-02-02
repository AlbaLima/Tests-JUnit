import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import test4.TestAccount;
import test4.TestBoa;
import test4.TestFridge;
import test4.TestOperador;
import test4.TestPila;
import test4.TestSubscription;

@RunWith(Suite.class)
@SuiteClasses({
	TestBoa.class,
	TestFridge.class,
	TestSubscription.class,
	TestOperador.class,
	TestPila.class,
	TestAccount.class
})
public class TestBoletinJunit {}
