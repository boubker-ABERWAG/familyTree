package fr.aberwag.familytree.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class MereRelationManagmentService {

	@Autowired
	private MembreRepository membreRepository;
	private Membre personne = null;

	public Membre addMother(Membre child, Membre mother) {
		child.setMere(mother);
		return membreRepository.save(child);
	}

	public Membre deleteMother(Membre child, Membre mother) {
		membreRepository
		.findOneByPseudo(child.getPseudo())
			.filter(
					m -> m.getMere().getPseudo().equals(mother.getPseudo()))
			.ifPresent(m -> {
				m.setMere(null);});
	
		return membreRepository.save(child);
	}

	public Membre addMother(String childPseudo, String motherPseudo) {
		membreRepository.findOneByPseudo(childPseudo)
		.map(m -> personne = m)
		.ifPresent(m -> {
			m.setConjoint(membreRepository.findOneByPseudo(motherPseudo).get());
			membreRepository.save(m);
		});
	return personne;
	}

	public Membre deleteMother(String childPseudo, String motherPseudo) {
		personne = membreRepository.findOneByPseudo(childPseudo).get();
		membreRepository
		.findOneByPseudo(motherPseudo)
			.filter(
					m -> personne.getConjoint().getPseudo().equals(m.getPseudo()))
			.ifPresent(m -> {
				personne.setConjoint(m);
			});
		return membreRepository.save(personne);
	}
}
