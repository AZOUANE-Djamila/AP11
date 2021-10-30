package dz.ibnrochd.master15.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dz.ibnrochd.master15.dao.TraitementRepository;
import dz.ibnrochd.master15.model.Traitement;

@Service
public class TraitementService implements ITraitementService{

	@Autowired
	TraitementRepository traitementRepository;

	@Override
	public void creerTraitement(Traitement traitement) {
		traitementRepository.save(traitement);		
	}

	@Override
	public void modifierTraitement(Traitement traitement) {
		traitementRepository.save(traitement);
	}

	@Override
	public void supprimerTraitements(Traitement traitement) {
		traitementRepository.delete(traitement);		
	}

	public List<Traitement> findAllTraitements() {
		
		return traitementRepository.findAll();
	}




}