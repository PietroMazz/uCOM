package util;

/**
 * @author Pietro
 *
 */
@SuppressWarnings("serial")
public class ExitException extends Exception {

	/**
	 * @param string
	 */
	public ExitException(String string) {
		super(string);
	}
}
