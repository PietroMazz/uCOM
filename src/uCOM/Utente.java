package uCOM;

/**
 * Classe astratta che definisce Utenti
 * @author Pietro
 *
 */
public abstract class Utente {
	private	 String 	username;
	private  Ruolo 		ruolo;
	private	 Sistema 	sistema = Sistema.getIstanza();
		
	/**
	 * L'utente seleziona l'operazione da eseguire
	 * @return true se il menù è di tipo grafico, false se il menù è a riga di comando
	 */
	public boolean scegliOperazione()
	{
		return sistema.mostraMenu();
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
	public Sistema getSistema() {
		return sistema;
	}
	public void setSistema(Sistema sistema) {
		this.sistema = sistema;
	}
	
	
}
