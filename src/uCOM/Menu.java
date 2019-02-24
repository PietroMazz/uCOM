package uCOM;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author Pietro
 *
 */
public class Menu {
	
	private Map<Integer, String> menu;
	private Integer autoIncrement;
	
	public Menu(String [] s)
	{
		autoIncrement = 1;
		menu = new Hashtable<Integer, String>();
		for(String pietanza: s)
		{
			menu.put(autoIncrement, pietanza);
			autoIncrement++;
		}
	}
	
	public String toString()
	{
		Iterator<Entry<Integer, String>> it = menu.entrySet().iterator();
		String s = new String("Menù\n");
		while(it.hasNext())		
		{
			Map.Entry pair = (Map.Entry)it.next();
	        s = s.concat(pair.getKey() + ") " + pair.getValue()+"\n");
		}
		return s;
	}

	/**
	 * @return
	 */
	public String[] getAsArray() {
		return (String [])menu.values().toArray();
	}

	/**
	 * 
	 */
	public String get(Integer i) {
		return menu.get(i);
	}

}
