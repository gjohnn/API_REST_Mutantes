package com.juanGuerrero.adn_mutantes.Controllers;

import com.juanGuerrero.adn_mutantes.Models.Dto.ADNdto;
import com.juanGuerrero.adn_mutantes.Services.Impl.AdnService;
import com.juanGuerrero.adn_mutantes.Tools.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("api/v1/adn")
@RequiredArgsConstructor
public class ADNController {

    private final AdnService adnService;

    @GetMapping("")
    public ResponseEntity<?> index() {
        return ResponseEntity.ok().body(adnService.getAllAdnsRatio().toString());
    }

    @PostMapping("")
    public ResponseEntity<?> sendDna(@RequestBody ADNdto adnDto) {
        try {
            boolean isMutant = adnService.isMutant(adnDto.getAdn());
            adnDto.setMutant(isMutant);
            adnService.Save(adnDto);
            String message = isMutant ? "El ADN corresponde a un mutante." : "El ADN NO corresponde a un mutante.";
            return ResponseEntity.ok().body(message);
        } catch (Exception e) {
            ErrorResponse errorResponse = ErrorResponse.builder()
                    .status(404)
                    .message(e.getMessage())
                    .stackTrace(e.getStackTrace())
                    .build();
            return ResponseEntity.badRequest().body(errorResponse);
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable UUID id) {
        return ResponseEntity.ok().body(id);
    }

}
