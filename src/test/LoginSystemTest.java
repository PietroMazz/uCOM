package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.DatiLogin;
import uCOM.DatiUtente;
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
	void testCredenziali() {	
		
		DatiUtente s = new DatiUtente("s", Ruolo.STUDENTE);
		DatiUtente a = new DatiUtente("a", Ruolo.AMMINISTRATORE);
		DatiUtente sa = new DatiUtente("sa", Ruolo.SYSTEMADMIN);
		loginTest.creaUtente(s);
		loginTest.creaUtente(a);
		loginTest.creaUtente(sa);
		
		DatiLogin datiTest;
		Ruolo role;		
		
		datiTest = new DatiLogin("s", "test");
		role = loginTest.verificaCredenziali(datiTest);
		assertEquals(Ruolo.STUDENTE, role);
		
		datiTest = new DatiLogin("a", "test");
		role = loginTest.verificaCredenziali(datiTest);
		assertEquals(Ruolo.AMMINISTRATORE, role);
		
		datiTest = new DatiLogin("sa", "test");
		role = loginTest.verificaCredenziali(datiTest);
		assertEquals(Ruolo.SYSTEMADMIN, role);
		
		
	}	

}
