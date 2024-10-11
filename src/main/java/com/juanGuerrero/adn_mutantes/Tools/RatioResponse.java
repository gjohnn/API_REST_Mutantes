package com.juanGuerrero.adn_mutantes.Tools;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatioResponse {
    long count_mutants;
    long count_adns;
    double ratio;

    @Override
    public String toString() {
        return "Cantidad de Mutantes: " + count_mutants +
                ", Cantidad de ADNs: " + count_adns +
                ", Ratio: " + ratio;
    }

}
