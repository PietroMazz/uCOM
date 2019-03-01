package uCOM;

import util.MessagingException;
import util.Status;

/**
 * @author Pietro
 */
public class MessagingSystem {
	
	/**
	 * UC4: Elabora comunicazione inviata dallo Studente
	 * @param c comunicazione
	 * @return esito operazione
	 * @throws Exception
	 */
	public Status elaboraComunicazione( Comunicazione c ) throws MessagingException
	{
		Boolean oggettoVuoto = c.getOggetto().compareTo("") == 0;
		if(oggettoVuoto) throw new MessagingException("Oggetto comunicazione vuoto");
		Boolean corpoVuoto = c.getCorpo().compareTo("") == 0;
		if(corpoVuoto) throw new MessagingException("Corpo comunicazione vuoto");
		return Status.SUCCESS;
	}
	
	/**
	 * UC7: Elabora comunicazione inviata dall'Admin
	 * @param a avviso
	 * @return esito operazione
	 * @throws Exception
	 */
	public Status elaboraAvviso( Avviso a ) throws MessagingException
	{
		Boolean titoloVuoto = a.getTitolo().compareTo("") == 0;
		if(titoloVuoto) throw new MessagingException("Titolo avviso vuoto");
		Boolean dettagliVuoto = a.getDettagli().compareTo("") == 0;
		if(dettagliVuoto) throw new MessagingException("Dettagli avviso vuoto");
		return Status.SUCCESS;
	}
	
}
