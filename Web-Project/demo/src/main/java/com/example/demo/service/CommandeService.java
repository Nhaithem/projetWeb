package com.example.demo.service;

import com.example.demo.entity.Commande;
import java.util.List;

public interface CommandeService {
    
    List<Commande> findAll();
    
    Commande getCommandeById(Long id);
    
    Commande addCommande(Commande commande);
    
    Commande updateCommande(Long id, Commande commande);
    
    void deleteCommande(Long id);
}
