package dz.ibnrochd.master15.business;

import java.util.List;
import dz.ibnrochd.master15.model.Patient;

public interface IPatientService {
	
	Patient modifierPatient(Patient patient);
	void supprimerPatient(Patient patient);
	List<Patient> findAllPatients();
	Patient findPatientById(int id);
	Patient creerPatient(Patient patient);
	
}
