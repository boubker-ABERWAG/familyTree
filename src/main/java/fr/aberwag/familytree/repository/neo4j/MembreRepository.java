package fr.aberwag.familytree.repository.neo4j;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import fr.aberwag.familytree.domain.neo4j.Membre;

@Repository
public interface MembreRepository extends PagingAndSortingRepository<Membre, String> {

	public Optional<Membre> findOneByPseudo(String pseudo);

	public List<Membre> findByActifTrue();
}
