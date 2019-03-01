package uCOM;

import util.Status;

/**
 * @author Pietro
 *
 */
public class UserSystem {
	
	private RegistroCorsi registro;
	private UserService servizio;
	
	/**
	 * 
	 */
	public UserSystem() {
		registro = new RegistroCorsi();
	}
	
	/**
	 * Crea l'istanza del servizio sulla base dell'utente e lo avvia
	 * @param ruoloUtente ruolo dell'utente
	 */
	public void avviaServizi(Ruolo ruoloUtente)
	{
		switch(ruoloUtente) 
		{
			case SYSTEMADMIN:
				servizio = new SysAdminService();
				break;
			case AMMINISTRATORE:
				servizio = new AdminService();
				break;				
			default:
				servizio = new StudentService();
		}
		servizio.start();
	}
	
	/**
	 * Mostra il menù di sistema
	 * @return restituisce true se il menù è di tipo grafico, false se è di tipo a linea di comando
	 */
	public boolean mostraMenu() {
		return servizio.mostraMenu();
	}
	
	/**
	 * UC5: Aggiunge corso al Registro Corsi
	 * @param c
	 * @return
	 */
	public Status creaCorso(Corso c) {
		return registro.add(c);
	}

	/**
	 * Logout: viene smontato il service
	 */
	public void logout() {
		servizio = null;
	}

	public UserService getServizio() {
		return servizio;
	}

	public void setServizio(UserService servizio) {
		this.servizio = servizio;
	}

}
