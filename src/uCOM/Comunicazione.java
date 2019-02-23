package uCOM;

/**
 * @author Pietro
 *
 */
public class Comunicazione {
	private String oggetto;
	private String corpo;
	
	public Comunicazione(String oggetto, String corpo) {
		super();
		this.oggetto 	= oggetto;
		this.corpo 		= corpo;
	}
	
	public String toString()
	{
		String s = new String("Oggetto: " + oggetto +"\n");
		s.concat(corpo);
		return s;
	}
}
