package fr.highteam.katabackend.controller;

import fr.highteam.katabackend.model.Resultat;
import fr.highteam.katabackend.service.KataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KataController {
    private final KataService kataService;

    public KataController(KataService kataService) {
        this.kataService = kataService;
    }

    @GetMapping("/api/transform")
    public Resultat transform(@RequestParam int number) {

        return kataService.transformNumber(number);
    }
}
