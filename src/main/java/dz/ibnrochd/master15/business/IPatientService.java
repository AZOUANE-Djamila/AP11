package dz.ibnrochd.master15.business;

import java.util.List;

import dz.ibnrochd.master15.dao.PatientRepository;
import dz.ibnrochd.master15.model.Patient;

public interface IPatientService {
	
	void creerPatient(Patient patient);
	void modifierPatient(Patient patient);
	void supprimerPatients(Patient patient);
	List<Patient> findAllPatients();
	
}
