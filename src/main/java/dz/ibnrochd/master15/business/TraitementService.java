package dz.ibnrochd.master15.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master15.dao.LigneConsultationRepository;
import dz.ibnrochd.master15.dao.TraitementRepository;
import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Traitement;

@Service
public class TraitementService implements ITraitementService{

	@Autowired
	TraitementRepository traitementRepository;
	
	@Autowired
	LigneConsultationRepository lCRepository;
	
	@Autowired
	LigneConsultationRepository cRepository;

	
	public void creerTraitement(Traitement traitement) {
		traitementRepository.save(traitement);		
	}


	public void modifierTraitement(Traitement traitement) {
		traitementRepository.save(traitement);
	}


	public void supprimerTraitements(Traitement traitement) {
		traitementRepository.delete(traitement);		
	}

	public List<Traitement> findAllTraitements() {
		
		return traitementRepository.findAll();
	}
	
	/**
	 * Lister les traitements par consultation
	 * J'ai récupéré les traitement grace aux lignes de consultation pour chaque consultation
	 */
	public List<Traitement> listeTraitementsParConsultation(Consultation c) {
		List<Traitement> lt = new ArrayList<>();
		lCRepository.findByConsultation(c).forEach(lc->{
			lt.add(traitementRepository.findTraitementByLigneConsultations(lc));
		});
		return lt;
	}
	
	
}