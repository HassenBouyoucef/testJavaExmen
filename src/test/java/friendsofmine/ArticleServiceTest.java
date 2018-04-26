package friendsofmine;

import friendsofmine.domain.Article;
import friendsofmine.repositories.ArticleRepositoryInt;
import friendsofmine.repositories.ArticleRepositoryWithJdbc;
import friendsofmine.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testTypeRepository() {
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryWithJdbc.class));
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryInt.class));
    }

    @Test
    public void testFindAllPremiereCategorie() {
        assertEquals("Sport", (articleService.findAllArticles().get(0).getCategorie()));
    }

    @Test
    public void testFindAllCardinal() {
        assertEquals(9, (articleService.findAllArticles().size()));
    }

    @Test
    public void testFindByIdOk() {
        assertEquals(0, (articleService.findArticlesById(0)).getId());
    }

    @Test
    public void testFindByIdInconnuIsNull() {
        assertNull(articleService.findArticlesById(9999));
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void testSaveNullEntailsException() {
        articleService.saveArticle(null);
    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    public void testSaveDejaPresentEntailsException() {
        articleService.saveArticle(new Article(1, "titre", "categorie"));
    }

    @Test @DirtiesContext
    public void testSaveIsSaved() {
        Article a = new Article (125, "Titre", "Categorie");
        assertNull(articleService.findArticlesById(a.getId()));
        assertEquals(a, articleService.saveArticle(a));
    }

    @Test @DirtiesContext
    public void testSaveIsSavedCardinal() {
        int before = (articleService.findAllArticles()).size();

        Article a = new Article (130, "Titre", "Categorie");
        articleService.saveArticle(a);

        int after = (articleService.findAllArticles()).size();

        assertEquals(before + 1, after);
    }

    @Test @DirtiesContext
    public void testArticleRecupereeInchangee() {
        Article a = new Article (135, "Titre", "Categorie");
        articleService.saveArticle(a);

        Article fetched = articleService.findArticlesById(a.getId());
        assertEquals(fetched.getId(), a.getId());
        assertEquals(fetched.getTitre(), a.getTitre());
        assertEquals(fetched.getCategorie(), a.getCategorie());
    }

}