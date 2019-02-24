package uCOM;

import ui.InputConsoleUI;
import ui.NotifyConsoleUI;
import util.Nomi;
import util.Status;

/**
 * @author Pietro
 *
 */
public class Studente extends Utente {
	
	private final 	Ruolo 	ruolo	= Ruolo.STUDENTE;
	private 		Sistema	sistema = Sistema.getIstanza();

	private 		String 	username;
	
	
	private Comunicazione comunicazioneInCorso; 
	
	public Studente(String user)
	{
		username 	= user;
	}
	
	/**
	 * Inizia l'operazione per inviare una comunicazione
	 */
	public void avviaComunicazione()
	{
		comunicazioneInCorso = creaComunicazione();
		Status result 		 = inviaComunicazione(comunicazioneInCorso);	
		
		if(result == Status.SUCCESS) NotifyConsoleUI.notificaSuccesso();
		else NotifyConsoleUI.notificaErrore("Impossibile inviare comunicazione");
			
		// cleanup
		comunicazioneInCorso = null;		
	}
	
	/**
	 * Invia la comunicazione al Sistema
	 */
	public Status inviaComunicazione(Comunicazione c)
	{
		return sistema.elaboraComunicazione(comunicazioneInCorso);	
		
	}
	
	public Comunicazione creaComunicazione()
	{		
		String oggetto 	= InputConsoleUI.inserisciStringa(Nomi.OGGETTO);
		String corpo 	= InputConsoleUI.inserisciStringa(Nomi.CORPO);
		
		return new Comunicazione(oggetto, corpo);		
	}
	
	@Override
	public boolean scegliOperazione()
	{
		if(!super.scegliOperazione())
		{
			Integer scelta;
			do {
				scelta = InputConsoleUI.inserisciIntero(0,1);
				switch(scelta)
				{
				case 0:
					return true;
				case 1:
					avviaComunicazione();
					break;
				default:
					continue;
				}
				sistema.mostraMenu();
			} while(true);
		}
		return true;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Comunicazione getComunicazioneInCorso() {
		return comunicazioneInCorso;
	}

	public void setComunicazioneInCorso(Comunicazione comunicazioneInCorso) {
		this.comunicazioneInCorso = comunicazioneInCorso;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}
	
	
	
}
