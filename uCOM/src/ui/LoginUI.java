package ui;

import uCOM.DatiLogin;

/**
 * @author Pietro
 *
 */
public interface LoginUI {

	/**
	 * Richiede all'utente l'inserimento dei dati per il login
	 * @return dati per il login
	 */
	public DatiLogin richiediDatiLogin();
	
}
