package com.example.demo.service;

import com.example.demo.entity.Commande;
import com.example.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeServiceImpl implements CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    @Override
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande getCommandeById(Long id) {
        Optional<Commande> optionalCommande = commandeRepository.findById(id);
        return optionalCommande.orElse(null);
    }

    @Override
    public Commande addCommande(Commande commande) {
        return commandeRepository.save(commande);
    }

    @Override
    public Commande updateCommande(Long id, Commande commande) {
        Commande existingCommande = getCommandeById(id);
        if (existingCommande == null) {
            return null;
        }
        existingCommande.setEtat(commande.getEtat());
        return commandeRepository.save(existingCommande);
    }

    @Override
    public void deleteCommande(Long id) {
        commandeRepository.deleteById(id);
    }
}
