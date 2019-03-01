package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import uCOM.Comunicazione;
import uCOM.Pasto;
import uCOM.PrenotazionePasto;
import uCOM.Ruolo;
import uCOM.Sistema;
import uCOM.Studente;
import uCOM.TipoPrenotazione;
import util.Status;

/**
 * @author Pietro
 *
 */
class StudenteTest {
	
	/**
	 * Test method for {@link uCOM.Studente#Studente(uCOM.Studente)}.
	 */
	@Test
	void testStudente() {
		Studente sTest = new Studente("prova");
		assertTrue(sTest.getUsername().compareTo("prova") == 0);
		assertEquals(Ruolo.STUDENTE, sTest.getRuolo());
	}

	/**
	 * Test method for {@link uCOM.Studente#inviaComunicazione(uCOM.Comunicazione)}.
	 */
	@Test
	void testInviaComunicazione() {
		Sistema.getIstanza().startup();
		Comunicazione cuTest = new Comunicazione("prova", "test");
		Studente sTest = new Studente("prova");
		assertEquals(Status.SUCCESS, sTest.inviaComunicazione(cuTest));
	}
	/**
	 * Test method for {@link uCOM.Studente#elaboraPrenotazionePasto(uCOM.PrenotazionePasto)}.
	 */
	@Test
	void testElaboraPrenotazione() {
		Sistema.getIstanza().startup();
		Pasto p = new Pasto("primo", "secondo");
		PrenotazionePasto pp = new PrenotazionePasto(TipoPrenotazione.PRANZO, p);
		
		Studente sTest = new Studente("prova");
		assertEquals(Status.SUCCESS, sTest.elaboraPrenotazionePasto(pp));
	}

}
