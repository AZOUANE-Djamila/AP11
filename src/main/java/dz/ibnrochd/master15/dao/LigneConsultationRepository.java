package dz.ibnrochd.master15.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.LigneConsultation;

@Repository
public interface LigneConsultationRepository extends JpaRepository<LigneConsultation, Integer> 
{
	List<LigneConsultation> findByConsultation(Consultation cons);


}
