package dz.ibnrochd.master15.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "cabinet", name = "ligne_consultation")


public class LigneConsultation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

	 
    @ManyToOne()
    @JoinColumn(name = "id_traitement", nullable = false)
    private Traitement traitement;
	 
	 @ManyToOne()
	 @JoinColumn(name = "id_consultation", nullable = false)
	    private Consultation consultation;
	 
	 @Column(name = "posologie", nullable = false, length = 255)
	 private String posologie;
	 
	 @Column(name = "unite_temps", nullable = false, length = 255)
	 private String unite_temps;
	 
	 @Column(name = "quantite", nullable = false, length = 255)
	 private String quantite;
	
	 public LigneConsultation() {
			super();		
		}
	public LigneConsultation(int id, Consultation consultation, Traitement traitement, String posologie,
			String unite_temps, String quantite) {
		super();
		this.id = id;
		this.consultation = consultation;
		this.traitement = traitement;
		this.posologie = posologie;
		this.unite_temps = unite_temps;
		this.quantite = quantite;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
	 * @return the id_traitement
	 */
	public Traitement getTraitement() {
		return traitement;
	}
	/**
	 * @param id_traitement the id_traitement to set
	 */
	public void setTraitement(Traitement traitement) {
		this.traitement = traitement;
	}
	/**
	 * @return the posologie
	 */
	public String getPosologie() {
		return posologie;
	}
	/**
	 * @param posologie the posologie to set
	 */
	public void setPosologie(String posologie) {
		this.posologie = posologie;
	}
	/**
	 * @return the unite_temps
	 */
	public String getUnite_temps() {
		return unite_temps;
	}
	/**
	 * @param unite_temps the unite_temps to set
	 */
	public void setUnite_temps(String unite_temps) {
		this.unite_temps = unite_temps;
	}
	/**
	 * @return the quantite
	 */
	public String getQuantite() {
		return quantite;
	}
	/**
	 * @param quantite the quantite to set
	 */
	public void setQuantite(String quantite) {
		this.quantite = quantite;
	}
	public Consultation getConsultation() {
		return consultation;
	}
	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}
	
	
	 
	 
}
