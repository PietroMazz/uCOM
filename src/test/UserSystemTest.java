package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.AdminService;
import uCOM.Ruolo;
import uCOM.StudentService;
import uCOM.SysAdminService;
import uCOM.UserSystem;

/**
 * @author Pietro
 *
 */
class UserSystemTest {

	private UserSystem userSystem;
	
	@BeforeEach
	void startup()
	{
		userSystem = new UserSystem();
	}
	
	@Test
	void statePatternTest() {
		userSystem.avviaServizi(Ruolo.STUDENTE);
		assertTrue(userSystem.getServizio() instanceof StudentService);
		userSystem.avviaServizi(Ruolo.AMMINISTRATORE);
		assertTrue(userSystem.getServizio() instanceof AdminService);
		userSystem.avviaServizi(Ruolo.SYSTEMADMIN);
		assertTrue(userSystem.getServizio() instanceof SysAdminService);
	}
	
	@Test
	void logout()
	{
		userSystem.avviaServizi(Ruolo.STUDENTE);
		assertTrue(userSystem.getServizio() instanceof StudentService);
		userSystem.logout();
		assertEquals(null, userSystem.getServizio());
	}

}
