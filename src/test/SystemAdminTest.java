package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uCOM.DatiUtente;
import uCOM.Ruolo;
import uCOM.SystemAdmin;
import util.Status;

/**
 * @author Pietro
 *
 */
class SystemAdminTest {

	/**
	 * Test method for {@link uCOM.SystemAdmin#SystemAdmin(java.lang.String)}.
	 */
	@Test
	void testSystemAdmin() {
		SystemAdmin saTest = new SystemAdmin("pippo");
		assertTrue(saTest.getUsername().compareTo("pippo") == 0);
		assertEquals(Ruolo.SYSTEMADMIN, saTest.getRuolo());
	}
	
	@Test
	void testCreaUtente()
	{
		SystemAdmin saTest = new SystemAdmin("pippo");
		DatiUtente duTest = new DatiUtente("pluto", Ruolo.STUDENTE);
		assertEquals(Status.SUCCESS, saTest.creaUtente(duTest) );	
	}

}
