package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the colis database table.
 * 
 */
@Entity
@NamedQuery(name="Colis.findAll", query="SELECT c FROM Colis c")
public class Colis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	@Lob
	private String destination;

	@Lob
	private String label;

	@Lob
	private String origine;

	private int poids;

	private int valeur;

	//bi-directional many-to-one association to Client
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;

	//bi-directional many-to-one association to Suivi
	@OneToMany(mappedBy="coli")
	private List<Suivi> suivis;

	public Colis() {
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getOrigine() {
		return this.origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	public int getPoids() {
		return this.poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<Suivi> getSuivis() {
		return this.suivis;
	}

	public void setSuivis(List<Suivi> suivis) {
		this.suivis = suivis;
	}

	public Suivi addSuivi(Suivi suivi) {
		getSuivis().add(suivi);
		suivi.setColi(this);

		return suivi;
	}

	public Suivi removeSuivi(Suivi suivi) {
		getSuivis().remove(suivi);
		suivi.setColi(null);

		return suivi;
	}

}