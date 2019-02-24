package uCOM;

/**
 * @author Pietro
 *
 */
public class UserSystem {
	
	private UserService servizio;
	
	/**
	 * Crea l'istanza del servizio sulla base dell'utente e lo avvia
	 * @param ruoloUtente
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
	
	public boolean mostraMenu() {
		return servizio.mostraMenu();
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
