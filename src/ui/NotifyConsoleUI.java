package ui;

/**
 * @author Pietro
 *
 */
public class NotifyConsoleUI implements NotifyUI
{
	public void notificaErrore()
	{
		System.out.println("Sono stati rilevati errori. Riprova.");
	}
	
	public void notificaErrore(String msg)
	{
		System.out.println("Errore: "+ msg + ". Riprova.");
	}
	
	public void notificaSuccesso()
	{
		System.out.println("Operazione avvenuta con successo.");
	}
	
	public void notificaSuccesso(String msg)
	{
		System.out.println(msg);
	}

}
