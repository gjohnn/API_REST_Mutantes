package com.juanGuerrero.adn_mutantes.Services;

import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;
import com.juanGuerrero.adn_mutantes.Tools.RatioResponse;

public interface IAdnService {
    boolean isMutant(String[] dna);

    ADNdto getAdn();
    
    void Save(ADNdto dto);

    RatioResponse getAllAdnsRatio();
    
}
