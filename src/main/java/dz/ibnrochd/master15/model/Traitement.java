package dz.ibnrochd.master15.model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(schema = "cabinet", name = "traitement")
public class Traitement {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;


    @OneToMany(mappedBy = "traitement")
    private List<LigneConsultation> ligneConsultations = new ArrayList<>();
    
    //////////////////////////////////////
    
    public Traitement() {
	
	}

	public Traitement(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	
	///////////////////////////////////////

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<LigneConsultation> getLigneConsultations() {
		return ligneConsultations;
	}

	public void setLigneConsultations(List<LigneConsultation> ligneConsultations) {
		this.ligneConsultations = ligneConsultations;
	}
    
    
}
