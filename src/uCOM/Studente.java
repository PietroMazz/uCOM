package uCOM;

import ui.InputConsoleUI;
import ui.InputSwingUI;
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
	private PrenotazionePasto prenotazioneInCorso; 
	
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
	 * @return esito operazione
	 */
	public Status inviaComunicazione(Comunicazione c)
	{
		return sistema.elaboraComunicazione(comunicazioneInCorso);	
		
	}
	
	/**
	 * Crea comunicazione con Input utente
	 * @return restituisce comunicazione
	 */
	public Comunicazione creaComunicazione()
	{		
		String oggetto 	= InputConsoleUI.inserisciStringa(Nomi.OGGETTO);
		String corpo 	= InputConsoleUI.inserisciStringa(Nomi.CORPO);
		
		return new Comunicazione(oggetto, corpo);		
	}
	
	/**
	 * Avvia l'operazione per aggiungere una Prenotazione Pasto al Sistema
	 */
	public void avviaPrenotazionePasto()
	{
		TipoPrenotazione tp = InputSwingUI.inserisciTipoPrenotazione();
		Menu menu = indicaTipoPrenotazione(tp);
		
		System.out.println("\n\n"+menu);
		
		prenotazioneInCorso  = creaPrenotazionePasto(menu, tp);
		
		Status result = elaboraPrenotazionePasto(prenotazioneInCorso);
		
		if(result == Status.SUCCESS) NotifyConsoleUI.notificaSuccesso();
		else NotifyConsoleUI.notificaErrore("Impossibile elaborare prenotazione");
			
		// cleanup
		prenotazioneInCorso = null;		
	}
	
	/**
	 * @param 
	 * @return
	 */
	public Status elaboraPrenotazionePasto(PrenotazionePasto pp) {
		return sistema.elaboraPrenotazionePasto(pp);
	}

	/**
	 * Richiede input per creare una PrenotazionePasto
	 */
	private PrenotazionePasto creaPrenotazionePasto(Menu m, TipoPrenotazione tp) {
		boolean loop = true;
		
		String sPrimo = new String();
		String sSecondo = new String();
		
		while(loop)
		{
			try {
			Integer primo = InputConsoleUI.inserisciIntero(1, 2);
			sPrimo = m.get(primo);
			if(sPrimo == null) throw new Exception();
			loop = false;
			} catch(Exception e) {
				NotifyConsoleUI.notificaErrore();
			}
		}
		
		loop = true;
		
		while(loop)
		{
			try {
				Integer secondo = InputConsoleUI.inserisciIntero(3, 4);
				sSecondo = m.get(secondo);
				if(sSecondo == null) throw new Exception();
				loop = false;
			} catch(Exception e) {
				NotifyConsoleUI.notificaErrore();
			}
		}
		
		Pasto p = new Pasto(sPrimo, sSecondo);
		
		return new PrenotazionePasto(tp, p);
	}

	/**
	 * Richiede al Sistema il menù offerto dal servizio mensa, per il tipo di prenotazione dato
	 * @param tp
	 */
	public Menu indicaTipoPrenotazione(TipoPrenotazione tp) {
		return sistema.indicaTipoPrenotazione(tp);
	}

	@Override
	public boolean scegliOperazione()
	{
		if(!super.scegliOperazione())
		{
			Integer scelta;
			do {
				scelta = InputConsoleUI.inserisciIntero(0,2);
				switch(scelta)
				{
				case 0:
					return true;
				case 1:
					avviaComunicazione();
					break;
				case 2:
					avviaPrenotazionePasto();
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
