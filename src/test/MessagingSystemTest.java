package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.Comunicazione;
import uCOM.MessagingSystem;
import util.Status;

/**
 * @author Pietro
 *
 */
class MessagingSystemTest {

	private MessagingSystem messagingTest;
	
	@BeforeEach
	void startUp()
	{
		messagingTest = new MessagingSystem();
	}
	
	@Test
	void testElaboraComunicazione() {
		Comunicazione c = new Comunicazione("Oggetto", "Corpo");
		
		Status test = messagingTest.elaboraComunicazione(c);
		
		assertEquals(test, Status.SUCCESS);
	}

}
