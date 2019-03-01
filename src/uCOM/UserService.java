package uCOM;

/**
 * @author Pietro
 *
 */
public interface UserService {
	
	/**
	 * Avvia i servizi per l'utente
	 */
	public void start();
	
	/**
	 * Mostra il menù adeguato per l'utente
	 * @return true se l'interfaccia è di tipo grafico, false se l'interfaccia è a linea di comando
	 */
	public boolean mostraMenu();
	

}
