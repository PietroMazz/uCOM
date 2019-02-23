package ui;

import java.util.Scanner;

/**
 * @author Pietro
 *
 */
public class ComunicazioneConsoleInput implements ComunicazioneInput {

	private Scanner scanner = new Scanner(System.in);

	public String inserisciOggetto()
	{
		System.out.println("Inserisci oggetto:");
		String o = scanner.nextLine();
		return o;
	}
	public String inserisciCorpo()
	{
		System.out.println("Inserisci corpo:");
		String c = scanner.nextLine();
		return c;
	}
}
