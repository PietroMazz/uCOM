package uCOM;

/**
 * Classe del main, che avvia il software
 * 
 * @author Pietro
 * 
 */
public class uCOM {

		
	public static void main(String[] args)
	{
		// Start & login
		Utente user = Sistema.getIstanza().login();
		
		// Avvio servizi
		Sistema.getIstanza().avviaServizi(user.getRuolo());

		// Operazioni fino alla chiusura dell'App
		while(true)
		{
			user.scegliOperazione();	
		}
	}
	
	
}
