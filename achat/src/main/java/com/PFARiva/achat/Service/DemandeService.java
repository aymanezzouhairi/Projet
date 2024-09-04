package com.PFARiva.achat.Service;

import com.PFARiva.achat.Repository.DemandeRepository;
import com.PFARiva.achat.Repository.TypeArticleRepository;
import com.PFARiva.achat.models.Demande;
import com.PFARiva.achat.models.TypeArticle;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.Optional;

@Service
public class DemandeService {

    @Autowired
    private DemandeRepository demandeRepository;

    @Autowired
    private TypeArticleRepository typeArticleRepository;

    public Demande createRequest(Demande demande) {
        if (demande.getStatus() == null) {
            demande.setStatus("En_cours_de_traitement");
        }


        return demandeRepository.save(demande);

    }

    public List<Demande> getAllRequests() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getRequestById(Long id) {
        return demandeRepository.findById(id);
    }


    public void deleteRequest(Long id) {
        demandeRepository.deleteById(id);
    }

    private boolean isValidStatus(String status) {
        return status.equals("En_cours_de_traitement") || status.equals("Approuvée") || status.equals("Rejetée");
    }

   /* public Demande updateRequestStatus(Long id, String newStatus) {
        Demande demande = demandeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Demande non trouvée avec l'ID : " + id));

        if (!isValidStatus(newStatus)) {
            throw new IllegalArgumentException("Statut non valide : " + newStatus);
        }
        demande.setStatus(newStatus);
        return demandeRepository.save(demande);
    }*/
}

/*

    public Demande updateRequest(Demande demande) {
        if (demande.getId() == null || !demandeRepository.existsById(demande.getId())) {
            throw new EntityNotFoundException("Demande non trouvée avec l'ID : " + demande.getId());
        }

        // Validation ou transformation additionnelle si nécessaire
        // Exemple : vérifier si le statut est valide
        if (!isValidStatus(demande.getStatus())) {
            throw new IllegalArgumentException("Statut non valide : " + demande.getStatus());
        }

        return demandeRepository.save(demande);
    }

    private boolean isValidStatus(String status) {
        return "En_cours_de_traitement".equals(status) || "Approuvée".equals(status) || "Rejetée".equals(status);
    }
*/

 /*   public Demande updateRequestStatus(Demande demande) {
        if (demande.getId() == null || !demandeRepository.existsById(demande.getId())) {
            throw new IllegalArgumentException("Demande non trouvée.");
        }
        return demandeRepository.save(demande);
    }
*/




