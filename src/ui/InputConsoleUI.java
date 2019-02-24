package ui;

import java.util.Scanner;

import uCOM.Ruolo;

/**
 * @author Pietro
 *
 */
public class InputConsoleUI {

	private static Scanner scanner = new Scanner(System.in);
	
	public static String inserisciStringa(String msg) {
		System.out.println("Inserisci " + msg +":");
		String s = scanner.nextLine();
		return s;
	}
	
	public static Integer inserisciIntero() {
		Integer i = -1;
		while(true) {
				System.out.println("Inserisci intero:");
			try {
				i = scanner.nextInt();			
				break;
			} catch(Exception e){
				scanner.nextLine();
				System.out.println("Si prega di inserire un intero. Riprova.");
			}
		}
		// removing next line...
		scanner.nextLine();
		return i;
	}
	
	
	public static Integer inserisciIntero(int min, int max) {
		Integer i = -1;
		while(true) {
				System.out.println("Inserisci intero compreso tra " + min + " e " + max +":");
			try {
				i = scanner.nextInt();			
				if(i>max || i<min) throw new Exception();
				break;
			} catch(Exception e){
				scanner.nextLine();
				System.out.println("Si prega di inserire un intero nel range. Riprova.");
			}
		}
		// removing next line...
		scanner.nextLine();
		return i;
	}

	/**
	 * @return
	 */
	public static Ruolo inserisciRuolo() {
		Ruolo r;
		do 
		{
			System.out.println("Inserisci ruolo (studente/amministratore/system admin):");
			String s = scanner.nextLine();
			switch(s)
			{
			case "studente":
				r = Ruolo.STUDENTE;
				return r;
			case "amministratore":
				r = Ruolo.AMMINISTRATORE;
				return r; 
			case "system admin":
				r = Ruolo.SYSTEMADMIN;
				return r;
			default:
				continue;
			}
		} while(true);
	}
	
}
