package com.juanGuerrero.adn_mutantes.Services.Impl;

import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;
import com.juanGuerrero.adn_mutantes.Services.IAdnService;
import org.springframework.data.domain.Page;

public class AdnService implements IAdnService {
    
    @Override
    public boolean isMutant(String[] dna) {
        return false;
    }
    
    @Override
    public ADNdto getAdn() {
        return null;
    }

    @Override
    public Page<ADNdto> getAllAdns() {
        return null;
    }
}
