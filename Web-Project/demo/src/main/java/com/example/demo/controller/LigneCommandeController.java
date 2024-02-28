package com.example.demo.controller;

import com.example.demo.entity.LigneCommande;
import com.example.demo.service.LigneCommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LigneCommandeController {

    private final LigneCommandeService ligneCommandeService;

    @Autowired
    public LigneCommandeController(LigneCommandeService ligneCommandeService) {
        this.ligneCommandeService = ligneCommandeService;
    }

    @GetMapping("/lignes-commande")
    public List<LigneCommande> getAllLignesCommande() {
        return ligneCommandeService.findAll();
    }

    @GetMapping("/lignes-commande/{id}")
    public LigneCommande getLigneCommandeById(@PathVariable Long id) {
        return ligneCommandeService.getLigneCommandeById(id);
    }

    @PostMapping("/lignes-commande")
    public LigneCommande createLigneCommande(@RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.createLigneCommande(ligneCommande);
    }

    @PutMapping("/lignes-commande/{id}")
    public LigneCommande updateLigneCommande(@PathVariable Long id, @RequestBody LigneCommande ligneCommande) {
        return ligneCommandeService.updateLigneCommande(id, ligneCommande);
    }

    
}
