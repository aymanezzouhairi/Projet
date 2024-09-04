package com.PFARiva.achat.Service;

import com.PFARiva.achat.DTO.ArticleDto;
import com.PFARiva.achat.Repository.ArticleRepository;
import com.PFARiva.achat.Repository.TypeArticleRepository;
import com.PFARiva.achat.models.Article;
import com.PFARiva.achat.models.TypeArticle;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private TypeArticleRepository typeArticleRepository;

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }
    /*public Article convertToEntity(ArticleDto articleDto) {
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setNom(articleDto.getNom());
        article.setDescription(articleDto.getDescription());
        article.setPrix(articleDto.getPrix());

        // Si vous avez besoin de TypeArticle, vous devrez le récupérer à partir de son ID
        TypeArticle typeArticle = typeArticleRepository.findById(articleDto.getTypeArticleId())
                .orElseThrow(() -> new EntityNotFoundException("TypeArticle not found"));

        article.setTypeArticle(typeArticle);

        return article;
    }*/
    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }


    public Article updateArticle(Long id, Article updatedArticle) {
        if (articleRepository.existsById(id)) {
            updatedArticle.setId(id);
            return articleRepository.save(updatedArticle);
        } else {
            throw new ResourceNotFoundException("Article not found with ID: " + id);
        }


    }


    public void deleteArticle(Long id) {
        if (articleRepository.existsById(id)) {
            articleRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Article not found with ID: " + id);
        }
    }
}

