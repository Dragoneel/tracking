package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String adresse;

	@Lob
	private String nom;

	@Lob
	private String password;

	@Lob
	private String username;

	//bi-directional many-to-one association to Colis
	@OneToMany(mappedBy="client")
	private List<Colis> colis;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public List<Colis> getColis() {
		return this.colis;
	}

	public void setColis(List<Colis> colis) {
		this.colis = colis;
	}

	public Colis addColi(Colis coli) {
		getColis().add(coli);
		coli.setClient(this);

		return coli;
	}

	public Colis removeColi(Colis coli) {
		getColis().remove(coli);
		coli.setClient(null);

		return coli;
	}

}