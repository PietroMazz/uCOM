package uCOM;

import ui.LoginSwing;
import ui.LoginUI;
import ui.NotifyConsoleUI;
import util.ExitException;
import util.Status;

/**
 * @author Pietro
 *
 */
public class LoginSystem {
	
	private RegistroUtenti	registroUtenti;
	private LoginUI 		loginUI;
	
	public LoginSystem() {
		loginUI = new LoginSwing();
		registroUtenti = new RegistroUtenti();
	}
	
	/**
	 * Avvia la schermata di login e permette l'inserimento dei dati
	 * @return utente risultante dal login
	 */
	public Utente login () throws ExitException
	{
		DatiLogin 	datiLogin 	= loginUI.richiediDatiLogin();
		
		Ruolo ruoloUtente = verificaCredenziali(datiLogin);
		
		if (ruoloUtente == null) 
		{
			NotifyConsoleUI.notificaErrore("Dati login errati o impossibile accedere al momento");
			return null;
		}
	
		Sistema.getIstanza().avviaServizi(ruoloUtente);
		
		switch(ruoloUtente)
		{
		case AMMINISTRATORE:
			return new Amministratore( datiLogin.getUsername() );
		case SYSTEMADMIN:
			return new SystemAdmin( datiLogin.getUsername() );
		case STUDENTE:
			return new Studente( datiLogin.getUsername() );
		default:
			return null;
		}
		
	}
	
	/**
	 * Verifica le credenziali inserite dall'utente sul registro degli utenti autorizzati
	 * @param dl - dati inseriti dall'utente
	 * @return Restituisce il ruolo dell'utente, in caso di successo altrimenti rilancia un'eccezione
	 */
	public Ruolo verificaCredenziali (DatiLogin dl)
	{
		Boolean wrongPassword = (dl.getPassword().compareTo("test") != 0);
		
		if(wrongPassword) return null;
		
		String user = dl.getUsername();
		Ruolo ruolo = registroUtenti.getRoleForUser(user);
		if(ruolo == null) return null;
		return ruolo;
	}

	/**
	 * Crea utente per il System Admin
	 * @param du
	 */
	public Status creaUtente(DatiUtente du) {
		return registroUtenti.add(du);		
	}

}
