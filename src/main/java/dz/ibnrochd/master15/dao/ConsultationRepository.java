package dz.ibnrochd.master15.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Patient;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

	Consultation findById(int id);
	
	@Query("select c from Consultation c where c.motif = ?1")
	List<Consultation> rechercheParMotif(String  motif);
	List<Consultation> findByPatient(Patient patient);
	Consultation findConsultationById(int id);

	
}


