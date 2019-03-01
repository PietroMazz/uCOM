package uCOM;

import util.Status;

/**
 * @author Pietro
 *
 */
public interface CateringService {
	/**
	 * Indica il tipo di prenotazione al servizio mensa integrato
	 * @param tp Tipo prenotazione indicata
	 * @return Menù da fornire all'utilizzatore
	 */
	public Menu indicaTipoPrenotazione(TipoPrenotazione tp);
	
	/**
	 * Riceve una prenotazione dal sistema e la inoltra al servizio mensa integrato
	 * @param pp Pasto da prenotare
	 * @return esito operazione
	 */
	public Status elaboraPrenotazione(PrenotazionePasto pp);

}
