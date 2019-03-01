package uCOM;

/**
 * @author Pietro
 *
 */
public class PrenotazionePasto {
	
	@SuppressWarnings("unused")
	private TipoPrenotazione tipo;
	@SuppressWarnings("unused")
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
