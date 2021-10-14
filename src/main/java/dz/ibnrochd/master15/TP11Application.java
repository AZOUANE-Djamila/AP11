package dz.ibnrochd.master15;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dz.ibnrochd.master15.dao.PatientRepository;
import dz.ibnrochd.master15.business.ConsultationService;
import dz.ibnrochd.master15.business.PatientService;
import dz.ibnrochd.master15.business.TraitementService;
import dz.ibnrochd.master15.dao.ConsultationRepository;
import dz.ibnrochd.master15.dao.LigneConsultationRepository;
import dz.ibnrochd.master15.dao.TraitementRepository;
import dz.ibnrochd.master15.model.Patient;
import dz.ibnrochd.master15.dao.RendezVousRepository;

@SpringBootApplication
public class TP11Application implements CommandLineRunner 
{
	
	@Autowired
	PatientRepository patientRepository;
	
	// TODO : déclarer les autres repository de la même façon que PatientRepository
	
	@Autowired
	private ConsultationRepository consultationRepository;
	
	@Autowired
	private LigneConsultationRepository ligneConsultationRepository;
	
	@Autowired
	private TraitementRepository traitementRepository;
	
	@Autowired
	private RendezVousRepository rendezVousRepository;

	
	@Autowired
    private PatientService patientService;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private TraitementService traitementService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(TP11Application.class, args);
	}

	
	
		public void run(String... args) throws Exception {

			@SuppressWarnings("deprecation")
			Patient patientCréé = new Patient(111,"AZOUANE","Wassilla","f",new Date("28/12/1997"),"657747","Bejaia");
			patientRepository.findAll().forEach(p->System.out.println(p.getNom()));
	/* récupérer la liste de tous les patients puis afficher leurs noms*/
	/*	System.out.println("______________________________________________________________________________________________\n");
		System.out.println("Récupérer la liste de tous les patients puis afficher leurs noms");
		patientRepository.findAll().forEach(pat -> System.out.println("Name: "+pat.getNom()+"\n"));
		System.out.println("______________________________________________________________________________________________\n");

		// TODO : rechercher les patients ayant le nom "Yahi" puis leurs prénoms
		System.out.println("Rechercher les patients ayant le nom \"Yahi\" puis leurs prénoms");
		patientRepository.findByNom("Yahi").forEach(pat -> System.out.println(pat.getNom()+" "+pat.getPrenom()+"\n"));
		System.out.println("______________________________________________________________________________________________\n");

		// TODO : créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le
		System.out.println("Créer un nouveau patient (valeurs au choix)  PUIS enregistrer-le");
		patientRepository.save(new Patient(11111,"AZOUANE","Djamila","f",new Date("25/06/1993"),"657777","Alger"));
		System.out.println("Le patient ajouté: ");
		patientRepository.findByNom("AZOUANE").forEach(pat -> System.out.println(pat.getNom()+" "+pat.getPrenom()+"\n"));
		// TODO : rechercher la consultation ayant id=3 
		System.out.println("______________________________________________________________________________________________\n");

		Consultation consult = consultationRepository.findById(3);
		System.out.println("La consultation N°: "+ consult.getId() +"\nPatient: " + consult.getPatient().getNom() + " " + consult.getPatient().getPrenom() +"\nDate de la consultation: " + consult.getDate_consultation() + "\nMotif: " + consult.getMotif());
			
		System.out.println("______________________________________________________________________________________________\n");

		
		//(consult -> System.out.println(consult.getNom()+" "+consult.getPrenom()+"\n"));

		// TODO : parcourir les lignes de la consultation trouvée et afficher les noms des médicaments
		System.out.println("La liste des traitements préscits pour la consultation N°3 est:\n");
		ligneConsultationRepository.findByConsultation(consult).forEach(l->System.out.println("- "+ l.getId_traitement().getNom() +"\n"));
		//getLigneConsultations().forEach(l->System.out.println("- "+ l.getId_traitement().getNom() +"\n"));*/
	}

}
