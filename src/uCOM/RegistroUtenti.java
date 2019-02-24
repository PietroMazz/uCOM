package uCOM;

import java.util.Hashtable;
import java.util.Map;

import util.Status;

/**
 * @author Pietro
 *
 */
public class RegistroUtenti {
	
	private Map<String, DatiUtente> registro;
	
	public RegistroUtenti()
	{
		registro = new Hashtable<String, DatiUtente>();
	}
	
	/**
	 * 
	 * @param du Dati utente
	 * @return Status: SUCCESS/FAIL
	 */
	public Status add(DatiUtente du)
	{
		String user = du.getUsername();
		Boolean alreadyPresent = (registro.get(user) != null);
		
		if (alreadyPresent) return Status.FAIL;	
		
		registro.put(user, du);
		return Status.SUCCESS;
	}

	/**
	 * @param user
	 */
	public Ruolo getRoleForUser(String user) {
		DatiUtente 	du 	= registro.get(user);
		if(du == null) return null;
		Ruolo 		r 	= du.getRuolo();
		return r;
	}

}
