package dz.ibnrochd.master15.model;

import java.io.Serializable;
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
@Table(schema = "cabinet",name = "traitement")
public class Traitement {

	//private static final long serialVersionUID = 8248365590951840055L;
    
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;

    @OneToMany()//mappedBy = "traitements")
    private List<LigneConsultation> ligneConsultations = new ArrayList<>();
    
	public Traitement() {
		super();
	}
	public Traitement(long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
    
    
}
