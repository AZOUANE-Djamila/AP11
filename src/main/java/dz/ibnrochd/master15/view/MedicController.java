package dz.ibnrochd.master15.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import dz.ibnrochd.master15.business.IPatientService;
import dz.ibnrochd.master15.model.Patient;

@Controller
public class MedicController {
	
	@Autowired
	private IPatientService ipatientService;
	

	//private IConsultationService consultationService;
	//private ITraitementService traitementService;
	


	//Handler methods
	@GetMapping("/patients")
	public String getpatients(Model model) {
		model.addAttribute("name", ipatientService.findAllPatients());
		return "listePatients";
	}
	
}
