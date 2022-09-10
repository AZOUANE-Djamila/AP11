package dz.ibnrochd.master15.business;

import java.util.List;
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
	 * Créér un patient
	 */
	public void creerPatient(Patient patient) {
		if (patient.getAge()>18) {
			patientRepository.save(patient);
			
		}else {
			throw new IllegalArgumentException("Le patient doit avoir plus de 18 ans. Il a "+patient.getAge()+" ans");
		}
	}
	
	/**
	 * Modifier un patient
	 */
	public void modifierPatient(Patient patient) {
		//patient.setId(id);
		
		if (patient.getAge() < 18) {
		      throw new IllegalArgumentException("Le patient doit avoir plus de 18 ans. Il a "+patient.getAge()+" ans");
		}
		 else {
			 	patient.setNom(patient.getNom());
				patient.setPrenom(patient.getPrenom());
				patient.setDateNaissance(patient.getDateNaissance());
				patient.setSexe(patient.getSexe());
				patient.setNumeroTelephone(patient.getNumeroTelephone()); 
				patient.setAdresse(patient.getAdresse()); 
		 
			  patientRepository.save(patient);
			 }
	}

	/**
	 * Supprimer un patient
	 */
	public void supprimerPatient(Patient patient) {
		patientRepository.delete(patient);		
	}

	/***
	 * Trouver un patient
	 */
	 public Patient findPatient(int id) {
	     return patientRepository.findById(id);
	    }


}
