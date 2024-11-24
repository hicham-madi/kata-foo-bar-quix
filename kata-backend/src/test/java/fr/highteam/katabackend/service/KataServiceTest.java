package fr.highteam.katabackend.service;

import fr.highteam.katabackend.repository.KataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KataServiceTest {

    private final KataRepository repository = new KataRepository();
    private final KataService kataService = new KataService(repository);

    @Test
    void testTransformNumber() {
        assertEquals("1", kataService.transformNumber(1).getResultat());           // Pas de règle, retourne le nombre
        assertEquals("FOOFOO", kataService.transformNumber(3).getResultat());      // Divisible par 3 et contient 3
        assertEquals("BARBAR", kataService.transformNumber(5).getResultat());      // Divisible par 5 et contient 5
        assertEquals("QUIX", kataService.transformNumber(7).getResultat());        // Contient 7
        assertEquals("FOO", kataService.transformNumber(9).getResultat());         // Divisible par 3
        assertEquals("FOOBAR", kataService.transformNumber(51).getResultat());     // Divisible par 3 et contient 5
        assertEquals("BARFOO", kataService.transformNumber(53).getResultat());     // Divisible par 5 et contient 3
        assertEquals("FOOFOOFOO", kataService.transformNumber(33).getResultat());  // Divisible par 3 et contient 3 (trois fois)
        assertEquals("FOOBARBAR", kataService.transformNumber(15).getResultat());  // Divisible par 3, 5 et contient 5
    }

    @Test
    void testInvalidNumbers() {
        // Cas limites : nombres hors de l'intervalle
        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> kataService.transformNumber(-1)
        );
        assertEquals("Le nombre saisi doit être compris entre 0 et 100.", exception.getMessage());

        exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> kataService.transformNumber(101)
        );
        assertEquals("Le nombre saisi doit être compris entre 0 et 100.", exception.getMessage());
    }

    @Test
    void testDivisibleOnly() {
        // Divisible par 3 seulement
        assertEquals("FOO", kataService.transformNumber(6).getResultat());
        // Divisible par 5 seulement
        assertEquals("BAR", kataService.transformNumber(10).getResultat());
        // Divisible par 3 et 5
        assertEquals("FOOBARBAR", kataService.transformNumber(15).getResultat());
    }

    @Test
    void testContainsOnly() {
        // Contient seulement 3
        assertEquals("FOO", kataService.transformNumber(13).getResultat());
        // Contient seulement 5
        assertEquals("BAR", kataService.transformNumber(52).getResultat());
        // Contient seulement 7
        assertEquals("QUIX", kataService.transformNumber(17).getResultat());
    }

    @Test
    void testDivisibleAndContains() {
        // Divisible par 3 et contient 3
        assertEquals("FOOFOOFOO", kataService.transformNumber(33).getResultat());
        // Divisible par 5 et contient 5
        assertEquals("BARBARBAR", kataService.transformNumber(55).getResultat());
    }
}

