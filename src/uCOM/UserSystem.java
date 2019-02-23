package uCOM;

/**
 * @author Pietro
 *
 */
public class UserSystem {
	
	private UserService servizio;
	
	/**
	 * Crea l'istanza del servizio sulla base dell'utente e lo avvia
	 * @param ruoloUtente
	 */
	public void avviaServizi(Ruolo ruoloUtente)
	{
		servizio = new StudentService();
		servizio.start();
	}

}
