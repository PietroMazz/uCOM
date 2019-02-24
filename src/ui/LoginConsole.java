package ui;

import uCOM.DatiLogin;
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
	public DatiLogin richiediDatiLogin() {
		String username = InputConsoleUI.inserisciStringa(Nomi.USERNAME);
		String password = InputConsoleUI.inserisciStringa(Nomi.PASSWORD);
		return new DatiLogin(username, password);
	}

}
