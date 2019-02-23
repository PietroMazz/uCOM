package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.DatiLogin;
import uCOM.LoginSystem;
import uCOM.Ruolo;

/**
 * @author Pietro
 *
 */
class LoginSystemTest {

	private LoginSystem loginTest;
	
	@BeforeEach
	public void setUp()
	{
		loginTest = new LoginSystem();
	}
	
	/**
	 * Test method for {@link uCOM.LoginSystem#verificaCredenziali(uCOM.DatiLogin)}.
	 */
	@Test
	void testVerificaCredenziali() {
		DatiLogin datiTest = new DatiLogin("prova", "prova");
		
		Ruolo r = loginTest.verificaCredenziali(datiTest);
		
		assertEquals(r, Ruolo.STUDENTE);
		
	}

}
