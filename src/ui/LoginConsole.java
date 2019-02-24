package ui;

import uCOM.DatiLogin;
import util.ExitException;
import util.Nomi;

/**
 * @author Pietro
 *
 */
public class LoginConsole implements LoginUI {


	/* (non-Javadoc)
	 * @see uCOM.LoginUI#richiediDatiLogin()
	 */
	@Override
	public DatiLogin richiediDatiLogin() throws ExitException {
		String username = InputConsoleUI.inserisciStringa(Nomi.USERNAME);
		String password = InputConsoleUI.inserisciStringa(Nomi.PASSWORD);
		
		boolean emptyUser = username.compareTo("") == 0;
		boolean emptyPswd = password.compareTo("") == 0;
		
		if(emptyUser && emptyPswd)
			throw new ExitException("Empty fields forced exit");
			
		
		
		return new DatiLogin(username, password);
	}

}
