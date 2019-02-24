package uCOM;

import util.ExitException;
import util.Status;

/**
 * SINGLETON
 * Classe che implementa il pattern FACADE per tutti i servizi del sistema uCOM
 *
 * @author Pietro
 *
 */
public class Sistema {

	private LoginSystem 	loginSystem;
	private UserSystem 		userSystem;	
	private MessagingSystem messagingSystem;
	
	private Sistema()
	{
		loginSystem 	= new LoginSystem();
		userSystem 		= new UserSystem();
		messagingSystem = new MessagingSystem();
	}
	
	// SINGLETON
	private static Sistema istanza;
	
	public static synchronized Sistema getIstanza()
	{
		if ( istanza == null)
		{
			istanza = new Sistema();
		}
		return istanza;
	}
	////////////
		
	/**
	 * Metodo di startup del sistema per utilizzo dei dati in memoria: vengono aggiunti utenti di base
	 */
	public void startup()
	{
		DatiUtente sysadmin = new DatiUtente("sysadmin", 	Ruolo.SYSTEMADMIN);
		DatiUtente admin 	= new DatiUtente("admin", 		Ruolo.AMMINISTRATORE);
		DatiUtente studente = new DatiUtente("student",		Ruolo.STUDENTE);
		loginSystem.creaUtente(sysadmin);
		loginSystem.creaUtente(admin);
		loginSystem.creaUtente(studente);
	}
				
		
	/**
	 * Avvia il sistema, richiedendo l'autenticazione dell'utente
	 * @return utente istanziato dal login
	 */
	public Utente login() throws ExitException
	{
		Utente u = loginSystem.login();
		return u;
	}
	
	/**
	 * Avvia servizi per l'utente
	 */
	public void avviaServizi(Ruolo ruoloUtente)
	{
		userSystem.avviaServizi(ruoloUtente);
	}
	
	/**
	 * Processa la comunicazione da inviare
	 * @param c comunicazione da inviare
	 * @return SUCCESS/FAIL
	 */
	public Status elaboraComunicazione(Comunicazione c)
	{
		try {			
			messagingSystem.elaboraComunicazione(c);
		} catch(Exception e)
		{
			return Status.FAIL;
		}
		return Status.SUCCESS;
	}
	
	public Status elaboraAvviso(Avviso a)
	{
		try {			
			messagingSystem.elaboraAvviso(a);
		} catch(Exception e)
		{
			return Status.FAIL;
		}
		return Status.SUCCESS;
	}
	
	
	public boolean mostraMenu()
	{
		return userSystem.mostraMenu();
	}


	/**
	 * Crea utente per il SystemAdmin
	 * @param du
	 */
	public Status creaUtente(DatiUtente du) {
		return loginSystem.creaUtente(du);		
	}

	/**
	 * 
	 */
	public void logout() {
		userSystem.logout();
		
	}
}
