package uCOM;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Pietro
 *
 */
@Entity
@Table(name="Utenti")
public class DatiUtente {
	
	@Id
	@Column(name = "username", updatable = false, nullable = false)
	private	String	username;
	
    @Enumerated
    @Column(columnDefinition = "smallint")
	private	Ruolo	ruolo;
    
    public DatiUtente(){};
	
	public DatiUtente(String username, Ruolo ruolo) {
		super();
		this.username = username;
		this.ruolo = ruolo;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Ruolo getRuolo() {
		return ruolo;
	}

	public void setRuolo(Ruolo ruolo) {
		this.ruolo = ruolo;
	}

}
