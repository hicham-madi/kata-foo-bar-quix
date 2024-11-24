package fr.highteam.katabackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Resultat {
    private int nombreSaisie;
    private String resultat;
}
