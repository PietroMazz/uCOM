package uCOM;

import java.util.Hashtable;
import java.util.Map;

import util.Status;

/**
 * @author Pietro
 *
 */
public class RegistroCorsi {

private Map<String, Corso> registro;
	
	public RegistroCorsi()
	{
		registro = new Hashtable<String, Corso>();
	}
	
	/**
	 * 
	 * @param c 
	 * @return Status: SUCCESS/FAIL
	 */
	public Status add(Corso c)
	{
		String nome = c.getNome();
		Boolean alreadyPresent = (registro.get(nome) != null);
		
		if (alreadyPresent) return Status.FAIL;	
		
		registro.put(nome, c);
		return Status.SUCCESS;
	}

	
}
