package uCOM;

import ui.InputConsoleUI;
import ui.NotifyConsoleUI;
import util.Nomi;
import util.Status;

/**
 * @author Pietro
 *
 */
public class SystemAdmin extends Utente {
	
	private final 	Ruolo 	ruolo = Ruolo.SYSTEMADMIN;
	private 		Sistema	sistema = Sistema.getIstanza();
	
	private 		String 	username;

	public SystemAdmin(String user)
	{
		username 	= user;
	}

	
	public void aggiungiUtente()
	{
		DatiUtente datiUtente = inserisciDatiUtente();
		Status s = creaUtente(datiUtente);
		
		if(s == Status.SUCCESS) NotifyConsoleUI.notificaSuccesso();
		else NotifyConsoleUI.notificaErrore("Impossibile aggiungere utente");
	}

	/**
	 * 
	 * @return
	 */
	private DatiUtente inserisciDatiUtente() {
		String username = InputConsoleUI.inserisciStringa(Nomi.USERNAME);
		Ruolo  ruolo 	= InputConsoleUI.inserisciRuolo();
		DatiUtente du	= new DatiUtente(username, ruolo);
		return du;
	}
	
	private Status creaUtente(DatiUtente du)
	{
		return sistema.creaUtente(du);
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
					aggiungiUtente();
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


	public Ruolo getRuolo() {
		return ruolo;
	}
	
	
	
}
