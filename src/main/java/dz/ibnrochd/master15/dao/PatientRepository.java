package dz.ibnrochd.master15.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.ibnrochd.master15.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	Patient findById(int id);
	
}
