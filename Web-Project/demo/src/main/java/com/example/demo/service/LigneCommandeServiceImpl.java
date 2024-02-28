package com.example.demo.service;

import com.example.demo.entity.LigneCommande;
import com.example.demo.repository.LigneCommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LigneCommandeServiceImpl implements LigneCommandeService {

    private final LigneCommandeRepository ligneCommandeRepository;

    @Autowired
    public LigneCommandeServiceImpl(LigneCommandeRepository ligneCommandeRepository) {
        this.ligneCommandeRepository = ligneCommandeRepository;
    }

    @Override
    public List<LigneCommande> findAll() {
        return ligneCommandeRepository.findAll();
    }

    @Override
    public LigneCommande getLigneCommandeById(Long id) {
        Optional<LigneCommande> optionalLigneCommande = ligneCommandeRepository.findById(id);
        return optionalLigneCommande.orElse(null);
    }

    @Override
    public LigneCommande createLigneCommande(LigneCommande ligneCommande) {
        return ligneCommandeRepository.save(ligneCommande);
    }

    @Override
    public LigneCommande updateLigneCommande(Long id, LigneCommande nouvelleLigneCommande) {
        LigneCommande existingLigneCommande = getLigneCommandeById(id);
        if (existingLigneCommande == null) {
            return null;
        }
        // Mettez à jour les champs de la ligne de commande existante avec les valeurs de la nouvelle ligne de commande
        // existingLigneCommande.setXXX(nouvelleLigneCommande.getXXX());
        return ligneCommandeRepository.save(existingLigneCommande);
    }

    @Override
    public void deleteLigneCommande(Long id) {
        ligneCommandeRepository.deleteById(id);
    }
}
