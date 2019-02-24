package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uCOM.Amministratore;
import uCOM.Avviso;
import uCOM.Corso;
import uCOM.Ruolo;
import util.Status;

/**
 * @author Pietro
 *
 */
class AmministratoreTest {

	
	/**
	 * Test method for {@link uCOM.Amministratore#Amministratore(java.lang.String)}.
	 */
	@Test
	void testAmministratore() {
		Amministratore a = new Amministratore("francesco");
	
		assertTrue(a.getUsername().compareTo("francesco") == 0);
		assertEquals(Ruolo.AMMINISTRATORE, a.getRuolo());
	}

	/**
	 * Test method for {@link uCOM.Amministratore#inviaAvviso(uCOM.Avviso)}.
	 */
	@Test
	void testInviaAvviso() {
		Avviso avv = new Avviso("prova", "test");
		Amministratore a = new Amministratore("francesco");
		assertEquals(Status.SUCCESS, a.inviaAvviso(avv));
	}
	
	void testCreaCorso()
	{
		Corso c = new Corso("ML", "TEST c");
		Amministratore a = new Amministratore("francesco");
		assertEquals(Status.SUCCESS, a.creaCorso(c));
		
	}

}
