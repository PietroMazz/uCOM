package ui;

import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JOptionPane;

import uCOM.Ruolo;
import util.Nomi;

/**
 * @author Pietro
 *
 */
public class InputSwingUI {
	
	public static Ruolo inserisciRuolo()
	{
		Ruolo r;
		do 
		{
			String[] array =  {Nomi.STUDENTE, Nomi.AMMINISTRATORE, Nomi.SYSTEMADMIN};
			JList list = new JList(array);
			JOptionPane.showMessageDialog(null, list, Nomi.RUOLO , JOptionPane.PLAIN_MESSAGE);
			int index = Integer.parseInt(""+Arrays.toString(list.getSelectedIndices()).charAt(1));
			String s = array[index];
			System.out.print(s);
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
