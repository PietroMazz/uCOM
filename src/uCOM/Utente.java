package uCOM;

/**
 * Classe astratta che definisce Utenti
 * @author Pietro
 *
 */
public abstract class Utente {
	private String 	username;
	private Ruolo 	ruolo;
	private Sistema sistema;
	
	public abstract void scegliOperazione();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Ruolo getRuolo() {
		return ruolo;
	}
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
}
