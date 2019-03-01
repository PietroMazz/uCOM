package uCOM;

import java.io.IOException;

import persistence.LocalDatabase;
import util.ExitException;
import util.MessagingException;
import util.Status;

/**
 * SINGLETON
 * Classe che implementa il pattern FACADE per tutti i servizi del sistema uCOM
 *
 * @author Pietro
 *
 */
public class Sistema {

	// FACADE PATTERN
	private LoginSystem 	loginSystem;
	private UserSystem 		userSystem;	
	private MessagingSystem messagingSystem;
	private CateringService cateringService;
		
	// SINGLETON
	private static Sistema istanza;
	
	public static synchronized Sistema getIstanza()
	{
		if ( istanza == null)
		{
			istanza = new Sistema();
		}
		return istanza;
	}
	////////////
		
	/**
	 * Metodo di startup del sistema per utilizzo dei dati in memoria: vengono aggiunti utenti di base
	 */
	public void startup()
	{
		LocalDatabase mysqldb = new LocalDatabase();
		Thread t = new Thread() {
			public void run( ) {
				synchronized(mysqldb)
				{					
					try {
						mysqldb.start();
						mysqldb.notifyAll();
					} catch (IOException | InterruptedException e) {
						e.printStackTrace();
					}	
				}
			}
			
		};
		t.start();
		synchronized(mysqldb)
		{
			try {
				mysqldb.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}			
		}
		
		loginSystem 	= new LoginSystem();
		userSystem 		= new UserSystem();
		messagingSystem = new MessagingSystem();
		cateringService = new FakeCateringAdapter();
		
		
		DatiUtente sysadmin = new DatiUtente("sysadmin", 	Ruolo.SYSTEMADMIN);
		DatiUtente admin 	= new DatiUtente("admin", 		Ruolo.AMMINISTRATORE);
		DatiUtente studente = new DatiUtente("student",		Ruolo.STUDENTE);
		loginSystem.creaUtente(sysadmin);
		loginSystem.creaUtente(admin);
		loginSystem.creaUtente(studente);
	}
				
		
	/**
	 * Avvia il sistema, richiedendo l'autenticazione dell'utente
	 * @return utente istanziato dal login
	 * @throws ExitException
	 */
	public Utente login() throws ExitException
	{
		Utente u = loginSystem.login();
		return u;
	}
	
	/**
	 * Avvia servizi per l'utente
	 * @param ruoloUtente i servizi di sistema vengono avviati sulla base dell'utente utilizzatore della piattaforma
	 */
	public void avviaServizi(Ruolo ruoloUtente)
	{
		userSystem.avviaServizi(ruoloUtente);
	}
	
	/**
	 * @return restituisce vero se l'interfaccia è di tipo grafico, falso se l'interfaccia è a riga di comando
	 */
	public boolean mostraMenu()
	{
		return userSystem.mostraMenu();
	}
	
	/**
	 * Effettua il logout: viene eliminata il parameto relativo al pattern Strategy dell'userSystem
	 * TODO : aggiungere logout per gli altri sistemi, anche se vuoto
	 */
	public void logout() {
		userSystem.logout();	
	}
	
	//##################### CASI D'USO ##########################

	/**
	 * UC1: Ricevuto il tipo di prenotazione dall'utente, lo indica al servizio mensa
	 * @param tp Tipo di prenotazione pasto
	 * @return Restituisce il menù che viene fornito dal servizio mensa
	 */
	public Menu indicaTipoPrenotazione(TipoPrenotazione tp) {
		return cateringService.indicaTipoPrenotazione(tp);
	}

	/**
	 * UC1: Riceve la prenotazione pasto dallo Studente e la gira al servizio mensa 
	 * @param pp prenotazione pasto
	 * @return esito operazione
	 */
	public Status elaboraPrenotazionePasto(PrenotazionePasto pp) {
		return cateringService.elaboraPrenotazione(pp);
	}
	
	/**
	 * UC4: Processa la Comunicazione che lo Studente sta inviando
	 * @param c comunicazione da inviare
	 * @return esito elaborazione
	 */
	public Status elaboraComunicazione(Comunicazione c)
	{
		try {			
			messagingSystem.elaboraComunicazione(c);
		} catch(MessagingException e)
		{
			return Status.FAIL;
		}
		return Status.SUCCESS;
	}
	
	/**
	 * UC5: Viene creato il corso su indicazione dell'Amministratore
	 * @param c corso da creare
	 * @return esito operazione
	 */
	public Status creaCorso(Corso c) {
		return userSystem.creaCorso(c);
	}
	
	/**
	 * UC7: Processa l'avviso che l'Amministratore sta inviando
	 * @param a avviso da elaborare
	 * @return esito elaborazione
	 */
	public Status elaboraAvviso(Avviso a)
	{
		try {			
			messagingSystem.elaboraAvviso(a);
		} catch(Exception e)
		{
			return Status.FAIL;
		}
		return Status.SUCCESS;
	}
		
	/**
	 * UC8: Crea utente per il SystemAdmin
	 * @param du dati utente da creare
	 * @return esito operazione
	 */
	public Status creaUtente(DatiUtente du) {
		return loginSystem.creaUtente(du);		
	}
}
