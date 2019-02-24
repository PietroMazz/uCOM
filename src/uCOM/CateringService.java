package uCOM;

import util.Status;

/**
 * @author Pietro
 *
 */
public interface CateringService {
	public Menu indicaTipoPrenotazione(TipoPrenotazione tp);
	public Status elaboraPrenotazione(PrenotazionePasto pp);

}
