package br.com.mercadolivre.identificator.repository;

import br.com.mercadolivre.identificator.model.Dna;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DnaRepository extends JpaRepository<Dna, Long> {
	
	@Query(value = "SELECT count(id) as total FROM dna", nativeQuery = true)
    public Integer totalSpecies();
    
	@Query(value = "SELECT count(id) as totalSimian FROM dna WHERE species=2", nativeQuery = true)
    public Integer totalSimian();
}
