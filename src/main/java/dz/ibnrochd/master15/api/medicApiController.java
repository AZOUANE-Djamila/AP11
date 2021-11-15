package dz.ibnrochd.master15.api;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import dz.ibnrochd.master15.business.IPatientService;
import dz.ibnrochd.master15.business.ITraitementService;
import dz.ibnrochd.master15.model.Patient;

@RestController
public class medicApiController {

	@Autowired
	private IPatientService ipatientService;
	
	@Autowired
	private ITraitementService iTraitementService;
	
	
	 @RequestMapping(value = "/api/traitements")
		public ResponseEntity<Object> ListConsultations() {

	    
	     return new ResponseEntity<>(iTraitementService.findAllTraitements(),HttpStatus.OK);
				
		}
	   @RequestMapping(value = "/api/patients")
		public ResponseEntity<Object> ListPatients() {

         List<Patient> liste = ipatientService.findAllPatients();
         
	     return new ResponseEntity<>(liste,HttpStatus.OK);
				
		}
	   
	   
	   @RequestMapping(value = "/api/ajouter-patient",method = RequestMethod.POST)
		public ResponseEntity<Object> AjouterPatient(@RequestBody Patient patient) {

         ipatientService.creerPatient(patient);
        
	     return new ResponseEntity<>("Bravo ! Le patient est ajouté avec succès ! ",HttpStatus.CREATED);
				
		}
	   
	   @RequestMapping(value = "/api/modifier-patient/{id}",method = RequestMethod.PUT)
		public ResponseEntity<Object> ModifierPatient(@PathVariable("id") int id ,@RequestBody Patient patient) {
		  
        ipatientService.modifierPatient(id, patient);
       
	     return new ResponseEntity<>("Bravo ! Le patient est modifié avec succès !",HttpStatus.OK);
				
		}
	   
	   @RequestMapping(value = "/api/supprimer-patient/{id}",method = RequestMethod.DELETE)
	 		public ResponseEntity<Object> SupprimerPatient(@PathVariable("id") int id) {
	         ipatientService.supprimerPatient(id);
	        
	 	     return new ResponseEntity<>("Patient supprimé avec succès",HttpStatus.OK);
	 				
	 		}
	   
	   
}