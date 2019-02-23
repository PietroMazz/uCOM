package uCOM;

import ui.LoginConsole;
import ui.LoginUI;

/**
 * @author Pietro
 *
 */
public class LoginSystem {
	
	private LoginUI loginUI;
	
	public LoginSystem() {
		loginUI = new LoginConsole();
	}
	
	/**
	 * Avvia la schermata di login e permette l'inserimento dei dati
	 * @return utente risultante dal login
	 */
	public Utente login()
	{
		DatiLogin 	datiLogin 	= loginUI.richiediDatiLogin();
		
		Ruolo ruoloUtente = verificaCredenziali(datiLogin);
		
		Sistema.getIstanza().avviaServizi(ruoloUtente);
		
		return new Studente( datiLogin.getUsername() );
	}
	
	/**
	 * Verifica le credenziali inserite dall'utente sul registro degli utenti autorizzati
	 * @param dl - dati inseriti dall'utente
	 * @return Restituisce il ruolo dell'utente, in caso di successo altrimenti rilancia un'eccezione
	 */
	public Ruolo verificaCredenziali (DatiLogin dl)
	{
		return Ruolo.STUDENTE;
	}

}
