package friendsofmine.services;

import friendsofmine.domain.Article;
import friendsofmine.repositories.ArticleRepositoryInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    ArticleRepositoryInt articleRepositoryInt;

    public ArticleRepositoryInt getArticleRepository() {
        return articleRepositoryInt;
    }

    public List<Article> findAllArticles() {
        return articleRepositoryInt.findAllArticles();
    }

    public Article findArticlesById(int i) { return articleRepositoryInt.findById(i);
    }

    public Article saveArticle(Article article) {return articleRepositoryInt.saveArticle(article);
    }
}
