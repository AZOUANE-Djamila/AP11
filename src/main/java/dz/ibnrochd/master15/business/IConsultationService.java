/**
 * @author AZOUANE DJAMILA
 *
 */
package dz.ibnrochd.master15.business;

import java.util.List;

import dz.ibnrochd.master15.model.Consultation;


public interface IConsultationService {

	List<Consultation> listeDesConsultations();
	void creerConsultation(Consultation consultation);
	void modifierConsultation(Consultation consultation);
	void supprimerConsultations(Consultation consultation);
}
