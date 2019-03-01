package uCOM;

import ui.InputConsoleUI;
import ui.Notifier;
import util.Nomi;
import util.Status;

/**
 * @author Pietro
 *
 */
public class Amministratore extends Utente {
	
	private final 	Ruolo 	ruolo 	= Ruolo.AMMINISTRATORE;
	private 		Sistema	sistema = Sistema.getIstanza();
	
	private 		String 	username;
	
	private 		Avviso 	avvisoInCorso; 
	
	public Amministratore(String user)
	{
		username 	= user;
	}
	

	/**
	 * Inizia l'operazione di invio di un Avviso
	 */
	public void avviaAvviso()
	{
		avvisoInCorso = creaAvviso();
		Status result = inviaAvviso(avvisoInCorso);	
		
		// Notifica esito operazione
		if(result == Status.SUCCESS) Notifier.notificaSuccesso();
		else Notifier.notificaErrore("Impossibile inviare avviso");
	}
	
	/**
	 * Richiede input per creazione avvis
	 * @return nuovo avviso
	 */
	public Avviso creaAvviso()
	{
		String titolo 	= InputConsoleUI.inserisciStringa(Nomi.TITOLO);
		String dettagli = InputConsoleUI.inserisciStringa(Nomi.DETTAGLI);
		
		return new Avviso(titolo, dettagli);	
	}
	
	/**
	 * Invia l'Avviso a al Sistema 
	 * @param a
	 * @return esito operazione
	 */
	public Status inviaAvviso(Avviso a)
	{
		return sistema.elaboraAvviso(a);
	}
	
	/**
	 * Avvia l'operazione per aggiungere un corso
	 */
	public void aggiungiCorso()
	{
		Corso c = inserisciDatiCorso();
		Status s = creaCorso(c);
		
		if(s == Status.SUCCESS) Notifier.notificaSuccesso();
		else Notifier.notificaErrore("Impossibile aggiungere utente");
	}
	
	/**
	 * Richiede input per creazione corso
	 * @return il corso da creare, ricevuti i dati in input
	 */
	private Corso inserisciDatiCorso() {
		String nome = InputConsoleUI.inserisciStringa(Nomi.CORSO);
		String descrizione = InputConsoleUI.inserisciStringa(Nomi.DESCRIZIONE);
		
		return new Corso(nome, descrizione);
	}
	
	/**
	 * Dice al sistema di creare il corso
	 * @param c corso da creare
	 * @return esito operazione
	 */
	public Status creaCorso(Corso c) {
		return sistema.creaCorso(c);
	}

	/* (non-Javadoc)
	 * @see uCOM.Utente#scegliOperazione()
	 */
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
					avviaAvviso();
					break;
				case 2:
					aggiungiCorso();
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

	public Avviso getAvvisoInCorso() {
		return avvisoInCorso;
	}
	
	public void setAvvisoInCorso(Avviso avvisoInCorso) {
		this.avvisoInCorso = avvisoInCorso;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}
	
	
}
