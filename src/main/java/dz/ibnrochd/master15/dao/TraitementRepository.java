package dz.ibnrochd.master15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Traitement;

@Repository
public interface TraitementRepository 
extends JpaRepository<Traitement, Integer> 
{
	//Traitement findById(int id);

}
