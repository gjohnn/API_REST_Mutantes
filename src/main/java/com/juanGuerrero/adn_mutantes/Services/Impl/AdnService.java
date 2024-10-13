package com.juanGuerrero.adn_mutantes.Services.Impl;

import com.juanGuerrero.adn_mutantes.Models.ADN;
import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;
import com.juanGuerrero.adn_mutantes.Repositories.AdnRepository;
import com.juanGuerrero.adn_mutantes.Services.IAdnService;
import com.juanGuerrero.adn_mutantes.Tools.RatioResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class AdnService implements IAdnService {

    private final AdnRepository adnRepository;
    @Autowired
    public AdnService(AdnRepository adnRepository) {
        this.adnRepository = adnRepository;
    }

    @Override
    public void Save(ADNdto adnDto) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        ADN adn = ADN.builder()
                .name(adnDto.getName())
                .isMutant(adnDto.isMutant())
                .created_at(timestamp)
                .updated_at(timestamp)
                .build();
        adnRepository.save(adn);
    }

    @Override
    public boolean isMutant(String[] dna) {
        if (dna == null) {
            throw new IllegalArgumentException("El array no debe ser null");
        }
        if (dna.length == 0) {
            throw new IllegalArgumentException("El array no debe estar vacío");
        }
        int n = dna.length;
        for (String fila : dna) {
            if (fila == null) {
                throw new IllegalArgumentException("El array contiene valores null");
            }
            if (fila.length() != n) {
                throw new IllegalArgumentException("El array debe ser NxN");
            }
            if (!fila.matches("[ACTG]+")) {
                throw new IllegalArgumentException("El array contiene caracteres no permitidos");
            }
        }
        int marcoSkip = 4;
        for (int i = 0; i < dna.length; i++) {
            for (int j = 0; j < dna.length; j++) {
                // Revisión horizontal HECHO
                if (j <= n - marcoSkip && checkSequence(dna, i, j, 0, 1)) {
                    return true;
                }
                //Revisión vertical HECHO
                if (i <= n - marcoSkip && checkSequence(dna, i, j, 1, 0)) {
                    return true;
                }
                // Revisión diagonal ↘ 
                if (i <= n - marcoSkip && j <= n - marcoSkip && checkSequence(dna, i, j, 1, 1)) {
                    return true;
                }
                // Revisión diagonal inversa ↙ 
                if (i <= n - marcoSkip && j >= marcoSkip - 1 && checkSequence(dna, i, j, 1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public ADNdto getAdn() {
        return null;
    }

    @Override
    public RatioResponse getAllAdnsRatio() {
        long totalAdns = adnRepository.count();
        long totalMutants = adnRepository.countByIsMutant(true);

        if (totalMutants == 0) {
            throw new RuntimeException("Can't divide by zero"); // Evitar la division por 0
        }
        return RatioResponse.builder()
                .count_adns(totalAdns)
                .count_mutants(totalMutants)
                .ratio((double) totalMutants / (double) totalAdns) // Convertir a double para obtener el valor decimal
                .build();
    }

    public static boolean checkSequence(String[] dna, int row, int col, int rowDir, int colDir) {
        char initial = dna[row].charAt(col); // Posicion inicial
        int cant = 0; // Iniciar variable de cantidad
        for (int i = 1; i < 4; i++) {  // Itera solo 4 posiciones consecutivas
            // Verifica si las letras consecutivas son iguales en la dirección dada
            if (dna[row + i * rowDir].charAt(col + i * colDir) == initial) {
                cant++;  // Si encuentra una que no coincide, regresa false
            } else {
                return false;
            }
        }
        return cant >= 3;
    }
}
