package uCOM;

import ui.InputConsoleUI;
import ui.NotifyConsoleUI;
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
		Status result 		 = inviaAvviso(avvisoInCorso);	
		
		if(result == Status.SUCCESS) NotifyConsoleUI.notificaSuccesso();
		else NotifyConsoleUI.notificaErrore("Impossibile inviare avviso");
	}
	
	public Avviso creaAvviso()
	{
		String titolo 	= InputConsoleUI.inserisciStringa(Nomi.TITOLO);
		String dettagli = InputConsoleUI.inserisciStringa(Nomi.DETTAGLI);
		
		return new Avviso(titolo, dettagli);	
	}
	
	public Status inviaAvviso(Avviso a)
	{
		return sistema.elaboraAvviso(a);
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
					avviaAvviso();
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
