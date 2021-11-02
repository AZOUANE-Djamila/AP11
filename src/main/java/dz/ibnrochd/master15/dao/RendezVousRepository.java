package dz.ibnrochd.master15.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import dz.ibnrochd.master15.model.RendezVous;

@Repository
public interface RendezVousRepository extends JpaRepository<RendezVous, Integer> 
{
	//RendezVous findById(int id);

}
