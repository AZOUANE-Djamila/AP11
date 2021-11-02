package dz.ibnrochd.master15.business;

import java.util.List;

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
	
	@Override
	public List<Consultation> listeDesConsultations() {
		return consultationRepository.findAll();
	}

	@Override
	public void creerConsultation(Consultation consultation) {
		consultationRepository.save(consultation);		
	}

	@Override
	public void modifierConsultation(Consultation consultation) {
		consultationRepository.save(consultation);
	}

	@Override	
	public void supprimerConsultations(Consultation consultation) {
		consultationRepository.delete(consultation);		
	}

	public List<Consultation> listeConsultationsParPatient(Patient p) {

		return consultationRepository.findConsultationsByPatient(p);
	}

	public Consultation trouverConsultationById(int idC) {
		return consultationRepository.findConsultationById(idC);
	}

}
