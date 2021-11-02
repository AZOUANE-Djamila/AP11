package dz.ibnrochd.master15.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(schema = "cabinet", name = "consultation")
public class Consultation {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    
	@Column(name = "motif", length = 255)
    private String motif;
	
	@Column(name = "date_consultation", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date date_consultation;
	
	 @ManyToOne()
	    @JoinColumn(name = "id_patient", nullable = false)
	    private Patient patient;
	 
	 @OneToMany()
	   // private Set<LigneConsultation> LigneConsultations;
	   private List<LigneConsultation> ligneConsultations = new ArrayList<>();
	
	public Consultation() {
		super();
	}

	public Consultation(int id, String motif, Date date_consultation, Patient patient) {
		super();
		this.id = id;
		this.motif = motif;
		this.date_consultation = date_consultation;
		this.patient = patient;
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
	 * @return the motif
	 */
	public String getMotif() {
		return motif;
	}

	/**
	 * @param motif the motif to set
	 */
	public void setMotif(String motif) {
		this.motif = motif;
	}

	/**
	 * @return the date_consultation
	 */
	public Date getDate_consultation() {
		return date_consultation;
	}

	/**
	 * @param date_consultation the date_consultation to set
	 */
	public void setDate_consultation(Date date_consultation) {
		this.date_consultation = date_consultation;
	}

	/**
	 * @return the patient
	 */
	public Patient getPatient() {
		return patient;
	}

	public List<LigneConsultation> getLigneConsultations() {
		return ligneConsultations;
	}

	public void setLigneConsultations(List<LigneConsultation> ligneConsultations) {
		this.ligneConsultations = ligneConsultations;
	}

	/**
	 * @param patient the patient to set
	 */
	public void setPatient(Patient patient) {
		this.patient = patient;
	}


}
