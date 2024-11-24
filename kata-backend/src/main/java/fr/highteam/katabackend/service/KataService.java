package fr.highteam.katabackend.service;

import fr.highteam.katabackend.model.Resultat;
import fr.highteam.katabackend.repository.KataRepository;
import org.springframework.stereotype.Service;


@Service
public class KataService {

    private final KataRepository repository;

    public KataService(KataRepository repository) {
        this.repository = repository;
    }

    public Resultat transformNumber(int nombreSaisie) {
        if (nombreSaisie < 0 || nombreSaisie > 100) {
            throw new IllegalArgumentException("Le nombre saisi doit être compris entre 0 et 100.");
        }

        String finalResult = calculateResult(nombreSaisie);

        return new Resultat(nombreSaisie, finalResult);
    }

    private String calculateResult(int nombreSaisie) {
        StringBuilder result = new StringBuilder();

        // Règles "divisible par"
        applyDivisibilityRules(nombreSaisie, result);

        // Règles "contient"
        applyContainRules(nombreSaisie, result);

        // Retourne le nombre en tant que chaîne si aucun résultat
        return result.length() > 0 ? result.toString() : String.valueOf(nombreSaisie);
    }

    private void applyDivisibilityRules(int nombreSaisie, StringBuilder result) {
        if (nombreSaisie % 3 == 0) result.append("FOO");
        if (nombreSaisie % 5 == 0) result.append("BAR");
    }

    private void applyContainRules(int nombreSaisie, StringBuilder result) {
        String number = String.valueOf(nombreSaisie);
        for (char c : number.toCharArray()) {
            if (c == '3') result.append("FOO");
            if (c == '5') result.append("BAR");
            if (c == '7') result.append("QUIX");
        }
    }
}

