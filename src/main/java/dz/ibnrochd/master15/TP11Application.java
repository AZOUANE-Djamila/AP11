package dz.ibnrochd.master15;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class TP11Application implements CommandLineRunner 
{	
	@GetMapping("/")
	public String index(@RequestParam(value="nom", defaultValue = "Visiteur") String nom){
    return String.format("Bonjour %s!", nom);
}

	public static void main(String[] args) {
		SpringApplication.run(TP11Application.class, args);		
	}

	@Override
	public void run(String... args) throws Exception {
		
		
	}
}