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
	public Patient creerPatient(Patient patient) {
		return patientRepository.save(patient);
	}
	
	@Override
	public Patient modifierPatient(Patient patient) {
		return patientRepository.save(patient);
	}

	@Override
	public void supprimerPatient(Patient patient) {
		patientRepository.delete(patient);		
	}

	 @Override
	 public Patient findPatientById(int id) {
	     return patientRepository.getOne(id);
	    }


}
