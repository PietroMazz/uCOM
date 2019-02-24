package uCOM;

/**
 * @author Pietro
 *
 */
public class DatiUtente {
	
	private	String	username;
	private	Ruolo	ruolo;
	
	public DatiUtente(String username, Ruolo ruolo) {
		super();
		this.username = username;
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
