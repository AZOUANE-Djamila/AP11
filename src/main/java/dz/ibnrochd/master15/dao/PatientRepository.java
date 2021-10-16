package dz.ibnrochd.master15.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import dz.ibnrochd.master15.model.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

	List<Patient> findAll();
	
	//@Query("select p from patient p")
	//List<Patient> rechercheParNom(String  nom);
	
}
