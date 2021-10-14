package dz.ibnrochd.master15.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import dz.ibnrochd.master15.business.IPatientService;

@Controller
public class MedicController {

	
	@Autowired
	private IPatientService patientService;
	
	
	@GetMapping(value = { "/patients/liste" })
	public String index(Model model) {
		model.addAttribute("liste", patientService.listeDesPatients());	
		return "liste_p"; 
	}
	
}
