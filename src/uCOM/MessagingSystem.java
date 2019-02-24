package uCOM;

import util.Status;

/**
 * @author Pietro
 *
 */
public class MessagingSystem {
	
	public Status elaboraComunicazione( Comunicazione c ) throws Exception
	{
		Boolean oggettoVuoto = c.getOggetto().compareTo("") == 0;
		if(oggettoVuoto) throw new Exception("Oggetto comunicazione vuoto");
		Boolean corpoVuoto = c.getCorpo().compareTo("") == 0;
		if(corpoVuoto) throw new Exception("Corpo comunicazione vuoto");
		return Status.SUCCESS;
	}
	
	public Status elaboraAvviso( Avviso a ) throws Exception
	{
		Boolean titoloVuoto = a.getTitolo().compareTo("") == 0;
		if(titoloVuoto) throw new Exception("Titolo avviso vuoto");
		Boolean dettagliVuoto = a.getDettagli().compareTo("") == 0;
		if(dettagliVuoto) throw new Exception("Dettagli avviso vuoto");
		return Status.SUCCESS;
	}
	
}
