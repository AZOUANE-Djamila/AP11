package dz.ibnrochd.master15;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dz.ibnrochd.master15.business.IPatientService;
import dz.ibnrochd.master15.model.Patient;


class Sb002ApplicationTests {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IPatientService iPatientService;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	Patient p = new Patient(2,"nom","prenom","f",new Date(26/01/2000),"000000000","adresse");

	/*@Test
	public void testCreation() throws JsonProcessingException, Exception {
		objectMapper = new ObjectMapper();

		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> { 
				
			iPatientService.creerPatient(p);});
			//.withMessageMatching("Le patient doit avoir plus de 18 ans. Il a "+p.getAge()+" ans");
		mockMvc.perform(post("/ajuterPatient").contentType("application/json").content(objectMapper.writeValueAsString(p))).andExpect(status().isOk());
       
	}*/
	@Test
	public void testModification() throws JsonProcessingException, Exception {
		objectMapper = new ObjectMapper();
		
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> {iPatientService.modifierPatient(p);});//,.withMessageMatching("Le patient doit avoir plus de 18 ans. Il a "+p.getAge()+" ans");
		
		mockMvc.perform(post("/modifierPatient").contentType("application/json").content(objectMapper.writeValueAsString(p)))
		.andExpect(status().isOk())
               ;
       
	}

}
