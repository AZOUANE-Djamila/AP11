package dz.ibnrochd.master15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.ibnrochd.master15.model.Consultation;

/*@Repository
public interface ConsultationRepository 
	extends JpaRepository<Consultation, Integer> 
{
	Consultation findById(int id);
}*/
@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

	Consultation findById(int id);
}