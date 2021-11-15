/**
 * @author AZOUANE DJAMILA
 *
 */
package dz.ibnrochd.master15.business;

import java.util.List;
import java.util.Optional;

import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Patient;


public interface IConsultationService {

	List<Consultation> listeDesConsultations();
	void creerConsultation(Consultation consultation);
	void modifierConsultation(Consultation consultation);
	void supprimerConsultations(Consultation consultation);
	List<Consultation> listeConsultationsParPatient(Patient patient);
}
