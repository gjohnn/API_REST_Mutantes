package com.juanGuerrero.adn_mutantes;

import com.juanGuerrero.adn_mutantes.Repositories.AdnRepository;
import com.juanGuerrero.adn_mutantes.Services.Impl.AdnService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class AdnMutantesApplicationTests {

    @Mock
    private AdnRepository adnRepository;  // Mock del repositorio

    @InjectMocks
    private AdnService adnService;  // Inyectar el mock en el servicio

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);  // Inicializar los mocks antes de cada test
    }
    
    @Test
    public void testArrayVacio() {
        String[] adn = {};
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array no debe estar vacío", exception.getMessage());
    }
    @Test
    public void testArrayNxM() {
        String[] adn = {
                "ACTG",
                "TGAC"
        }; // Array de 2x4
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array debe ser NxN", exception.getMessage());
    }
    @Test
    public void testArrayConNumeros() {
        String[] adn = {
                "1234",
                "5678",
                "9101",
                "1213"
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array contiene caracteres no permitidos", exception.getMessage());
    }
    @Test
    public void testRecibirNull() {
        String[] adn = null;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array no debe ser null", exception.getMessage());
    }
    @Test
    public void testArrayNxNDeNulls() {
        String[] adn = {
                null, null, null, null
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array contiene valores null", exception.getMessage());
    }
    @Test
    public void testArrayConLetrasDistintas() {
        String[] adn = {
                "AXTG",
                "TGAC",
                "ATCG",
                "GAXT"
        };
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            adnService.isMutant(adn);
        });
        assertEquals("El array contiene caracteres no permitidos", exception.getMessage());
    }
}
