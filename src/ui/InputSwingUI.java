package ui;

import java.util.Arrays;

import javax.swing.JList;
import javax.swing.JOptionPane;

import uCOM.Ruolo;
import uCOM.TipoPrenotazione;
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
			switch(s)
			{
			case Nomi.STUDENTE:
				r = Ruolo.STUDENTE;
				return r;
			case Nomi.AMMINISTRATORE:
				r = Ruolo.AMMINISTRATORE;
				return r; 
			case Nomi.SYSTEMADMIN:
				r = Ruolo.SYSTEMADMIN;
				return r;
			default:
				continue;
			}
		} while(true);
	}

	/**
	 * @return
	 */
	public static TipoPrenotazione inserisciTipoPrenotazione() {
		TipoPrenotazione tp;
		do {
			String[] array =  {Nomi.PRANZO, Nomi.CENA};
			JList list = new JList(array);
			JOptionPane.showMessageDialog(null, list, Nomi.TIPOPRENOTAZIONE , JOptionPane.PLAIN_MESSAGE);
			int index = Integer.parseInt(""+Arrays.toString(list.getSelectedIndices()).charAt(1));
			String s = array[index];
			switch(s)
			{
			case Nomi.PRANZO:
				tp = TipoPrenotazione.PRANZO;
				return tp;
			case Nomi.CENA:
				tp = TipoPrenotazione.CENA;
				return tp; 
			default:
				continue;
			}
		} while(true);
	}

}
