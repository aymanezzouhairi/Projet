package com.PFARiva.achat.Repository;

import com.PFARiva.achat.models.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUsernameAndPassword(String username, String password);
    Utilisateur findByUsername(String username);
}
