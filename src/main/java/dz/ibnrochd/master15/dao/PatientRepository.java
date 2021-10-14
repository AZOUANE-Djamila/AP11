package dz.ibnrochd.master15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.ibnrochd.master15.model.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> 
{

	List<Patient> findByNom(String string);

	// TODO ajouter la signature d'une méthode pour rechercher des patients par leurs noms (convention Spring Data)
	//List<Patient> findByNom(String nom);
	//List<Patient> findAll();
	
}
