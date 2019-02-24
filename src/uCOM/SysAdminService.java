package uCOM;

import ui.MenuConsole;
import ui.MenuUI;

/**
 * @author Pietro
 *
 */
public class SysAdminService implements UserService {

	
	private MenuUI menuUI = new MenuConsole(); 
	
	/* (non-Javadoc)
	 * @see uCOM.UserService#start()
	 */
	@Override
	public void start()
	{
	}
	
	/* (non-Javadoc)
	 * @see uCOM.UserService#mostraMenu()
	 */
	public boolean mostraMenu()
	{
		if (!menuUI.mostraMenu())
		{
			System.out.println("1. Aggiungi utente.");
			System.out.println("0. Termina.");
			return false;
		}
		return true;
	}

}
