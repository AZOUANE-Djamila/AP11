package dz.ibnrochd.master15.business;

import java.util.List;
import dz.ibnrochd.master15.model.Patient;

public interface IPatientService {
	
	void modifierPatient(Patient patient);
	void supprimerPatient(Patient patient);
	List<Patient> findAllPatients();
	Patient findPatient(int id);
	void creerPatient(Patient patient);
	
}
