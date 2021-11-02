package dz.ibnrochd.master15.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.ibnrochd.master15.model.LigneConsultation;
import dz.ibnrochd.master15.model.Traitement;

@Repository
public interface TraitementRepository extends JpaRepository<Traitement, Integer> 
{
    List<Traitement> findAll();
    Traitement findTraitementByLigneConsultations(LigneConsultation lc);

}
