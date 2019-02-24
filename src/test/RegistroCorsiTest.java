package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uCOM.Corso;
import uCOM.RegistroCorsi;
import util.Status;

/**
 * @author Pietro
 *
 */
class RegistroCorsiTest {
	
	/**
	 * Test method for {@link uCOM.RegistroCorsi#add(uCOM.Corso)}.
	 */
	@Test
	void testAdd() {
		RegistroCorsi rcTest = new RegistroCorsi();
		Corso c = new Corso("ML", "Test Doppia copia");
		
		assertEquals(Status.SUCCESS, rcTest.add(c));
		assertEquals(Status.FAIL, rcTest.add(c));
	
	}

}
