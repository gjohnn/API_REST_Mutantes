package com.juanGuerrero.adn_mutantes.Repositories;

import com.juanGuerrero.adn_mutantes.Models.ADN;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AdnRepository extends JpaRepository<ADN, UUID> {
    List<ADN> findByIsMutantIs(boolean mutant);

    long countByIsMutant(boolean b);
}
