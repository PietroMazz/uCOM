package ui;

import uCOM.DatiLogin;
import util.ExitException;
import util.Nomi;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField; 

/**
 * @author Pietro
 *
 */
public class LoginSwing implements LoginUI {

	private JTextField textField;
	private JPasswordField passwordField;
	
	/* (non-Javadoc)
	 * @see ui.LoginUI#richiediDatiLogin()
	 */
	@Override
	public DatiLogin richiediDatiLogin() throws ExitException {
			      
			JPanel panel = new JPanel();

			JLabel lblNewLabel = new JLabel(Nomi.USERNAME);
			panel.add(lblNewLabel);
			
			textField = new JTextField(10);
			panel.add(textField);
			textField.setColumns(10);
			
			JLabel lblNewLabel_1 = new JLabel(Nomi.PASSWORD);
			panel.add(lblNewLabel_1);
			
			passwordField = new JPasswordField(10);
			panel.add(passwordField);
			
			
			int result = JOptionPane.showConfirmDialog(null, panel, "Login", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE);
			
	      if (result == JOptionPane.OK_OPTION) {
	          String user = textField.getText();
	          String pswd = new String(passwordField.getPassword());
	          return new DatiLogin (user, pswd);
	       }
	      else
	    	  throw new ExitException("Exit Exception");
	    	 
	    	  
	}

}
