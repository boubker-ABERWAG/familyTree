package fr.aberwag.familytree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class ConjointRelationManagmentService {

	private static final Logger log = LoggerFactory.getLogger(ConjointRelationManagmentService.class);

	@Autowired
	private MembreRepository membreRepository;
	
	private Membre personne = null;

	public Membre addConjoint(Membre membre, Membre conjoint) {
		membre.setConjoint(conjoint);
		return membreRepository.save(membre);
	}

	public Membre deleteConjoint(Membre membre, Membre conjoint) {
		membreRepository
			.findOneByPseudo(membre.getPseudo())
				.filter(
						m -> m.getConjoint().getPseudo().equals(conjoint.getPseudo()))
				.ifPresent(m -> {
					m.setConjoint(null);});
		
		return membreRepository.save(membre);
	}

	public Membre addConjoint(String membrePseudo, String conjointPseudo) {
		membreRepository.findOneByPseudo(membrePseudo)
			.map(m -> personne = m)
			.ifPresent(m -> {
				m.setConjoint(membreRepository.findOneByPseudo(conjointPseudo).get());
				membreRepository.save(m);
			});
		return personne;
	}

	public Membre deleteConjoint(String membrePseudo, String conjointPseudo) {
		personne = membreRepository.findOneByPseudo(membrePseudo).get();
		membreRepository
		.findOneByPseudo(conjointPseudo)
			.filter(
					m -> personne.getConjoint().getPseudo().equals(m.getPseudo()))
			.ifPresent(m -> {
				personne.setConjoint(m);
			});
		return membreRepository.save(personne);
	}
}
