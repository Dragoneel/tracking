package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the suivi database table.
 * 
 */
@Entity
@NamedQuery(name="Suivi.findAll", query="SELECT s FROM Suivi s")
public class Suivi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Lob
	private String emplacement;

	@Lob
	private String etat;

	private BigDecimal latitude;

	private BigDecimal longitude;

	//bi-directional many-to-one association to Colis
	@ManyToOne
	@JoinColumn(name="id_colis")
	private Colis coli;

	public Suivi() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmplacement() {
		return this.emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	public String getEtat() {
		return this.etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public BigDecimal getLatitude() {
		return this.latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return this.longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public Colis getColi() {
		return this.coli;
	}

	public void setColi(Colis coli) {
		this.coli = coli;
	}

}