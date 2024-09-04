package com.PFARiva.achat.Test;


import com.PFARiva.achat.Repository.DemandeRepository;
import com.PFARiva.achat.models.Demande;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemandeRepositoryTests {

    @Autowired
    private DemandeRepository demandeRepository;

    @Test
    public void testUpdateDemande() {
        Demande demande = new Demande();
        demande.setTitreDemande("Titre");
        demande.setDescription("Description");
        demande.setMontant(100.0);
        demande.setStatus("En_cours_de_traitement");

        Demande savedDemande = demandeRepository.save(demande);
        savedDemande.setStatus("Approuvée");

        Demande updatedDemande = demandeRepository.save(savedDemande);

        assertEquals("Approuvée", updatedDemande.getStatus());
    }
}


