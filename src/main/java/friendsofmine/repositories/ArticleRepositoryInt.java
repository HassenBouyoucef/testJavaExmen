package friendsofmine.repositories;

import friendsofmine.domain.Article;
import java.util.List;

public interface ArticleRepositoryInt {

    public List<Article> findAllArticles();

        public Article findById(int id);

    public Article saveArticle(Article article);
}