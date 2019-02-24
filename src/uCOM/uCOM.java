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
		Sistema s = Sistema.getIstanza();
		
		s.startup();
		
		while(true)
		{
			// Start & login
			Utente user = s.login();		
			
			// Operazioni fino alla chiusura dell'App
			if(user != null) user.scegliOperazione();	
			
			s.logout();
		}
	}
	
	
}
