package ui;

import java.util.Scanner;

import uCOM.DatiLogin;
import util.Nomi;

/**
 * @author Pietro
 *
 */
public class LoginConsole implements LoginUI {

	private Scanner scanner = new Scanner(System.in);

	/* (non-Javadoc)
	 * @see uCOM.LoginUI#richiediDatiLogin()
	 */
	@Override
	public DatiLogin richiediDatiLogin() {
		String username = this.inserisciUsername();
		String password = this.inserisciPassword();
		return new DatiLogin(username, password);
	}
	
	/**
	 * Richiede inserimento username
	 * @return username 
	 */
	public String inserisciUsername()
	{
		System.out.println(Nomi.USERNAME+":");
		String u = scanner.nextLine();
		return u;
	}
	
	/**
	 * Richiede inserimento password
	 * @return password
	 */
	public String inserisciPassword()
	{
		System.out.println(Nomi.PASSWORD+":");
		String p = scanner.nextLine();
		return p;
	}

}
