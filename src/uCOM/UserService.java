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
	 * Mostra il men� adeguato per l'utente
	 * @return true se l'interfaccia � di tipo grafico, false se l'interfaccia � a linea di comando
	 */
	public boolean mostraMenu();
	

}
