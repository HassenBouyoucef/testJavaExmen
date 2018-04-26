package friendsofmine.repositories;

import friendsofmine.domain.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ArticleRepositoryWithJdbc implements ArticleRepositoryInt {

    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;

    public List<Article> findAllArticles() {

        List<Article> articles = new ArrayList<>();
        ResultSet fetchedArticles;

        try {
            Connection connexion = dataSource.getConnection();
            Statement statement = connexion.createStatement();
            fetchedArticles = statement.executeQuery("SELECT * FROM articles");
            while(fetchedArticles.next()) {
                Article art = new Article();
                art.setId(fetchedArticles.getInt("id"));
                art.setTitre(fetchedArticles.getString("titre"));
                art.setCategorie(fetchedArticles.getString("categorie"));
                articles.add(art);
            }
            statement.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return articles;
    }

    public Article findById(int id) {
        Article article = null;
        ResultSet fetchedArticle;

        try {
            Connection connexion = dataSource.getConnection();
            PreparedStatement statement =
                    connexion.prepareStatement("SELECT id, titre, categorie FROM articles WHERE id = ?");

            statement.setString(1, String.valueOf(id));
            fetchedArticle = statement.executeQuery();

            if(fetchedArticle.next()) {
                article = new Article();
                article.setId(fetchedArticle.getInt("id"));
                article.setTitre(fetchedArticle.getString("titre"));
                article.setCategorie(fetchedArticle.getString("categorie"));
            }
            statement.close();
            connexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return article;

    }

    public Article saveArticle(Article article) {
        if (article == null)
            throw new InvalidDataAccessApiUsageException("Article must not be null");
        if (findById(article.getId()) != null)
            throw new InvalidDataAccessApiUsageException("L'id ne doit pas déjà être en base");

        try {
            Connection connexion = dataSource.getConnection();
            PreparedStatement statement =
                    connexion.prepareStatement("INSERT INTO articles (id, titre, categorie) VALUES (?, ?, ?)");

            statement.setString(1, String.valueOf(article.getId()));
            statement.setString(2, String.valueOf(article.getTitre()));
            statement.setString(3, String.valueOf(article.getCategorie()));

            statement.execute();

            statement.close();
            connexion.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return article;
    }
}