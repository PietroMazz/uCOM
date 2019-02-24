package uCOM;

import ui.MenuConsole;
import ui.MenuUI;

/**
 * @author Pietro
 *
 */
public class StudentService implements UserService {
		
	private MenuUI menuUI = new MenuConsole(); 
	
	public void start()
	{
	}
	
	public boolean mostraMenu()
	{
		if (!menuUI.mostraMenu())
		{
			System.out.println("1. Invia comunicazione.");
			System.out.println("2. Prenota pasto.");
			System.out.println("0. Termina.");
			return false;
		}
		return true;
	}
	
	
	
	
}
