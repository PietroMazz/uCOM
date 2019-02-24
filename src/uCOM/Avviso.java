package uCOM;

/**
 * @author Pietro
 *
 */
public class Avviso {
	
	private String titolo;
	private String dettagli;
	
	
	public Avviso(String titolo, String dettagli) {
		super();
		this.titolo = titolo;
		this.dettagli = dettagli;
	}


	public String getTitolo() {
		return titolo;
	}


	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}


	public String getDettagli() {
		return dettagli;
	}


	public void setDettagli(String dettagli) {
		this.dettagli = dettagli;
	}
	
	

}
