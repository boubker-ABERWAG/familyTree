package fr.aberwag.familytree.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.aberwag.familytree.domain.neo4j.Membre;
import fr.aberwag.familytree.repository.neo4j.MembreRepository;

@Service
public class EnfantRelationManagmentService {

	private static final Logger log = LoggerFactory.getLogger(EnfantRelationManagmentService.class);

	@Autowired
	private MembreRepository membreRepository;

	public Membre addChild(Membre child, Membre Father) {
		return null;
	}

	public Membre deleteChild(Membre child, Membre Father) {
		return null;
	}
}
