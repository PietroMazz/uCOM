package uCOM;

import util.ExitException;

/**
 * @author Pietro
 */
public class uCOM {

		
	/**
	 * Metodo main del programma
	 * @param args
	 */
	public static void main(String[] args)
	{		
		try
		{
			Sistema s = Sistema.getIstanza();
			
			s.startup();
			
			while(true)
			{
				// Start & login
				Utente user = s.login();		
				
				// Operazioni fino alla chiusura dell'App
				if(user != null) user.scegliOperazione();	
				
				// Logout
				s.logout();
			}			
		}
		catch (ExitException e)
		{
			System.exit(0);
		}
	}
	
	
}
