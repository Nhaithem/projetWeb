package com.example.demo.service;

import com.example.demo.entity.LigneCommande;

import java.util.List;

public interface LigneCommandeService {
    List<LigneCommande> findAll();

    LigneCommande getLigneCommandeById(Long id);

    LigneCommande createLigneCommande(LigneCommande ligneCommande);

    LigneCommande updateLigneCommande(Long id, LigneCommande nouvelleLigneCommande);

    void deleteLigneCommande(Long id);
}
