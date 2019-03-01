package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.DatiUtente;
import uCOM.RegistroUtenti;
import uCOM.Ruolo;
import uCOM.Sistema;
import util.Status;

/**
 * @author Pietro
 *
 */
class RegistroUtentiTest {

	private RegistroUtenti registroTest;
	
	@Before
	void startSystem(){
		Sistema.getIstanza().startup();
	}
	
	@BeforeEach
	void startup()
	{
		registroTest = new RegistroUtenti();
	}
	
	/**
	 * Test method for {@link uCOM.RegistroUtenti#add(uCOM.DatiUtente)}.
	 */
	@Test
	void testAdd() {
		DatiUtente du = new DatiUtente("prova", Ruolo.STUDENTE);	
		assertEquals(Status.SUCCESS, registroTest.add(du));
	}

	@Test
	void testAddDoppione() {
		
		DatiUtente du = new DatiUtente("prova", Ruolo.STUDENTE);
		registroTest.add(du);
	
		du = new DatiUtente("prova", Ruolo.AMMINISTRATORE);
		registroTest.add(du);
	
		assertEquals(Status.FAIL, registroTest.add(du));
	}
	
	/**
	 * Test method for {@link uCOM.RegistroUtenti#getRoleForUser(uCOM.DatiUtente)}.
	 */
	@Test
	void testGetRole() {
		DatiUtente du = new DatiUtente("prova", Ruolo.STUDENTE);
		registroTest.add(du);
		Ruolo	role = registroTest.getRoleForUser(du.getUsername());
		assertEquals(Ruolo.STUDENTE, role);
	}


}
