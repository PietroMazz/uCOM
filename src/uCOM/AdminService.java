package uCOM;

import ui.MenuConsole;
import ui.MenuUI;

/**
 * @author Pietro
 *
 */
public class AdminService implements UserService {

	private MenuUI menuUI = new MenuConsole(); 
	
	public void start()
	{
	}
	
	public boolean mostraMenu()
	{
		if (!menuUI.mostraMenu())
		{
			System.out.println("1. Invia avviso.");
			System.out.println("2. Aggiungi corso.");
			System.out.println("0. Termina.");
			return false;
		}
		return true;
	}
	
}
