package dz.ibnrochd.master15.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import dz.ibnrochd.master15.business.IPatientService;
import dz.ibnrochd.master15.business.ITraitementService;
import dz.ibnrochd.master15.model.Patient;

@Controller
public class MedicController {
	
	@Autowired
	private IPatientService ipatientService;
	
    @Autowired
	private ITraitementService itraitementService;
	//private IConsultationService iconsultationService;
	
	@InitBinder
	protected void initBinder(WebDataBinder binder,WebRequest request) {
	    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(
	            dateFormat, true));
	}
	//Handler methods
	@RequestMapping(value = { "/patients" }, method = RequestMethod.GET)
	public String getpatients(Model model) {
		model.addAttribute("patients", ipatientService.findAllPatients());
		return "listePatients";
	}
	
	
	//Créer un nouveau patient
	@GetMapping("/patients/ajouter-patient")
	public String createpatientForm(Model model) {
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		return "createPatient";
	}
	

	 @PostMapping("/patients/{id}")
	 public String updatePatient(@PathVariable int id, 
		@ModelAttribute("patient") Patient patient, Model model) {
	  Patient existantPatient = ipatientService.findPatientById(id);
	   existantPatient.setId(id);
	   existantPatient.setNom(patient.getNom());
	   existantPatient.setPrenom(patient.getPrenom());
	   existantPatient.setDateNaissance(patient.getDateNaissance());
	   existantPatient.setSexe(patient.getSexe());
	   existantPatient.setNumeroTelephone(patient.getNumeroTelephone()); 
	   existantPatient.setAdresse(patient.getAdresse()); 
	   //if(existantPatient.getId() > 0) {
		   ipatientService.modifierPatient(existantPatient);
			return "redirect:/patients";
	 }
	 
	 @GetMapping("/patients/edit/{id}")
	 public String getpatient(@PathVariable (value = "id") int id, Model model) {
		 	Patient patient = ipatientService.findPatientById(id);
	        model.addAttribute("patient",patient);
			return "edit-patient";
	    }
	
	     
	 @GetMapping("/patients/delete/{id}")
	 public String deletePatient(@PathVariable("id") int id) {
	     Patient patient = ipatientService.findPatientById(id);//.orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
	     ipatientService.supprimerPatient(patient);
	     return "redirect:/patients";
	 }
	

	@RequestMapping(value = { "/patients" },method = RequestMethod.POST)
	public String savePatient(Model model,@ModelAttribute("patient") Patient patient) {	
			 ipatientService.creerPatient(patient);
			 return "redirect:/patients";
		
	}

	@GetMapping(value = { "/traitements" })
	public String listTraitements(Model model) {
		model.addAttribute("traitements", itraitementService.findAllTraitements());
		return "listTraitements";
	}
	}



