package com.juanGuerrero.adn_mutantes.Services;

import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;
import org.springframework.data.domain.Page;

public interface IAdnService {
    boolean isMutant(String[] dna);

    ADNdto getAdn();

    Page<ADNdto> getAllAdns();
    
}
