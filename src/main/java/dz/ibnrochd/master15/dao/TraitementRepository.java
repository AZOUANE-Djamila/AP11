package dz.ibnrochd.master15.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import dz.ibnrochd.master15.model.Traitement;

@Repository
public interface TraitementRepository 
extends JpaRepository<Traitement, Integer> 
{
	@Query("select t from Traitement t where t.nom = ?1")
	List<Traitement> rechercheParNom(String  nom);

}
