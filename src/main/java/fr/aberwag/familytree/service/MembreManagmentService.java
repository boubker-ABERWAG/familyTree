package fr.aberwag.familytree.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.Utils;
import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.exception.FamilyBusinessException;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class MembreManagmentService {

	private static final Logger log = LoggerFactory.getLogger(MembreManagmentService.class);

	@Autowired
	private MembreRepository membreRepository;
	private Membre personne;

	public Membre addMembre(Membre membre) {
		log.info("membre.getPseudo() ======> {}",membre.getPseudo());
		log.info("membreRepository =====> {}",membreRepository);
		/* membreRepository.findOneByPseudo(membre.getPseudo()).ifPresent(m -> {
			throw new FamilyBusinessException("Le client existe dans la base");
		});*/
		log.info("membreRepository.findOneByPseudo(membre.getPseudo()) ======> {}",membreRepository.findOneByPseudo(membre.getPseudo()));
		return membreRepository.save(membre);
	}

	public Membre deleteMembre(String pseudo) {
		membreRepository.findOneByPseudo(pseudo)
		.map(m -> personne = m)
		.ifPresent(m ->{
			m.setActif(false);
		});
		return membreRepository.save(personne);
	}

	public Membre updateMembre(Membre membre) {
		return membreRepository.findOneByPseudo(membre.getPseudo()).map(m -> Utils.mapper(m, membre))
				.map(m -> membreRepository.save(m)).get();
	}
	
	public Membre updateMembre(String pseudo, Membre membre) {
		return membreRepository.findOneByPseudo(pseudo).map(m -> Utils.mapper(m, membre))
				.map(m -> membreRepository.save(m)).get();
	}

	public Membre getMembre(String pseudo) {
		return membreRepository.findOneByPseudo(pseudo).get();
	}

	public List<Membre> getAllActifMembre() {
		return membreRepository.findByActifTrue();
	}

}
