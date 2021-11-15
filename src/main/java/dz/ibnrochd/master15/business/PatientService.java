package dz.ibnrochd.master15.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import dz.ibnrochd.master15.dao.PatientRepository;
import dz.ibnrochd.master15.model.Patient;

@Service
public class PatientService implements IPatientService{

	@Autowired
	PatientRepository patientRepository;
	
	/**
	 * Récupérer tous les patients
	 */
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	/**
	 * Créer un patient
	 */
	
	public Patient creerPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	/**
	 * Modifier un patient
	 */
	
	public void modifierPatient(int id, Patient patient) {		
		 Patient p;
		 
			Optional <Patient> optionalPatient = patientRepository.findById(id);
			if (optionalPatient.isPresent()) {
				
			    p = optionalPatient.get();
			    p.setAdresse(patient.getAdresse());
				p.setConsultations(patient.getConsultations());
				p.setDateNaissance(patient.getDateNaissance());
				p.setNom(patient.getNom());
				p.setNumeroTelephone(patient.getNumeroTelephone());
				p.setPrenom(patient.getPrenom());
				p.setRendezVous(patient.getRendezVous());
				p.setSexe(patient.getSexe());
				patientRepository.save(p);
			}
			
			else System.out.print("patient est non existant");	
			
		
	}

	/***
	 * Trouver un patient
	 */
	
	 public Patient findPatient(int id) {
		 Patient p=null;
		 
			Optional <Patient> optionalPatient = patientRepository.findById(id);
			if (optionalPatient.isPresent()) {
				 p = optionalPatient.get();
			}
		return p;
	    }

	 /**
		 * Supprimer un patient
		 */
	
	
	@Override
	public void supprimerPatient(int id) {
		if (id > 0) {
			 
			Patient p;
			
			Optional <Patient> optionalEntity = patientRepository.findById(id);
			if (optionalEntity.isPresent()) {
				System.out.print("patient is present" );
			    p = optionalEntity.get();
			  				
			    patientRepository.delete(p);	
			}
			
			else System.out.print("Aucun patient ayant le id n'est trouvé");	
		}
		else System.out.print("Le id est non existant ");	
		
	}
	


}
