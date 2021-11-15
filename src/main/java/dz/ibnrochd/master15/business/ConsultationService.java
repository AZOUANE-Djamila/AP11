package dz.ibnrochd.master15.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dz.ibnrochd.master15.dao.ConsultationRepository;
import dz.ibnrochd.master15.dao.LigneConsultationRepository;
import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Patient;


@Service
public class ConsultationService implements IConsultationService{

	@Autowired
	ConsultationRepository consultationRepository;
	
	@Autowired
	LigneConsultationRepository ligneConsultationRepository;

	
	public ConsultationService(ConsultationRepository consultationRepository) {
		super();
		this.consultationRepository = consultationRepository;
	}
	
	/**
	 * Récupérer la liste de toutes les consultations
	 */
	public List<Consultation> listeDesConsultations() {
		return consultationRepository.findAll();
	}

	/**
	 * Créer une consultation
	 */
	public void creerConsultation(Consultation consultation) {
		consultationRepository.save(consultation);		
	}

	/**
	 * Modifier une consultation en possédant l'objet
	 */
	public void modifierConsultation(Consultation consultation) {
		consultationRepository.save(consultation);
	}

	/**
	 * Supprimer une consultation donnée	
	 */
	public void supprimerConsultations(Consultation consultation) {
		consultationRepository.delete(consultation);		
	}


	/**
	 * 
	 * @param idC le id unique de la consultation à rechercher
	 * @return La consultation qui posséde le id en parametre
	 */
	public Consultation trouverConsultationById(int idC) {
		return consultationRepository.findConsultationById(idC);
	}

	@Override
	public List<Consultation> listeConsultationsParPatient(Patient patient) {
		return consultationRepository.findByPatient(patient);
	}

}
