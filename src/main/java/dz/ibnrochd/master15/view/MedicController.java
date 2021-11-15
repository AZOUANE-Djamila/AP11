package dz.ibnrochd.master15.view;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
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

import dz.ibnrochd.master15.business.IConsultationService;
import dz.ibnrochd.master15.business.IPatientService;
import dz.ibnrochd.master15.business.ITraitementService;
import dz.ibnrochd.master15.model.Consultation;
import dz.ibnrochd.master15.model.Patient;
import dz.ibnrochd.master15.model.Traitement;

@Controller
public class MedicController {
	
	@Autowired
	private IPatientService ipatientService;
	
    @Autowired
	private ITraitementService itraitementService;
    
    @Autowired
	private IConsultationService iconsultationService;
	
   
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
 
	   //if(existantPatient.getId() > 0) {
		   ipatientService.modifierPatient(id,patient);
			return "redirect:/patients";
	 }
	 
	 @GetMapping("/patients/edit/{id}")
	 public String getpatient(@PathVariable (value = "id") int id,Model model,@ModelAttribute("patient") Patient p) {
		 
	        ipatientService.modifierPatient(id, p);
			return "edit-patient";
	    }
	
	     
	 @GetMapping("/patients/delete/{id}")
	 public String deletePatient(@PathVariable("id") int id) {
	     ipatientService.supprimerPatient(id);
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
	
	
	
	//Liste de consultations par patient
	@RequestMapping(value = { "patients/{id}/consultations" }, method = RequestMethod.GET)
	public String listConsultationsPatient(Model model,@PathVariable("id") int id) {
	
		List<Consultation> listeC = iconsultationService.listeConsultationsParPatient(ipatientService.findPatient(id));
		
		List<Traitement> t = new ArrayList<>();

		for(Consultation c : listeC) {
			t.addAll(itraitementService.listeTraitementsParConsultation(c));
		}
		model.addAttribute("consultations", listeC);
		model.addAttribute("traitements", t);
		return "listconsultationsPatient";
	}
	
	  //Erreurs
	   @GetMapping("/error")
	    public String handleError(HttpServletRequest request) {
	        String errorPage = "error"; // default
	         
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
	         
	        if (status != null) {
	            Integer statusCode = Integer.valueOf(status.toString());
	             
	            if (statusCode == HttpStatus.NOT_FOUND.value()) {
	                // handle HTTP 404 Not Found error
	                errorPage = "error/404";
	                 
	            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
	                // handle HTTP 403 Forbidden error
	                errorPage = "error/403";
	                 
	            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	                // handle HTTP 500 Internal Server error
	                errorPage = "error/500";
	                 
	            }
	        }
	         
	        return errorPage;
	    }
	     
	    public String getErrorPath() {
	        return "/error";
	    }

}

