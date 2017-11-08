package fr.aberwag.familytree.web.rest;

import java.util.List;
import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.service.MembreManagmentService;

@RestController
@RequestMapping("/bk/membres")
public class MembreManagmentController {
	
	private static final Logger log = LoggerFactory.getLogger(MembreManagmentController.class);

	@Autowired
	private MembreManagmentService membreManagmentService;

	@PostMapping("/")
	public Membre addMembre(
			@RequestBody Membre membre
	){
		log.info("Membre => {}", membre.getNom());
		return membreManagmentService.addMembre(membre);
	}

	@DeleteMapping("/{pseudo}")
	public Membre deleteMembre(
			@PathVariable(name = "pseudo") String pseudo
	){
		return membreManagmentService.deleteMembre(pseudo);
	}

	@PutMapping("/{pseudo}")
	public Membre updateMembre(
			@PathVariable(name = "pseudo") String pseudo,
			@RequestBody Membre membre
	){
		return membreManagmentService.updateMembre(pseudo, membre);
	}

	@GetMapping("/{pseudo}")
	public Membre getMembre(
			@PathVariable(name = "pseudo") String pseudo
	){
		return membreManagmentService.getMembre(pseudo);
	}

	@GetMapping("/")
	public List<Membre> getAllActiveMembre(){
		return membreManagmentService.getAllActifMembre();
	}
}