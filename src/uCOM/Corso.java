package uCOM;

/**
 * @author Pietro
 *
 */
public class Corso {

	private String nome;
	private String descrizione;
	
	public Corso(String nome, String descrizione) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
	}

	public String getNome() {
		return nome;
	}
	
	public String getDescrizione()
	{
		return descrizione;
	}
	
}
