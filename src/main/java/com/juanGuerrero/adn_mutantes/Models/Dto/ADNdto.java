package com.juanGuerrero.adn_mutantes.Models.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ADNdto {
    public String name;
    public String[] adn;
    public boolean isMutant;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
