package ui;

/**
 * @author Pietro
 *
 */
public class Notifier {
	
	private static NotifyUI ui = new NotifyConsoleUI();
	
	public static void notificaErrore()
	{
		ui.notificaErrore();
	}
	
	public static void notificaErrore(String msg)
	{
		ui.notificaErrore(msg);
	}
	
	public static void notificaSuccesso()
	{
		ui.notificaSuccesso();
	}
	
	public static void notificaSuccesso(String msg) {
		ui.notificaSuccesso(msg);
	}

}
