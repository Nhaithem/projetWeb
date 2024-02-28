package com.example.demo.controller;

import com.example.demo.entity.Commande;
import com.example.demo.service.CommandeService;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;
    private final UserService userService;

    @Autowired
    public CommandeController(CommandeService commandeService, UserService userService) {
        this.commandeService = commandeService;
        this.userService = userService;
    }

    @PostMapping
    public Commande createCommande(@RequestBody Commande newCommande) {
        // Récupérer l'utilisateur associé à partir de l'ID
        User user = newCommande.getUser(); // Obtenez l'utilisateur de la commande
        if (user == null) {
            throw new IllegalArgumentException("L'utilisateur associé à la commande ne peut pas être null.");
        }

        // Vérifiez si l'utilisateur a un ID
        Long userId = user.getId();
        if (userId == null) {
            throw new IllegalArgumentException("L'ID de l'utilisateur associé à la commande ne peut pas être null.");
        }

        // Récupérer l'utilisateur à partir de son ID
        User existingUser = userService.getUserById(userId);
        if (existingUser == null) {
            throw new RuntimeException("Utilisateur non trouvé avec l'ID: " + userId);
        }

        // Définir l'utilisateur pour la commande
        newCommande.setUser(existingUser);

        // Enregistrer la commande dans la base de données
        return commandeService.addCommande(newCommande);
    }
}