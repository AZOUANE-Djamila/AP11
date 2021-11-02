package dz.ibnrochd.master15.business;

import java.util.List;

import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Traitement;

public interface ITraitementService {

	List<Traitement> findAllTraitements();
	void creerTraitement(Traitement traitement);
	void modifierTraitement(Traitement traitement);
	void supprimerTraitements(Traitement traitement);
	List<Traitement> listeTraitementsParConsultation(Consultation c);
}
