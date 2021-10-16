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
	
	@Override
	public List<Patient> findAllPatients() {
		return patientRepository.findAll();
	}
	
	@Override
	public void creerPatient(Patient patient) {
		patientRepository.save(patient);
	}
	
	@Override
	public void modifierPatient(Patient patient) {
		patientRepository.save(patient);
	}

	@Override
	public void supprimerPatients(Patient patient) {
		patientRepository.delete(patient);		
	}
	
	
}
