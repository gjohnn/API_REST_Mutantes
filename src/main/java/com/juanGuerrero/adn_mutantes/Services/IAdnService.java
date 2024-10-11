package com.juanGuerrero.adn_mutantes.Services;

import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;

public interface IAdnService {
    boolean isMutant(String[] dna);

    ADNdto getAdn();
    
    void Save(ADNdto dto);

    Double getAllAdnsRatio();
    
}
