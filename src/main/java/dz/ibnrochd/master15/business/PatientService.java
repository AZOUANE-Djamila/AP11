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
	public Patient creerPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	/**
	 * Modifier un patient
	 */
	public Patient modifierPatient(Patient patient) {
		return patientRepository.save(patient);
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
