package uCOM;

/**
 * @author Pietro
 *
 */
public class PrenotazionePasto {
	
	private TipoPrenotazione tipo;
	private Pasto			 pasto;
	/**
	 * @param tp
	 * @param p
	 */
	public PrenotazionePasto(TipoPrenotazione tp, Pasto p) {
		tipo = tp;
		pasto = p;
	}
}
