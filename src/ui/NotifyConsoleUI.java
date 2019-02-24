package ui;

/**
 * @author Pietro
 *
 */
public class NotifyConsoleUI 
{
	public static void notificaErrore()
	{
		System.out.println("Sono stati rilevati errori. Riprova.");
	}
	
	public static void notificaErrore(String msg)
	{
		System.out.println("Errore: "+ msg + ". Riprova.");
	}
	
	public static void notificaSuccesso()
	{
		System.out.println("Operazione avvenuta con successo.");
	}

}
