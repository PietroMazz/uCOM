package test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import uCOM.Menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uCOM.FakeCateringAdapter;
import uCOM.Pasto;
import uCOM.PrenotazionePasto;
import uCOM.TipoPrenotazione;
import util.Status;

/**
 * @author Pietro
 *
 */
class FakeCateringAdapterTest {

	private FakeCateringAdapter fcaTest;
	
	@BeforeEach
	void startup()
	{
		fcaTest = new FakeCateringAdapter();
	}
	
	/**
	 * Test method for {@link uCOM.FakeCateringAdapter#indicaTipoPrenotazione(uCOM.TipoPrenotazione)}.
	 */
	@Test
	void testIndicaTipoPrenotazione() {
		assertTrue(fcaTest.indicaTipoPrenotazione(TipoPrenotazione.PRANZO) instanceof Menu);
		assertTrue(fcaTest.indicaTipoPrenotazione(TipoPrenotazione.CENA) instanceof Menu);
	}

	/**
	 * Test method for {@link uCOM.FakeCateringAdapter#elaboraPrenotazione(uCOM.PrenotazionePasto)}.
	 */
	@Test
	void testElaboraPrenotazione() {
		Pasto p = new Pasto("Primo", "Secondo");
		PrenotazionePasto pp = new PrenotazionePasto(TipoPrenotazione.CENA, p);
		
		assertEquals(Status.SUCCESS, fcaTest.elaboraPrenotazione(pp));		
	}

}
