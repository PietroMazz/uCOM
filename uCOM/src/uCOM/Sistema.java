package uCOM;

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
	 * Avvia il sistema, richiedendo l'autenticazione dell'utente
	 * @return utente istanziato dal login
	 */
	public Utente login()
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
	public Status inviaComunicazione(Comunicazione c)
	{
		return messagingSystem.elaboraComunicazione(c);
	}
}
