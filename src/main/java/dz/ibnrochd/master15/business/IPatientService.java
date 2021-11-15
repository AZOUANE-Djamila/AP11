package dz.ibnrochd.master15.business;

import java.util.List;
import java.util.Optional;

import dz.ibnrochd.master15.model.Patient;

public interface IPatientService {
	
	void modifierPatient(int id,Patient patient);
	void supprimerPatient(int id);
	List<Patient> findAllPatients();
	Patient creerPatient(Patient patient);
	Patient findPatient(int id);
	
	
}
