package uCOM;

import ui.ComunicazioneConsoleInput;
import ui.ComunicazioneInput;
import util.Status;

/**
 * @author Pietro
 *
 */
public class Studente extends Utente {
	
	private final 	Ruolo 	ruolo = Ruolo.STUDENTE;
	
	private 		String 	username;
	private 		Sistema	sistema;
	
	private Comunicazione comunicazioneInCorso; 
	
	public Studente(String user)
	{
		this.username 	= user;
		this.sistema 	= Sistema.getIstanza();
	}
	
	/**
	 * L'utente seleziona l'operazione da eseguire
	 */
	public void scegliOperazione()
	{
		avviaComunicazione();
	}
	

	/**
	 * Inizia l'operazione per inviare una comunicazione
	 */
	public void avviaComunicazione()
	{
		creaComunicazione();
		Status result = inviaComunicazione(comunicazioneInCorso);	
		
		// TODO : DA RIVEDERE ASSOLUTAMENTE
		if(result == Status.SUCCESS)
		{
			System.out.println("Successo");
			// cleanup
			comunicazioneInCorso = null;		
		}
		
	}
	
	/**
	 * Invia la comunicazione al Sistema
	 */
	public Status inviaComunicazione(Comunicazione c)
	{
		return sistema.inviaComunicazione(comunicazioneInCorso);	
		
	}
	
	public void creaComunicazione()
	{
		// TODO: da rivedere
		ComunicazioneInput ci = new ComunicazioneConsoleInput();
		
		String oggetto 	= ci.inserisciOggetto();
		String corpo 	= ci.inserisciCorpo();
		
		comunicazioneInCorso = new Comunicazione(oggetto, corpo);		
	}
	
}
