package uCOM;

import util.Status;

/**
 * @author Pietro
 *
 */
public class FakeCateringAdapter extends FakeCatering implements CateringService {

	// ADAPTER PATTERN
	
	/* (non-Javadoc)
	 * @see uCOM.CateringService#indicaTipoPrenotazione(uCOM.TipoPrenotazione)
	 */
	@Override
	public Menu indicaTipoPrenotazione(TipoPrenotazione tp) {
		Menu m = new Menu(getMenu());
		return m;
	}

	/* (non-Javadoc)
	 * @see uCOM.CateringService#elaboraPrenotazione(uCOM.PrenotazionePasto)
	 */
	@Override
	public Status elaboraPrenotazione(PrenotazionePasto pp) {
		return sendMealBooking();
	}

}
