package uCOM;

import ui.InputConsoleUI;
import ui.InputSwingUI;
import ui.Notifier;
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
	
	/**
	 * UC8: Inizia l'operazione di aggiunta utente
	 */
	public void aggiungiUtente()
	{
		DatiUtente datiUtente = inserisciDatiUtente();
		Status s = creaUtente(datiUtente);
		
		if(s == Status.SUCCESS) Notifier.notificaSuccesso();
		else Notifier.notificaErrore("Impossibile aggiungere utente");
	}

	/**
	 * UC8: Inserimento dati utente
	 * @return dati utente inseriti
	 */
	private DatiUtente inserisciDatiUtente() {
		String username = InputConsoleUI.inserisciStringa(Nomi.USERNAME);
		Ruolo  ruolo 	= InputSwingUI.inserisciRuolo();
		DatiUtente du	= new DatiUtente(username, ruolo);
		return du;
	}
	
	/**
	 * UC8: Indica al sistema di creare un utente
	 * @param du dati utente da creare
	 * @return esito operazione
	 */
	public Status creaUtente(DatiUtente du)
	{
		return sistema.creaUtente(du);
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
