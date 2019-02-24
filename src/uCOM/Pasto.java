package uCOM;

/**
 * @author Pietro
 *
 */
public class Pasto {
	private String primo;
	private String secondo;
	
	public Pasto(String primo, String secondo) {
		super();
		this.primo = primo;
		this.secondo = secondo;
	}

	public String getPrimo() {
		return primo;
	}

	public void setPrimo(String primo) {
		this.primo = primo;
	}

	public String getSecondo() {
		return secondo;
	}

	public void setSecondo(String secondo) {
		this.secondo = secondo;
	}
	
}
