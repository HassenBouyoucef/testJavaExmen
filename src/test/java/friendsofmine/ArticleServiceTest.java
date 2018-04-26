package friendsofmine;

import friendsofmine.domain.Article;
import friendsofmine.repositories.ArticleRepositoryInt;
import friendsofmine.repositories.ArticleRepositoryWithJdbc;
import friendsofmine.services.ArticleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ArticleServiceTest {

    @Autowired
    private ArticleService articleService;

    @Test
    public void testTypeRepository() {
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryWithJdbc.class));
        assertThat(articleService.getArticleRepository(), instanceOf(ArticleRepositoryInt.class));
    }

    @Test
    public void testFindAllCardinal() {
        assertEquals(9, (articleService.findAllArticles().size()));
    }

    @Test
    public void testFindAllPremiereCategorie() {
        assertEquals("Sport", (articleService.findAllArticles().get(0).getCategorie()));
    }
}