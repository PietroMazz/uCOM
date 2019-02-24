package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.Avviso;
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
	void testElaboraComunicazione() throws Exception {
		Comunicazione c = new Comunicazione("Oggetto", "Corpo");
		
		Status test = messagingTest.elaboraComunicazione(c);
		
		assertEquals(Status.SUCCESS, test);
	}
	
	@Test
	void testOggettoVuoto()
	{
		Comunicazione c = new Comunicazione("", "a");
		
		try {
			messagingTest.elaboraComunicazione(c);			
		} catch(Exception e)
		{
			return;
		}
		
		fail("Expected OggettoVuoto exception to be thrown");
	}
	
	@Test
	void testCorpoVuoto()
	{
		Comunicazione c = new Comunicazione("a", "");
		
		try {
			messagingTest.elaboraComunicazione(c);			
		} catch(Exception e)
		{
			return;
		}
		
		fail("Expected CorpoVuoto exception to be thrown");
		
		
	}
	
	@Test
	void testElaboraAvviso() throws Exception{
		Avviso a = new Avviso("Titolo", "Dettagli");
		
		Status test = messagingTest.elaboraAvviso(a);
		
		assertEquals(Status.SUCCESS, test);
	}
	
	@Test
	void testTitoloVuoto()
	{
		Avviso a = new Avviso("", "b");
		
		try {
			messagingTest.elaboraAvviso(a);			
		} catch(Exception e)
		{
			return;
		}
		
		fail("Expected TitoloVuoto exception to be thrown");
		
		
	}
	
	@Test
	void testDettagliVuoto()
	{
		Avviso a = new Avviso("b", "");
		
		try {
			messagingTest.elaboraAvviso(a);			
		} catch(Exception e)
		{
			return;
		}
		
		fail("Expected DettagliVuoto exception to be thrown");
		
		
	}

}
