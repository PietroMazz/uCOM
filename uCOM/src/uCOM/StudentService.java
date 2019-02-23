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
		menuUI.mostraMenu();
	}
	
	
	
	
}
