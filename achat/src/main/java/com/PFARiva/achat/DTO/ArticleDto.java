package com.PFARiva.achat.DTO;


import com.PFARiva.achat.models.Article;
import com.PFARiva.achat.models.TypeArticle;

public class ArticleDto {
    private String nom;
    private String description;
    private Double prix;
    private String typeArticleName;
    private TypeArticle typeArticle;

    // Getters and Setters

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getTypeArticleName() {
        return typeArticleName;
    }

    public void setTypeArticleName(String typeArticleName) {
        this.typeArticleName = typeArticleName;
    }

    public TypeArticle getTypeArticle() {
        return typeArticle;
    }

    public void setTypeArticle(TypeArticle typeArticle) {
        this.typeArticle = typeArticle;
    }



}